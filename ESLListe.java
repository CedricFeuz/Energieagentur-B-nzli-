package Model;
/**
 * @author Yara Fischer
 * @date 01.10.19
 * @Version 1.0
 */
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ESLListe {
	private HashMap<Timestamp, ESLDaten> einspeisen; // Liste mit Werten, welche in das Stromnetz eingespiesen wurden
	private HashMap<Timestamp, ESLDaten> bezogen; //Liste mit werden, welche aus dem Stromnetz  bezogen wurden
	private ESLDaten wert;

	public ESLListe() {
		einspeisen = new HashMap<>();
		bezogen = new HashMap<>();
	}

	/**
	 * Diese Methode erstellt eine Liste mit allen Werten, welche Strom in das Stromnetz eingespiesen haben
	 */
	public void setListEinspeisen() {
		for (int i = 0; i < 300; i++) {
			einspeisen.put(wert.getDatum(i), new ESLDaten(wert.getEinspeisung(wert.getDatum(i))));
		}
	}
	/**
	 * 
	 * @return Liste mit den Werten, welche in das Stromnetz eingespiesen wurden
	 */
	public HashMap<Timestamp, ESLDaten> getListEinspeisen() {
		return einspeisen;
	}

	public void setListBezogen() {
		for (int i = 0; i < 300; i++) {
			einspeisen.put(wert.getDatum(i), new ESLDaten(wert.getBezug(wert.getDatum(i))));
		}
	}

	public HashMap<Timestamp, ESLDaten> getListBezogen() {
		return bezogen;
	}

	public void sort(HashMap<Timestamp, ESLDaten> daten) {
		TreeMap<Timestamp, ESLDaten> sorted = new TreeMap<>();
		sorted.putAll(daten);
		daten.clear();
		daten.putAll(sorted);
	}
	
	public double getDurchschnittBezogen(HashMap<Timestamp, ESLDaten> daten) {
		double durchschnitt = 0;
		for(int i = 0; i < daten.size(); i++) {
			durchschnitt =+ daten.get(wert.getDatum(i)).getBezug(wert.getDatum(i));
		}
		
		durchschnitt = durchschnitt / daten.size();
		return durchschnitt;
	}
	
	public double getDurchschnittEinspeissen(HashMap<Timestamp, ESLDaten> daten) {
		double durchschnitt = 0;
		for(int i = 0; i < daten.size(); i++) {
			durchschnitt =+ daten.get(wert.getDatum(i)).getEinspeisung(wert.getDatum(i));
		}
		
		durchschnitt = durchschnitt / daten.size();
		return durchschnitt;
	}
}
