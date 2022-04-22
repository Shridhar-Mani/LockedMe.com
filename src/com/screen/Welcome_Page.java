package com.screen;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


import com.screen.Screen;
import com.services.Service_screen;
import com.screen.FileOption_screen;
import com.services.Directory_Service;


public class Welcome_Page implements Screen {
	
	private String welcomeText = "Hi! Welcome to LockedMe";
    private String developerText = "Developer: Shridhar";

    private ArrayList<String> options = new ArrayList<>();


    public Welcome_Page() {
        options.add("1: Show Files");
        options.add("2: File Operations");
        options.add("3: Exit");

    }
    
    public void introWS() {
    	System.out.println(welcomeText);
        System.out.println(developerText);
        System.out.println("");
        Show();
    }
    
    
    
    @Override
    public void Show() {
    	System.out.println("\nMain Menu:");
        for (String s : options)  {
            System.out.println(s);
        }

    }

    public void GetUserInput() {
        int selectedOption  = 0;
        while ((selectedOption = this.getOption()) != 3) {
            this.NavigateOption(selectedOption);
        }
    }

    @Override
    public void NavigateOption(int option) {
        switch(option) {

            case 1: // Show Files in Directory
                this.ShowFiles();
                
                this.Show();
                
                break;
                
            case 2: // Show File Options menu
            	Service_screen.setCurrentScreen(Service_screen.FileOptionsScreen);
            	Service_screen.getCurrentScreen().Show();
            	Service_screen.getCurrentScreen().GetUserInput();
                
                this.Show();
                
                break;
                
            default:
                System.out.println("Invalid Option");
                break;
        }
        
    }

    public void ShowFiles() {

        //TODO: Get the files from the Directory
    	
    	//Finished TODO Task

        System.out.println("List of Files: \n");
    	Directory_Service.PrintFiles();

    }
    
    private int getOption() {
        Scanner in = new Scanner(System.in);

        int returnOption = 0;
        try {
            returnOption = in.nextInt();
        }
        catch (InputMismatchException ex) {

        }
        return returnOption;

    }

}
