package com.khai.room;

import com.khai.interfaces.DeviceInterface;
import com.khai.interfaces.RoomInterface;

import java.util.ArrayList;

public class RoomClass implements RoomInterface {
    private String name;
    private ArrayList<DeviceInterface> devices;

    public RoomClass(String name) {
        this.name = name;
        devices = new ArrayList<>();
    }

    @Override
    public void displayRoom() {
        for (DeviceInterface device : devices) {
            System.out.println(device.toString());
        }
    }

    @Override
    public void addDevice(DeviceInterface deviceInterface) {
        this.devices.add(deviceInterface);
    }

    @Override
    public void removeDevice(int deviceIndex) {
        devices.remove(deviceIndex);
    }

    public ArrayList<DeviceInterface> getDevices() {
        return devices;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Room " + name + ":\n");
        for (DeviceInterface device : devices) {
            result.append(device.toString()).append("\n");
        }
        return result.toString();
    }

    public void setName(String name) {
        this.name = name;
    }
}
