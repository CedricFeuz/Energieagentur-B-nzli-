package view;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import control.Manager;

public class ZaehlerstandGui extends JFrame {
	// VARIABELN DEKLARIEREN
	private final JFrame frame;
	private final Manager vm;
	// Komponente
	private JPanel buttonPanel, diagrammPanel;
	private JButton zuruekButton;

	public ZaehlerstandGui(JFrame frame, Manager vm) {

		// instanzieren
		this.frame = frame;
		this.vm = vm;
	}

	public void gui() {

		// Fensterdetails
		frame.setTitle("Zählerstanddiagramm");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Groesse bei Minimierung des Fensters
		frame.setSize(944, 600);
		frame.setLayout(new BorderLayout(150, 100));

		zuruekButton = new JButton("Zurück");
		diagrammPanel = new JPanel();
		buttonPanel = new JPanel();

		// komponente den Panels zufuegen
		// Fenster
		buttonPanel.add(zuruekButton);
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel pane = new JPanel();
		// Layouts setzen
		panel1.setLayout(new BorderLayout());
		panel2.setLayout(new BorderLayout(20, 0));
		diagrammPanel.setLayout(new BorderLayout(0, 0));

		// Komponente den Panels zufügen
		panel2.add(diagrammPanel, BorderLayout.CENTER);

		panel1.add(panel2);

		pane.add(panel1);
		// Kalender dem Panel zufuegen
		// diagrammPanel.add();

		// Diagramm dem Panel zufuegen

		// zum erkennen wo die Panels plaziert sind
		// kalenderPanel.setBackground(Color.gray);
		// diagrammPanel.setBackground(Color.red);

		// Komponente dem Fenster zufuegen
		this.initUI();
		frame.getContentPane().add(buttonPanel, BorderLayout.WEST);
		frame.getContentPane().add(pane, BorderLayout.CENTER);
		frame.getContentPane().add(new JPanel(), BorderLayout.EAST);

		frame.setResizable(false);
		frame.setVisible(true);
	}

	private void initUI() {

		vm.setEslEinspeisen();
		vm.setEslBezogen();
		
		XYDataset dataset = createDataset();
		JFreeChart chart = createChart(dataset);
		ChartPanel chartPanel = new ChartPanel(chart);
		chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
		chartPanel.setBackground(Color.white);
		diagrammPanel.add(chartPanel);
	}

	private JFreeChart createChart(XYDataset dataset) {
		JFreeChart chart = ChartFactory.createXYLineChart("Jahresüberblick Zählerstand", "Monat", "Zähleratand",
				dataset, PlotOrientation.VERTICAL, true, true, false);

		XYPlot plot = chart.getXYPlot();

		XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();

		renderer.setSeriesPaint(0, Color.RED);
		renderer.setSeriesStroke(0, new BasicStroke(2.0f));

		renderer.setSeriesPaint(1, Color.BLUE);
		renderer.setSeriesStroke(1, new BasicStroke(2.0f));

		plot.setRenderer(renderer);
		plot.setBackgroundPaint(Color.white);

		plot.setRangeGridlinesVisible(false);
		plot.setDomainGridlinesVisible(false);

		chart.getLegend().setFrame(BlockBorder.NONE);

		chart.setTitle(new TextTitle("Zählerstand", new Font("Serif", Font.BOLD, 18)));

		return chart;
	}

	private XYDataset createDataset() {
		XYSeries series1 = new XYSeries("Strom in das Stromnetz eingespiesen");
		for (int i = 0; i < 9; i++) {
			series1.add(i + 1, vm.getEslEinspeisen(i));
		}
		System.out.println(series1);

		XYSeries series2 = new XYSeries("Strom vom Stromnetz bezogen");
		for (int i = 0; i < 9; i++) {
			series1.add(i + 1, vm.getEslBezogen(i));
		}
		System.out.println(series2);
		XYSeriesCollection dataset = new XYSeriesCollection();
		dataset.addSeries(series1);
		dataset.addSeries(series2);

		return dataset;
	}

	public static void main(String[] arguments) {
		ZaehlerstandGui jvg = new ZaehlerstandGui(new JFrame(), new Manager());
		jvg.gui();
	}
}
