package me.hakki.nat_project.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DotEnv {
    public static boolean load() {
        File file = new File(".env");
        if (!file.exists()) {
            System.out.println(".env file not exists!");
            return false;
        }
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int counter = 0;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            int seperatorIndex = line.indexOf("=");
            System.getProperties().setProperty(line.substring(0, seperatorIndex), line.substring(seperatorIndex + 1));
            counter++;
        }
        System.out.println("Loaded " + counter + " environment from .env");
        return counter > 0;
    }
}
