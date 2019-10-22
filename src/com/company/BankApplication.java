package com.company;

import java.lang.reflect.Array;
import java.security.PublicKey;
import java.util.*;

public class BankApplication {
    public Map<Integer, Payment> payments = new HashMap<>();

    public BankApplication() {

        Payment food2 = new Payment(16, 50.0, "Grocaries", 2, 2019);

        Payment drugs2 = new Payment(18, 90.0, "Pharmacy", 4, 2019);

        Payment inCafe3 = new Payment(11, 10.0, "Cafe", 8, 2019);

        Payment inCafe2 = new Payment(2, 11.2, "Cafe", 9, 2019);
        Payment cosmotics = new Payment(6, -2.0, "Douglas", 9, 2019);
        Payment drugs = new Payment(7, -25.0, "Pharmacy", 9, 2019);
        Payment rentSeptamber = new Payment(8, 302.0, "House", 9, 2019);
        Payment salarySeptamper = new Payment(10, 2200, "Salary", 9, 2019);


        Payment inCafe = new Payment(1, 10.0, "Cafe", 10, 2019);
        Payment rentOctober = new Payment(3, 302.0, "House", 10, 2019);
        Payment foodRewe = new Payment(5, 12.0, "Groceries", 10, 2019);
        Payment salaryOcttober = new Payment(9, 1200, "Salary", 10, 2019);
        Payment rentNovamber = new Payment(4, 302.0, "House", 11, 2019);

        Payment rentAugust = new Payment(14, 302.0, "House", 5, 2017);
        Payment food = new Payment(15, -30.0, "Grocaries", 5, 2017);
        Payment cosmotics2 = new Payment(20, 120.0, "Rossman", 10, 2017);
        Payment rentOctober3 = new Payment(13, 302.0, "House", 10, 2017);


        Payment cafe = new Payment(17, -80.0, "Cafe", 3, 2018);
        Payment salaryAugust = new Payment(19, 4202.0, "Salary", 8, 2018);

        Payment rentOctober2 = new Payment(12, 302.0, "House", 10, 2018);


        payments.put(salaryAugust.getId(), salaryAugust);
        payments.put(cosmotics2.getId(), cosmotics2);
        payments.put(inCafe3.getId(), inCafe3);
        payments.put(rentOctober2.getId(), rentOctober2);
        payments.put(rentOctober3.getId(), rentOctober3);
        payments.put(rentAugust.getId(), rentAugust);
        payments.put(food.getId(), food);
        payments.put(food2.getId(), food2);
        payments.put(cafe.getId(), cafe);
        payments.put(drugs.getId(), drugs);
        payments.put(inCafe.getId(), inCafe);
        payments.put(inCafe2.getId(), inCafe2);
        payments.put(rentOctober.getId(), rentOctober);
        payments.put(rentNovamber.getId(), rentNovamber);
        payments.put(foodRewe.getId(), foodRewe);
        payments.put(cosmotics.getId(), cosmotics);
        payments.put(drugs2.getId(), drugs2);
        payments.put(rentSeptamber.getId(), rentSeptamber);
        payments.put(salaryOcttober.getId(), salaryOcttober);
        payments.put(salarySeptamper.getId(), salarySeptamper);

    }

    //BiggestExpenses
    public String calculateMostExpenses() {

        Payment theBiggestPayment = null;
        for (Map.Entry<Integer, Payment> entry : payments.entrySet()) {
            if (entry.getValue().getAmount() >= 0) {
                continue;
            }
            if (theBiggestPayment == null) {
                theBiggestPayment = entry.getValue();
            }
            if (theBiggestPayment.getAmount() > entry.getValue().getAmount()) {
                theBiggestPayment = entry.getValue();
            }

        }
        return theBiggestPayment.displayAmount();
    }

    //Total income
    public Double totalIncome() {

        Double income = 0.0;

        for (Map.Entry<Integer, Payment> entry : payments.entrySet()) {
            if (entry.getValue().getAmount() > 0) {
                income += entry.getValue().getAmount();
            }

        }
        return income;
    }


