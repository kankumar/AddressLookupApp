package com.lh.address.outbound.representation;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

/**
 * Created by kumar k on 12/03/2017.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AddressDetailsResponse implements Serializable {

    @JsonCreator
    public AddressDetailsResponse(@JsonProperty("status") String status, @JsonProperty("results") List<AddressResult> results) {
        this.status = status;
        this.results = results;
    }

    public AddressDetailsResponse() {
    }

    @JsonProperty("status")
    private String status;
    @JsonProperty("results")
    private List<AddressResult> results;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<AddressResult> getResults() {
        return results;
    }

    public void setResults(List<AddressResult> results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return "AddressDetailsResponse{" +
                "status='" + status + '\'' +
                ", results=" + results +
                '}';
    }
}
