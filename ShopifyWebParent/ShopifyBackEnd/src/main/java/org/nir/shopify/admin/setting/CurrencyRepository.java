package org.nir.shopify.admin.setting;
import org.springframework.data.repository.CrudRepository;

import org.nir.shopify.common.entity.Currency;

public interface CurrencyRepository extends CrudRepository<Currency, Integer> {

}