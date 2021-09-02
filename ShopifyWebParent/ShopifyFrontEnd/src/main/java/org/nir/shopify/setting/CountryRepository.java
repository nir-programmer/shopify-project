package org.nir.shopify.setting;

import java.util.List;

import org.nir.shopify.common.entity.Country;
import org.springframework.data.repository.CrudRepository;

public interface CountryRepository extends CrudRepository<Country, Integer> {
	public List<Country> findAllByOrderByNameAsc();
}