//Programs for the Reverse LinkList and Hash Operations 
// HashMap operations: find pair of elements with same sum, find itinerary 

import java.io.*;
import java.util.*;


class HashProbs{
public void getItinerary(Map<String, String> test){

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
  
public void findPairs(int[] test){
 
  Map<Integer, Pair> fpmap = new HashMap<Integer, Pair>();
  for(int i = 0 ; i < test.length ; i ++){
    for(int j = i+1 ; j < test.length ; j++){
        int sum = test[i] + test[j];
      
      if(!fpmap.containsKey(sum)){
        fpmap.put(sum, new Pair(i, j));
      }
      
      else
      {
        Pair p = fpmap.get(sum); 
        System.out.println("the pairs with the same sum " + sum +" is: \n " +
              "("+test[i]+ ","+ test[j]+")"+ "(" + test[p.first] + "," +                                     test[p.second] + " )");
      }
    }
  }
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
    
        HashProbs hp = new HashProbs();
    int[] pariArray = {3, 4, 7, 1, 12, 9};
    
    hp.findPairs(pariArray);
    
    hp.getItinerary(dataSet);
    
    
    LinkList l1 = new LinkList();
    l1.insert(5);l1.insert(6);l1.insert(7);l1.insert(8);
    System.out.println((l1.search(50))+ "  \n  ");
    l1.printEntire();
    //l1.deleteFirst();
    System.out.println("  \n \n ");
//    l1.printEntire();
 //   l1.deleteKey(6);
    System.out.println("  \n \n ");
    l1.printEntire();
    l1.reverseList();
    System.out.println("  \n \n ");
    l1.printEntire();
  }
}