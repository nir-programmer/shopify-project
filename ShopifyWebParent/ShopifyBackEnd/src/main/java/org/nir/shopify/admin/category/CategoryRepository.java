package org.nir.shopify.admin.category;
import org.springframework.data.domain.Sort;
import java.util.List;

import org.nir.shopify.common.entity.Category;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface CategoryRepository extends PagingAndSortingRepository<Category, Integer> {
	@Query("SELECT c FROM Category c WHERE c.parent.id is NULL")
	public List<Category> findRootCategories(Sort sort);
	
	public Category findByName(String name);
	
	public Category findByAlias(String alias);
}