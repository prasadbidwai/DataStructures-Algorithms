/* 
Program for String operations 

String operations: 
1. find longest palindromic substring 
2. String compression, 
3. Check if a String is rotation of other, 
4. Check if String has unique chracters
5. Generate lexicographicallySmallest string by removing one character
6. Logic to compress the string with no occurence exceeding more than three
7. Print all the Permutations of a String
*/

import java.io.*;
import java.util.*;

class StringOpsApp {
  
  public static void main(String[] args) {
      int[] num = {1,2,4,5};
  
  System.out.println(lessthanthree("aaabbbaaabcccc"));
  System.out.println(lessthanthree("xxxyyyazzz"));
  
  lexicographicallySmallest("abfd");
  
  
  System.out.println(sayInt(30));
  System.out.println("Calling search insert :: "+searchInsert(num,3));
      
  String test = "aabbbbcddddaaaaa";
  stringCompres(test);

  String string1 = "waterbottle";
  String string2 = "erbottlewat";

  System.out.println(string1+" is rotation of word "+string2+":: "+ checkIfRotation(string2, string1));

  String chck = "parallel";
  System.out.println(chckUnique(chck));

//  String orig = "sracecars";
//  System.out.println(isPalindrome(orig));

  // call to function to find the longest palindromic substring
  System.out.println(longestPalindromeString("12321113111"));
  
  String to_permute = "abcd";
  System.out.println("\nPrinting all the permutations for: "+to_permute);
  permute("abcd", 0, to_permute.length()-1);
  
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
    
      int val = uniqueStr.charAt(i);  //get the ascii value of the characters
//      System.out.println(val);
      if(chckBoolean[val]){
        return false;
      }
    chckBoolean[val] = true;
    }
    return true;
    }

public static String sayInt(int n){
    StringBuffer sBuffer = new StringBuffer();
    while(n%10 != 0){
        System.out.println(n);
        sBuffer.append(1);
        sBuffer.append(n);
        n = n/10;
    }
    return sBuffer.toString();
}

    public static int searchInsert(int[] nums, int target) {
        int i = 0;
        int corret = 99999;

        while (i< nums.length){
 
            if (target == nums[i])
            {
                corret = i;
                break;
            }
            else if(nums[i] < target){
                i++;
            }
            else if (nums[i]>target){
                corret = i;
                break;
            }
        }
      return corret;

    }
    
    //If a string has 3 or more than 3 consecutive same characters, compress the string with only 2 occurences.
    //Convert aaabbbaaabcccc to aabbaabcc
    //Convert xxxyyyazzz to xxyyazz

    public static String lessthanthree(String input) {
    	System.out.println("Called lessthanthree method, compressing string with 3 or more occurences of same chars");
    	StringBuilder sb = new StringBuilder();
    	Character first = input.charAt(0);
    	Integer count = 1;
    	sb.append(first);
    	for (int i = 1 ; i < input.length() ;i++) {
    		if (input.charAt(i)==first) 
    		{
    			count++;
    			
	    		if (count<3) {
	    			sb.append(input.charAt(i));    			
	    		}else if (count>=3) {	    		
	    		}    			
    		}else
    		{
    			first = input.charAt(i);
    			count = 1;
    			sb.append(first);
    		}
    	}
    	return sb.toString();
    }
    
    //Function to return lexicographicallySmallest substring by removing a single alphabet
    
    public static String lexicographicallySmallest(String input) {
    	
    	StringBuilder sb = new StringBuilder();
    	
    	int largest = input.charAt(0);
    	for (int i = 0 ; i < input.length(); i++) {    		
    		int current = input.charAt(i);
    		if (largest < current) {
    			largest = current;
    		} 
    	}    	
    	
    	for(int j = 0 ; j< input.length();j++) {
    		int current = input.charAt(j);
    		if (current==largest){    			
    		}else {
    			sb.append(input.charAt(j));
    		}
    	}
    	
    	System.out.println("\nlexicallySmallest for input: "+input+" is: "+sb.toString());
    	return sb.toString();
    }

    // This Method Generates all the permutation of the give input string
    private static void permute(String str, int l, int r) 
    {     	    	
        if (l == r) 
            System.out.println("permutation String:: "+str); 
        else
        { 
            for (int i = l; i <= r; i++) 
            { 
            	str = swap(str,l,i);        	
                permute(str, l+1, r); 
                str = swap(str,l,i);             
            } 
        } 
    } 

    public static String swap(String a, int i, int j) 
    { 
        char temp; 
        char[] charArray = a.toCharArray(); 
        temp = charArray[i] ; 
        charArray[i] = charArray[j]; 
        charArray[j] = temp; 
        return String.valueOf(charArray); 
     }
}
  

