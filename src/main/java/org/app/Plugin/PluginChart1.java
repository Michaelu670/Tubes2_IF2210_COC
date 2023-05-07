package org.app.Plugin;

import org.app.GUI.MainGUI;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;

public class PluginChart1 extends BasePlugin implements Plugin {
    @Override
    public void onEnable(MainGUI mainGUI) {
        // Panel initialization
        panel.removeAll();
        panel.setLayout(new java.awt.GridLayout(1, 2));

        // Create Line Chart
        JFreeChart lineChart = ChartFactory.createLineChart(
                "Line Chart",
                "Item", "Number of Item Sold",
                createCategoryDataset(),
                org.jfree.chart.plot.PlotOrientation.VERTICAL,
                true, true, false);

        ChartPanel lineChartPanel = new ChartPanel(lineChart);
        lineChartPanel.setPreferredSize(new java.awt.Dimension(500, 400));

        // Create Bar Chart
        JFreeChart barChart = ChartFactory.createBarChart(
                "Bar Chart",
                "Item", "Number of Item Sold",
                createCategoryDataset(),
                org.jfree.chart.plot.PlotOrientation.VERTICAL,
                true, true, false);

        ChartPanel barChartPanel = new ChartPanel(barChart);
        barChartPanel.setPreferredSize(new java.awt.Dimension(500, 400));

        // Add to panel & frame
        panel.add(lineChartPanel);
        panel.add(barChartPanel);

        mainGUI.newTabAction(panel).actionPerformed(null);
    }
}
