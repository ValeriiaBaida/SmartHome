package com.khai.validators;
import com.khai.interfaces.DeviceInterface;
import java.util.List;

public class DeviceValidator {
    public static boolean isValidDeviceIndex(int index, List<DeviceInterface> deviceInterfaces) {
        if (index < 0 || index >= deviceInterfaces.size()) {
            System.out.println("Invalid device selection.");
            return false;
        }
        return true;
    }
}