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
		String dirName = "user-photos";
		Path userPhotosDir = Paths.get(dirName);
		
		String pathPrefix = getPathPrefix();
		System.err.println("Path Prefix : " + pathPrefix);
		
		String userPhotosPath = userPhotosDir.toFile().getAbsolutePath();
		
		
		registry.addResourceHandler("/" + dirName + "/**")
			.addResourceLocations(pathPrefix + userPhotosPath + "/");
		
		String categoryImagesDirName = "../category-images";
		Path categoryImagesDir = Paths.get(categoryImagesDirName);
		
		String categoryImagesPath = categoryImagesDir.toFile().getAbsolutePath();
		
		//"file://"
		registry.addResourceHandler("/category-images/**")
			.addResourceLocations(pathPrefix + categoryImagesPath + "/");		
	}

	private String getPathPrefix() 
	{
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