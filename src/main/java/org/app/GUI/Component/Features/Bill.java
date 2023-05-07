package org.app.GUI.Component.Features;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import org.app.Inventory.Holder.FixedBill;
import org.app.Inventory.Item.BillItem;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Bill extends JPanel {
    public Bill(FixedBill fixedBill) {
        ArrayList<BillItem> bills = (ArrayList<BillItem>) fixedBill.itemList();
        int billAmount = bills.size();

        this.setLayout(new GridLayoutManager(billAmount + 3, 4, new Insets(0, 0, 0, 0), -1, -1));
        final JLabel label1 = new JLabel();
        label1.setText("Bill " + fixedBill.billId());
        this.add(label1, new GridConstraints(0, 0, 1, 4, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label2 = new JLabel();
        label2.setText("Nama");
        this.add(label2, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label3 = new JLabel();
        label3.setText("Jumlah");
        this.add(label3, new GridConstraints(1, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label4 = new JLabel();
        label4.setText("Total");
        this.add(label4, new GridConstraints(1, 3, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label5 = new JLabel();
        label5.setText("Harga");
        this.add(label5, new GridConstraints(1, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 1, false));
        final JLabel label6 = new JLabel();

        for(int i=0;i<billAmount;i++) {
            JLabel labelBill1 = new JLabel(bills.get(i).itemName());
            this.add(labelBill1, new GridConstraints(2 + i, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 1, false));
            JLabel labelBill2 = new JLabel(String.valueOf(bills.get(i).sellingPrice()));
            this.add(labelBill2, new GridConstraints(2 + i, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 1, false));
            JLabel labelBill3 = new JLabel(String.valueOf(bills.get(i).quantity()));
            this.add(labelBill3, new GridConstraints(2 + i, 2, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 1, false));
            JLabel labelBill4 = new JLabel(String.valueOf(bills.get(i).quantity() * bills.get(i).sellingPrice()));
            this.add(labelBill4, new GridConstraints(2 + i, 3, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 1, false));
        }

        label6.setText("Total");
        this.add(label6, new GridConstraints(billAmount + 2, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label7 = new JLabel();
        label7.setText(String.valueOf(fixedBill.totalPrice()));
        this.add(label7, new GridConstraints(billAmount + 2, 3, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }
}
