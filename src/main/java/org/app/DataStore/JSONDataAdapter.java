package org.app.DataStore;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

import java.io.FileReader;
import java.io.FileWriter;

@AllArgsConstructor
@Getter
public class JSONDataAdapter implements DataAdapter {
    @NonNull private Loadable obj;
    @Override
    public void saveData(String fileLocation) throws Exception {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        FileWriter fw = new FileWriter(fileLocation);
        gson.toJson(obj.getData(), fw);
        fw.flush();
        fw.close();
    }

    @Override
    public void loadData(String fileLocation) throws Exception {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        obj.setData(gson.fromJson(new FileReader(fileLocation), obj.getClass()));
    }

}
