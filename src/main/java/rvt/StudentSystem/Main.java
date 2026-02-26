package rvt.StudentSystem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Register register = new Register();
        FileHandler fileHandler = new FileHandler();
        UserInterface ui = new UserInterface(register, scanner, fileHandler);
        ui.start();
    }
}
