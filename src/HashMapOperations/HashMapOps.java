// HashMap operations: find pair of elements with same sum, find itinerary given list of cities.
// HashMap operations: To find the symmetric array elements, to find the largest sub array with zero sum.   

import java.io.*;
import java.util.*;

class HashProbs
{

public void getItinerary(Map<String, String> ipMap)
{
  String start = null;
  Map<String, String> rm = new HashMap<String, String>();

  for(Map.Entry<String, String> it: ipMap.entrySet()){
    rm.put(it.getValue(), it.getKey());
  }

  for(Map.Entry<String, String> it: ipMap.entrySet())
  { 
    String current = it.getKey();
    if(!rm.containsKey(current))
    {
      start = current;
      break;
    }
  }

  String to = ipMap.get(start);

  while(to != null)
  {
    System.out.println(start +" to --> "+ to);
    start = to;
    to = ipMap.get(start);
  }

}

  public static void findSymmtricPairs(int[][] test)
  {

    HashMap<Integer, Integer> theMap= new HashMap<Integer, Integer>();

    for (int i = 0 ; i < test.length ;i++ ) 
    {
      Integer first, sec;

      first = test[i][0];
      sec = test[i][1];

      Integer val = theMap.get(sec);  
          
      if(val == first)
      {
        System.out.println("the pairs are: " + first + "  " + sec); 
      }

      else
      {
        theMap.put(first, sec);
      } 
    }

  }

public static int largestZeroSumSubArray(int[] arr)
{
  // Creates an empty hashMap hM
  HashMap<Integer, Integer> hM = new HashMap<Integer, Integer>();
 
  int sum = 0;      // Initialize sum of elements
  int max_len = 0;  // Initialize result
 
  // Traverse through the given array
  for (int i = 0; i < arr.length; i++)
  {
    // Add current element to sum
    sum += arr[i];
 
    if (arr[i] == 0 && max_len == 0)
      max_len = 1;
 
    if (sum == 0)
      max_len = i+1;
 
    // Look this sum in hash table
      Integer prev_i = hM.get(sum);
 
    // If this sum is seen before, then update max_len
    // if required
    if (prev_i != null)
      max_len = Math.max(max_len, i-prev_i);
    else  // Else put this sum in hash table
      hM.put(sum, i);
  }
 
    return max_len;
}

public void findPairs(int[] test){
 
  Map<Integer, Pair> fpmap = new HashMap<Integer, Pair>();
  
  for(int i = 0 ; i < test.length ; i ++)
  {
    for(int j = i+1 ; j < test.length ; j++)
    {
        int sum = test[i] + test[j];
      
        if(!fpmap.containsKey(sum))
        {
          fpmap.put(sum, new Pair(i, j));
        }
      
        else
        {
          Pair p = fpmap.get(sum); 
          System.out.println("the pairs with the same sum " + sum +" is: \n " +
                "("+test[i]+ ","+ test[j]+")"+ "(" + test[p.first] + "," + test[p.second] + " )");
        }
    }
  }

}

 public int solution(int X) {
        // write your code in Java
        
        TreeSet<Character> ts  = new TreeSet<Character>(); 
        char[] charArray = String.valueOf(X).toCharArray();  
        for(int i = 0 ; i < charArray.length-1 ; i ++)
        {
            if(charArray[i] == charArray[i+1])
            {
                if(!ts.contains(charArray[i]))
                {
                    ts.add(charArray[i]);    
                }
            }
        }
        
        StringBuilder strngbldr = new StringBuilder();   
     
    int firstMin = ts.first();
    int j;
    
    for( j = 0 ; j < charArray.length-1 ; j++){
        
        if(firstMin == (int)charArray[j] && firstMin == (int)charArray[j+1])
        {
            break;
        }
        else 
        {
            strngbldr.append(String.valueOf(charArray[j]));
        }
    }
    
    while(j < charArray.length-1)
    {
        strngbldr.append(String.valueOf(charArray[j+1]));
        j++;
    }
    System.out.println(Integer.parseInt(new String(strngbldr)));
    return Integer.parseInt(new String(strngbldr));
    }
     
}

class Pair{
  int first, second;
  
  Pair(int a, int b){
    first = a;
    second = b; 
  }
}


class HashMapOps{
  
  public static void main(String[]args){
  
    Map<String, String> dataSet = new HashMap<String, String>();
    
        dataSet.put("Chennai", "Banglore");
        dataSet.put("Bombay", "Delhi");
        dataSet.put("Goa", "Chennai");
        dataSet.put("Delhi", "Goa");
    
    System.out.println("\nthe travel itinerary problem answer:: ");
    
    HashProbs hp = new HashProbs();   // class instanciation for calling its funcions from the main method.

    hp.getItinerary(dataSet);
     
    System.out.println("\nthe solution to finding pairs with the same sum :: ");
    int[] pariArray = {3, 4, 7, 1, 12, 9};
    
    hp.findPairs(pariArray);
    
    System.out.println("\nthe solution to finding symmetric pairs :: ");  
    int arr[][]= {{11, 20}, {30, 40}, {5, 10}, {40, 30}, {10, 5}};
    hp.findSymmtricPairs(arr);

    System.out.println("\nthe solution to the largest sub array with zero sum ::");  
    int arr1[] = {15, -2, 2, -8, 1, 7, 10, -12, 2, 23};
    System.out.println("the length of the largest sub array with zero sum is: " + hp.largestZeroSumSubArray(arr1));    

  }
} 
