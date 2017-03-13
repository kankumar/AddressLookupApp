package com.lh.address.web;

import com.lh.address.domain.AddressDetails;
import com.lh.address.service.AddressDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * Created by kumar k on 12/03/2017.
 */
@RestController
public class AddressSearchController {

    @Autowired
    private AddressDataService addressDataService;

    @GetMapping(path = "address/{postcode}", produces = MediaType.APPLICATION_JSON_VALUE)
    public AddressDetails VehicleDetailsJson(@PathVariable String postcode) throws IOException {
        return this.addressDataService.getAddressDetailByPostCode(postcode);
    }

}
