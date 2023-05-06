package org.app.DataStore;

import lombok.AllArgsConstructor;
import org.app.Inventory.Loadable;

import java.io.*;

@AllArgsConstructor
public class OBJDataAdapter implements DataAdapter{
    private Loadable obj;

    @Override
    public void getData(String fileLocation) throws Exception {
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileLocation));
        outputStream.writeObject(obj);
        outputStream.flush();
        outputStream.close();
    }

    @Override
    public void setData(String fileLocation) throws Exception {
        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileLocation));
        obj.setData(obj.getClass().cast(inputStream.readObject()));
        inputStream.close();
    }
}
