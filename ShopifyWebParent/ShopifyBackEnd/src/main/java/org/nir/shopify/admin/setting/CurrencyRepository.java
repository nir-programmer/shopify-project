package org.nir.shopify.admin.setting;
import java.util.List;

import org.nir.shopify.common.entity.Currency;
import org.springframework.data.repository.CrudRepository;

public interface CurrencyRepository extends CrudRepository<Currency, Integer> 
{
	public List<Currency> findAllByOrderByNameAsc();

}