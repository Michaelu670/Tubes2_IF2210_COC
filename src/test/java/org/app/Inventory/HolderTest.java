package org.app.Inventory;

import org.app.Inventory.Holder.*;
import org.app.Inventory.Item.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HolderTest {
    
    @Test
    void constructorTest(){
        // Inventory Class
        Inventory newInventory = new Inventory();
        assertNotNull(newInventory.itemList());

        // Bill Class
        Bill newBill = new Bill(1);
        assertNotNull(newBill.itemList());

        // Fixed Bill Class
        FixedBill newFixedBill = FixedBill.builder()
                                    .itemList(newBill.itemList())
                                    .totalPrice(newBill.totalPrice())
                                    .build();

        assertNotNull(newFixedBill.itemList());
        assertEquals(newFixedBill.totalPrice(), 0);



        // Kasir Class
        Cashier newCashier = new Cashier();
        assertNotNull(newCashier.billList());
    }

    @Test
    void kasirTest(){
        Bill newBill = new Bill(1);

        // Kasir Class
        Cashier newCashier = new Cashier();
        newCashier.addBill(newBill);
        newCashier.addBill(newBill);
        assertEquals(newCashier.billList().size(), 2);
        assert(newCashier.billList().contains(newBill));
        newCashier.removeBill(newBill);
        assertEquals(newCashier.billList().size(), 1);
        }

    @Test
    void inventoryTest(){
        Item item = Item.builder()
                .itemName("First Item")
                .sellingPrice(1000)
                .category("first")
                .imagePath("")
                .build();

        BillItem billItem = new BillItem(item);

        // Inventory Class
        Inventory newInventory = new Inventory();
        newInventory.addItem(item);
        assertEquals(newInventory.itemList().size(), 1);
        assert(newInventory.itemList().contains(item));

        assertThrows(ClassCastException.class, () -> newInventory.addItem(billItem));

        newInventory.removeItem(item);
        assert(!newInventory.itemList().contains(item));
        assertEquals(newInventory.itemList().size(), 0);
    }

    @Test
    void billItemTest(){
        Item item = Item.builder()
                .itemName("First Item")
                .sellingPrice(1000)
                .category("first")
                .imagePath("")
                .build();

        BillItem billItem = new BillItem(item);

        // Bill Class
        Bill newBill = new Bill(1);
        newBill.addItem(billItem);
        assertEquals(newBill.itemList().size(), 1);
        assert(newBill.itemList().contains(billItem));

        assertThrows(ClassCastException.class, () -> newBill.addItem(item));

        newBill.removeItem(billItem);
        assert(!newBill.itemList().contains(billItem));
        assertEquals(newBill.itemList().size(), 0);
    }

    @Test
    void fixedBillTest(){

        // Item List Check
        BillItem billItem = BillItem.builder()
                .itemName("")
                .category("")
                .imagePath("")
                .build();

        Bill bill = new Bill(1);
        bill.addItem(billItem);

        FixedBill fixedBill = new FixedBill(bill);

        assertEquals(bill.itemList(), fixedBill.itemList());

        bill.removeItem(billItem);
        assertNotEquals(bill.itemList().size(), fixedBill.itemList().size());
    }

    @Test
    void editTest(){
        // Inventory Test
        Item item = Item.builder()
                .itemName("1")
                .sellingPrice(1000)
                .category("first")
                .imagePath("")
                .build();
        
        Inventory inventory = new Inventory();
        inventory.addItem(item);

        Item edit = inventory.getItem(0);

        edit.itemName("2");

        assertEquals(item.itemName(), "2");

        Item edit2 = inventory.getItem("2");

        edit2.itemName("3");

        assertEquals(item.itemName(), "3");

        // Bill Test
        BillItem billItem = new BillItem(item);

        Bill bill = new Bill(1);
        bill.addItem(billItem);

        BillItem editBill = bill.getItem(0);

        editBill.itemName("4");

        assertEquals(billItem.itemName(), "4");

        editBill.itemName("5");

        BillItem editBill2 = bill.getItem("5");

        editBill2.itemName("6");

        assertEquals(billItem.itemName(), "6");

        // Cashier Test

        Cashier cashier = new Cashier();

        cashier.addBill(bill);

        assertEquals(cashier.getBill(1).itemList().size(), 1);

        Bill editCashier = cashier.getBill(1);

        editCashier.addItem(billItem);

        assertEquals(cashier.getBill(1).itemList().size(), 2);

    }
}
