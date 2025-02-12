package main.java;


public class PrimeGenerator {
    private static boolean[] crossedOut;
    private static int[] result;


public static int [] generatePrimes(int maxValue) {
        if (maxValue < 2)
            return new int[0];
        else{
            uncrossIntegersUpTo(maxValue);
            crossOutMultiples();
            putUncrossedIntegersIntoResult();
            return result;
        }
}
    private static void uncrossIntegersUpTo(int maxValue){
        crossedOut = new boolean[maxValue+1];
        for (int i = 2; i < crossedOut.length; i++) {
            crossedOut[i] = false;
        }
    }
    private static void crossOutMultiples(){
        int maxPrimeFactor = calcMaxPrimeFactor();
        for (int i = 2; i <= maxPrimeFactor; i++) {
            if (notCrossed(i)) {
               crossOutMultiplesOf(i);
            }
        }

    }

private static int calcMaxPrimeFactor(){
// We cross out all multiples of p, where p is prime.
// Thus, all crossed out multiples have p and q for
// factors. If p > sqrt of the size of the array, then
// q will never be greater than 1. Thus p is the
// largest prime factor in the array, and is also
// the iteration limit.

    double maxPrimeFactor = Math.sqrt(crossedOut.length);
    return (int) maxPrimeFactor;
}


private static void crossOutMultiplesOf(int i){
    for(int multiple = 2*i; multiple < crossedOut.length; multiple +=i){
        crossedOut[multiple] = true;
    }
}

private static boolean notCrossed(int i){

    return crossedOut[i] == false;
}

private static void putUncrossedIntegersIntoResult(){
    result = new int[numberOfUncrossedIntegers()];
    for(int j = 0, i = 2; i < crossedOut.length; i++){
        if(notCrossed(i)){
            result[j++] = i;
        }
    }
}


private static int numberOfUncrossedIntegers(){
    int count = 0;
    for (int i = 2; i < crossedOut.length; i++){
        if(notCrossed(i)){
            count++;
        }
    }return count;

}































}





