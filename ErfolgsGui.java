package View;

/**
 * Teilweise mit GUIGenie generiert
 *
 * @author Clarissa Sullivan
 * @version 1.1
 * @since 20.08.2019
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class ErfolgsGui extends JFrame {

    private JPanel panel;
    private JLabel success;
    private JButton zurückButton;

    private JFrame frame;
    private Manager vm;

    public ErfolgsGui(JFrame frame, Manager vm) {

        this.frame = frame;
        this.vm = vm;
    }
    public void gui() {
        success = new JLabel("Export erfolgreich.");
        frame.setPreferredSize(new Dimension(944, 600));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        zurückButton = new JButton("Zurück");
        panel = new JPanel();

        panel.setLayout(null);

        panel.add(success);
        panel.add(zurückButton);

        success.setBounds(406, 240, 115, 35);
        zurückButton.setBounds(370, 310, 175, 40);

        frame.getContentPane().add(panel);
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        ErfolgsGui eg = new ErfolgsGui(new JFrame(), new Manager());
        eg.gui();

    }

}
