package org.nir.shopify.shipping;

import org.nir.shopify.common.entity.Country;
import org.nir.shopify.common.entity.ShippingRate;
import org.springframework.data.repository.CrudRepository;


public interface ShippingRateRepository extends CrudRepository<ShippingRate, Integer> {

	public ShippingRate findByCountryAndState(Country country, String state);
}