package org.app.DataStore;

import com.sun.istack.NotNull;
import lombok.*;
import lombok.experimental.Accessors;
import org.app.Customer.Customers;
import org.app.Inventory.Cashier;
import org.app.Inventory.Holder.Inventory;
import org.app.Setting.Setting;

import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Accessors(fluent = true)
@ToString
public class DataStore {
    @NotNull private XMLDataAdapter settings;
    @NotNull private static final String settingFileLocation = "setting.xml";

    @NotNull private DataAdapter inventorySaver;
    @NotNull private DataAdapter cashierSaver;
    @NotNull private DataAdapter customersSaver;
    @NotNull private String dataformat;

    public DataStore() {
        settings = new XMLDataAdapter(Setting.getInstance());
        loadSettings();
        dataformat = "json";
        inventorySaver = new JSONDataAdapter(new Inventory());
        cashierSaver = new JSONDataAdapter(new Cashier());
        customersSaver = new JSONDataAdapter(new Customers());
    }

    public void save() {
        try {
            changeDataFormat();
            Files.createDirectories(Paths.get(Setting.getInstance().getStoragePath()));
            settings.saveData(settingFileLocation);
            inventorySaver.saveData(fileLocation("inventory"));
            cashierSaver.saveData(fileLocation("cashier"));
            customersSaver.saveData(fileLocation("customers"));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void loadSettings() {
        // try loading settings
        try {
            settings.loadData(settingFileLocation);
        }
        catch (FileNotFoundException e) {
            // use default setting
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void load() {
        try {
            changeDataFormat();
            // assumption: one file doesn't exist means all file don't
            inventorySaver.loadData(fileLocation("inventory"));
            cashierSaver.loadData(fileLocation("cashier"));
            customersSaver.loadData(fileLocation("customers"));
        }
        catch (FileNotFoundException e) {
            // use default file
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Inventory inventory() {
        return (Inventory) inventorySaver.getObj();
    }
    public Cashier cashier() {
        return (Cashier) cashierSaver.getObj();
    }
    public Customers customers() {
        return (Customers) customersSaver.getObj();
    }


    private void changeDataFormat() throws Exception {
        if (dataformat.toLowerCase()
                .equals(Setting.getInstance().getDataFormat().toLowerCase()))
            return;
        dataformat = Setting.getInstance().getDataFormat().toLowerCase();
        if (dataformat.equals("json")) {
            inventorySaver = new JSONDataAdapter(inventorySaver.getObj());
            cashierSaver = new JSONDataAdapter(cashierSaver.getObj());
            customersSaver = new JSONDataAdapter(customersSaver.getObj());
        }
        else if (dataformat.equals("xml")) {
            inventorySaver = new XMLDataAdapter(inventorySaver.getObj());
            cashierSaver = new XMLDataAdapter(cashierSaver.getObj());
            customersSaver = new XMLDataAdapter(customersSaver.getObj());
        }
        else if (dataformat.equals("obj")) {
            inventorySaver = new OBJDataAdapter(inventorySaver.getObj());
            cashierSaver = new OBJDataAdapter(cashierSaver.getObj());
            customersSaver = new OBJDataAdapter(customersSaver.getObj());
        }
        else throw new Exception("Unknown format: " + dataformat);
    }

    private String fileLocation(String fileName) {
        return Paths.get(
                Setting.getInstance().getStoragePath()
                , fileName + "." + dataformat.toLowerCase())
                .toString();
    }
}
