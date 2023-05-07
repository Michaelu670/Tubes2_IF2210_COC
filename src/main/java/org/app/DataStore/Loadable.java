package org.app.DataStore;

import java.io.Serializable;

public interface Loadable extends Serializable {
    /*
    Class must have annotation:
    @XmlRootElement
    @XmlAccessorType(XmlAccessType.FIELD)
     */

    void setData(Loadable data) throws Exception;
    Loadable getData();
}
