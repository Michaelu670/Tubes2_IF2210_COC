package org.app.Plugin;

import javax.swing.JPanel;

import org.app.DataStore.DataStoreInterface;
import org.app.GUI.MainGUI;

public class BasePlugin {
    protected JPanel panel;
    protected MainGUI mainGUI;
    protected DataStoreInterface dataStore;

    public BasePlugin() {
        panel = new JPanel();
    }

    public org.jfree.data.category.DefaultCategoryDataset createCategoryDataset() {
        org.jfree.data.category.DefaultCategoryDataset dataset = new org.jfree.data.category.DefaultCategoryDataset();
        for (int i = 0; i < dataStore.inventory().itemList().size(); i++) {
            dataset.addValue(dataStore.inventory().itemList().get(i).stock(), "Stock", dataStore.inventory().itemList().get(i).itemName());
        }
        return dataset;
    }

    public org.jfree.data.general.PieDataset createPieDataset() {
        org.jfree.data.general.DefaultPieDataset dataset = new org.jfree.data.general.DefaultPieDataset();
        for (int i = 0; i < dataStore.inventory().itemList().size(); i++) {
            dataset.setValue(dataStore.inventory().itemList().get(i).itemName(), dataStore.inventory().itemList().get(i).stock());
        }
        return dataset;
    }
}
