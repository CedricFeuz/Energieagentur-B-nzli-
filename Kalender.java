package View;

/**
 * Kalender
 * @source: https://www.javacodex.com/Swing/Swing-Calendar
 */
import Control.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.*;

/**
 * @author Mia Gudelj
 * @since 2019-10-02
 * @version 1.0
 */
public class Kalender extends JFrame {

    //VARIABELN DEKLARIEREN
    private DefaultTableModel model;
    private final Calendar cal = new GregorianCalendar();
    //Komponente
    private JLabel label;
    private JButton b1, b2;
    private JPanel panel;
    private JTable table;
    private JScrollPane pane;

    public Kalender() {
        gui();
    }
    
    private void gui() {

        label = new JLabel();
        label.setHorizontalAlignment(SwingConstants.CENTER);

        //Actionlistener den Knoepfen zufuegen
        b1 = new JButton("<-");
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                //geht einen Monat nach zurueck
                cal.add(Calendar.MONTH, -1);
                updateMonth();
            }
        });

        b2 = new JButton("->");
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                //geht einen Monat nach vorn
                cal.add(Calendar.MONTH, +1);
                updateMonth();
            }
        });
        
        //Kopf von Kalender
        panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(b1, BorderLayout.WEST);
        panel.add(label, BorderLayout.CENTER);
        panel.add(b2, BorderLayout.EAST);
        
        //Farbe der Knoepfe setzen 
        b1.setBackground(Color.white);
        b2.setBackground(Color.white);
        

        String[] columns = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
        model = new DefaultTableModel(null, columns);
        table = new JTable(model);
        pane = new JScrollPane(table);
        
        this.add(panel, BorderLayout.NORTH);
        this.add(pane, BorderLayout.CENTER);

        this.updateMonth();

    }

    private void updateMonth() {
        cal.set(Calendar.DAY_OF_MONTH, 1);

        String month = cal.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.GERMANY);
        int year = cal.get(Calendar.YEAR);
        label.setText(month + " " + year);

        int startDay = cal.get(Calendar.DAY_OF_WEEK);
        int numberOfDays = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        int weeks = 6;

        model.setRowCount(0);
        model.setRowCount(weeks);

        int i = startDay - 1;
        for (int day = 1; day <= numberOfDays; day++) {
            model.setValueAt(day, i / 7, i % 7);
            i = i + 1;
        }        
    }
    
    public DefaultTableModel getModel() {
        return this.model;
    }

    public static void main(String[] arguments) {
        Kalender g = new Kalender();
        g.gui();
    }
}
