package ru.stileyn.task_1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String fileContent = scanner.nextLine();
        String resultContent = replacePasswords(fileContent);
        System.out.println(resultContent);
    }

    public static String replacePasswords(String fileContent) {
        String pattern = "code\\d+";
        String result = fileContent.replaceAll(pattern, "???");

        return result;
    }
}