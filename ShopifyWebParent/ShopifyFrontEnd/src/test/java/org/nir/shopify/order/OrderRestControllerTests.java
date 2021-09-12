package org.nir.shopify.order;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
public class OrderRestControllerTests
{
	@Autowired  private MockMvc mockMvc; 
	
	//will be used to serialize the OrderReturnRequest Object to JSON String..
	@Autowired private ObjectMapper objectMapper; 
	
	
	
	@Test
	@WithUserDetails("niritzhak10.devel@gmail.com")
	public void testSendOrderReturnRequestFailed() throws Exception
	{
		//GIVEN - A NON EXISTS ORDER IN THE DB
		Integer orderId = 1111;
		OrderReturnRequest returnRequest = new OrderReturnRequest(orderId, "", "");
		
		String requestURL = "/orders/return"; 
		
		mockMvc.perform(post(requestURL)
				.with(csrf())
				.contentType("application/json")
				.content(requestURL)//Send the OrderReturnRequest object along with the HttpRequest objecs
				.content(objectMapper.writeValueAsString(returnRequest)))
			.andExpect(status().isNotFound())
			.andDo(print()); 
		
	}

	@Test
	@WithUserDetails("niritzhak10.devel@gmail.com")
	public void testSendOrderReturnRequestSuccessfull() throws Exception
	{
		//GIVEN - AN EXISTS ORDER IN THE DB of an Existing customer
		Integer orderId = 10;
		String reason = "I bough the wrong items" ; 
		String note = "Please return my money" ; 
		
		
		OrderReturnRequest returnRequest = new OrderReturnRequest(orderId, reason, note);
		
		String requestURL = "/orders/return"; 
		
		mockMvc.perform(post(requestURL)
				.with(csrf())
				.contentType("application/json")
				.content(requestURL)//Send the OrderReturnRequest object along with the HttpRequest objecs
				.content(objectMapper.writeValueAsString(returnRequest)))
			.andExpect(status().isOk())
			.andDo(print()); 
		
	}
	

}
