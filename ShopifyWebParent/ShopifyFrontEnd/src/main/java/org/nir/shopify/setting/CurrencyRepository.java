package org.nir.shopify.setting;

import org.nir.shopify.common.entity.Currency;
import org.springframework.data.repository.CrudRepository;

public interface CurrencyRepository extends CrudRepository<Currency, Integer> {

}
