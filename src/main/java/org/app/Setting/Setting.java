package org.app.Setting;

import java.util.ArrayList;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.app.DataStore.DataHolder;

@Getter
@Setter
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@ToString
public class Setting extends DataHolder {
    // Atributes
    private static Setting instance;
    private String storagePath;
    private String dataFormat;
    private ArrayList<String> pluginPaths;

    // Constructor
    private Setting() {
        this.storagePath = "";
        this.dataFormat = "json";
        this.pluginPaths = new ArrayList<String>();
    }

    // Methods
    public static Setting getInstance() {
        if (instance == null)
            instance = new Setting();

        return instance;
    }
}
