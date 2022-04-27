package main.java;


import java.util.ArrayList;
import java.util.List;

public class GeneratePrimes {
    private static List<Integer> listOfNumbers = new ArrayList<>();
    private int numbers;
    private int primeNumbers;

    public static void setListOfNumbers(int MaxValue) {
        int i = 2;
        while(i <= MaxValue){
            listOfNumbers.add(i);
            i++;
        }
    }

    public static List<Integer> getListOfNumbers(){

        return listOfNumbers;
    }

    public static boolean checkIfPrime(int number) {
        boolean isPrime = false;
        for (int i = 2; i <= number / 2; ++i) {

            if (number % i == 0) {
                isPrime = true;
                break;
            }
        }
        return isPrime;
    }





    public static int [] generatePrimes(int maxValue){
        int[] primeNumbers = new int[1000];
        int i = 0;
      setListOfNumbers(maxValue);
      listOfNumbers = getListOfNumbers();
      for(Integer elements : listOfNumbers){
          checkIfPrime(elements);
          //System.out.println("before Check:"+ elements);
          if(!checkIfPrime(elements)){
              primeNumbers[i] = elements;
              System.out.println("The Prime is: "+ primeNumbers[i]);
              i++;

          }
      }return primeNumbers;

    }



    public static void main(String[] args){
        GeneratePrimes generatePrimes = new GeneratePrimes();
        generatePrimes.generatePrimes(243);

    }


























}





