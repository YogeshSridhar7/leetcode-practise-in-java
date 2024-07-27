package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class CampingDemo {
    // 0=S, 1=J, 2=B, 3=A
    public static void main(String[] args) {
        List<Integer> id = List.of(0,1,2,3);
        System.out.println(id +""+ id.size());
        CampingExpenseCalculation campingExpenseCalculation = new CampingExpenseCalculation(id);
        campingExpenseCalculation.calculateExpense(0,400,List.of(0,1,2,3));
        campingExpenseCalculation.calculateExpense(1,100,List.of(2,3));
        campingExpenseCalculation.calculateExpense(2,200,List.of(0,1,2,3));
        System.out.println(campingExpenseCalculation.getTransactionCount());
    }
}
class CampingExpenseCalculation{
    List<Double> balance = new ArrayList<>();
    int transactionCount =0;
    CampingExpenseCalculation(List<Integer> id){
//        balance.set(id,balance);
        for (int i=0; i<id.size(); i++) {
            balance.add(0.0);
        }
        System.out.println(id +""+ id.size());
        System.out.println(balance +""+  balance.size());
    }

    public int getTransactionCount() {
        return transactionCount;
    }

    public void calculateExpense(int id, double amountSpent, List<Integer> spentOnWhom){
        transactionCount++;
        double eachPersonExpense = amountSpent/spentOnWhom.size();
        for (var personId:spentOnWhom) {
            var currentBalance = balance.get(personId);
            balance.set(personId, eachPersonExpense+currentBalance);
        }
        var currentBalance = balance.get(id)-amountSpent;
        balance.set(id, currentBalance);
        System.out.println(balance);
    }
}
