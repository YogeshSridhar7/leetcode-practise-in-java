package Leetcode;

public class WatermelonProblem {
    public static void main(String[] args) {
        WatermelonWeightCalculation watermelonWeight = new WatermelonWeightCalculation();
        System.out.println(watermelonWeight.calculateWeight());

    }
}

class WatermelonWeightCalculation{

    private static double initialHumidity = 99.0;
    private static double finalHumidity = 98.0;

    public double calculateWeight(){
        double initialWeight = 10.0;
        double solidWeight = initialWeight * (1 - initialHumidity/100);
        double newWeight = solidWeight / (1 - finalHumidity/100);
        System.out.println(newWeight);
        return newWeight;
    }
}