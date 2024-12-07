package com.khai.devices;

import com.khai.interfaces.DeviceInterface;
import java.util.*;

public class CleanerClass implements DeviceInterface {
    private boolean isOn = false;

    private int speed = 3;

   
    private String name;

    public CleanerClass(String name) {
        this.name = name;
    }

    @Override
    public void turnOn() {
        isOn = true;
        System.out.println("Robotic vacuum cleaner " + name + " is turned on.");
    }

    @Override
    public void turnOff() {
        isOn = false;
        System.out.println("Robotic vacuum cleaner " + name + " is turned off.");
    }

    @Override
    public void setParameters(Map<String, String> params) {
        if (params.containsKey("speed")) {
            speed = Integer.parseInt(params.get("speed"));
            System.out.println("Robotic vacuum cleaner " + name + " cleaning speed set to " + speed);

        } else {
            System.out.println("No valid parameter found for Robotic Vacuum Cleaner.");
        }
    }

    @Override
    public String toString() {
        return "Robotic vacuum cleaner " + name + " is " + (isOn ? "on" : "off") + ", cleaning speed: " + speed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}