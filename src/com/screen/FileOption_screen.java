package com.screen;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


import com.directory.Directory;
import com.services.Service_screen;
import com.screen.Screen;

public class FileOption_screen implements Screen {
	
private Directory dir = new Directory();
	
	private ArrayList<String> options = new ArrayList<>();

    public FileOption_screen() {
    	
    	options.add("1: Add A File");
        options.add("2: Delete A File");
        options.add("3: Search A File");
        options.add("4: Return To Menu");
        
    }
    
    @Override
    public void Show() {
    	System.out.println("\nFile Operations:");
        for (String s : options) {
            System.out.println(s);
        }

    }

    public void GetUserInput() {
        int selectedOption;
        while ((selectedOption = this.getOption()) != 4) {
            this.NavigateOption(selectedOption);
        }
    }

    @Override
    public void NavigateOption(int option) {
        
    	switch(option) {

            case 1: // Add File
                this.AddFile();
                
                this.Show();
                break;
            case 2: // Delete File
                this.DeleteFile();
                
                this.Show();
                break;
            case 3: // Search File
                this.SearchFile();
                this.Show();
                break;
             
            default:
                System.out.println("\nInvalid Option");
                break;
                
                
        }

    }

    public void AddFile() {
        System.out.println("\nPlease Enter the Filename:");

        String fileName = this.getInputString();

        System.out.println("\nYou are adding a file named: " + fileName);
        
		try {
			Path path = FileSystems.getDefault().getPath(Directory.name + fileName).toAbsolutePath();
			File file = new File(dir.getName() + fileName);
			
		      if (file.createNewFile()) {
		    	  System.out.println("\nFile created: " + file.getName());
		    	  dir.getFiles().add(file);
		    	  
		      } else {
		        System.out.println("\nThis File Already Exits, no need to add another");
		      }
		}catch (IOException e){
			System.out.println(e);
		}
	}
        
    
    
    public void DeleteFile() {
    	
    	System.out.println("\nPlease Enter the Filename:");

        String fileName = this.getInputString();

        System.out.println("\nYou are deleting a file named: " + fileName);
        
		Path path = FileSystems.getDefault().getPath(Directory.name + fileName).toAbsolutePath();
		File file = path.toFile();
	      if (file.delete()) {
	    	  System.out.println("\nDeleted File: " + file.getName());
	    	  dir.getFiles().remove(file);
	      } else {
	        System.out.println("\nFailed to delete file:" + fileName + ", file was not found.");
	      }
    }
    
    public void SearchFile() {
    	
    	Boolean found = false;
    	
    	System.out.println("\nPlease Enter the Filename:");

        String fileName = this.getInputString();

        System.out.println("\nYou are searching for a file named: " + fileName);
        
        
        ArrayList<File> files = dir.getFiles();
        
        
        for(int i = 0; i < files.size(); i++) {
			if(files.get(i).getName().equals(fileName)) {
				System.out.println("Found " + fileName);
				found = true;
			}
        }
        if (found == false) {
        	System.out.println("\nFile not found");
        }
    }
    
    private String getInputString() {

        Scanner in = new Scanner(System.in);
        return(in.nextLine());

    }
    
    private int getOption() {
        Scanner in = new Scanner(System.in);

        int returnOption = 0;
        try {
            returnOption = in.nextInt();
        }
        catch (InputMismatchException ex) {
        	System.out.println("\nInvalid input");
        }
        return returnOption;

    }


}
