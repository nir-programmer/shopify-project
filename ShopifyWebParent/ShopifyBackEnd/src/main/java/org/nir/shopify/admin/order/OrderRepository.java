package org.nir.shopify.admin.order;

import org.nir.shopify.common.entity.Order;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface OrderRepository extends PagingAndSortingRepository<Order, Integer> {

}
