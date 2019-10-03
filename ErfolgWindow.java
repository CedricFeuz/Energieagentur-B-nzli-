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

public class ErfolgWindow extends JFrame {
	
	private JPanel panel;
	private JLabel success;
    private JButton zurückButton;
    
    
	private JFrame frame;
	private Manager vm;
	
    public ErfolgWindow(JFrame frame, Manager vm) {

    	
    	this.frame = frame;
    	this.vm = vm;
    	
        success = new JLabel ("Export erfolgreich.");
        zurückButton = new JButton ("Zurück");
        panel = new JPanel();

        frame.setPreferredSize (new Dimension (944, 574));
    	panel.setPreferredSize(new Dimension(944, 574));
		panel.setLayout(null);
		
		frame.setResizable(false);

        /* add (success);
        add (zurückButton);
        */
		
		panel.add(success);
		panel.add(zurückButton);

        success.setBounds (406, 240, 115, 35);
        zurückButton.setBounds (370, 310, 175, 40);
        
        JFrame windowFrame = new JFrame ("MyPanel");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add (panel);
        frame.pack();
        frame.setVisible (true);
    }
    
	public static void main(String[] args) {
	new ErfolgWindow(new JFrame(), new Manager());

	}


}
