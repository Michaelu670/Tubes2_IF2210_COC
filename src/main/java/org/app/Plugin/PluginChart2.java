package org.app.Plugin;

import org.app.GUI.MainGUI;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;

public class PluginChart2 extends BasePlugin implements Plugin {
    @Override
    public void onEnable(MainGUI mainGUI) {
        // Panel initialization
        panel.removeAll();
        panel.setLayout(new java.awt.GridLayout(1, 1));

        // Create Pie Chart
        JFreeChart pieChart = ChartFactory.createPieChart(
                "Pie Chart",
                createPieDataset(),
                true, true, false);

        ChartPanel pieChartPanel = new ChartPanel(pieChart);
        pieChartPanel.setPreferredSize(new java.awt.Dimension(500, 400));

        // Add to panel & frame
        panel.add(pieChartPanel);
        mainGUI.newTabAction(panel).actionPerformed(null);
    }
}
