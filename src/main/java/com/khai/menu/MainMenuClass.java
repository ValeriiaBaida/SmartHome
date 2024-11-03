package com.khai.menu;

import com.khai.room.RoomClass;
import com.khai.SmartHome;
import com.khai.devices.*;
import com.khai.validators.*;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MainMenuClass {
    private final SmartHome smartHome;
    private final Scanner scanner;

    public static final String RESET = "\033[0m";  // Скинути колір тексту
    public static final String BLACK = "\033[0;30m";
    public static final String RED = "\033[0;31m";
    public static final String GREEN = "\033[0;32m";
    public static final String YELLOW = "\033[0;33m";
    public static final String BLUE = "\033[0;34m";
    public static final String PURPLE = "\033[0;35m";
    public static final String CYAN = "\033[0;36m";
    public static final String WHITE = "\033[0;37m";
    public static final String BRIGHT_RED = "\033[0;91m";
    public static final String BRIGHT_GREEN = "\033[0;92m";
    public static final String BRIGHT_YELLOW = "\033[0;93m";
    public static final String BRIGHT_BLUE = "\033[0;94m";
    public static final String BRIGHT_PURPLE = "\033[0;95m";

    public MainMenuClass()
    {
        smartHome = new SmartHome();
        scanner = new Scanner(System.in);
    }

    public int printMenu()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println(CYAN + "\nSmart Home System Menu:" + RESET);
        System.out.println(RED+"1. Device menu" + RESET);
        System.out.println(GREEN+"2. Room menu" + RESET);
        System.out.println(GREEN+"3. Schedule menu" + RESET);
        System.out.println(YELLOW+"4. View Sensor Data" + RESET);
        System.out.println(BRIGHT_RED+"5. Exit"+RESET);

        System.out.print("Choose an option: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        return choice;
    }

    public boolean choiceMenu(int choice)
    {
        switch (choice) {
            case 1:
                DeviceMenuClass deviceMenuClass = new DeviceMenuClass(smartHome, scanner);
                while(deviceMenuClass.choiseMenu(deviceMenuClass.printMenu())) {}
                break;
            case 2:
                RoomMenuClass roomMenuClass = new RoomMenuClass(smartHome, scanner);
                while(roomMenuClass.choiseMenu(roomMenuClass.printMenu())) {}
                break;
            case 3:
                SheludeMenuClass sheludeMenuClass = new SheludeMenuClass(smartHome, scanner);
                while(sheludeMenuClass.choiseMenu(sheludeMenuClass.printMenu())) {}
                break;
            case 4:
                smartHome.viewSensorData();
                break;
            case 5:
                System.out.println("Exiting...");
                scanner.close();
                return false;
            default:
                System.out.println("Invalid option.");
        }
        return true;
    }


}
