package org.nir.shopify.common.utils;

import org.springframework.stereotype.Component;


public class Util 
	{
	    // create enums for each operating system
	    public enum OS {
	        WINDOWS, LINUX, MAC, SOLARIS
	    };
	 
	    public static OS getOperatingSystem()
	    {
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
	 
	    public static void main(String[] args)
	    {
	        switch (getOperatingSystem())
	        {
	            case WINDOWS:
	                System.out.println("Windows Operating System");
	                break;
	            case LINUX:
	                System.out.println("Linux Operating System");
	                break;
	            case MAC:
	                System.out.println("Mac Operating System");
	                break;
	            case SOLARIS:
	                System.out.println("Solaris Operating System");
	                break;
	            default:
	                System.out.println("Unknown Operating System");
	        }
	    }
	}



