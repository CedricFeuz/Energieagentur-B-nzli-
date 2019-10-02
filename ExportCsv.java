import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ExportCsv {

	public static void main(String[] args) {
		String nameHomeVereichnis = System.getProperty("user.home");
		Path PfadMitDatei = Paths.get(nameHomeVereichnis, "daten.csv");
		String t = "Time";
		String v = "Volt";
		String[] time = {"00:00", "01:00", "02:00", "03:00", "04:00", "05:00", "06:00", "07:00",
				"08:00", "09:00","10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", 
				"18:00", "19:00", "20:00", "21:00", "22:00","23:00"};
		int[] volt = {34, 23, 41, 23, 31, 51, 3, 2, 5, 7, 0, 32, 13, 42, 13, 52, 23, 25, 5, 9, 20, 21, 42, 23};
		
		try(BufferedWriter schreibpuffer = Files.newBufferedWriter(PfadMitDatei)) {
			String zeile1 = String.format("%s;%s%n", t, v);
			schreibpuffer.write(zeile1);
			for (int i = 0; i<24; i++) {
				String zeile2 = String.format("%s;%s%n", time[i], volt[i]);
				schreibpuffer.write(zeile2);
			}
		}catch(IOException ex){
			
		}
	}
}