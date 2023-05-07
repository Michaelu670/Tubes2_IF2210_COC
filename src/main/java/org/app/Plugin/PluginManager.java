package org.app.Plugin;

import org.app.DataStore.DataHolder;

import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlRootElement;
import org.app.GUI.MainGUI;
import org.app.Setting.Setting;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class PluginManager extends DataHolder {
    public static void register(String filePath, MainGUI mainGUI) {
        PluginLoader.load(filePath, mainGUI);
    }

    public static void enableAll(MainGUI mainGUI) {
        for (String filePath : Setting.getInstance().getPluginPaths()) {
            PluginLoader.load(filePath, mainGUI);
        }
    }
}
