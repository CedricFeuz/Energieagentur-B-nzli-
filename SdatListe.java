package Model;

import java.sql.Timestamp;
import java.util.HashMap;

public class SdatListe {
	private HashMap<Timestamp, SdatDaten> einspeisen;
	private HashMap<Timestamp, SdatDaten> bezogen;
	private SdatDaten wert;

	public SdatListe() {
		einspeisen = new HashMap<>();
		bezogen = new HashMap<>();
	}

	public void setListEinspeisen() {
		for (int i = 0; i < 300; i++) {
			if (wert.isEinspeisen(wert.getDatum(i))) {
				einspeisen.put(wert.getDatum(i), new SdatDaten(wert.getEinspeisung(wert.getDatum(i))));
			}
		}
	}
	
	public HashMap<Timestamp, SdatDaten> getEinspeisen(){
		return einspeisen;
	}
	
	public void setListBezogen() {
		for (int i = 0; i < 300; i++) {
			if (!wert.isEinspeisen(wert.getDatum(i))) {
				einspeisen.put(wert.getDatum(i), new SdatDaten(wert.getBezug(wert.getDatum(i))));
			}
		}
	}
	
	public HashMap<Timestamp, SdatDaten> getBezogen(){
		return bezogen;
	}
	
	public double getDurchschnittBezogen(HashMap<Timestamp, SdatDaten> daten) {
		double durchschnitt = 0;
		for(int i = 0; i < daten.size(); i++) {
			durchschnitt =+ daten.get(wert.getDatum(i)).getBezug(wert.getDatum(i));
		}
		
		durchschnitt = durchschnitt / daten.size();
		return durchschnitt;
	}
	
	public double getDurchschnittEinspeissen(HashMap<Timestamp, SdatDaten> daten) {
		double durchschnitt = 0;
		for(int i = 0; i < daten.size(); i++) {
			durchschnitt =+ daten.get(wert.getDatum(i)).getEinspeisung(wert.getDatum(i));
		}
		
		durchschnitt = durchschnitt / daten.size();
		return durchschnitt;
	}
}
