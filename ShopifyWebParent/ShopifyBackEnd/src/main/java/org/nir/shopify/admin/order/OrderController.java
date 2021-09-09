package org.nir.shopify.admin.order;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.nir.shopify.admin.paging.PagingAndSortingHelper;
import org.nir.shopify.admin.paging.PagingAndSortingParam;
import org.nir.shopify.admin.setting.SettingService;
import org.nir.shopify.common.entity.Setting;

@Controller
public class OrderController {
	private String defaultRedirectURL = "redirect:/orders/page/1?sortField=orderTime&sortDir=desc";

	@Autowired private OrderService orderService;
	@Autowired private SettingService settingService;

	@GetMapping("/orders")
	public String listFirstPage() {
		return defaultRedirectURL;
	}

	@GetMapping("/orders/page/{pageNum}")
	public String listByPage(
			@PagingAndSortingParam(listName = "listOrders", moduleURL = "/orders") PagingAndSortingHelper helper,
			@PathVariable(name = "pageNum") int pageNum,
			HttpServletRequest request) {

		orderService.listByPage(pageNum, helper);
		loadCurrencySetting(request);

		return "orders/orders";
	}

	private void loadCurrencySetting(HttpServletRequest request) {
		List<Setting> currencySettings = settingService.getCurrencySettings();

		for (Setting setting : currencySettings) {
			request.setAttribute(setting.getKey(), setting.getValue());
		}	
	}	
}