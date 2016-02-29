// progrms for String operations 
// String operations: String compresion & check if rotation

import java.io.*;
import java.util.*;

class Solution {
  
  public static void main(String[] args) {
  String test = "aabbbbcddddaaaaa";     
  stringCompres(test);
  
  String string1 = "waterbottle";
  String string2 = "erbottlewat";
    
  System.out.println("erbottlewate is rotation of word waterbottle: "+ 
                    checkIfRotation(string2, string1));
    
  assert((checkIfRotation(string2, string1))) == true;
    
  }
  
public static void stringCompres(String input){
    int cnt = 1; 
    char first = input.charAt(0);
    StringBuilder sb = new StringBuilder();
    
    for(int i = 1 ; i < input.length() ; i++){
      if(input.charAt(i) == first){
        cnt++;
      }
      
      else{
       sb.append(first);
       sb.append(cnt); 
       first = input.charAt(i);
       cnt = 1;          
      }         
    }
 
 sb.append(first);
 sb.append(cnt);
  
 System.out.println("compressed String:  " + sb);   
}
  
public static boolean checkIfRotation(String s1, String s2)  {
  
   s1 = s1+s1;
  
  return(s1.contains(s2));
}
  
}
