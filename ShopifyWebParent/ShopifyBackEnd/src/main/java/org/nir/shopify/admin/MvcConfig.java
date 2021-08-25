package org.nir.shopify.admin;

import java.nio.file.Path;
import java.nio.file.Paths;

import org.nir.shopify.common.utils.Util.OS;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
	public enum OS {
		WINDOWS, LINUX, MAC, SOLARIS
	};

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		String dirName = "user-photos";
		Path userPhotosDir = Paths.get(dirName);
		
		//My code - get the prefix based on the OS
		String fileSystemPrefix = getFileSystemPathPrefix();
		System.err.println(">>File System Prefix on this machine : " + fileSystemPrefix);

		String userPhotosPath = userPhotosDir.toFile().getAbsolutePath();

		
		registry.addResourceHandler("/" + dirName + "/**").addResourceLocations("file://" + userPhotosPath + "/");
	}

	
	private static String getFileSystemPathPrefix()
	{
		String fileSystemPrefix = ""; 
		OS os = getOperatingSystem();
		
		if(os.equals(OS.LINUX))
			fileSystemPrefix = "file://";
		
		else if(os.equals(OS.WINDOWS))
			fileSystemPrefix = "file:/"; 
		
		return fileSystemPrefix;
	}
	
	
	private static OS getOperatingSystem() {
		// detecting the operating system using `os.name` System property
		String os = System.getProperty("os.name").toLowerCase();

		if (os.contains("win")) {
			return OS.WINDOWS;
		}

		else if (os.contains("nix") || os.contains("nux") || os.contains("aix")) {
			return OS.LINUX;
		}

		else if (os.contains("mac")) {
			return OS.MAC;
		}

		else if (os.contains("sunos")) {
			return OS.SOLARIS;
		}

		return null;
	}

}