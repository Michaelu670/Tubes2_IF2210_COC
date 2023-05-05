package org.app.DataStore;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class JSONDataFormatter<T> implements DataFormatter<T> {
    private Class<T> type;
    @Override
    public String toSaveFormat(Object obj) throws Exception {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(obj);
    }

    @Override
    public T toObject(String str)throws Exception {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.fromJson(str, type);
    }
}
