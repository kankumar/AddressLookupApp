package com.lh.address.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * Created by kumar k on 12/03/2017.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AddressDetails {
    private String street;
    private String town;
    private String postcode;
    private String country;
    private String formattedAddress;
    private boolean validPostcode;

    public AddressDetails(AddressBuilder addressBuilder) {
        this.street = addressBuilder.street;
        this.town = addressBuilder.town;
        this.postcode = addressBuilder.postcode;
        this.country = addressBuilder.country;
        this.formattedAddress = addressBuilder.formattedAddress;
        this.validPostcode = addressBuilder.validPostcode;

    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getFormattedAddress() {
        return formattedAddress;
    }

    public void setFormattedAddress(String formattedAddress) {
        this.formattedAddress = formattedAddress;
    }

    public boolean isValidPostcode() {
        return validPostcode;
    }

    public void setValidPostcode(boolean validPostcode) {
        this.validPostcode = validPostcode;
    }

    @Override
    public String toString() {
        return "AddressDetails{" +
                "street='" + street + '\'' +
                ", town='" + town + '\'' +
                ", postcode='" + postcode + '\'' +
                ", country='" + country + '\'' +
                ", formattedAddress='" + formattedAddress + '\'' +
                '}';
    }

    public static class AddressBuilder{
        private String street;
        private String town;
        private String postcode;
        private String country;
        private String formattedAddress;
        private boolean validPostcode;

        public AddressBuilder() {
        }
        public AddressBuilder street(String street){
            this.street = street;
            return this;
        }
        public AddressBuilder town(String town){
            this.town = town;
            return this;
        }
        public AddressBuilder postcode(String postcode){
            this.street = postcode;
            return this;
        }
        public AddressBuilder country(String country){
            this.country = country;
            return this;
        }
        public AddressBuilder validPostcode(boolean validPostcode){
            this.validPostcode = validPostcode;
            return this;
        }
        public AddressBuilder formattedAddress(String formattedAddress){
            this.formattedAddress = formattedAddress;
            return this;
        }
        public AddressDetails build(){
            return new AddressDetails(this);
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AddressDetails that = (AddressDetails) o;

        if (validPostcode != that.validPostcode) return false;
        if (street != null ? !street.equals(that.street) : that.street != null) return false;
        if (town != null ? !town.equals(that.town) : that.town != null) return false;
        if (postcode != null ? !postcode.equals(that.postcode) : that.postcode != null) return false;
        if (country != null ? !country.equals(that.country) : that.country != null) return false;
        return !(formattedAddress != null ? !formattedAddress.equals(that.formattedAddress) : that.formattedAddress != null);

    }

    @Override
    public int hashCode() {
        int result = street != null ? street.hashCode() : 0;
        result = 31 * result + (town != null ? town.hashCode() : 0);
        result = 31 * result + (postcode != null ? postcode.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (formattedAddress != null ? formattedAddress.hashCode() : 0);
        result = 31 * result + (validPostcode ? 1 : 0);
        return result;
    }

}
