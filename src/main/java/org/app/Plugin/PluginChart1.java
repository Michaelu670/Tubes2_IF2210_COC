package org.app.Plugin;

import org.app.DataStore.DataSaver;
import org.app.DataStore.DataStore;
import org.app.DataStore.DataStoreInterface;
import org.app.GUI.MainGUI;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;

public class PluginChart1 extends BasePlugin implements Plugin, Runnable {
    @Override
    public void onEnable(MainGUI mainGUI, DataStoreInterface dataStore) {
        this.mainGUI = mainGUI;
        this.dataStore = dataStore;
        new Thread(this).start();
    }

    @Override
    public void run() {
        mainGUI.newTabAction(panel).actionPerformed(null);
        while (true) {
            try {
                // Panel initialization
                panel.removeAll();
                panel.setLayout(new java.awt.GridLayout(1, 2));

                // Create Line Chart
                JFreeChart lineChart = ChartFactory.createLineChart(
                        "Line Chart",
                        "Item", "Number of Item Sold",
                        createCategoryDataset(dataStore.inventory()),
                        org.jfree.chart.plot.PlotOrientation.VERTICAL,
                        true, true, false);

                ChartPanel lineChartPanel = new ChartPanel(lineChart);
                lineChartPanel.setPreferredSize(new java.awt.Dimension(500, 400));

                // Create Bar Chart
                JFreeChart barChart = ChartFactory.createBarChart(
                        "Bar Chart",
                        "Item", "Number of Item Sold",
                        createCategoryDataset(dataStore.inventory()),
                        org.jfree.chart.plot.PlotOrientation.VERTICAL,
                        true, true, false);

                ChartPanel barChartPanel = new ChartPanel(barChart);
                barChartPanel.setPreferredSize(new java.awt.Dimension(500, 400));

                // Add to panel
                panel.add(lineChartPanel);
                panel.add(barChartPanel);

                // Sleep 10s
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        DataStore dataStore = new DataStore();
        dataStore.load();
        DataSaver.init(dataStore);

        MainGUI mainGUI = new MainGUI(dataStore);
        PluginChart1 pluginChart1 = new PluginChart1();
        pluginChart1.onEnable(mainGUI, mainGUI.dataStore);
    }
}
