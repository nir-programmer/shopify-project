package org.nir.shopify.admin.user;
import org.nir.shopify.common.entity.User;
import org.springframework.data.repository.CrudRepository;



public interface UserRepository extends CrudRepository<User, Integer> {

}