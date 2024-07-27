package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class CampingTripExpense {
    List<Double> balance = new ArrayList<>();
    public static void main(String[] args) {
        CampingTripExpense campingTripExpense = new CampingTripExpense();
        campingTripExpense.calculateExpense(0,400,List.of(0,1,2,3));
//        double samExpenses = 400;
//        double johnExpenses = 100;
//
//        // Number of people sharing Sam's expenses
//        int totalPeople = 4;
//
//        // Number of people sharing John's expenses
//        int alexBobCount = 2;
//
//        // Each person's share of Sam's expenses
//        double shareSamExpenses = samExpenses / totalPeople;
//
//        // Alex's and Bob's share of John's expenses
//        double shareJohnExpenses = johnExpenses / alexBobCount;
//
//        double alexBalance = -shareSamExpenses - shareJohnExpenses;
//        double samBalance = -shareSamExpenses;
//        double johnBalance = -shareSamExpenses - johnExpenses;
//        double bobBalance = -shareSamExpenses - shareJohnExpenses;
//
//        // Sam spent since it is to be reimbursed
//        samBalance += samExpenses;
//        // John spent for Alex and Bob to be reimbursed
//        johnBalance = johnBalance + johnExpenses;
//
//
//        // Displaying net balances
//        System.out.println("Net balance for Alex: $" + alexBalance);
//        System.out.println("Net balance for Sam: $" + samBalance);
//        System.out.println("Net balance for John: $" + johnBalance);
//        System.out.println("Net balance for Bob: $" + bobBalance);
    }
    public void calculateExpense(int id, double amountSpent, List<Integer> spentOnWhom){
        double eachPersonExpense = amountSpent/spentOnWhom.size();
        for (var personId:spentOnWhom) {
            balance.set(personId, eachPersonExpense);
        }
        var currentBalance = balance.get(id)-amountSpent;
        balance.set(id, currentBalance);
        System.out.println(balance);
    }
}
