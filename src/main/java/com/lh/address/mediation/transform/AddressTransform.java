package com.lh.address.mediation.transform;

import com.lh.address.domain.AddressDetails;
import com.lh.address.outbound.representation.AddressDetailsResponse;
import com.lh.address.outbound.representation.AddressGeometry;
import com.lh.address.outbound.representation.AddressResponsePredicate;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.function.Function;

/**
 * Address Mediation to transform de-serialized json response wrapped object to simplified address details object
 *
 * Created by kumar k on 12/03/2017.
 */
@Component
public class AddressTransform {

    /**
     * Get the address details for a given postCode.
     *
     * @param detailsResponse AddressDetailsResponse to be transformed
     * @return AddressDetails simplified address details
     */
    public AddressDetails xformAddressOutbound(AddressDetailsResponse detailsResponse) {
        Optional<AddressDetailsResponse> resOptional = Optional.ofNullable(detailsResponse);
        if (resOptional.isPresent() && AddressResponsePredicate.isStatusOK.test(detailsResponse)) {
            Optional<AddressDetails> firstAddResult = detailsResponse.getResults().stream().map(
                    a -> new AddressDetails.AddressBuilder().formattedAddress(a.getFormatted_address()).validPostcode(true).build()).findFirst();
            if (firstAddResult.isPresent()){
                return firstAddResult.get();
            }
        }
        return new AddressDetails.AddressBuilder().build();
    }

    /**
     * Get the address details for a given postCode.
     *
     * @param addressResponse AddressDetailsResponse to be transformed
     * @return Optional<String> to return latitude and longitude for the location; separated by comma.
     */
    public Optional<String> getLatLongFromAddress(AddressDetailsResponse addressResponse) {
        Optional<AddressDetailsResponse> resOptional = Optional.ofNullable(addressResponse);
        if (resOptional.isPresent() && AddressResponsePredicate.isStatusOK.test(addressResponse)) {
            Function<AddressGeometry, String> latLong = (g -> String.join(",", String.valueOf(g.getLocation().getLat()), String.valueOf(g.getLocation().getLng())));

            return addressResponse.getResults().parallelStream().map(
                    r -> r.getGeometry()).map(latLong).findFirst();
        }
        return Optional.empty();
    }
}
