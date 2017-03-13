package com.lh.address.service;

import com.lh.address.domain.AddressDetails;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

/**
 * Tests for {@link AddressDataService}.
 *
 * @author Kumar K
 */
@RunWith(MockitoJUnitRunner.class)
public class AddressServiceTest {

    @Mock
    private AddressDataService addressDataService;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getAddressForPostcodeW60LG() throws Exception {
        AddressDetails details = new AddressDetails.AddressBuilder()
                .validPostcode(true).formattedAddress("5-17 Hammersmith Grove, London W6 0LG, UK").build();

        when(addressDataService.getAddressDetailByPostCode(anyString())).thenReturn(details);
        assertNotNull(addressDataService.getAddressDetailByPostCode("W6 0LG"));
    }

    @Test
    public void getAddressForPostcodeSW1A2AA() throws Exception {
        AddressDetails details = new AddressDetails.AddressBuilder()
                .validPostcode(true).formattedAddress("10 Downing St, Westminster, London SW1A 2AA, UK").build();

        when(addressDataService.getAddressDetailByPostCode(anyString())).thenReturn(details);
        assertNotNull(addressDataService.getAddressDetailByPostCode("SW1A 2AA"));
    }

    @Test
    public void getAddressForPostcodeBT486DQ() throws Exception {
        AddressDetails details = new AddressDetails.AddressBuilder()
                .validPostcode(true).formattedAddress("Newmarket Office, Newmarket St, Londonderry BT48 6DQ, UK").build();

        when(addressDataService.getAddressDetailByPostCode(anyString())).thenReturn(details);
        assertNotNull(addressDataService.getAddressDetailByPostCode("BT48 6DQ"));
    }

}
