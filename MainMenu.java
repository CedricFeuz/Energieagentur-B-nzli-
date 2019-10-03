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

import java.io.IOException;
import javax.swing.JPanel;

import javafx.scene.layout.Background;

public class MainMenu extends JFrame {
	
	private JPanel panel;
	
	private JFrame frame;
	private Manager vm;
	
    private JButton verbrauchsd;
    private JButton jahresvbd;
    private JButton zaehlerstandd;
    
    private JButton importbutton;
    private JButton exportbutton;
    private JLabel copyrighttext;

    
    Image img = Toolkit.getDefaultToolkit().getImage("background.jpg");
    
    public MainMenu(JFrame frame, Manager vm) {
    	
    	this.frame = frame;
    	this.vm = vm;
    	
        verbrauchsd = new JButton ("Verbrauchsdiagramm");
        jahresvbd = new JButton ("Jahresverbrauchsdiagramm");
        zaehlerstandd = new JButton ("Zählerstanddiagramm");
        importbutton = new JButton ("Importieren");
        exportbutton = new JButton ("Exportieren");
        copyrighttext = new JLabel ("Stromdatenvisualisierer Version 1.0. Alle Rechte vorbehalten.");
        panel = new JPanel();

        frame.setPreferredSize(new Dimension(944, 574));
		panel.setLayout(null);
		
		frame.setResizable(false);

        /* add (verbrauchsd);
        add (jahresvbd);
        add (zaehlerstandd);
        add (importbutton);
        add (exportbutton);
        add (copyrighttext);
        */

        verbrauchsd.setBounds (509, 115, 340, 75);
        jahresvbd.setBounds (505, 240, 340, 75);
        zaehlerstandd.setBounds (505, 370, 340, 75);
        importbutton.setBounds (100, 180, 230, 75);
        exportbutton.setBounds (100, 305, 230, 75);
        copyrighttext.setBounds (300, 535, 355, 25);
        
        panel.add(verbrauchsd);
        panel.add(jahresvbd);
        panel.add(zaehlerstandd);
        panel.add(importbutton);
        panel.add(exportbutton);
        panel.add(copyrighttext);
        
        frame.setTitle ("MyPanel");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add (panel);
        frame.pack();
        frame.setVisible (true);
        
    }
    
    public static void main(String[] args) {
		new MainMenu(new JFrame(), new Manager());
	}
}
