package org.app.DataStore;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.app.Inventory.Loadable;

import java.io.FileReader;
import java.io.FileWriter;

@AllArgsConstructor
@Getter
public class XMLDataAdapter implements DataAdapter {
    private Loadable obj;

    @Override
    public void saveData(String fileLocation) throws Exception{
        JAXBContext context = JAXBContext.newInstance(obj.getClass());
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        marshaller.marshal(obj, new FileWriter(fileLocation));
    }

    @Override
    public void loadData(String fileLocation) throws Exception {
        JAXBContext context = JAXBContext.newInstance(obj.getClass());
        Unmarshaller unmarshaller = context.createUnmarshaller();

        obj.setData(obj.getClass()
                .cast(unmarshaller.unmarshal(new FileReader(fileLocation))));
    }
}
