package org.nir.shopify.admin.category;

import org.springframework.data.repository.PagingAndSortingRepository;

import org.nir.shopify.common.entity.Category;

public interface CategoryRepository extends PagingAndSortingRepository<Category, Integer> {

}