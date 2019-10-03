package view;
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

import control.Manager;

import java.io.IOException;
import javax.swing.JPanel;

//import javafx.scene.layout.Background;

public class StartGui extends JFrame {

	private JFrame frame;
	private Manager vm;

	private JButton tagesvbd;
	private JButton jahresvbd;
	private JButton zaehlerstandd;
	private JButton importbutton;
	private JButton exportbutton;
	private JLabel copyrighttext;

	Image img = Toolkit.getDefaultToolkit().getImage("background.jpg");

	public StartGui(JFrame frame, Manager vm) {

		this.frame = frame;
		this.vm = vm;

		tagesvbd = new JButton("Tagesverbrauchsdiagramm");
		jahresvbd = new JButton("Jahresverbrauchsdiagramm");
		zaehlerstandd = new JButton("Zählerstanddiagramm");
		importbutton = new JButton("Importieren");
		exportbutton = new JButton("Exportieren");
		copyrighttext = new JLabel("Stromdatenvisualisierer Version 1.0. Alle Rechte vorbehalten.");

	}

	public void gui() {
		// TODO Auto-generated method stub
		setPreferredSize(new Dimension(944, 574));
		setLayout(null);

		add(tagesvbd);
		add(jahresvbd);
		add(zaehlerstandd);
		add(importbutton);
		add(exportbutton);
		add(copyrighttext);

		tagesvbd.setBounds(509, 115, 340, 75);
		jahresvbd.setBounds(505, 240, 340, 75);
		zaehlerstandd.setBounds(505, 370, 340, 75);
		importbutton.setBounds(100, 180, 230, 75);
		exportbutton.setBounds(100, 305, 230, 75);
		copyrighttext.setBounds(300, 535, 355, 25);

		JFrame windowFrame = new JFrame("MyPanel");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(new StartGui(windowFrame, vm));
		frame.pack();
		frame.setVisible(true);

		tagesvbd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				vm.openT_VerbrauchsGui();
			}
		});

		jahresvbd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				vm.openJ_VerbrauchsGui();
			}
		});

		zaehlerstandd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				vm.openZaehlerstandGui();
			}
		});

		importbutton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				vm.setEslEinspeisen();
				vm.setEslBezogen();
				vm.setSdatEinspeisen();
				vm.setSdatBezogen();
			}
		});

		exportbutton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out
						.println("Dieser Button wurde noch nicht fertig programmiert. Bitte nachholen wer dies liest");

			}
		});
	}

}
