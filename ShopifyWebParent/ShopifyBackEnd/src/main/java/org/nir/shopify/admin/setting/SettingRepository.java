package org.nir.shopify.admin.setting;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import org.nir.shopify.common.entity.Setting;
import org.nir.shopify.common.entity.SettingCategory;

public interface SettingRepository extends CrudRepository<Setting, String> {
	public List<Setting> findByCategory(SettingCategory category);
}