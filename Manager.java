package Control;

/**
 * @author Yara Fischer
 * @date 02.10.19
 * @Version 1.0
 */
import java.sql.Timestamp;
import java.util.HashMap;

import javax.swing.JFrame;

import Model.ESLDaten;
import Model.ESLListe;
import Model.ExportDaten;
import Model.SdatDaten;
import Model.SdatListe;
import View.ErfolgGui;
import View.ExportierenGui;
import View.J_VerbrauchsGui;
import View.StartGui;
import View.T_VerbrauchsGui;
import View.ZaehlerstandGui;

public class Manager extends JFrame {

	// Model
	private ExportDaten export;
	private SdatListe sdatEinspeisen;
	private SdatListe sdatBezogen;
	private ESLListe eslEinspeisen;
	private ESLListe eslBezogen;
	// View
	private JFrame frame;
	private StartGui startGui;
	private ZaehlerstandGui zaehlerstandGui;
	private T_VerbrauchsGui t_VerbrauchsGui;
	private J_VerbrauchsGui j_VerbrauchsGui;
	private ExportierenGui exportierenGui;
	private ErfolgGui erfolgGui;

	public Manager() {
		// Model
		sdatEinspeisen = new SdatListe();
		sdatBezogen = new SdatListe();
		eslBezogen = new ESLListe();
		eslEinspeisen = new ESLListe();

		// View
		frame = new JFrame();
		startGui = new StartGui(frame, this);
		zaehlerstandGui = new ZaehlerstandGui(frame, this);
		t_VerbrauchsGui = new T_VerbrauchsGui(frame, this);
		j_VerbrauchsGui = new J_VerbrauchsGui(frame, this);
		exportierenGui = new ExportierenGui(frame, this);
		erfolgGui = new ErfolgGui(frame, this);
	}

	// Model
	public HashMap<Timestamp, ESLDaten> getEslEinspeisen() {

		return eslEinspeisen.getListEinspeisen();
	}

	public HashMap<Timestamp, ESLDaten> getEslBezogen() {

		return eslBezogen.getListBezogen();
	}

	public void setEslEinspeisen() {

		eslEinspeisen.setListEinspeisen();
	}

	public void setEslBezogen() {

		eslBezogen.setListBezogen();
	}

	public double getEslEinspeissenDurchschnitt() {

		return eslEinspeisen.getDurchschnittEinspeissen(eslEinspeisen.getListEinspeisen());
	}

	public double getEslBezogenDuchschnitt() {

		return eslBezogen.getDurchschnittBezogen(eslBezogen.getListBezogen());
	}

	public HashMap<Timestamp, SdatDaten> getSdatEinspeisen() {

		return sdatEinspeisen.getEinspeisen();
	}

	public HashMap<Timestamp, SdatDaten> getSdatBezogen() {

		return sdatBezogen.getBezogen();
	}

	public void setSdatEinspeisen() {

		sdatEinspeisen.setListEinspeisen();
	}

	public void setSdatBezogen() {

		sdatBezogen.setListBezogen();
	}

	public double getSdatEinspeisenDurchschnitt() {

		return sdatEinspeisen.getDurchschnittEinspeissen(sdatEinspeisen.getEinspeisen());
	}

	public double getSdatBezogenDuchschnitt() {

		return sdatBezogen.getDurchschnittBezogen(sdatBezogen.getBezogen());
	}
	public void exportEinspeisen(ESLListe daten) {
		//export.exportEinspeisen(daten);
	}
	public void exportBezogen(ESLListe daten) {
		//export.exportBezogen(daten);
	}

	// View
	public void openStartGui() {
		startGui.startGui();
	}

	public void openZaehlerstandGui() {
		zaehlerstandGui.zaehlerstandGui();
	}

	public void openT_VerbrauchsGui() {
		t_VerbrauchsGui.t_VerbrauchsGui();
	}

	public void openJ_VerbrauchsGui() {
		j_VerbrauchsGui.j_VerbrauchsGui();
	}

	public void openExportierenGui() {
		exportierenGui.exportierenGui();
	}

}
