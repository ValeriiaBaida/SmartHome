package com.khai.validators;

import com.khai.room.RoomClass;
import com.khai.interfaces.DeviceInterface;

import java.util.List;

public class RoomValidator {
    public static boolean isValidRoomIndex(int index, List<RoomClass> roomClasses) {
        if (index < 0 || index >= roomClasses.size()) {
            System.out.println("Invalid device selection.");
            return false;
        }
        return true;
    }
}
