package hu.robot.model.service;

import java.util.Scanner;

public class Console {

    private final Scanner scanner;

    public Console(Scanner scanner) {
        this.scanner = scanner;
    }

    public int getInt() {
        return scanner.nextInt();
    }

    public String readProgram() {
        return scanner.next();
    }
}
