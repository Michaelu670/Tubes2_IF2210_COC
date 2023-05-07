package org.app.Plugin;

import org.app.DataStore.DataStoreInterface;

import javax.swing.*;

public interface Plugin {
    void onEnable(JFrame mainGUI, DataStoreInterface dataStore);
}
