package com.khai.menu;

import com.khai.room.RoomClass;
import com.khai.SmartHome;
import com.khai.devices.*;
import com.khai.validators.*;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DeviceMenuClass {
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

    public DeviceMenuClass(SmartHome smartHome, Scanner scanner) {
        this.smartHome = smartHome;
        this.scanner = scanner;
    }

    public int printMenu()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println(CYAN + "\nDevice Menu:" + RESET);
        System.out.println(RED+"1. Add Device" + RESET);
        System.out.println(GREEN+"2. View Devices" + RESET);
        System.out.println(GREEN+"3. Delete Devices" + RESET);
        System.out.println(BLUE+"4. Control Device (Turn On/Off)" + RESET);
        System.out.println(PURPLE+"5. Set Device Parameters" + RESET);
        System.out.println(BRIGHT_RED+"6. Exit"+RESET);


        System.out.print("Choose an option: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        return choice;
    }

    public boolean choiceMenu(int choice)
    {
        switch (choice) {
            case 1:
                System.out.print("Enter device type (Light/AirConditioner/Socket/Cleaner): ");

                System.out.print("Select variant (1-4): ");
                while (!scanner.hasNextInt()) {
                    System.out.println("please enter a number between 1 and 4");
                    scanner.next(); // очищення при неправильному вводі
                }
                int choiceDevice = scanner.nextInt();
                switch (choiceDevice)
                {
                    case 1:
                        initializeClass("LightClass");
                        break;
                    case 2:
                        initializeClass("AirConditionerClass");
                        break;
                    case 3:
                        initializeClass("SocketClass");
                        break;
                    case 4:
                        initializeClass("CleanerClass");
                        break;
                    default:
                        break;
                }
                break;
            case 2:
                smartHome.viewDevices();
                break;
            case 3:
                deleteDevice();
                break;
            case 4:
                switchModeDevice();
                break;
            case 5:
                setParameterDevice();
                break;
            case 6:
                System.out.println("Exiting...");
                return false;
            default:
                System.out.println("Invalid option.");
        }
        return true;
    }

    private void deleteDevice() {
        smartHome.viewDevices();
        System.out.print("Enter device index to set parameters: ");
        int paramDeviceIndex = scanner.nextInt() - 1;
        scanner.nextLine();

        if (!DeviceValidator.isValidDeviceIndex(paramDeviceIndex, smartHome.getDevices())) {
            return;
        }
        smartHome.deleteDevice(paramDeviceIndex);
    }


    private void setParameterDevice() {
        smartHome.viewDevices();
        System.out.print("Enter device index to set parameters: ");
        int paramDeviceIndex = scanner.nextInt() - 1;
        scanner.nextLine();

        if (!DeviceValidator.isValidDeviceIndex(paramDeviceIndex, smartHome.getDevices())) {
            return;
        }

        Map<String, String> params = new HashMap<>();
        System.out.print("Enter brightness (for Light) or temperature (for AirConditioner) or speed (for Cleaner): ");
        String input = scanner.nextLine();


        if (smartHome.getDevices().get(paramDeviceIndex) instanceof LightClass) {
            params.put("brightness", input);
        } else if (smartHome.getDevices().get(paramDeviceIndex) instanceof AirConditionerClass) {
            params.put("temperature", input);
        } else if (smartHome.getDevices().get(paramDeviceIndex) instanceof CleanerClass) {
            params.put("speed", input);
        }else {
            System.out.println("Invalid device type for setting parameters.");
            return;
        }
        smartHome.setDeviceParameters(paramDeviceIndex, params);
    }

    private void switchModeDevice() {
        smartHome.viewDevices();
        System.out.print("Enter device index to control: ");
        int deviceIndex = scanner.nextInt() - 1;
        scanner.nextLine();
        System.out.print("Enter action (on/off): ");
        String action = scanner.next();
        scanner.nextLine();
        smartHome.controlDevice(deviceIndex, action);
    }


    public void initializeClass(String className) {
        String deviceName;
        System.out.println("Enter device name");
        deviceName = scanner.next();
        scanner.nextLine();

        switch (className) {
            case "AirConditionerClass":
                smartHome.addDevice(new AirConditionerClass(deviceName));
                break;
            case "LightClass":
                smartHome.addDevice(new LightClass(deviceName));
                break;
            case "SocketClass":
                smartHome.addDevice(new SocketClass(deviceName));
                break;
            case "CleanerClass":
                smartHome.addDevice(new CleanerClass(deviceName));
                break;
            default:
                throw new IllegalArgumentException("Unknown class: " + className);

        };
    }
}
