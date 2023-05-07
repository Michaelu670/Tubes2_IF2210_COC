package org.app.GUI.Component.Features;


import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import org.app.GUI.Component.InventorySystemBuy;
import org.app.GUI.MainGUI;
import org.app.Inventory.Item.BillItem;
import org.app.Inventory.Item.Item;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InventorySystemBuyOrder extends JPanel{
    private JTextField numfieldTextField;
    private JLabel label1;
    private JButton button1;
    private JComboBox<String> comboBox1;
    private JLabel label3;
    private JButton button2;
    private JTextArea textArea1;
    private JButton cancelButton;
    private JButton OKButton;
    private MainGUI mainGUI;
    private InventorySystemBuy parent;
    private Item item;

    public InventorySystemBuyOrder(MainGUI mainGUI, InventorySystemBuy parent, Item item) {
        this.parent = parent;
        this.item = item;
        this.setLayout(new GridLayoutManager(7, 5, new Insets(0, 0, 0, 0), -1, -1));
        label1 = new JLabel();
        label1.setText("Nama - Harga");
        this.add(label1, new GridConstraints(0, 0, 1, 5, GridConstraints.ANCHOR_NORTH, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label2 = new JLabel();
        label2.setText("Quantity");
        this.add(label2, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 1, false));
        label3 = new JLabel();
        label3.setText("Stok: ");
        this.add(label3, new GridConstraints(1, 1, 1, 4, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        numfieldTextField = new JTextField();
        numfieldTextField.setText("numfield");
        this.add(numfieldTextField, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final JLabel label4 = new JLabel();
        label4.setText("Sales Type");
        this.add(label4, new GridConstraints(3, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        button1 = new JButton();
        button1.setText("-");
        this.add(button1, new GridConstraints(2, 1, 1, 3, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        button2 = new JButton();
        button2.setText("+");
        this.add(button2, new GridConstraints(2, 4, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        comboBox1 = new JComboBox<>();
        final DefaultComboBoxModel<String> defaultComboBoxModel1 = new DefaultComboBoxModel<>();
        defaultComboBoxModel1.addElement("Dine-in");
        defaultComboBoxModel1.addElement("Go-Food");
        defaultComboBoxModel1.addElement("Grab-Food");
        defaultComboBoxModel1.addElement("Take-Away");
        comboBox1.setModel(defaultComboBoxModel1);
        this.add(comboBox1, new GridConstraints(3, 1, 1, 4, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label5 = new JLabel();
        label5.setText("Notes");
        this.add(label5, new GridConstraints(4, 0, 1, 5, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        textArea1 = new JTextArea();
        this.add(textArea1, new GridConstraints(5, 0, 1, 5, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(150, 50), null, 0, false));
        cancelButton = new JButton();
        cancelButton.setText("Cancel");
        this.add(cancelButton, new GridConstraints(6, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        OKButton = new JButton();
        OKButton.setText("OK");
        this.add(OKButton, new GridConstraints(6, 1, 1, 4, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));

        this.mainGUI = mainGUI;
        userDefinedConfig();
    }

    private void userDefinedConfig() {
        this.setName("Inventory System Buy Order");

        label1.setText(item.itemName() + " - " + item.sellingPrice());
        numfieldTextField.setText("1");

        label3.setText("Stok : " + item.stock());

        this.button1.addActionListener(minusButtonAction(mainGUI));
        this.button2.addActionListener(plusButtonAction(mainGUI));
        this.cancelButton.addActionListener(cancelButtonAction());
        this.OKButton.addActionListener(okButtonAction());

        numfieldTextField.addKeyListener(GUIUtil.numericTextFieldListener());
    }

    private ActionListener cancelButtonAction() {
        return new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainGUI.closeTab().actionPerformed(null);
            }
        };
    }

    private ActionListener okButtonAction() {
        return new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                BillItem billItem = new BillItem(item);
                billItem.quantity(Integer.parseInt(numfieldTextField.getText()));
                billItem.orderType(comboBox1.getSelectedItem().toString());
                billItem.notes(textArea1.getText());
                parent.addItemToBill(billItem);
                mainGUI.closeTab().actionPerformed(null);
            }
        };
    }

    private ActionListener plusButtonAction(MainGUI mainGUI) {
        return new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int number = Integer.parseInt(numfieldTextField.getText()) + 1;
                if(number <= item.stock()){
                    numfieldTextField.setText(Integer.toString(number));
                }
            }
        };
    }

    private ActionListener minusButtonAction(MainGUI mainGUI) {
        return new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int number = Integer.parseInt(numfieldTextField.getText()) - 1;
                if(number > 0){
                    numfieldTextField.setText(Integer.toString(number));
                }
            }
        };
    }

}
