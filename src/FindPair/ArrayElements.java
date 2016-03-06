import java.io.*;
import java.util.*;

class ArrayElements{

    boolean finddPair(int[] arr)
    {
        // Create an empty Hash to store mapping from sum to
        // pair indexes
        HashMap<Integer,Pair> map = new HashMap<Integer,Pair>();
        int n=arr.length;
        
        // Traverse through all possible pairs of arr[]
       for (int i = 0; i < n-1; i++)
       {
       	for (int j = i+1; j < n-1; j++)
       	{
       		int sum = arr[i] + arr[j];
       		if(!map.containsKey(sum))
       		{
       			map.put(sum, new Pair(arr[i],arr[j]));
       		}

       		else{
       			Pair found = map.get(sum);
   		  	System.out.println("the pair with sum similar to " + arr[i] + ", " + arr[j] + " is: "+ found.first + ", " + found.second);
			return true;
       		}
       	}
       }
       		return false;
    }
}
