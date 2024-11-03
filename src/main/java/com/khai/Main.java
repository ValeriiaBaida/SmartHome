package com.khai;

import com.khai.menu.MainMenuClass;
public class Main {

    public static void main(String[] args) {
        MainMenuClass menu = new MainMenuClass();
        while(menu.choiceMenu(menu.printMenu())) {}
    }
}
