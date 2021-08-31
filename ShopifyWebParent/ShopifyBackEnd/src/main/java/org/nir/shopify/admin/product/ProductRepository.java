package org.nir.shopify.admin.product;

import org.springframework.data.repository.PagingAndSortingRepository;

import org.nir.shopify.common.entity.Product;

public interface ProductRepository extends PagingAndSortingRepository<Product, Integer> {
	public Product findByName(String name);
}