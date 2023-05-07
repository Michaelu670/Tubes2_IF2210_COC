package org.app.GUI.Component;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;
import org.apache.maven.plugin.AbstractMojoExecutionException;
import org.app.Customer.Customer;
import org.app.GUI.Component.Features.ReportLabelThreading;
import org.app.GUI.MainGUI;
import org.app.Inventory.Holder.Bill;
import org.app.Inventory.Holder.FixedBill;
import org.app.Inventory.Item.BillItem;
import org.app.Inventory.Item.Item;
import org.app.Report.AbstractReport;
import org.app.Report.SalesReport;
import org.app.Report.FixedBillReport;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Report extends JPanel {
    private JButton cetakPenjualanButton;
    private JComboBox comboBox1;
    private DefaultComboBoxModel defaultComboBoxModel1;
    private JButton cetakTransaksiButton;
    private JComboBox comboBox2;
    private DefaultComboBoxModel defaultComboBoxModel2;
    private ReportLabelThreading sedangMencetakTextField;
    private MainGUI mainGUI;
    public Report(MainGUI mainGUI) {
        this.mainGUI = mainGUI;
        this.setLayout(new GridLayoutManager(4, 4, new Insets(0, 0, 0, 0), -1, -1));
        final JLabel label1 = new JLabel();
        label1.setText("Laporan Transaksi");
        this.add(label1, new GridConstraints(0, 0, 1, 2, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label2 = new JLabel();
        label2.setText("Laporan Penjualan");
        this.add(label2, new GridConstraints(0, 3, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer1 = new Spacer();
        this.add(spacer1, new GridConstraints(0, 2, 4, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(11, 159), null, 0, false));
        comboBox2 = new JComboBox();
        defaultComboBoxModel2 = new DefaultComboBoxModel();
        comboBox2.setModel(defaultComboBoxModel2);
        this.add(comboBox2, new GridConstraints(2, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(122, 32), null, 0, false));
        cetakTransaksiButton = new JButton();
        cetakTransaksiButton.setText("Cetak");
        this.add(cetakTransaksiButton, new GridConstraints(3, 0, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        cetakPenjualanButton = new JButton();
        cetakPenjualanButton.setText("Cetak");
        this.add(cetakPenjualanButton, new GridConstraints(1, 3, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(85, 65), null, 0, false));
        final JLabel label3 = new JLabel();
        label3.setText("ID Transaksi");
        this.add(label3, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label4 = new JLabel();
        label4.setText("ID Customer");
        this.add(label4, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(66, 65), null, 0, false));
        comboBox1 = new JComboBox();
        defaultComboBoxModel1 = new DefaultComboBoxModel();
        comboBox1.setModel(defaultComboBoxModel1);
        this.add(comboBox1, new GridConstraints(1, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(122, 32), null, 0, false));
        sedangMencetakTextField = new ReportLabelThreading(this);
        this.add(sedangMencetakTextField, new GridConstraints(2, 3, 2, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));

        userDefinedConfig();
    }

    public void userDefinedConfig() {
        this.setName("Report");

        mainGUI.dataStore.customers().getCustomerList().forEach(
            x -> { defaultComboBoxModel1.addElement(x.getId());
        });

        cetakTransaksiButton.addActionListener(cetakTransaksiAction());
        cetakPenjualanButton.addActionListener(cetakPenjualanAction());
        comboBox1.addActionListener(changeUserAction());
    }

    private ActionListener cetakTransaksiAction() {
        return new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String id = comboBox1.getSelectedItem().toString();
                int intUserId = Integer.parseInt(id);
                String billid = comboBox2.getSelectedItem().toString();
                int intBillId = Integer.parseInt(billid);

                Customer selectedCustomer = mainGUI.dataStore.customers().getCustomerFromID(intUserId);
                FixedBill selectedBill = selectedCustomer.getBills().stream().filter(x -> x.billId() == intBillId).findFirst().get();
                ArrayList<FixedBill> selectedBills = new ArrayList<>();
                selectedBills.add(selectedBill);
                AbstractReport.listOfReport(selectedBills);
                sedangMencetakTextField.writeReport(new FixedBillReport(0));
            }
        };
    }

    private ActionListener cetakPenjualanAction() {
        return new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ArrayList<Customer> allCustomer = (ArrayList<Customer>)mainGUI.dataStore.customers().getCustomerList();
                ArrayList<FixedBill> listOfReport = new ArrayList<>();

                for (Customer customer : allCustomer) {
                    listOfReport.addAll(customer.getBills());
                }
                SalesReport salesReport = new SalesReport();
                AbstractReport.listOfReport(listOfReport);
                sedangMencetakTextField.writeReport(new SalesReport());
            }
        };
    }
    public void toggleButtonEnabled(boolean enable) {
        cetakPenjualanButton.setEnabled(enable);
        comboBox1.setEnabled(enable);
        cetakTransaksiButton.setEnabled(enable);
        comboBox2.setEnabled(enable);
    }

    private ActionListener changeUserAction() {
        return new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String id = comboBox1.getSelectedItem().toString();
                int intUserId = Integer.parseInt(id);
                defaultComboBoxModel2.removeAllElements();
                mainGUI.dataStore.customers().getCustomerFromID(intUserId).getBills().forEach(
                    x -> { defaultComboBoxModel2.addElement(x.billId());
                });
            }
        };
    }

}
