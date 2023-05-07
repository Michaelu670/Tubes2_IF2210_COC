package org.app.Report;

import java.util.ArrayList;
import java.util.List;

import org.app.Inventory.Holder.Bill;
import org.app.Inventory.Holder.FixedBill;
import org.app.Inventory.Item.BillItem;
import org.app.Inventory.Item.Item;
import org.app.money.MoneyDecorator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReportTest {

    @Test
    void salesReportTest(){
        
        Item item = Item.builder()
        .itemName("name")
        .sellingPrice(MoneyDecorator.getCurrentMoney(10))
        .category("cat")
        .imagePath("null")
        .build();
        
        BillItem billItem = new BillItem(item);
        billItem.quantity(100);
        billItem.notes("test notes");

        Bill bill = new Bill(1, 0);
        bill.addItem(billItem);
        bill.addItem(billItem);
        bill.addItem(billItem);
        bill.addItem(billItem);
        bill.addItem(billItem);
        bill.addItem(billItem);
        bill.addItem(billItem);
        bill.addItem(billItem);
        bill.addItem(billItem);
        
        FixedBill fixedBill = new FixedBill(bill);
        
        List<FixedBill> listOfReport = new ArrayList<>();
        listOfReport.add(fixedBill);
        listOfReport.add(fixedBill);
        listOfReport.add(fixedBill);
        
        
        SalesReport salesReport = new SalesReport();
        AbstractReport.listOfReport(listOfReport);

        assertDoesNotThrow(() -> {
            salesReport.writeReport();
        });
    }

    @Test
    void billReportTest(){
        
        Item item = Item.builder()
        .itemName("name")
        .sellingPrice(MoneyDecorator.getCurrentMoney(10))
        .category("cat")
        .imagePath("null")
        .build();
        
        BillItem billItem = new BillItem(item);
        billItem.quantity(100);
        billItem.notes("test notes");

        Bill bill = new Bill(1, 0);
        bill.addItem(billItem);
        bill.addItem(billItem);
        bill.addItem(billItem);
        bill.addItem(billItem);
        bill.addItem(billItem);
        bill.addItem(billItem);
        bill.addItem(billItem);
        bill.addItem(billItem);
        bill.addItem(billItem);
        
        FixedBill fixedBill = new FixedBill(bill);
        
        List<FixedBill> listOfReport = new ArrayList<>();
        listOfReport.add(fixedBill);
        listOfReport.add(fixedBill);
        listOfReport.add(fixedBill);
        
        FixedBillReport salesReport = new FixedBillReport(1);
        AbstractReport.listOfReport(listOfReport);

        assertDoesNotThrow(() -> {
            salesReport.writeReport();
        });
    }
    
}
