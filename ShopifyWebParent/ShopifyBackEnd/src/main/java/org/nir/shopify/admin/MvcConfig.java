package org.nir.shopify.admin;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

	

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) 
	{

		String pathPrefix = getPathPrefix();
		System.err.println("Path Prefix : " + pathPrefix);
		
		
		//EXPOSES USER IMAGES
		String dirName = "user-photos";
		Path userPhotosDir = Paths.get(dirName);


		String userPhotosPath = userPhotosDir.toFile().getAbsolutePath();

		registry.addResourceHandler("/" + dirName + "/**").addResourceLocations(pathPrefix + userPhotosPath + "/");

		
		//EXPOSES CATEGORIES IMAGES
		String categoryImagesDirName = "../category-images";
		Path categoryImagesDir = Paths.get(categoryImagesDirName);

		String categoryImagesPath = categoryImagesDir.toFile().getAbsolutePath();
		
		registry.addResourceHandler("/category-images/**").addResourceLocations(pathPrefix + categoryImagesPath + "/");
		
		//EXPOSES BRANDS IMAGES
		String brandLogosDirName = "../brand-logos";
		Path brandLogosDir = Paths.get(brandLogosDirName);

		String brandLogosPath = brandLogosDir.toFile().getAbsolutePath();
		
		registry.addResourceHandler("/brand-logos/**").addResourceLocations(pathPrefix + brandLogosPath + "/");
		
		
		
	}

	private String getPathPrefix() {
		// detecting the operating system using `os.name` System property
		String os = System.getProperty("os.name").toLowerCase();

		if (os.contains("win")) {
			return "file:/";
		}

		else if (os.contains("nix") || os.contains("nux") || os.contains("aix")) {
			return "file://";
		}

		/*
		 * else if (os.contains("mac")) { return OS.MAC; }
		 * 
		 * else if (os.contains("sunos")) { return OS.SOLARIS; }
		 */

		return null;
	}

	// create enums for each operating system
	public enum OS {
		WINDOWS, LINUX, MAC, SOLARIS
	};

}