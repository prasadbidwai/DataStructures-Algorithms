/* 
progrm for String operations 

String operations: 
1. find longest palindromic substring 
2. String compression, 
3. Check if a String is rotation of other, 
4. Check if String has unique chracters 
*/

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

  String chck = "parallel";
  String chck2 = "uniqe";

  System.out.println(chckUnique(chck));
  System.out.println(chckUnique(chck2)); 

  String orig = "sracecars";
  System.out.println(isPalindrome(orig));

  // call to function to find the longest palindromic substring 
  System.out.println(longestPalindromeString("1234"));
  System.out.println(longestPalindromeString("12321"));
  System.out.println(longestPalindromeString("9912321456"));
  System.out.println(longestPalindromeString("9912333321456"));
  System.out.println(longestPalindromeString("12145445499"));
  // end of call to function to find the longest palindromic substring

  }

//code for longest palindromic substring
public static String longestPalindromeString(String s)
{
  String longest = s.substring(0,1);
  

  for (int i = 0 ; i < s.length(); i++)
  {
    //to check the odd length palindromes (aba // abcba)
    String palindrome = IntermediatePalins(s,i,i);

    if(palindrome.length() > longest.length())
    {
        longest = palindrome;
    }

    //to check the even length palindromes (abba // bbccbb)
    palindrome = IntermediatePalins(s,i , i+1);

    if(palindrome.length() > longest.length())
    {
      longest = palindrome;
    }
  
  }

  return longest;
}

public static String IntermediatePalins(String s, int left, int right)
{
  if (left > right)
    return null;

  while(left >=0 && right < s.length() && s.charAt(left) == s.charAt(right))
  { 
      left--;
      right++;  
  }
  
  return s.substring(left+1, right);
}  
// End of logic for longest palindromic substring


public static boolean isPalindrome(String orig)
{
    return orig.equals(new StringBuilder(orig).reverse().toString());
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

public static boolean chckUnique(String uniqueStr)  {
      
    boolean[] chckBoolean = new boolean[128] ;
    
    for (int i = 0 ; i < uniqueStr.length() ; i++){
    
      int val = uniqueStr.charAt(i);
      System.out.println(val);
      if(chckBoolean[val]){
        return false;
      }
    chckBoolean[val] = true;
    }
    return true;
    }
  
}
