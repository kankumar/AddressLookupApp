package com.lh.address.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lh.address.domain.AddressDetails;
import com.lh.address.mediation.transform.AddressTransform;
import com.lh.address.outbound.representation.AddressDetailsResponse;
import com.lh.address.service.AddressDataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Optional;

/**
 * Created by kumar k on 12/03/2017.
 */
@Service
public class AddressDataServiceImpl implements AddressDataService {

    @Value("${google.api.postcode.endpoint}")
    private String postcodeApiEndpoint;
    @Value("${google.key.suffix.endpoint}")
    private String keySuffixEndpoint;
    @Value("${google.api.latlong.endpoint}")
    private String latLongEndpoint;

    private final RestTemplate restTemplate;

    @Autowired
    private AddressTransform addressTransform;

    public AddressDataServiceImpl(RestTemplateBuilder restTemplateBuilder) {
        restTemplate = restTemplateBuilder.build();
    }

    @Override
    /**
     * Get the address details for a given postCode.
     *
     * @param postcode postcode to be looked up
     * @return AddressDetails provides address details based on the given postcode.
     * Initially, the service makes call to get the latlong for the postcode location and
     * then get the address details based on the latlong.
     */
    public AddressDetails getAddressDetailByPostCode(String postcode) throws IOException {
        Optional<String> postCodeOpt = Optional.ofNullable(postcode);
        if (!postCodeOpt.isPresent())
            return new AddressDetails.AddressBuilder().validPostcode(false).build();
        String jsonResponse = restTemplate.getForObject(postcodeApiEndpoint.concat(postcode).concat(keySuffixEndpoint), String.class);
        ObjectMapper mapper = new ObjectMapper();
        Assert.notNull(jsonResponse, "jsonResponse String class must not be null");
        Optional<String> latLong = addressTransform.getLatLongFromAddress(mapper.readValue(jsonResponse, AddressDetailsResponse.class));
        if (latLong.isPresent()) {
            String latLonJsonResponse = restTemplate.getForObject(latLongEndpoint.concat(latLong.get()).concat(keySuffixEndpoint), String.class);
            return addressTransform.xformAddressOutbound(mapper.readValue(latLonJsonResponse, AddressDetailsResponse.class));
        }
        return new AddressDetails.AddressBuilder().validPostcode(false).build();
    }
}