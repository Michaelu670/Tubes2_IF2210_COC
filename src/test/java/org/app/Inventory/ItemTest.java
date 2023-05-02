package org.app.Inventory;

import org.app.Inventory.Item.BillItem;
import org.app.Inventory.Item.Item;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ItemTest {

    int defaultStock = 10;
    String defaultName = "Coffee";
    int defaultSelling = 150;
    int defaultPurchase = 100;
    String defaultCategories = "Beverages";
    String defaultImage = "";

    @Test
    void getterTest(){
        // Item get = new Item(defaultStock, defaultName, defaultSelling , 100, "Beverages", "");
        Item get = Item.builder()
                    .stock(defaultStock)
                    .itemName(defaultCategories)
                    .sellingPrice(defaultSelling)
                    .purchasePrice(defaultPurchase)
                    .category("Beverages")
                    .imagePath("")
                    .build();

        assertEquals (get.stock(), 10);
        assertNotEquals  (get.itemName(), "Coffees");
        assertEquals (get.sellingPrice(), 150.0000000);
        assertEquals (get.purchasePrice(), 00100.000000000);
        assertEquals  (get.category(), defaultCategories);
        assert  (get.imagePath().isEmpty());
    }

    @Test
    void setterTest(){
        // Item set = new Item(0, "", 0, 0, "", "");
        Item set = Item.builder()
                    .stock(0)
                    .itemName("")
                    .sellingPrice(0)
                    .purchasePrice(0)
                    .category("")
                    .imagePath("")
                    .build();

        set.stock(10);
        set.itemName(defaultName);
        set.sellingPrice(defaultSelling);
        set.purchasePrice(defaultPurchase);
        set.category(defaultCategories);
        set.imagePath(defaultImage);

        assertNotEquals (set.stock(), (10.0000001));
        assertEquals  (set.itemName(), ("Coffee"));
        assertEquals (set.sellingPrice() , 150);
        assertEquals (set.purchasePrice() , 100);
        assertEquals  (set.category(), ("Beverages"));
        assertEquals  (set.imagePath(), "") ;
    }

    @Test
    void nonNull(){
        // Item nonNull = new Item (0, "", 0, 0, "", "");
        Item nonNull = Item.builder()
                    .stock(0)
                    .itemName("")
                    .sellingPrice(0)
                    .purchasePrice(0)
                    .category("")
                    .imagePath("")
                    .build();
        assertThrows(NullPointerException.class , () -> nonNull.itemName(null));
        assertThrows(NullPointerException.class , () -> nonNull.category(null));
        assertThrows(NullPointerException.class , () -> nonNull.imagePath(null));
    }

    @Test
    void billItem(){
        Item item = Item.builder()
                    .itemName("first")
                    .category("first")
                    .imagePath("first")
                    .build();
        BillItem billItem = new BillItem(item);

        item.itemName("second");
        assertEquals(billItem.itemName(), "first");
        assertEquals(item.itemName(), "second");
    }

}
