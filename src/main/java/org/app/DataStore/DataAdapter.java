package org.app.DataStore;

public interface DataAdapter {
    void saveData(String fileLocation) throws Exception;
    void loadData(String fileLocation) throws Exception;
    Loadable getObj();
}
