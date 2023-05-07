package org.app.GUI.Component;

import org.app.GUI.Component.Features.Bill;
import org.app.GUI.MainGUI;
import org.app.Inventory.Holder.FixedBill;

import javax.swing.*;
import java.util.List;

public class MemberHistoryShow extends JPanel {
    private MainGUI mainGUI;
    public MemberHistoryShow(MainGUI mainGUI, int id) {
        this.mainGUI = mainGUI;
        this.setName("Member History Show");

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(new JLabel("History " + id));

        List<FixedBill> fixedBillList = mainGUI.dataStore.customers().getCustomerFromID(id).getBills();
        for(FixedBill fixedBill : fixedBillList) {
            this.add(new Bill(fixedBill));
        }
    }
}
