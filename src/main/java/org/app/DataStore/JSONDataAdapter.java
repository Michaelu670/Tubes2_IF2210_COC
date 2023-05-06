package org.app.DataStore;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.app.Inventory.Loadable;

import java.io.FileReader;
import java.io.FileWriter;

@AllArgsConstructor
public class JSONDataAdapter implements DataAdapter {
    @NonNull private Loadable obj;
    @Override
    public void getData(String fileLocation) throws Exception {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        FileWriter fw = new FileWriter(fileLocation);
        gson.toJson(obj, fw);
        fw.flush();
        fw.close();
    }

    @Override
    public void setData(String fileLocation) throws Exception {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        obj.setData(gson.fromJson(new FileReader(fileLocation), obj.getClass()));
    }

}
