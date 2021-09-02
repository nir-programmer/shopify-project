package org.nir.shopify.setting;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import org.nir.shopify.common.entity.Country;
import org.nir.shopify.common.entity.State;

public interface StateRepository extends CrudRepository<State, Integer> {

	public List<State> findByCountryOrderByNameAsc(Country country);
}