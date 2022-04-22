package com.services;


import java.io.File;
import com.directory.*;


public class Directory_Service {
	
	
private static Directory fileDirectory = new Directory();
    
    public static void PrintFiles() {
    	
    	fileDirectory.fillFiles();

        for (File file : Directory_Service.getFileDirectory().getFiles())
        {
            System.out.println(file.getName());
        }
    }
    public static Directory getFileDirectory() {
        return fileDirectory;
    }

    public static void setFileDirectory(Directory fileDirectory) {
        Directory_Service.fileDirectory = fileDirectory;
    }

	
	
}
