package org.app.DataStore;

public interface DataAdapter {
    void getData(String fileLocation) throws Exception;
    void setData(String fileLocation) throws Exception;
}
