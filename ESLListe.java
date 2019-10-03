import java.security.Timestamp;
import java.util.Date;
import java.util.HashMap;

public class ESLListe {
	public static void main(String[] args) {
		
	}

	double[] einspeisen;
	
	double[] bezug;

	private ESLDaten wert;

	Date januar = new Date(119, 1,1);
	Date februar = new Date(119, 2,1);
	Date maerz = new Date(119, 3,1);
	Date april = new Date(119, 4,1);
	Date mai = new Date(119, 5,1);
	Date juni = new Date(119, 6,1);
	Date juli = new Date(119, 7,1);
	Date august = new Date(119, 8,1);
	Date september = new Date(119, 9,1);
	Date oktober = new Date(119, 10,1);
	Date november = new Date(119, 11,1);
	Date dezember = new Date(119, 11,1);

	public ESLListe() {

	}


	public double getEinspeisen(int index) {
		return einspeisen[index];
	}



	public double getBezug(int index) {
		return bezug[index];
	}



	/**

	 * Diese Methode erstellt eine Liste mit allen Werten, welche Strom in das Stromnetz eingespiesen haben

	 */

	public void setListEinspeisen() {
		einspeisen[0] = wert.getEinspeisen(januar);
		einspeisen[1] = wert.getEinspeisen(februar);
		einspeisen[2] = wert.getEinspeisen(maerz);
		einspeisen[3] = wert.getEinspeisen(april);
		einspeisen[4] = wert.getEinspeisen(mai);
		einspeisen[5] = wert.getEinspeisen(juni);
		einspeisen[6] = wert.getEinspeisen(juli);
		einspeisen[7] = wert.getEinspeisen(august);
		einspeisen[8] = wert.getEinspeisen(september);
		einspeisen[9] = wert.getEinspeisen(oktober);
		einspeisen[10] = wert.getEinspeisen(november);
		einspeisen[11] = wert.getEinspeisen(dezember);
	}
	
	public void setListBezug() {
		einspeisen[0] = wert.getBezug(januar);
		einspeisen[1] = wert.getBezug(februar);
		einspeisen[2] = wert.getBezug(maerz);
		einspeisen[3] = wert.getBezug(april);
		einspeisen[4] = wert.getBezug(mai);
		einspeisen[5] = wert.getBezug(juni);
		einspeisen[6] = wert.getBezug(juli);
		einspeisen[7] = wert.getBezug(august);
		einspeisen[8] = wert.getBezug(september);
		einspeisen[9] = wert.getBezug(oktober);
		einspeisen[10] = wert.getBezug(november);
		einspeisen[11] = wert.getBezug(dezember);
	}

	public double getDurchschnittBezogen() {

		double durchschnitt = 0.0;
		for(int i = 0; i<12; i++) {
			durchschnitt = durchschnitt + einspeisen[i];
		}

		durchschnitt = durchschnitt / 12;
		return durchschnitt;

	}

	

	public double getDurchschnittEinspeissen() {

		double durchschnitt = 0.0;
		for(int i = 0; i<12; i++) {
			durchschnitt = durchschnitt + bezug[i];
		}

		durchschnitt = durchschnitt / 12;
		return durchschnitt;

	}
	
	
}
