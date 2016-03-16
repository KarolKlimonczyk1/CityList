package com.karol.klimonczyk.citylist;

import java.io.Serializable;
import java.util.Arrays;

/**
 * Created by Karol on 3/15/2016.
 */
public class GoogleGeoCodeResponse implements Serializable {

    private String status ;
    private results[] results ;
    public GoogleGeoCodeResponse() {

    }

    public String getStatus() {
        return status;
    }

    public com.karol.klimonczyk.citylist.results[] getResults() {
        return results;
    }

}

class results  implements Serializable {
    private String formatted_address ;
    private geometry geometry ;
    private String[] types;
    private address_component[] address_components;

    public String getFormatted_address() {
        return formatted_address;
    }

    public com.karol.klimonczyk.citylist.geometry getGeometry() {
        return geometry;
    }

    public String[] getTypes() {
        return types;
    }

    public address_component[] getAddress_components() {
        return address_components;
    }
}

class geometry  implements Serializable {
    private bounds bounds;
    private String location_type ;
    private location location;
    private bounds viewport;
}

class bounds  implements Serializable {

    private location northeast ;
    private location southwest ;
}

class location  implements Serializable{
    private String lat ;
    private String lng ;
}

class address_component  implements Serializable{
    private String long_name;
    private String short_name;
    private String[] types ;

    public String getLong_name() {
        return long_name;
    }

    public String getShort_name() {
        return short_name;
    }

    public String[] getTypes() {
        return types;
    }
}