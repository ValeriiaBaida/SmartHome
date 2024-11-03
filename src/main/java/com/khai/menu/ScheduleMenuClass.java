package com.khai.menu;

import com.khai.SmartHome;
import com.khai.validators.TimeValidator;

import java.util.Scanner;

public class ScheduleMenuClass {
    private final SmartHome smartHome;
    private final Scanner scanner;

    public static final String RESET = "\033[0m";
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

    public ScheduleMenuClass(SmartHome smartHome, Scanner scanner) {
        this.smartHome = smartHome;
        this.scanner = scanner;
    }

    public int printMenu()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println(CYAN + "\nSchedule Menu:" + RESET);
        System.out.println(RED+"1. Add schedule to device" + RESET);
        System.out.println(GREEN+"2. Remove schedule from device" + RESET);
        System.out.println(BRIGHT_RED+"3. Exit"+RESET);


        System.out.print("Choose an option: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        return choice;
    }

    public boolean choiceMenu(int choice)
    {
        switch (choice) {
            case 1:
                addScheduleToDevice();
                break;
            case 2:
                removeScheduleFromDevice();
                break;
            case 3:
                System.out.println("Exiting...");
                return false;
            default:
                System.out.println("Invalid option.");
        }
        return true;
    }
    private void removeScheduleFromDevice() {
        smartHome.viewSchedules();
        System.out.print("Enter device index to remove schedule: ");
        int removeIndex = scanner.nextInt() - 1;
        smartHome.removeSchedule(removeIndex);
    }

    private void addScheduleToDevice() {
        System.out.print("Enter device index to schedule: ");
        int scheduleIndex = scanner.nextInt() - 1;
        scanner.nextLine();
        System.out.print("Enter time (e.g., 10:00 AM): ");
        String time = scanner.nextLine();
        try {
            TimeValidator.validateTimeFormat(time);
            smartHome.setSchedule(scheduleIndex, time);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
