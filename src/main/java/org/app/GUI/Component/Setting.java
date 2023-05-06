package org.app.GUI.Component;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;

import javax.swing.*;
import javax.swing.filechooser.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.List;

public class Setting extends JPanel {
    private JComboBox comboBox1;
    private JButton selectPathButton;
    private DefaultListModel defaultListModel1;
    private JList list1;
    private JScrollPane scrollBar1;
    private JButton addPluginButton;
    private JButton deletePluginButton;
    private String storagePath;
    public Setting() {
        this.setLayout(new GridLayoutManager(5, 3, new Insets(0, 0, 0, 0), -1, -1));
        final JLabel label1 = new JLabel();
        label1.setText("Data Format");
        this.add(label1, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        comboBox1 = new JComboBox();
        final DefaultComboBoxModel defaultComboBoxModel1 = new DefaultComboBoxModel();
        defaultComboBoxModel1.addElement("JSON");
        defaultComboBoxModel1.addElement("XML");
        defaultComboBoxModel1.addElement("OBJ");
        comboBox1.setModel(defaultComboBoxModel1);
        this.add(comboBox1, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label2 = new JLabel();
        label2.setText("Storage Path");
        this.add(label2, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label3 = new JLabel();
        label3.setText("Plugin");
        this.add(label3, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        selectPathButton = new JButton();
        selectPathButton.setText("Select Path");
        this.add(selectPathButton, new GridConstraints(1, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        defaultListModel1 = new DefaultListModel();
        list1 = new JList(defaultListModel1);
        this.add(list1, new GridConstraints(3, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        scrollBar1 = new JScrollPane(list1);
        this.add(scrollBar1, new GridConstraints(3, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        addPluginButton = new JButton();
        addPluginButton.setText("+ Add Plugin");
        this.add(addPluginButton, new GridConstraints(2, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        deletePluginButton = new JButton();
        deletePluginButton.setText("Delete Plugin");
        this.add(deletePluginButton, new GridConstraints(4, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));

        userDefinedConfig();
    }

    public void userDefinedConfig() {
        scrollBar1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollBar1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        String[] pluginsData = {"qwe", "w", "", "dqWqw", "dqw", "dqw", "", "ewf", "eq", "gr", "gwtr", "je", "tr", "uytui", "ly"}; // TODO : just for testing, because not have real data
        for(String plugin : pluginsData) {
            defaultListModel1.addElement(plugin);
        }

        this.setName("Setting");
        selectPathButton.addActionListener(selectPathAction());
        addPluginButton.addActionListener(addPluginAction());
        deletePluginButton.addActionListener(deletePluginAction());
    }

    private ActionListener selectPathAction() {
        return new ActionListener(){
            public void actionPerformed(ActionEvent e){
                JFileChooser dialog = new JFileChooser();
                dialog.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                int choice = dialog.showSaveDialog(null);
                if (choice == JFileChooser.APPROVE_OPTION) {
                    storagePath = dialog.getSelectedFile().getAbsolutePath();
                    System.out.println(storagePath);
                }
            }
        };
    }

    private ActionListener addPluginAction() {
        return new ActionListener(){
            public void actionPerformed(ActionEvent e){
                JFileChooser dialog = new JFileChooser();
                dialog.setAcceptAllFileFilterUsed(false);
                dialog.addChoosableFileFilter(new FileNameExtensionFilter("*.jar", "jar"));
                int choice = dialog.showSaveDialog(null);
                if (choice == JFileChooser.APPROVE_OPTION) {
                    String filepath = dialog.getSelectedFile().getAbsolutePath();
                    defaultListModel1.addElement(filepath);
                }
            }
        };
    }

    private ActionListener deletePluginAction() {
        return new ActionListener(){
            public void actionPerformed(ActionEvent event){
                int idx = list1.getSelectedIndex();
                defaultListModel1.remove(idx);
            }
        };
    }
}
