// Program with solution for:
// Minimum Average Sub-array, Count increasing SubArrays, sort array in wave form

    import java.io.*;
    import java.util.*;

    class ArrayQuestion {

      public static void main(String[] args) 
      {

        String orig = "sracecars";
        System.out.println("String "+ orig+" is a Palindrome: ");
        
        System.out.println(isPalindrome(orig));
        
        int[] arr =   {1, 4,3,6, 7};
        System.out.println("\nIncreasing number of SubArrays in array "+ Arrays.toString(arr)+ " is: " );
        
        countIncreasingSubArr(arr);
        
        int[] arr2 = {3, 7, 90, 20, 10, 50, 40};
        int k = 3;
        MinAvgSubArray(arr2, k);

        // Given an array A[] and a number x, check for pair in A[] with sum as x
        int A[] = {1, 4, 45, 6, 10, 8, 8};
        int n = 16;
        printpairs(A,  n);
        
        // Print the number with every digit on new line 
        int input = 12345;
        System.out.println("\nprinting the number: "+input+" with every digit on a new line::");
        prints(input);
        
        // Sort array in wave form:
        // Input:  arr[] = {3 6 5 10 7 20 25}
        // Output: arr[] = {6 3 10 5 20 7 25}
        int[] waveSortArr = {3, 6, 5, 10, 7, 20, 25};
        sortInWaveFormat(waveSortArr);
      }

      public static boolean isPalindrome(String orig){
          return orig.equals(new StringBuilder(orig).reverse().toString());
      }
      
      public static void countIncreasingSubArr(int[] arr){
        int cnt = 0;
        int len = 1; 
        // 1, 4, 3, 6, 7
        for (int p = 0 ; p < arr.length-1 ; p++){
          
          if (arr[p+1] > arr[p]){ 
            len++;
          }else{
            cnt += ((len*(len-1))/2);
            len = 1;
          }             
        }
        
        if(len > 1 )
          cnt += ((len*(len-1))/2);
        
        System.out.println(cnt);
        
      } 
      
      public static void countIncreasingSubArr2(int[] arr){
        int count = 0;  
        for(int i = 0 ; i < arr.length ; i++){      
             for(int j = i+1 ; j < arr.length ; j++){
               if (arr[j] > arr[j-1])
                 count++;
             }
            }
      System.out.println("total increasing subArraays:" + count);
      }
      
     public static void MinAvgSubArray(int[] arra, int len) {
       int minSum = 0;
       int li = 0;
       int currentSum = 0;
       
       for (int i = 0; i < len ; i++){
         currentSum += arra[i];
       }
       
       minSum = currentSum;

       for (int j = len; j < arra.length ; j++ ){
          currentSum += arra[j] - arra[j - len]     ;
         
         if(currentSum < minSum){
           minSum = currentSum; 
           li = (j-len+1);
         }
       }
     System.out.println("\nMin average for subArray with subArrayLength:" + len + " is betwwen: "+ arra[li] + " " + arra[(li+len-1)]);   
     }

// Given an array A[] and a number x, check for pair in A[] with sum as x
  static void printpairs(int arr[],int sum)
  {
    
    // Declares and initializes the whole array as false
    boolean[] binmap = new boolean[2000];

    for (int i=0; i<arr.length; ++i)
    {
        int temp = sum-arr[i];
   
        // checking for condition
        if (temp>=0 && binmap[temp])
        {
        System.out.println("\nPair with given sum " +sum + " is (" + arr[i] +", "+temp+")");
        }
              binmap[arr[i]] = true;
    }
  }
  
 // Print the number with every digit on new line 
 static void prints(int d) 
 {
     int rem = d % 10;

     if (d == 0) {
         return;
     } else {
         prints(d / 10);
     }
     System.out.println(rem);
 }

 
// Input:  arr[] = {3 6 5 10 7 20 25 }
// Output: arr[] = {6 3 10 5 20 7 25 }
 static void sortInWaveFormat(int[]ipArray) {
	 
	 System.out.println("\nprinting array before wave sorted format:");
	 for(int i:ipArray) {
		 System.out.print(i+" ");
	 }
	 
	 for(int i = 0; i < ipArray.length-1; i+=2) {
		 if(ipArray[i+1] < ipArray[i])
			 swap(ipArray, i+1, i);
		 if(ipArray[i] < ipArray[i+1])
			 swap(ipArray, i, i+1);
		 
	 }
	 System.out.println("\nprinting array in wave sorted format:");
	 for(int i:ipArray) {
		 System.out.print(i+" ");
	 }
 }
  
 static void swap(int[]waveSortArr, int i, int j) {
	 int temp  = waveSortArr[i];
	 waveSortArr[i] = waveSortArr[j];
	 waveSortArr[j] = temp;
 }
 
}
