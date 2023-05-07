package org.app.GUI.Component;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import org.app.GUI.Component.Features.Clock;
import org.app.GUI.MainGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HomePage extends JPanel {
    final private JButton memberButton;
    final private JButton sistemUsahaBarangButton;
    final private JButton laporanButton;
    final private MainGUI mainGUI;
    public HomePage(MainGUI mainGUI) {
        this.setLayout(new GridLayoutManager(2, 2, new Insets(0, 0, 0, 0), -1, -1));
        this.setBackground(new Color(-1));
        final JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        panel2.setBackground(new Color(-15624448));
        this.add(panel2, new GridConstraints(1, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        panel2.add(new Clock(), new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JPanel panel3 = new JPanel();
        panel3.setLayout(new GridLayoutManager(6, 1, new Insets(0, 0, 0, 0), -1, -1));
        this.add(panel3, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        final JLabel label2 = new JLabel();
        label2.setText("Tugas Besar 2 IF2210 - Kelompok COC");
        panel3.add(label2, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label3 = new JLabel();
        label3.setText("13521049 - Brian Kheng");
        panel3.add(label3, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label4 = new JLabel();
        label4.setText("13521110 - Yanuar Sano Nur Rasyid");
        panel3.add(label4, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label5 = new JLabel();
        label5.setText("13521112 - Rayhan Hanif Maulana Pradana");
        panel3.add(label5, new GridConstraints(3, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label6 = new JLabel();
        label6.setText("13521137 - Michael Utama");
        panel3.add(label6, new GridConstraints(4, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label7 = new JLabel();
        label7.setText("13521173 - Dewana Gustavus Haraka Otang ");
        panel3.add(label7, new GridConstraints(5, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JPanel panel4 = new JPanel();
        panel4.setLayout(new GridLayoutManager(1, 3, new Insets(0, 0, 0, 0), -1, -1));
        this.add(panel4, new GridConstraints(0, 0, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        memberButton = new JButton();
        memberButton.setText("Member");
        panel4.add(memberButton, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        sistemUsahaBarangButton = new JButton();
        sistemUsahaBarangButton.setText("Sistem Usaha Barang");
        panel4.add(sistemUsahaBarangButton, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        laporanButton = new JButton();
        laporanButton.setText("Laporan");
        panel4.add(laporanButton, new GridConstraints(0, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));


        this.mainGUI = mainGUI;
        userDefinedConfig();
    }

    private void userDefinedConfig() {
        memberButton.addActionListener(newTabMember(mainGUI));
        sistemUsahaBarangButton.addActionListener(newTabInventorySystem(mainGUI));
        laporanButton.addActionListener(newTabReport(mainGUI));
        this.setName("Home Page");

    }

    private ActionListener newTabMember(MainGUI mainGUI) {
        return new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainGUI.newTabAction(new MemberMenu(mainGUI)).actionPerformed(null);
            }
        };
    }

    private ActionListener newTabInventorySystem(MainGUI mainGUI) {
        return new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainGUI.newTabAction(new InventorySystemMenu(mainGUI)).actionPerformed(null);
            }
        };
    }

    private ActionListener newTabReport(MainGUI mainGUI) {
        return new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainGUI.newTabAction(new Report(mainGUI)).actionPerformed(null);
            }
        };
    }

}
