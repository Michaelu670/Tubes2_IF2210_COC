package org.app.GUI;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;


public class TabGUI extends JTabbedPane{
    private int currentTab;

    public TabGUI() {
        currentTab = 0;
        this.setTabPlacement(JTabbedPane.TOP);
    }

    public void createNewTab(JPanel newPanel) {
        currentTab++;

        this.addTab(newPanel.getName(), newPanel);
        this.setSelectedIndex(currentTab-1);
    }

    public void removeTab() {
        this.remove(this.getSelectedIndex());
        currentTab--;
    }
}
