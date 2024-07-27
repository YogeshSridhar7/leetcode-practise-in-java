package Leetcode;

public class Temperature {
    public static void main(String[] args) {
        Temperature temperature = new Temperature();
        System.out.println(temperature.convertTemperature(36.50));
    }

    public double[] convertTemperature(double celsius){
//        double result[] = new double[2];
//        result[0] = celcius + 273.15;
//        result[1] = (celcius * 1.80) + 32.00;
        return new double[] {celsius+273.15,(celsius*1.8)+32};
    }
}
