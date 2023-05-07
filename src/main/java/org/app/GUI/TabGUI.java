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
        this.addTab(newPanel.getName(), newPanel);

        currentTab = this.getTabCount();
        this.setSelectedIndex(currentTab-1);
    }

    public void removeTab() {
        if(this.getTabCount() != 0){
            this.remove(this.getSelectedIndex());
            currentTab = this.getTabCount();
        }
    }
}
