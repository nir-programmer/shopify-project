package org.nir.shopify.admin.setting;
import org.springframework.data.repository.CrudRepository;

import org.nir.shopify.common.entity.Setting;

public interface SettingRepository extends CrudRepository<Setting, String> {

}