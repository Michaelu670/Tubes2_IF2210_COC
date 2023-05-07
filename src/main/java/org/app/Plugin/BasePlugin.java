package org.app.Plugin;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import javax.swing.JPanel;

import org.app.DataStore.DataStoreInterface;
import org.app.GUI.MainGUI;
import org.app.Inventory.Holder.Inventory;

public abstract class BasePlugin {
    protected JPanel panel;
    protected MainGUI mainGUI;
    protected DataStoreInterface dataStore;
    protected static List<String> data; // Data from db

    public BasePlugin() {
        panel = new JPanel();
        // Get data from db
        data = new ArrayList<>(List.of("coffee", "porridge", "tea")); // Temporary data
    }

    public org.jfree.data.category.DefaultCategoryDataset createCategoryDataset(Inventory inventory) {
        System.out.println(inventory.itemList().size());
        System.out.println(inventory.itemList());
        org.jfree.data.category.DefaultCategoryDataset dataset = new org.jfree.data.category.DefaultCategoryDataset();
        for (int i = 0; i < data.size(); i++) {
            Random random = new Random();
            dataset.addValue(random.nextInt(30), "Count", data.get(i));
        }
        return dataset;
    }

    // public org.jfree.data.general.PieDataset createPieDataset() {
    //     org.jfree.data.general.DefaultPieDataset dataset = new org.jfree.data.general.DefaultPieDataset();
    //     for (int i = 0; i < data.size(); i++) {
    //         dataset.setValue(data.get(i), Collections.frequency(data, data.get(i)));
    //     }
    //     return dataset;
    // }

}
