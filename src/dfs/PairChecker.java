import java.io.*;
import java.util.*;
import java.util.HashMap;

class Solution {
  public static void main(String[] args) {
    int[] arr = {92, 75, 65, 48, 45, 35, 47, 43, 51, 41};
    int k = 10;
    
    PairChecker pchkr = new PairChecker();
    System.out.println(pchkr.chechkPair(arr, k));
  }
}

class Pair{
  
  int first, second; 
  public Pair(int a, int b){
    first = a;
    second = b;
  }
}


class PairChecker{
  
  public Map<Pair, Integer> hm = new HashMap<Pair, Integer>();
  
  public Map<Integer, Integer> hmTest = new HashMap<Integer, Integer>();

  int pair, sum;
  
  public boolean chechkPair(int[] arr, int k){
  
  for(int i = 0; i < arr.length; i++){
    for(int j = i+1; j < arr.length; j++){
      
      sum = arr[i] + arr[j];
      
      if(sum % k == 0){
        hm.put(new Pair(i,j), sum);
      }
    }
  }
  
  for(Map.Entry<Pair, Integer> it: hm.entrySet())
    System.out.println(it.getKey().first + " " +it.getKey().second);
  
      
  for(Map.Entry<Pair, Integer> it1: hm.entrySet()){
    hmTest.put(it1.getKey().first, it1.getKey().second);
    hmTest.put(it1.getKey().second, it1.getKey().first);
  }
  
//    return true;
    return (arr.length == hmTest.size());
    
    //return true;
//    return (hm.size() >= (arr.length/2));
  }
}

