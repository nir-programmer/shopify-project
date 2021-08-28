package org.nir.shopify.admin.category;

import java.util.List;

import org.nir.shopify.common.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
	@Autowired
	private CategoryRepository repo;
	
	public List<Category> listAll() {
		return (List<Category>) repo.findAll();
	}
}