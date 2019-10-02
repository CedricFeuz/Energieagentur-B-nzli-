package View;
/**
 * @author Mia Gudelj
 * @since 02.10.0219
 * @version 1.0
 * 
 */

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;

/**
 * Dem Benutzer wird sein täglicher Verbrauch an Strom, in Form eines Diagrammes angezeigt. 
 * Der Benutzer wählt im Kalender aus, für welchen Tag er seinen Verbrauch sehen will.
 * Die blaue Linie entspricht dem Verbrauch der Einspesung und die rote Linie dem Bezug. 
 */

public class T_VerbrauchsGui extends JFrame {

    //VARIABELN DEKLARIEREN
    private final JFrame frame;
    private final Manager vm;
    private final Kalender kalender;
    //Komponente
    private JPanel buttonPanel, kalenderPanel, diagrammPanel;
    private JButton zuruekButton;
    
    //Kalender
    private DefaultTableModel model;
    private final Calendar cal = new GregorianCalendar();
    private JLabel label;
    
    GridBagConstraints c = new GridBagConstraints();
    
    
    public T_VerbrauchsGui(JFrame frame, Manager vm, Kalender kalender) {

        //instanzieren
        this.frame = frame;
        this.vm = vm;
        this.kalender = kalender;
        
        //Fensterdetails
        frame.setTitle("Tagesverbrauch");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //maximiert das Fenster 
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        frame.setSize(1200, 600);
        frame.setLayout(new BorderLayout(300, 10));
        
        this.init();
        
        frame.setResizable(true);
        frame.setVisible(true);
    }
    
    private void init() {
        zuruekButton = new JButton ("Zurück");
        kalenderPanel = new JPanel();
        diagrammPanel = new JPanel();
        buttonPanel = new JPanel();
        
        
        //komponente den Panels zufügen
        //Fenster
        buttonPanel.add(zuruekButton);
        JPanel panel1 = new JPanel(new BorderLayout());
        JPanel panel2 = new JPanel(new GridLayout(2, 1, 10, 10));
        
        panel2.add(kalenderPanel);
        panel2.add(diagrammPanel);
        
        panel1.add(panel2);
        
        //Kalender aufrufen
        kalenderPanel.add(kalender.getContentPane());
        
        //Diagramm aufrufen
        
        
        //Farben der Komponenten setzen
        zuruekButton.setBackground(Color.white);
        //kalenderPanel.setBackground(Color.gray);
        //diagrammPanel.setBackground(Color.gray.brighter());
        
        //Komponente dem Fenster zufügen
        frame.getContentPane().add(buttonPanel, BorderLayout.WEST);
        frame.getContentPane().add(panel1, BorderLayout.CENTER);
        frame.getContentPane().add(new JPanel(), BorderLayout.EAST);
    }
    
    public static void main(String[] arguments) {
        new T_VerbrauchsGui(new JFrame(), new Manager(), new Kalender());
    }
}
