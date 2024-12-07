package com.khai.devices;
import com.khai.interfaces.DeviceInterface;
import java.util.*;

public class SocketClass implements DeviceInterface {
    private boolean isOn = false;
    private String name;

    public SocketClass(String name) {
        this.name = name;
    }

    @Override
    public void turnOn() {
        isOn = true;
        System.out.println("Socket " + name + " is turned on.");
    }

    @Override
    public void turnOff() {
        isOn = false;
        System.out.println("Socket " + name + " is turned off.");
    }

    @Override
    public void setParameters(Map<String, String> params) {
        System.out.println("No parameters to set for Socket.");
    }

    @Override
    public String toString() {
        return "Socket " + name + " is " + (isOn ? "on" : "off");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
