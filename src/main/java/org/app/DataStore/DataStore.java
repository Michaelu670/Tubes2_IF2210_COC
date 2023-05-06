package org.app.DataStore;

import com.sun.istack.NotNull;
import com.sun.istack.Nullable;
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
@Getter
public class DataStore {
    @NotNull private XMLDataAdapter settings;
    @NotNull private static final String settingFileLocation = "setting.xml";

    @NotNull private DataAdapter inventory;
    @NotNull private DataAdapter cashier;
    @NotNull private DataAdapter customers;
    @NotNull private String dataformat;

    public DataStore() {
        settings = new XMLDataAdapter(Setting.getInstance());
        loadSettings();
        dataformat = "json";
        inventory = new JSONDataAdapter(new Inventory());
        cashier = new JSONDataAdapter(new Cashier());
        customers = new JSONDataAdapter(new Customers());
    }

    public void save() {
        try {
            Files.createDirectories(Paths.get(Setting.getInstance().getStoragePath()));
            settings.saveData(settingFileLocation);
            inventory.saveData(fileLocation("inventory"));
            cashier.saveData(fileLocation("cashier"));
            customers.saveData(fileLocation("customers"));
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
            // assumption: one file doesn't exist means all file don't
            inventory.loadData(fileLocation("inventory"));
            cashier.loadData(fileLocation("cashier"));
            customers.loadData(fileLocation("customers"));
        }
        catch (FileNotFoundException e) {
            // use default file
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void changeDataFormat() throws Exception {
        if (dataformat.toLowerCase()
                .equals(Setting.getInstance().getDataFormat().toLowerCase()))
            return;
        dataformat = Setting.getInstance().getDataFormat().toLowerCase();
        if (dataformat.equals("json")) {
            inventory = new JSONDataAdapter(inventory.getObj());
            cashier = new JSONDataAdapter(cashier.getObj());
            customers = new JSONDataAdapter(customers.getObj());
        }
        else if (dataformat.equals("xml")) {
            inventory = new XMLDataAdapter(inventory.getObj());
            cashier = new XMLDataAdapter(cashier.getObj());
            customers = new XMLDataAdapter(customers.getObj());
        }
        else if (dataformat.equals("obj")) {
            inventory = new OBJDataAdapter(inventory.getObj());
            cashier = new OBJDataAdapter(cashier.getObj());
            customers = new OBJDataAdapter(customers.getObj());
        }
        else throw new Exception("Unknown format: " + dataformat);
    }

    private String fileLocation(String fileName) {
        return Setting.getInstance().getStoragePath() + "/"
                + fileName + "." + dataformat.toLowerCase();
    }
}
