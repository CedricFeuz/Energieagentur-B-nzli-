import java.awt.List;
import java.io.File;
import java.sql.Date;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashSet;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ESLDaten {

	public ESLDaten() {
		
	}
	
	public Date getDatum(String Time) {
		String month = Time.substring(5, 7);
		int months = (int) month.charAt(1);
		if(month.charAt(0) == 1) {
			months = months + 10;
		}
		Date date = new Date(115, months - 1, 1);
		return date;
	}
	public double getBezug(java.util.Date date) {
		double zaehlerstand = 0.0;
		int zaehler = 0;
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder=factory.newDocumentBuilder();
			File dir = new File("C:\\Users\\cedri\\Desktop\\eclipse-workspace\\Daten_Stromnetz\\esl-files");
			File[] fileList = dir.listFiles();
			for(File f : fileList) {
				Document doc = builder.parse(f.getAbsolutePath());
				NodeList list = doc.getElementsByTagName("TimePeriod");
				for(int j = 0; j<list.getLength(); j++) {
					Date d = getDatum(list.item(j).getAttributes().getNamedItem("end").getNodeValue());
					if(date.equals(d)) {
						NodeList lists = doc.getElementsByTagName("ValueRow");
						for(int i = 0; i<lists.getLength(); i++) {
							char c = lists.item(i).getAttributes().getNamedItem("obis").getNodeValue().charAt(4);
							if (c == '1') {
								zaehler ++;
								String s = lists.item(i).getAttributes().getNamedItem("value").getNodeValue();
								double ds = Double.parseDouble(s);
								zaehlerstand = ds + zaehlerstand;
							}
						}
						zaehlerstand = zaehlerstand / zaehler;
						zaehlerstand = zaehlerstand * 2;
					}
				}
			}
		}catch (Exception e){
			
		}
		return zaehlerstand;
	}
	public double getEinspeisen(java.util.Date date) {
		double zaehlerstand = 0.0;
		int zaehler = 0;
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder=factory.newDocumentBuilder();
			File dir = new File("C:\\Users\\cedri\\Desktop\\eclipse-workspace\\Daten_Stromnetz\\esl-files");
			File[] fileList = dir.listFiles();
			for(File f : fileList) {
				Document doc = builder.parse(f.getAbsolutePath());
				NodeList list = doc.getElementsByTagName("TimePeriod");
				for(int j = 0; j<list.getLength(); j++) {
					Date d = getDatum(list.item(j).getAttributes().getNamedItem("end").getNodeValue());
					if(date.equals(d)) {
						NodeList lists = doc.getElementsByTagName("ValueRow");
						for(int i = 0; i<lists.getLength(); i++) {
							char c = lists.item(i).getAttributes().getNamedItem("obis").getNodeValue().charAt(4);
							if (c == '2') {
								zaehler ++;
								String s = lists.item(i).getAttributes().getNamedItem("value").getNodeValue();
								double ds = Double.parseDouble(s);
								zaehlerstand = ds + zaehlerstand;
							}
						}
						zaehlerstand = zaehlerstand / zaehler;
						zaehlerstand = zaehlerstand * 2;
			
				}
			}
		}
		}catch (Exception e){
			
		}
		return zaehlerstand;
	}
}
