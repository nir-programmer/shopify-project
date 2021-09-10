package org.nir.shopify.setting;

import java.util.List;

import org.nir.shopify.common.entity.setting.Setting;
import org.nir.shopify.common.entity.setting.SettingCategory;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface SettingRepository extends CrudRepository<Setting, String> {
	public List<Setting> findByCategory(SettingCategory category);
	
	@Query("SELECT s FROM Setting s WHERE s.category = ?1 OR s.category = ?2")
	public List<Setting> findByTwoCategories(SettingCategory catOne, SettingCategory catTwo);
	
	public Setting findByKey(String key);
}