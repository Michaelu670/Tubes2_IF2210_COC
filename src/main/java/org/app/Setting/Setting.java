package org.app.Setting;

import java.util.ArrayList;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.app.DataStore.DataHolder;
import org.app.GUI.MainGUI;
import org.app.Plugin.PluginManager;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Getter
@Setter
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Root
@ToString
public class Setting extends DataHolder {
    // Atributes
    private static Setting instance;
    @Element
    private String storagePath;
    @Element
    private String dataFormat;
    @ElementList
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

    public void addPluginPath(String path, MainGUI mainGUI) {
        pluginPaths.add(path);
        PluginManager.register(path, mainGUI);
    }

    public void removePluginPath(int idx) {
        pluginPaths.remove(idx);
    }
}
