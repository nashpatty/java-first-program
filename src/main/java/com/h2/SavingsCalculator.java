package com.h2;

import java.time.LocalDate;
import java.time.YearMonth;

public class SavingsCalculator {

    private float[] credits;
    private float[] debits;

    public SavingsCalculator(float[] credits, float[] debits) {
        this.credits = credits;
        this.debits = debits;
    }

    public static void main(String[] args) {
        String[] creditsAsString = args[0].split(",");
        String[] debitsAsString = args[1].split(",");

        float[] credits = parseToFloat(creditsAsString);
        float[] debits = parseToFloat(debitsAsString);

        SavingsCalculator savingsCalculator = new SavingsCalculator(credits, debits);
        float netSavings = savingsCalculator.calculate();
        System.out.println(
            "Net Savings = " + netSavings + ", remaining days in month = " + remainingDaysInMonth(LocalDate.now()));
    }

    public float calculate() {
        return sumOfCredits() - sumOfDebits();
    }

    private float sumOfCredits() {
        return adder(this.credits);
    }

    private float sumOfDebits() {
        return adder(this.debits);
    }

    private static int remainingDaysInMonth(LocalDate date) {
        YearMonth yearMonth = YearMonth.of(date.getYear(), date.getMonth());
        int totalDaysInMonth = yearMonth.lengthOfMonth();

        return totalDaysInMonth - date.getDayOfMonth();
    }

    private float adder(float[] nums) {
        float sum = 0.0f;
        for (float num : nums) {
            sum += num;
        }
        return sum;
    }

    private static float[] parseToFloat(String[] items) {
        float[] parsedItems = new float[items.length];

        int i = 0;
        for (String item : items) {
            parsedItems[i] = Float.parseFloat(item);
            i++;
        }

        return parsedItems;
    }

}
