package org.app.Setting;

import java.util.ArrayList;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class Setting {
    // Atributes
    private static Setting instance;
    private String storagePath;
    private String dataFormat;
    private ArrayList<String> pluginPaths;

    // Constructor
    private Setting() {
        this.storagePath = "";
        this.dataFormat = "json";
        this.pluginPaths = new ArrayList<String>();
    }

    // Methods
    public static Setting getInstance() {
        if (instance == null)
            instance = new Setting();

        return instance;
    }
}
