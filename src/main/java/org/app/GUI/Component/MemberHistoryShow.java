package org.app.GUI.Component;

import org.app.GUI.Component.Features.Bill;
import org.app.GUI.MainGUI;
import org.app.Inventory.Holder.FixedBill;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.List;

public class MemberHistoryShow extends JPanel {
    private MainGUI mainGUI;
    public MemberHistoryShow(MainGUI mainGUI, int id) {
        this.mainGUI = mainGUI;
        this.setName("Member History Show");

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        JLabel historyLabel = new JLabel("History " + id);
        historyLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(historyLabel);

        final JScrollPane scrollPane = new JScrollPane();
        this.add(scrollPane);
        JPanel billPanel = new JPanel();
        billPanel.setLayout(new BoxLayout(billPanel, BoxLayout.Y_AXIS));

        List<FixedBill> fixedBillList = mainGUI.dataStore.customers().getCustomerFromID(id).getBills();
        for(FixedBill fixedBill : fixedBillList) {
            JPanel billGUI = new Bill(fixedBill);
            Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
            billGUI.setBorder(border);
            billPanel.add(billGUI);
            billPanel.add(Box.createVerticalStrut(7));
        }
        scrollPane.setViewportView(billPanel);
    }
}
