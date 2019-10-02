
/**
* Teilweise mit GUIGenie generiert
* @author  Clarissa Sullivan
* @version 1.0
* @date   02.10.2019
*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class ErfolgWindow extends JFrame {
    private JLabel success;
    private JButton zurückButton;

	private JFrame frame;
	private Manager vm;
	
    public ErfolgWindow(JFrame frame, Manager vm) {

    	
    	this.frame = frame;
    	this.vm = vm;
    	
        success = new JLabel ("Export erfolgreich.");
        zurückButton = new JButton ("Zurück");

        setPreferredSize (new Dimension (944, 574));
        setLayout (null);

        add (success);
        add (zurückButton);

        success.setBounds (406, 240, 115, 35);
        zurückButton.setBounds (370, 310, 175, 40);
        
        JFrame windowFrame = new JFrame ("MyPanel");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add (new ExportierenWindow(windowFrame, vm));
        frame.pack();
        frame.setVisible (true);
    }

}
