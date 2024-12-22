package com.khai.menu;

import com.khai.room.RoomClass;
import com.khai.SmartHome;

import java.util.Scanner;

public class RoomMenuClass {

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

    public RoomMenuClass(SmartHome smartHome, Scanner scanner) {
        this.smartHome = smartHome;
        this.scanner = scanner;
    }
    public int printMenu()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println(CYAN + "\nRoom Menu:" + RESET);
        System.out.println(RED+"1. Add room" + RESET);
        System.out.println(GREEN+"2. View rooms" + RESET);
        System.out.println(GREEN+"3. Add device to room" + RESET);
        System.out.println(YELLOW+"4. Remove device from room" + RESET);
        System.out.println(YELLOW+"5. Delete room" + RESET);
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
                addRoom();
                break;
            case 2:
                viewRoom();
                break;
            case 3:
                addDeviceToRoom();
                break;
            case 4:
                removeDeviceFromRoom();
                break;
            case 5:
                deleteRoom();
                break;
            case 6:
                System.out.println("Exiting...");
                return false;
            default:
                System.out.println("Invalid option.");
        }
        return true;
    }

    private void removeDeviceFromRoom() {

        smartHome.viewRooms();
        System.out.print("Enter room index to control: ");
        int roomIndex = scanner.nextInt() - 1;
        scanner.nextLine();
        RoomClass room = smartHome.getRoom(roomIndex);
        room.displayRoom();
        System.out.print("Enter device index to control: ");
        int deviceIndex = scanner.nextInt() - 1;
        scanner.nextLine();
        room.removeDevice(deviceIndex);

    }

    private void addRoom() {

        String room;
        System.out.println("Enter room name");
        room = scanner.next();
        scanner.nextLine();
        smartHome.addRoom(new RoomClass(room));
        
    }

    private void addDeviceToRoom() {
        smartHome.viewRooms();
        System.out.print("Enter room index to control: ");
        int roomIndex = scanner.nextInt() - 1;
        scanner.nextLine();
        smartHome.viewDevices();
        System.out.print("Enter device index to control: ");
        int deviceIndex = scanner.nextInt() - 1;
        scanner.nextLine();
        smartHome.addDeviceToRoom(roomIndex, deviceIndex);
    }

    private void deleteRoom() {
        smartHome.viewRooms();
        System.out.print("Enter room index to control: ");
        int roomIndex = scanner.nextInt() - 1;
        scanner.nextLine();
        smartHome.deleteRoom(roomIndex);
    }

    private void viewRoom() {
        smartHome.viewRooms();
    }
}
