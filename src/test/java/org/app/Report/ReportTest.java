package org.app.Report;

import java.util.ArrayList;
import java.util.List;

import org.app.Inventory.Holder.Bill;
import org.app.Inventory.Holder.FixedBill;
import org.app.Inventory.Item.BillItem;
import org.app.Inventory.Item.Item;
import org.junit.jupiter.api.Test;

public class ReportTest {

    @Test
    void salesReportTest(){
        
        Item item = Item.builder()
        .itemName("name")
        .sellingPrice(10)
        .category("cat")
        .imagePath("null")
        .build();
        
        BillItem billItem = new BillItem(item);

        Bill bill = new Bill(1);
        bill.addItem(billItem);
        
        FixedBill fixedBill = new FixedBill(bill);
        
        List<FixedBill> listOfReport = new ArrayList<>();
        listOfReport.add(fixedBill);
        
        
        SalesReport salesReport = new SalesReport();
        AbstractReport.listOfReport(listOfReport);

        try{
            salesReport.writeReport();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    void billReportTest(){
        
        Item item = Item.builder()
        .itemName("name")
        .sellingPrice(10)
        .category("cat")
        .imagePath("null")
        .build();
        
        BillItem billItem = new BillItem(item);

        Bill bill = new Bill(1);
        bill.addItem(billItem);
        
        FixedBill fixedBill = new FixedBill(bill);
        
        List<FixedBill> listOfReport = new ArrayList<>();
        listOfReport.add(fixedBill);
        
        
        FixedBillReport salesReport = new FixedBillReport();
        AbstractReport.listOfReport(listOfReport);

        try{
            salesReport.writeReport();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    
}
