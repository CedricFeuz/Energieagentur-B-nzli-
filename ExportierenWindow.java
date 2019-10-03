/**
*Teilweise mit GUIGenie generiert
* @author  Clarissa Sullivan
* @version 1.1
* @since   20.08.2019
*/
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

import org.omg.CORBA.TypeCodePackage.Bounds;

public class ExportierenWindow extends JFrame {
	
	private JPanel panel;
	private JRadioButton eingespiesen;
	private JRadioButton verbraucht;
	private JRadioButton beides;
	private JButton httpbutton;
	private JButton csvbutton;
	private JButton jsonbutton;
	private JButton zurueckbutton;

	private Manager vm;
	private JFrame frame;

	public ExportierenWindow(JFrame frame, Manager vm) {

		this.frame = frame;
		this.vm = vm;

		frame.setTitle("MyPanel");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		eingespiesen = new JRadioButton("Eingespiesen");
		verbraucht = new JRadioButton("Verbraucht");
		beides = new JRadioButton("Beides");
		httpbutton = new JButton("HTTP-Server Upload");
		csvbutton = new JButton("CSV-Datei");
		jsonbutton = new JButton("JSON-Datei");
		zurueckbutton = new JButton("Zurück");
		panel = new JPanel ();

		frame.setPreferredSize(new Dimension(944, 574));
		panel.setPreferredSize(new Dimension(944, 574));
		panel.setLayout(null);
		
		frame.setResizable(false);
		

	/*add(eingespiesen);
		add(verbraucht);
		add(beides);
		add(httpbutton);
		add(csvbutton);
		add(jsonbutton);
		add(zurueckbutton);
		*/
		
		eingespiesen.setBounds(100, 180, 140, 25);
		verbraucht.setBounds(100, 250, 100, 25);
		beides.setBounds(100, 320, 100, 25);
		httpbutton.setBounds(505, 115, 340, 75);
		csvbutton.setBounds(505, 250, 340, 75);
		jsonbutton.setBounds(505, 385, 340, 75);
		zurueckbutton.setBounds(5, 5, 175, 40);
		

		panel.add(eingespiesen);
		panel.add(verbraucht);
		panel.add(beides);
		panel.add(httpbutton);
		panel.add(csvbutton);
		panel.add(jsonbutton);
		panel.add(zurueckbutton);



		frame.getContentPane().add(panel);
		
		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		new ExportierenWindow(new JFrame(), new Manager());

	}

}
