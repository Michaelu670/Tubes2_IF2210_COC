package org.app.Plugin;

import java.util.ArrayList;
import java.util.List;

import org.app.DataStore.DataHolder;

import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class PluginManager extends DataHolder {
    private static List<String> filePaths = new ArrayList<>();

    public static void register(String filePath) {
        // Add file to db
        filePaths.add(filePath);
        PluginLoader.load(filePath);
    }

    public static void remove(String filePath) {
        // Delete file from db, then reload all plugin
    }

    public static void enableAll() {
        // Get all file from db, then load all plugin
        for (String filePath : filePaths) {
            PluginLoader.load(filePath);
        }
    }
}
