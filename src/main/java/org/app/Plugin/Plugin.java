package org.app.Plugin;

import org.app.DataStore.DataStoreInterface;
import org.app.GUI.MainGUI;

import javax.swing.*;

public interface Plugin {
    void onEnable(MainGUI mainGUI, DataStoreInterface dataStore);
}
