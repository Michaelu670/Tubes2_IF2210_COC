package org.app.Inventory;

import java.io.Serializable;

public interface Loadable extends Serializable {
    /*
    Class must have annotation:
    @XmlRootElement
    @XmlAccessorType(XmlAccessType.FIELD)
     */

    void setData(Loadable data) throws Exception;
}
