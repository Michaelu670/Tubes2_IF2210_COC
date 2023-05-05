package org.app.DataStore;

public interface DataFormatter<T> {
    String toSaveFormat(T obj) throws Exception;
    T toObject(String str) throws Exception;
}
