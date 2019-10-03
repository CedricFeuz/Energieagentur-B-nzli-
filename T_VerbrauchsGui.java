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
 * Dem Benutzer wird sein taeglicher Verbrauch an Strom, in Form eines Diagrammes
 * angezeigt. Der Benutzer waehlt im Kalender aus, fuer welchen Tag er seinen
 * Verbrauch sehen will. Die blaue Linie entspricht dem Verbrauch der Einspesung
 * und die rote Linie dem Bezug.
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

    public T_VerbrauchsGui(JFrame frame, Manager vm, Kalender kalender) {

        //instanzieren
        this.frame = frame;
        this.vm = vm;
        this.kalender = kalender;
    }

    public void gui() {
        
        //Fensterdetails
        frame.setTitle("Tagesverbrauch");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Groesse bei Minimierung des Fensters 
        frame.setSize(944, 600);
        frame.setLayout(new BorderLayout(150, 100));
        
        zuruekButton = new JButton("Zurück");
        kalenderPanel = new JPanel();
        diagrammPanel = new JPanel();
        buttonPanel = new JPanel();

        //komponente den Panels zufuegen
        //Fenster
        buttonPanel.add(zuruekButton);
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JScrollPane pane = new JScrollPane(panel1);
        //Layouts setzen
        panel1.setLayout(new BorderLayout());
        panel2.setLayout(new BorderLayout(20, 0));
        kalenderPanel.setLayout(new BorderLayout(0, -250));
        diagrammPanel.setLayout(new BorderLayout(0, 0));

        //Komponente den Panels zufügen
        panel2.add(kalenderPanel, BorderLayout.NORTH);
        panel2.add(diagrammPanel, BorderLayout.CENTER);

        panel1.add(panel2);

        //Kalender dem Panel zufuegen 
        kalenderPanel.add(kalender.getContentPane(), BorderLayout.NORTH);
        diagrammPanel.add(new Kalender().getContentPane());
        
        //Diagramm dem Panel zufuegen

        //zum erkennen wo die Panels plaziert sind
        //kalenderPanel.setBackground(Color.gray);
        //diagrammPanel.setBackground(Color.red);

        //Komponente dem Fenster zufuegen
        frame.getContentPane().add(buttonPanel, BorderLayout.WEST);
        frame.getContentPane().add(pane, BorderLayout.CENTER);
        frame.getContentPane().add(new JPanel(), BorderLayout.EAST);
        
        frame.setResizable(false);
        frame.setVisible(true);
    }

    public static void main(String[] arguments) {
        T_VerbrauchsGui tvg = new T_VerbrauchsGui(new JFrame(), new Manager(), new Kalender());
        tvg.gui();
    }
}