    //get sum of each category
    public Map<String, Double> categorySummation() {
        Map<String, Double> inCategories = new HashMap<>();
        for (Map.Entry<Integer, Payment> entry : payments.entrySet()) {
            Payment payment = entry.getValue();
            String category = payment.getCategory();

            double categorySum = inCategories.getOrDefault(category, 0.0);
            categorySum += payment.getAmount();
            inCategories.put(category, categorySum);
        }

        return inCategories;
    }

    //User chosen statistics
    public String userStatistics(int choosenNumber) {
        String chosenNumber = "";
        switch (choosenNumber) {
            case 1:
                chosenNumber = "the biggest Expenses is: " + calculateMostExpenses();
                break;
            case 2:
                chosenNumber = "The total income is : " + totalIncome();
                break;
            case 3:
                chosenNumber = "How  do I spend your money:  " + categorySummation();
                break;

            case 4:
                System.out.println("Enter a year:  \n");
                Scanner scanner = new Scanner(System.in);
                int input = Integer.parseInt(scanner.nextLine());
                userSpendingAndEarning(input);

                break;
            case 5:
                chosenNumber = " The biggest income is:   " + biggestIncome();
                break;
            case 6:
                chosenNumber = " The Total spending is:   " + totalSpending();
                break;


            case 0:
                break;
            default:
                chosenNumber = "Invalid number";
                break;

        }
        return chosenNumber;
    }

    // user biggest income:

    public String biggestIncome() {

        Double biggestIncome = 0.0;
        Payment theBiggestIncome = null;

        for (Map.Entry<Integer, Payment> entry : payments.entrySet()) {

            if (entry.getValue().getAmount() > biggestIncome) {

                biggestIncome = entry.getValue().getAmount();
                theBiggestIncome = entry.getValue();
            }


        }
        return theBiggestIncome.displayAmount();
    }

    //user spending and income in 2019

    public void userSpendingAndEarning(int year) {
        Map<Integer, Double> monthlyExpenses = new HashMap<>();
        Map<Integer, Double> monthlyIncome = new HashMap<>();
        int month;
        for (Map.Entry<Integer, Payment> entry : payments.entrySet()) {
            if (entry.getValue().getYear() == year) {
                Payment payment = entry.getValue();
                if (payment.getCategory().equalsIgnoreCase("salary") || payment.getCategory().equalsIgnoreCase("income")) {
                    month = payment.getMonth();
                    double income = monthlyIncome.getOrDefault(month, 0.0);
                    income += payment.getAmount();
                    monthlyIncome.put(month, income);

                } else {
                    month = payment.getMonth();
                    double expenses = monthlyExpenses.getOrDefault(month, 0.0);
                    expenses += payment.getAmount();
                    monthlyExpenses.put(month, expenses);


                }

            }
        }
        monthlyExpenses = fillingMonths(monthlyExpenses);
        monthlyIncome = fillingMonths(monthlyIncome);
        for (Map.Entry<Integer, Double> entry1 : monthlyExpenses.entrySet()) {
            for (Map.Entry<Integer, Double> entry2 : monthlyIncome.entrySet()) {

                if (entry2.getKey() == entry1.getKey()) {

                    System.out.println("in month " + entry2.getKey() + " you Earned: " + entry2.getValue() + " $" + " and  you spent: " + entry1.getValue() + " $");
                }


            }

        }
    }


//user total spending

    public Double totalSpending() {

        Double spending = 0.0;

        for (Map.Entry<Integer, Payment> entry : payments.entrySet()) {
            if (entry.getValue().getAmount() < 0) {
                spending += entry.getValue().getAmount();
            }

        }
        return spending;
    }


    public Map<Integer, Double> fillingMonths(Map<Integer, Double> passingMap) {


        Set<Integer> months = new HashSet<>();
        for (Map.Entry<Integer, Double> entry : passingMap.entrySet()) {
            months.add(entry.getKey());
        }
        for (int month = 1; month <= 12; month++) {
            if (months.size() != 0) {
                for (int m : months) {
                    if (!months.contains(month)) {
                        passingMap.put(month, 0.0);
                    }
                }

            } else {
                passingMap.put(month, 0.0);

            }
        }
        return passingMap;
    }
}


