package org.app.GUI.Component;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import org.app.GUI.MainGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MemberMenu extends JPanel {
    private JButton registrationButton;
    private JButton listButton;
    private JButton historyButton;
    private MainGUI mainGUI;

    public MemberMenu(MainGUI mainGUI) {
        this.setLayout(new GridLayoutManager(3, 1, new Insets(0, 0, 0, 0), -1, -1));
        registrationButton = new JButton();
        registrationButton.setText("Registration");
        this.add(registrationButton, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        listButton = new JButton();
        listButton.setText("List");
        this.add(listButton, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        historyButton = new JButton();
        historyButton.setText("History");
        this.add(historyButton, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));

        this.mainGUI = mainGUI;
        userDefinedConfig();
    }

    private void userDefinedConfig() {
        this.setName("Member Menu");
        registrationButton.addActionListener(newTabMemberRegistration(mainGUI));
        historyButton.addActionListener(newTabMemberHistory(mainGUI));
    }


    private ActionListener newTabMemberRegistration(MainGUI mainGUI) {
        return new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainGUI.newTabAction(new MemberRegistration(mainGUI)).actionPerformed(null);
            }
        };
    }

    private ActionListener newTabMemberHistory(MainGUI mainGUI) {
        return new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainGUI.newTabAction(new MemberHistorySelect(mainGUI)).actionPerformed(null);
            }
        };
    }


}
