package org.app.GUI.Component;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import org.app.GUI.MainGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InventorySystemMenu extends JPanel {
    private JButton jualBarangButton;
    private JButton beliBarangButton;
    private MainGUI mainGUI;

    public InventorySystemMenu(MainGUI mainGUI) {
        this.setLayout(new GridLayoutManager(2, 1, new Insets(0, 0, 0, 0), -1, -1));
        jualBarangButton = new JButton();
        jualBarangButton.setText("Jual Barang");
        this.add(jualBarangButton, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        beliBarangButton = new JButton();
        beliBarangButton.setText("Beli Barang");
        this.add(beliBarangButton, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));

        this.mainGUI = mainGUI;
        userDefinedConfig();
    }

    public void userDefinedConfig() {
        this.setName("Inventory System Menu");
        jualBarangButton.addActionListener(jualBarangButtonAction(mainGUI));
        beliBarangButton.addActionListener(beliBarangButtonAction(mainGUI));
    }

    private ActionListener jualBarangButtonAction(MainGUI mainGUI) {
        return new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainGUI.newTabAction(new InventorySystemSell(mainGUI)).actionPerformed(null);
            }
        };
    }

    private ActionListener beliBarangButtonAction(MainGUI mainGUI) {
        return new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainGUI.newTabAction(new InventorySystemBuy(mainGUI, null)).actionPerformed(null);
            }
        };
    }
}
