package org.app.GUI.Component;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import org.app.Customer.Customer;
import org.app.Customer.CustomerSelector;
import org.app.GUI.Component.Features.GUIUtil;
import org.app.GUI.Component.Features.InventorySystemBuyOrder;
import org.app.GUI.MainGUI;
import org.app.Inventory.Holder.Bill;
import org.app.Inventory.Holder.FixedBill;
import org.app.Inventory.Item.BillItem;
import org.app.Inventory.Item.Item;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class InventorySystemBuy extends JPanel {
    private JList list1;
    private JComboBox<String> comboBox1;
    private JTextField textField1;
    private JCheckBox pakaiPoinCheckBox;
    private JComboBox<String> comboBox2;
    private DefaultComboBoxModel defaultComboBoxModel2;
    private JButton checkoutButton;
    private JButton orderButton;
    private DefaultListModel<BillItem> model;
    private JList<BillItem> list2;
    private MainGUI mainGUI;
    private Bill currentBill;
    public InventorySystemBuy(MainGUI mainGUI) {
        this.mainGUI = mainGUI;
        this.setLayout(new GridLayoutManager(5, 4, new Insets(0, 0, 0, 0), -1, -1));
        final JScrollPane scrollPane1 = new JScrollPane();
        this.add(scrollPane1, new GridConstraints(1, 0, 4, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        ArrayList<Item> items = (ArrayList<Item>) mainGUI.dataStore.inventory().itemList();
        String[] data = new String[items.size()];
        String[] imagePaths = new String[items.size()];
        for(int i=0;i<items.size();i++){
            data[i] = items.get(i).itemName();
            imagePaths[i] = items.get(i).imagePath();
        }
        list1 = new JList<>(data);
        list1.setCellRenderer(GUIUtil.imageListRenderer(imagePaths));
        scrollPane1.setViewportView(list1);
        comboBox1 = new JComboBox();
        final DefaultComboBoxModel defaultComboBoxModel1 = new DefaultComboBoxModel();
        defaultComboBoxModel1.addElement("Name");
        defaultComboBoxModel1.addElement("Category");
        defaultComboBoxModel1.addElement("Price");
        comboBox1.setModel(defaultComboBoxModel1);
        this.add(comboBox1, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        textField1 = new JTextField();
        this.add(textField1, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        pakaiPoinCheckBox = new JCheckBox();
        pakaiPoinCheckBox.setHorizontalAlignment(11);
        pakaiPoinCheckBox.setHorizontalTextPosition(2);
        pakaiPoinCheckBox.setText("Pakai Poin?");
        this.add(pakaiPoinCheckBox, new GridConstraints(3, 2, 1, 2, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label1 = new JLabel();
        label1.setText("ID");
        this.add(label1, new GridConstraints(2, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        defaultComboBoxModel2 = new DefaultComboBoxModel();
        List<Customer> customerList =
                new CustomerSelector(mainGUI.dataStore.customers())
                    .addMember()
                    .addVIP()
                    .get();
        System.out.println(customerList);
        customerList.forEach(x->{
            defaultComboBoxModel2.addElement(x.getId());
            System.out.println(x.getId());
        });
        comboBox2 = new JComboBox();
        comboBox2.setModel(defaultComboBoxModel2);
        this.add(comboBox2, new GridConstraints(2, 3, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        checkoutButton = new JButton();
        checkoutButton.setText("Checkout");
        this.add(checkoutButton, new GridConstraints(4, 2, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        orderButton = new JButton();
        orderButton.setText("Order");
        this.add(orderButton, new GridConstraints(0, 2, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));

        userDefinedConfig();
    }

    public void userDefinedConfig() {
        this.setName("Inventory System Buy");

        defaultComboBoxModel2.addElement("None");

        currentBill = new Bill(-1,0);
        mainGUI.dataStore.cashier().addBill(currentBill);
        model = new DefaultListModel<>();
        BillItem emptyBill = new BillItem(
                Item.builder()
                        .itemName("Nama")
                        .category("Nama")
                        .imagePath("Nama")
                        .sellingPrice(0)
                        .build()
        );
        emptyBill.quantity(0);
        model.addElement(emptyBill);

        final JScrollPane scrollPane2 = new JScrollPane();
        this.add(scrollPane2, new GridConstraints(1, 2, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        list2 = new JList<>(model);
        list2.setCellRenderer(new GUIUtil.ItemCellRenderer());
        scrollPane2.setViewportView(list2);

        checkoutButton.addActionListener(checkoutButtonAction());
        orderButton.addActionListener(orderButtonAction(this));
        textField1.addKeyListener(searchAction());
    }

    private ActionListener checkoutButtonAction() {
        return new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // TODO
                String userID = comboBox2.getSelectedItem().toString();
                Customer currentCustomer;
                int intUserID;
                if(userID == "None") {
                    currentCustomer = mainGUI.dataStore.customers().newCustomer();
                    intUserID = currentCustomer.getId();
                }else {
                    intUserID = Integer.parseInt(userID);
                    currentCustomer = mainGUI.dataStore.customers().getCustomerFromID(intUserID);
                }

                currentBill.user(intUserID);
                FixedBill fixedBill = mainGUI.dataStore.cashier().getFixedBill(intUserID, mainGUI.dataStore.inventory());
                currentCustomer.addFixedBill(fixedBill);

                mainGUI.closeTab().actionPerformed(null);
            }
        };
    }

    private ActionListener orderButtonAction(InventorySystemBuy parent) {
        return new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int index = list1.getSelectedIndex();
                if(index != -1) {
                    Item item = mainGUI.dataStore.inventory().getItem(index);
                    mainGUI.newTabAction(new InventorySystemBuyOrder(mainGUI, parent, item)).actionPerformed(null);
                }
            }
        };
    }
    private KeyAdapter searchAction(){
        return new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
//                    String sortType = comboBox1.getSelectedItem().toString();
//
//                    mainGUI.dataStore.inventory().se
//                    System.out.println("search dew");
                }
            }
        };
    }

    public void addItemToBill(BillItem billItem) {
        currentBill.addItem(billItem);
        model.addElement(billItem);
    }

}
