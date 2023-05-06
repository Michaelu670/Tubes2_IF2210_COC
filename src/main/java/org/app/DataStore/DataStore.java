package org.app.DataStore;

import com.sun.istack.NotNull;
import com.sun.istack.Nullable;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.experimental.Accessors;

import java.io.FileNotFoundException;

@AllArgsConstructor
@Accessors(fluent = true)
public class DataStore {
    @NotNull private XMLDataAdapter settings;
    @NotNull private static final String settingFileLocation = "setting.xml";

    @NotNull private DataAdapter inventory;
    @NotNull private DataAdapter cashier;
    @NotNull private DataAdapter customers;
    @Nullable private String folderLocation;


    public void save() {

    }
    public void load() {
        // try loading settings
        try {
            settings.loadData(settingFileLocation);
        }
        catch (FileNotFoundException e) {
            // create new file
        }
        catch (Exception e) {

        }
    }
}
