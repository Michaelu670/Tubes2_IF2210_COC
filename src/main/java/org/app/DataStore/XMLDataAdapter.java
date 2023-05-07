package org.app.DataStore;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.convert.AnnotationStrategy;
import org.simpleframework.xml.core.Persister;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

@AllArgsConstructor
@Getter
public class XMLDataAdapter implements DataAdapter {
    private Loadable obj;

    @Override
    public void saveData(String fileLocation) throws Exception{
        Serializer serializer = new Persister(new AnnotationStrategy());
        File file = new File(fileLocation);
        serializer.write(obj.getData(), file);
    }

    @Override
    public void loadData(String fileLocation) throws Exception {
        Serializer serializer = new Persister(new AnnotationStrategy());
        obj.setData(serializer.read(obj.getClass(), new File(fileLocation)));
    }
}
