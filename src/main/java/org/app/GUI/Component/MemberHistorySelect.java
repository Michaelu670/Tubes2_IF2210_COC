package org.app.GUI.Component;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import org.app.Customer.Customer;
import org.app.GUI.MainGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MemberHistorySelect extends JPanel {
    private JList<Integer> list1;
    private JButton lihatHistoryButton;
    private DefaultListModel<Integer> defaultListModel1;
    private JScrollPane scrollBar1;
    private MainGUI mainGUI;

    public MemberHistorySelect(MainGUI mainGUI) {
        this.setLayout(new GridLayoutManager(3, 1, new Insets(0, 0, 0, 0), -1, -1));
        final JLabel label1 = new JLabel();
        label1.setText("Pilih ID Customer");
        this.add(label1, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        list1 = new JList<>();
        defaultListModel1 = new DefaultListModel<>();
        list1.setModel(defaultListModel1);
        this.add(list1, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(150, 50), null, 0, false));
        scrollBar1 = new JScrollPane(list1);
        this.add(scrollBar1, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        lihatHistoryButton = new JButton();
        lihatHistoryButton.setText("Lihat History");
        this.add(lihatHistoryButton, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));

        this.mainGUI = mainGUI;
        userDefinedConfig();
    }

    public void userDefinedConfig() {
        scrollBar1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        this.setName("Member History Select");

        for(Customer customer : mainGUI.dataStore.customers().getCustomerList()) {
            defaultListModel1.addElement(customer.getId());
        }

        lihatHistoryButton.addActionListener(lihatHistoryAction(mainGUI, list1));
    }


    private ActionListener lihatHistoryAction(MainGUI mainGUI, JList<Integer> list) {
        return new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int id = list.getSelectedValue();
                System.out.println(id); // TODO
//                mainGUI.newTabAction(new MemberHIstoryShow(id));
            }
        };
    }

}
