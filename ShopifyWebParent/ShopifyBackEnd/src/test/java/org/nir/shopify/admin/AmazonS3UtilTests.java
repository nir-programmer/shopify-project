package org.nir.shopify.admin;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

import org.junit.jupiter.api.Test;

public class AmazonS3UtilTests
{
	@Test
	public void testListFolder()
	{
		//Given
		//String folderName = "product-images/18"; 
		String folderName = "product-images/10/"; 
		
		//WHEN
		List<String> listKeys = AmazonS3Util.listFolder(folderName);
		
		
		//THEN
		assertThat(listKeys).isNotNull();
		assertThat(listKeys.size()).isGreaterThan(0);
		
		listKeys.forEach(System.out::println);
		
	}
	
	@Test
	public void testUploadFile() throws FileNotFoundException
	{
		
		//GIVEN
		
		String folderName = "test-upload/one/two/three";
		String fileName = "test.jpeg"; 
		String filePath = "/home/nir/Desktop/" + fileName;
		
		InputStream inputStream = new FileInputStream(filePath);
		
		//WHEN
		AmazonS3Util.uploadFile(folderName, fileName, inputStream);
		
		//THEN
		
	}
	
	@Test 
	public void testDeleteFile()
	{
		//GIVEN
		//The Key on AWS for this object : test-upload/one/two/three/test.jpeg
		String fileName = "test-upload/one/two/three/test.jpeg"; 
		
		//WHEN
		AmazonS3Util.deleteFile(fileName);
		
		
		//THEN
		
		
	}
	
	@Test
	public void testRemoveFolder()
	{
		//GIVEN
		String folderName = "test-upload"; 
		
		//WHEN
		AmazonS3Util.removeFolder(folderName);
		
		
		
		
		//THEN
		
	}

}
