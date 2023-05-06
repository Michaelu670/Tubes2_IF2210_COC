package org.app.DataStore;

import org.app.Inventory.Loadable;

public interface DataAdapter {
    void saveData(String fileLocation) throws Exception;
    void loadData(String fileLocation) throws Exception;
    Loadable getObj();
}
