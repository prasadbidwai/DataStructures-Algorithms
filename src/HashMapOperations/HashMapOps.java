// HashMap operations: find pair of elements with same sum, find itinerary given list of cities.
// HashMap operations: To find the symmetric array elements, to find the largest sub array with zero sum.   

import java.io.*;
import java.util.*;

class HashProbs
{

public void getItinerary(Map<String, String> test)
{

    String start = null;
    Map<String, String> rm = new HashMap<String, String>();
    
    for(Map.Entry<String, String> it: test.entrySet()){
      rm.put(it.getValue(), it.getKey());
    } 
    
    for(Map.Entry<String, String> itt: test.entrySet()){
      if(!rm.containsKey(itt.getKey())){
        start = itt.getKey();
        break;
      }
    }
    
    String to = test.get(start);
    
    while(to!= null){
      System.out.println(start + " --> " + to);
      start = to; 
      to = test.get(start);
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

  public static int largestZeroSumSubArray(int[] array)
  {
    HashMap<Integer, Integer> newhm = new HashMap<Integer, Integer>();

    int sum = 0;
    int maxlen = 0;
    
    for(int i = 0 ; i < array.length ; i++)
    {
      sum += array[i];

      if(sum == 0)
      {
        maxlen = i++;
      }

      if(array[i] == 0 && maxlen == 0)
      {
        maxlen = 1;
      }

      Integer val = newhm.get(sum);
      int previous_i;

      if( val!= null)
      {
        previous_i = newhm.get(sum);
        maxlen = Math.max(maxlen,i-previous_i);
      }

      else
      {
        newhm.put(sum, i);
      }
    }

    return  maxlen;
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
    
    HashProbs hp = new HashProbs();   // class instanciation for calling its funcions from the main method. 

    int[] pariArray = {3, 4, 7, 1, 12, 9};
    
    hp.findPairs(pariArray);
    hp.getItinerary(dataSet);

    int arr[][]= {{11, 20}, {30, 40}, {5, 10}, {40, 30}, {10, 5}};
    hp.findSymmtricPairs(arr);

    int arr1[] = {15, -2, 2, -8, 1, 7, 10, -12, 2, 23};
    System.out.println("the length of the largest sub array with zero sum is: " + hp.largestZeroSumArray(arr1));    

  }
}
