package com.lh.address.service;

import com.lh.address.domain.AddressDetails;

import java.io.IOException;

/**
 * Address service to get the details based on the supplied postcode
 * Created by kumar k on 12/03/2017.
 */
public interface AddressDataService {

    /**
     * Get the address details for a given postCode.
     *
     * @param postCode used to find the address details
     * @return AddressDetails
     */

    AddressDetails getAddressDetailByPostCode(String postCode) throws IOException;
}
