package org.nir.shopify.admin.brand;

import org.nir.shopify.common.entity.Brand;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BrandRepository extends PagingAndSortingRepository<Brand, Integer> {
	
	public Long countById(Integer id);
	
	public Brand findByName(String name);
}