package com.services;

import com.services.Directory_Service;
import com.screen.FileOption_screen;
import com.screen.Welcome_Page;
import com.screen.Screen;


public class Service_screen {
	
	
	public static Welcome_Page WelcomeScreen = new Welcome_Page();
    public static FileOption_screen FileOptionsScreen = new FileOption_screen();
    
    

    public static Screen CurrentScreen = WelcomeScreen;

    
    public static Screen getCurrentScreen() {
        return CurrentScreen;
    }

    
    public static void setCurrentScreen(Screen currentScreen) {
        CurrentScreen = currentScreen;
    }

}
