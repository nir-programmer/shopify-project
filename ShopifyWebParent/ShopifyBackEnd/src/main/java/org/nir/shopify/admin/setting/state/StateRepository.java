package org.nir.shopify.admin.setting.state;


import java.util.List;

import org.nir.shopify.common.entity.Country;
import org.nir.shopify.common.entity.State;
import org.springframework.data.repository.CrudRepository;

public interface StateRepository extends CrudRepository<State, Integer> {

	public List<State> findByCountryOrderByNameAsc(Country country);
}