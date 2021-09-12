package org.nir.shopify.order;

public class OrderReturnResponse 
{
	private Integer orderId;

	
	
	public OrderReturnResponse() {
		super();
	}



	public OrderReturnResponse(Integer orderId) {
		
		this.orderId = orderId;
	}



	public Integer getOrderId() {
		return orderId;
	}



	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	} 
	
	
	
	

}
