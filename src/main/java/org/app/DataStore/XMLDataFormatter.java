package org.app.DataStore;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import lombok.AllArgsConstructor;

import java.io.StringReader;
import java.io.StringWriter;

@AllArgsConstructor
public class XMLDataFormatter<T> implements DataFormatter<T>{
    private Class<T> type;
    @Override
    public String toSaveFormat(T obj) throws Exception {
        System.out.println(type.toString());
        JAXBContext context = JAXBContext.newInstance(type);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        StringWriter sw = new StringWriter();
        marshaller.marshal(obj, sw);

        return sw.toString();
    }
    @Override
    public T toObject(String str) {
        return null;
    }
}
