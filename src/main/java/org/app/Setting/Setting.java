package org.app.Setting;

import java.util.ArrayList;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.app.DataStore.DataHolder;

@Getter
@Setter
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@ToString
public class Setting extends DataHolder {
    // Atributes
    private static Setting instance;
    private String storagePath;
    private String dataFormat;
    private ArrayList<String> pluginPaths;

    // Constructor
    private Setting() {
        this.storagePath = "";
        this.dataFormat = "JSON";
        this.pluginPaths = new ArrayList<String>();
    }

    // Methods
    public static Setting getInstance() {
        if (instance == null)
            instance = new Setting();

        return instance;
    }

    public void addPluginPath(String path) {
        pluginPaths.add(path);
    }

    public void removePluginPath(int idx) {
        pluginPaths.remove(idx);
    }
}
