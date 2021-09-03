package org.nir.shopify.admin;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.nir.shopify.admin.paging.PagingAndSortingArgumentResolver;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

	

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		exposeDirectory("user-photos", registry);
		exposeDirectory("../category-images", registry);
		exposeDirectory("../brand-logos", registry);
		exposeDirectory("../product-images", registry);
		exposeDirectory("../site-logo", registry);
	}

	private void exposeDirectory(String pathPattern, ResourceHandlerRegistry registry) 
	{
		//The prefix path of the current OS file system
		String pathPrefix = getPathPrefix();
		System.err.println("Path Prefix : " + pathPrefix);
		
		Path path = Paths.get(pathPattern);
		String absolutePath = path.toFile().getAbsolutePath();
		
		String logicalPath = pathPattern.replace("../", "") + "/**";
				
		registry.addResourceHandler(logicalPath)
			.addResourceLocations(pathPrefix + absolutePath + "/");	
		
	
	}
	
	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
		resolvers.add(new PagingAndSortingArgumentResolver());
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