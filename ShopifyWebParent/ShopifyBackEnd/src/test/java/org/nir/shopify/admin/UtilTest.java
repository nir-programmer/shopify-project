package org.nir.shopify.admin;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.nir.shopify.common.utils.Util;
import org.nir.shopify.common.utils.Util.OS;

public class UtilTest 
{
	@Test
	@DisplayName("Test the Os")
	public void testOs()
	{
		//GIVEN
		OS expectedOS = OS.LINUX;
		
		
		
		
		//WHEN 
		OS actualOS = Util.getOperatingSystem();
		
		//THEN
		assertThat(actualOS).isEqualTo(expectedOS);
		System.out.println("The OS is : " + actualOS);
	}

}
