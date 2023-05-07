package org.app.GUI.Component;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;
import org.app.Customer.Customer;
import org.app.GUI.Component.Features.GUIUtil;
import org.app.GUI.MainGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class MemberRegistration extends JPanel{     
    private DefaultComboBoxModel<Integer> defaultComboBoxModel1;
    private DefaultComboBoxModel<String> defaultComboBoxModel2;
    private JComboBox<Integer> comboBox1;
    private JTextField textField2;
    private JTextField textField3;
    private JComboBox<String> comboBox2;
    private JButton submitButton;
    private MainGUI mainGUI;

    public MemberRegistration(MainGUI mainGUI) {
        this.setLayout(new GridLayoutManager(6, 3, new Insets(0, 0, 0, 0), -1, -1));
        final Spacer spacer1 = new Spacer();
        this.add(spacer1, new GridConstraints(0, 1, 5, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        submitButton = new JButton();
        submitButton.setText("Submit");
        this.add(submitButton, new GridConstraints(5, 2, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        comboBox2 = new JComboBox<>();
        defaultComboBoxModel2 = new DefaultComboBoxModel<>();
        defaultComboBoxModel2.addElement("Member");
        defaultComboBoxModel2.addElement("VIP");
        comboBox2.setModel(defaultComboBoxModel2);
        this.add(comboBox2, new GridConstraints(4, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        textField3 = new JTextField();
        this.add(textField3, new GridConstraints(3, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        textField2 = new JTextField();
        textField2.setText("");
        this.add(textField2, new GridConstraints(2, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        comboBox1 = new JComboBox<>();
        defaultComboBoxModel1 = new DefaultComboBoxModel<>();
        comboBox1.setModel(defaultComboBoxModel1);
        this.add(comboBox1, new GridConstraints(1, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final JLabel label1 = new JLabel();
        label1.setText("ID customer");
        this.add(label1, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label2 = new JLabel();
        label2.setText("Nama");
        this.add(label2, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label3 = new JLabel();
        label3.setText("Nomor Telepon");
        this.add(label3, new GridConstraints(3, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label4 = new JLabel();
        label4.setText("Tipe Member");
        this.add(label4, new GridConstraints(4, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));

        this.mainGUI = mainGUI;
        userDefinedConfig();
    }

    private void userDefinedConfig() {
        this.setName("Member Registration");

        for(Customer customer : mainGUI.dataStore.customers().getNotRegisteredCustomers()) {
            defaultComboBoxModel1.addElement(customer.getId());
        }

        textField3.addKeyListener(GUIUtil.numericTextFieldListener());

        submitButton.addActionListener(submitAction(
            comboBox1,
            textField2,
            textField3,
            comboBox2
        ));
    }

    private ActionListener submitAction(JComboBox<Integer> idField, JTextField nameField, JTextField numberField, JComboBox<String> typeField) {
        return new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int id = (int) idField.getSelectedItem();
                String name = nameField.getText();
                String number = numberField.getText();
                String type = typeField.getSelectedItem().toString();
                if(type.equals("Member")){
                    mainGUI.dataStore.customers().turnToMember(id, name, number);
                }else {
                    mainGUI.dataStore.customers().turnToVIP(id, name, number);
                }
                
                defaultComboBoxModel1.removeElement(id);

                System.out.println(id);
                System.out.println(name);
                System.out.println(number);
                System.out.println(type);
                System.out.println();
            }
        };
    }

}
