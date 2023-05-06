package org.app.DataStore;

import lombok.AllArgsConstructor;

import java.util.Timer;
import java.util.TimerTask;
@AllArgsConstructor
public class DataSaver extends TimerTask {
    DataStore dataStore;
    @Override
    public void run() {
        dataStore.save();
        System.out.println("Saved!");
    }

    public static void init(DataStore dataStore, int delay) {
        Timer timer = new Timer("DataSaver");
        timer.schedule(new DataSaver(dataStore), 3000, delay);
    }
    public static void init(DataStore dataStore) {
        init(dataStore, 3000);
    }
}
