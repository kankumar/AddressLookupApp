package com.lh.address.outbound.representation;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.List;

/**
 * Created by kumar k on 12/03/2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AddressResult implements Serializable {
    private List<AddressComponent> address_components;
    private String formatted_address;
    private String place_id;
    private List<String> types;
    private AddressGeometry geometry;

    public List<AddressComponent> getAddress_components() {
        return address_components;
    }

    public void setAddress_components(List<AddressComponent> address_components) {
        this.address_components = address_components;
    }

    public String getFormatted_address() {
        return formatted_address;
    }

    public void setFormatted_address(String formatted_address) {
        this.formatted_address = formatted_address;
    }

    public String getPlace_id() {
        return place_id;
    }

    public void setPlace_id(String place_id) {
        this.place_id = place_id;
    }

    public List<String> getTypes() {
        return types;
    }

    public void setTypes(List<String> types) {
        this.types = types;
    }

    public AddressGeometry getGeometry() {
        return geometry;
    }

    public void setGeometry(AddressGeometry geometry) {
        this.geometry = geometry;
    }

    @Override
    public String toString() {
        return "AddressResult{" +
                "address_components=" + address_components +
                ", formatted_address='" + formatted_address + '\'' +
                ", place_id='" + place_id + '\'' +
                ", types=" + types +
                ", geometry=" + geometry +
                '}';
    }
}
