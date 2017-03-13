package com.lh.address.outbound.representation;

import java.util.function.Predicate;

/**
 * Created by kumar k on 12/03/2017.
 */
public class AddressResponsePredicate {
    public static Predicate<AddressDetailsResponse> isStatusOK = resp -> "OK".equalsIgnoreCase(resp.getStatus());

}
