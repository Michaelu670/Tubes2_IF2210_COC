package org.app.Customer;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.app.DataStore.DataHolder;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Customers extends DataHolder {
    private List<Customer> customerList;
    public Customers() {
        customerList = new ArrayList<>();
    }
}
