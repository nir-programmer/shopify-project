package org.nir.shopify.admin;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer 
{
	@Value("${os.file-system.prefix}")
	private String fileSystemPrefix;
	

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		String dirName = "user-photos";
		Path userPhotosDir = Paths.get(dirName);

		String userPhotosPath = userPhotosDir.toFile().getAbsolutePath();
		
		System.err.println(">>MvcConfig: fileSystemPrefix: " + fileSystemPrefix);
		registry.addResourceHandler("/" + dirName + "/**")
			.addResourceLocations(fileSystemPrefix + userPhotosPath + "/");
	}

}