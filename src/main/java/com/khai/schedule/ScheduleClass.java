package com.khai.schedule;
import com.khai.interfaces.ScheduleInterface;
import com.khai.interfaces.DeviceInterface;


import java.util.*;

public class ScheduleClass implements ScheduleInterface {
    private Map<DeviceInterface, String> schedules = new HashMap<>();

    @Override
    public void setSchedule(DeviceInterface deviceInterface, String time) {
        schedules.put(deviceInterface, time);
        System.out.println("Schedule set for device at: " + time);
    }

    @Override
    public void removeSchedule(DeviceInterface deviceInterface) {
        schedules.remove(deviceInterface);
        System.out.println("Schedule removed for device.");
    }

    @Override
    public void viewSchedules() {
        if (schedules.isEmpty()) {
            System.out.println("No schedules available.");
        } else {
            schedules.forEach((device, time) -> {
                System.out.println("Device: " + device.toString() + " ,scheduled at: " + time);
            });
        }
    }
}
