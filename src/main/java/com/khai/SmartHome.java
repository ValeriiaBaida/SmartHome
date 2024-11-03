package com.khai;

import java.util.*;

import com.khai.room.RoomClass;
import com.khai.interfaces.*;
import com.khai.devices.*;
import com.khai.sensors.HomeSensorClass;
import com.khai.schedule.ScheduleClass;
import com.khai.validators.*;

public class SmartHome {
    private List<DeviceInterface> devices = new ArrayList<>();
    private List<SensorInterface> sensors = new ArrayList<>();
    private List<RoomClass> rooms = new ArrayList<>();
    private ScheduleClass scheduleManager = new ScheduleClass();

    public SmartHome() {
        HomeSensorClass homeSensor = new HomeSensorClass();
        sensors.add(homeSensor);
    }

    public void addRoom(RoomClass room) {
        rooms.add(room);
        System.out.println("Room added: " + room);
    }

    public RoomClass getRoom(int id) {
        if (!RoomValidator.isValidRoomIndex(id, rooms)) return null;
        return rooms.get(id);
    }

    public void addDevice(DeviceInterface deviceInterface) {
        devices.add(deviceInterface);
        System.out.println("Device added: " + deviceInterface);
    }

    public void viewSensorData() {
        // Заголовок таблиці
        System.out.printf("%-15s %-20s %-20s %-15s%n", "Sensor", "Temperature (°C)", "Humidity (%)", "Light Level (lux)");
        System.out.println("----------------------------------------------------------------------------");

        // Виведення даних сенсора
        for (SensorInterface sensorInterface : sensors) {
            System.out.printf("%-15s %-20.1f %-20.1f %-15.1f%n",
                    sensorInterface.getClass().getSimpleName(),
                    sensorInterface.getTemperature(),
                    sensorInterface.getHumidity(),
                    sensorInterface.getLightLevel());
        }
    }

    public void viewDevices() {
        if (devices.isEmpty()) {
            System.out.println("No devices available.");
        } else {
            for (int i = 0; i < devices.size(); i++) {
                System.out.println((i + 1) + ". " + devices.get(i).toString());
            }
        }
    }

    public void viewRooms() {
        if (rooms.isEmpty()) {
            System.out.println("No rooms available.");
        } else {
            for (int i = 0; i < rooms.size(); i++) {
                System.out.println((i + 1) + ". " + rooms.get(i).toString());
            }
        }
    }

    public void controlDevice(int index, String action) {
        if (!DeviceValidator.isValidDeviceIndex(index, devices)) return;

        DeviceInterface deviceInterface = devices.get(index);
        switch (action.toLowerCase()) {
            case "on":
                deviceInterface.turnOn();
                break;
            case "off":
                deviceInterface.turnOff();
                break;
            default:
                System.out.println("Invalid action.");
        }
    }

    public List<DeviceInterface> getDevices() {
        return devices;
    }

    public void setDeviceParameters(int index, Map<String, String> params) {
        if (!DeviceValidator.isValidDeviceIndex(index, devices)) return;

        DeviceInterface deviceInterface = devices.get(index);

        if (deviceInterface instanceof LightClass) {
            DeviceParameterValidator.validateLightParameters(params);
        } else if (deviceInterface instanceof AirConditionerClass) {
            DeviceParameterValidator.validateAirConditionerParameters(params);
        } else {
            throw new IllegalArgumentException("Invalid device type for setting parameters.");
        }
        deviceInterface.setParameters(params);
    }

    public void setSchedule(int index, String time) {
        if (!DeviceValidator.isValidDeviceIndex(index, devices)) return;

        DeviceInterface deviceInterface = devices.get(index);
        scheduleManager.setSchedule(deviceInterface, time);
    }

    public void viewSchedules() {
        scheduleManager.viewSchedules();
    }

    public void removeSchedule(int index) {
        if (!DeviceValidator.isValidDeviceIndex(index, devices)) return;

        DeviceInterface deviceInterface = devices.get(index);
        scheduleManager.removeSchedule(deviceInterface);
    }



    public void deleteDevice(int indexDevice) {
        if (!DeviceValidator.isValidDeviceIndex(indexDevice, devices)) return;
        //очистить комнату от устройства
        findDeviceInRoom(indexDevice);
        devices.remove(indexDevice);
    }

    private void findDeviceInRoom(int indexDevice) {
        for (RoomClass room : rooms) {
            ArrayList<DeviceInterface> devices = room.getDevices();
            //devices.remove(indexDevice);
        }
    }

    public void addDeviceToRoom(int roomIndex, int indexDevice) {
        if (!RoomValidator.isValidRoomIndex(roomIndex, rooms)) return;
        if (!DeviceValidator.isValidDeviceIndex(indexDevice, devices)) return;

        DeviceInterface deviceInterface = devices.get(indexDevice);
        RoomClass room = rooms.get(roomIndex);
        room.addDevice(deviceInterface);
    }

    public void deleteRoom(int roomIndex) {
        if (!RoomValidator.isValidRoomIndex(roomIndex, rooms)) return;
        rooms.remove(roomIndex);
    }
}
