package org.app.Plugin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JPanel;

public abstract class BasePlugin {
    protected static JPanel panel = null;
    protected static List<String> data; // Data from db

    public BasePlugin() {
        if (panel == null) {
            panel = new JPanel();
            // Get data from db
            data = new ArrayList<>(List.of("coffee", "bread", "coffee", "porridge", "tea", "tea")); // Temporary data
        }
    }

    public org.jfree.data.category.DefaultCategoryDataset createCategoryDataset() {
        org.jfree.data.category.DefaultCategoryDataset dataset = new org.jfree.data.category.DefaultCategoryDataset();
        for (int i = 0; i < data.size(); i++) {
            dataset.addValue(Collections.frequency(data, data.get(i)), "Count", data.get(i));
        }
        return dataset;
    }

    public org.jfree.data.general.PieDataset createPieDataset() {
        org.jfree.data.general.DefaultPieDataset dataset = new org.jfree.data.general.DefaultPieDataset();
        for (int i = 0; i < data.size(); i++) {
            dataset.setValue(data.get(i), Collections.frequency(data, data.get(i)));
        }
        return dataset;
    }

    // Use thread to update data
    // @Override
    // public void run() {
    // while (true) {
    // // Get updated data from db
    // try {
    // Thread.sleep(10000);
    // data = new ArrayList<>(List.of("1", "2", "2", "3", "3", "3"));
    // try {
    // Thread.sleep(10000);
    // } catch (InterruptedException e) {
    // e.printStackTrace();
    // }
    // } catch (InterruptedException e) {
    // e.printStackTrace();
    // }
    // }
    // }
}
