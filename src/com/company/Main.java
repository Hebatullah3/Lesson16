package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // write your code here

        BankApplication application = new BankApplication();


        System.out.println("Enter what statistics you want to see: \n");
        System.out.println("1 - My biggest payment\n" +
                "2 - My total income\n" +
                "3 - How do I spend my money\n" +
                "4 - Statistics for 1 year\n" +
                "5 - The Biggest income \n"+
                "6 - the Total spending\n"+
                "0 - exit\n");

        Scanner scanner = new Scanner(System.in);
        int input = Integer.parseInt(scanner.nextLine());
            System.out.println(application.userStatistics(input));
        }


}
