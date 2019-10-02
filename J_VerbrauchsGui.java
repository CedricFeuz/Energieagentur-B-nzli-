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
 * Dem Benutzer wird sein jährlicher Verbrauch an Strom, in Form eines Diagrammes angezeigt. 
 * Die blaue Linie entspricht dem Verbrauch der Einspesung und die rote Linie dem Bezug. 
 */

public class J_VerbrauchsGui extends JFrame {

    //VARIABELN DEKLARIEREN
    private final JFrame frame;
    private final Manager vm;
    //Komponente
    private JPanel buttonPanel, diagrammPanel;
    private JButton zuruekButton;
    
    
    public J_VerbrauchsGui(JFrame frame, Manager vm) {

        //instanzieren
        this.frame = frame;
        this.vm = vm;
        
        //Fensterdetails
        frame.setTitle("Jahresverbrauch");
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
        diagrammPanel = new JPanel();
        buttonPanel = new JPanel();
        
        //komponente den Panels zufügen
        //Fenster
        buttonPanel.add(zuruekButton);
        JPanel panel = new JPanel(new BorderLayout());
        //JPanel panel = new JPanel(new B(1, 1, 10, 10));
        
        panel.add(diagrammPanel);
        
        //Diagramm aufrufen
        //TODO
        
        //Farben der Komponenten setzen
        zuruekButton.setBackground(Color.white);
        diagrammPanel.setBackground(Color.gray.brighter());
        
        //Komponente dem Fenster zufügen
        frame.getContentPane().add(buttonPanel, BorderLayout.WEST);
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        frame.getContentPane().add(new JPanel(), BorderLayout.EAST);
    }
    
    public static void main(String[] arguments) {
        new J_VerbrauchsGui(new JFrame(), new Manager());
    }
}
