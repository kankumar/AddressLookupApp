package com.lh.address.service;

import com.lh.address.domain.AddressDetails;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;

/**
 * Created by kumar k on 12/03/2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AddressServiceRemoteTest {
    @Autowired
    private AddressDataService addressDataService;

    @Value("${google.api.postcode.endpoint}")
    private String postcodeApiEndpoint;
    @Value("${google.key.suffix.endpoint}")
    private String keySuffixEndpoint;
    @Value("${google.api.latlong.endpoint}")
    private String latLongEndpoint;

    @Test
    public void getAddressDetailsForW60LGFromRmote() throws Exception{
        AddressDetails addressDetails = new AddressDetails.AddressBuilder()
                .validPostcode(true).formattedAddress("5-17 Hammersmith Grove, London W6 0LG, UK").build();

        AddressDetails details = addressDataService.getAddressDetailByPostCode("W6 0LG");
        assertNotNull(details);
        assertThat(details.getFormattedAddress()).isEqualTo(addressDetails.getFormattedAddress());
    }

    @Test
    public void getAddressDetailsForSW1A2AAFromRmote() throws Exception{
        AddressDetails addressDetails = new AddressDetails.AddressBuilder()
                .validPostcode(true).formattedAddress("10 Downing St, Westminster, London SW1A 2AB, UK").build();

        AddressDetails details = addressDataService.getAddressDetailByPostCode("SW1A 2AA");
        assertNotNull(details);
        assertThat(details.getFormattedAddress()).isEqualTo(addressDetails.getFormattedAddress());
    }

    @Test
    public void getAddressDetailsForNullValueFromRmote() throws Exception{
        AddressDetails addressDetails = new AddressDetails.AddressBuilder()
                .validPostcode(false).build();

        AddressDetails details = addressDataService.getAddressDetailByPostCode(null);
        assertNotNull(details);
        assertThat(details.isValidPostcode()).isEqualTo(addressDetails.isValidPostcode());
    }

    @Test
    public void getAddressDetailsForInvalidPostcodeFromRmote() throws Exception{
        AddressDetails addressDetails = new AddressDetails.AddressBuilder()
                .validPostcode(false).build();

        AddressDetails details = addressDataService.getAddressDetailByPostCode("whoami");
        assertNotNull(details);
        assertThat(details.isValidPostcode()).isEqualTo(addressDetails.isValidPostcode());
    }

}
