package DataAnalysis;
// process an array of opening stock prices containing 10 days 

import java.util.ArrayList;
import java.util.Arrays;

public class DataAnalysis{
    public static void main(String[] args){
        //an array of integers representing the daily stock prices of a company for a given period
        float[] stockPrice = 
        {240.38f, 239.76f, 238.87f, 237.88f, 239.76f, 241.41f, 240.56f, 241.26f, 241.77f, 242.50f};

        ArrayList<Float> stockPriceList = new ArrayList<>(Arrays.asList(240.38f, 239.70f, 238.87f, 237.88f, 239.76f, 241.41f, 240.56f, 241.26f, 241.77f, 242.50f));        
    
        // printing average of stockprice
        float averagePrice = calculateAveragePrice(stockPrice);
        System.out.println("\nAverage price for Stock within a 10 days period: " + averagePrice);
    
        // printing max stockprice
        float maxPrice = findMaximumPrice(stockPrice);
        System.out.println("\nThe maximum stock price: " + maxPrice);

        // printing number of occurrences
        byte occurrences = countOccurrences(stockPrice, 239.76f);
        System.out.println("\nThere are " + occurrences + " occurences of 239.76");

        // printing arrray cumulative sum
        ArrayList<Float> cumSum = computeCumulativeSum(stockPriceList);
        System.out.println("\nCumulative sum: " + cumSum);
    }

    /* takes array of stock prices as input and returns the
     average price of the stocks
     */
    public static float calculateAveragePrice(float[] stockPrice){
        float sum = 0;
        for(byte i  = 0; i < stockPrice.length; i++){
            sum += stockPrice[i];
        }
        return (sum/stockPrice.length);
    }

    /*
      takes the array of stock prices as input and 
      returns the maximum price among all the stocks.
    */
    public static float findMaximumPrice(float[] stockPrice){
        float maxPrice = 0;
        for(byte i  = 0; i < stockPrice.length; i++){
            if(stockPrice[i] > maxPrice){
                maxPrice = stockPrice[i];
            }
        }
        return maxPrice;
    }

    /*takes the array of stock prices and a target price
     as input and returns the number of times the target price occurs in the 
    */
    public static byte countOccurrences(float[] stockPrice, float targetPrice){
        byte occur = 0;
        for(byte i  = 0; i < stockPrice.length; i++){
            if(stockPrice[i] == targetPrice){
                occur++;
            }
        }
        return occur;
    }

    /* takes the ArrayList of stock prices as input and returns a new 
    ArrayList containing the cumulative sum of prices at each position.
    */
    public static ArrayList<Float> computeCumulativeSum(ArrayList<Float> stockPrice){
        ArrayList<Float> cumulativeSum = new ArrayList<>();
        float cum_sum = 0;

        for (float price : stockPrice) {
            cum_sum += price;

            cumulativeSum.add(cum_sum);
        }
        return cumulativeSum;
    }
}
