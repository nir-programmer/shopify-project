package org.shopify.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan({"corg.nir.shopify.common.entity", "org.nir.shopify.admin.user"})
public class ShopifyBackEndApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopifyBackEndApplication.class, args);
	}

}
