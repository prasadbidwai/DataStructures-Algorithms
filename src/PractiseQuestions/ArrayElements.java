//import java.util.*;
//
//// Find the pair of elements in array having same sum.
//
//class ArrayElements{
//
//	class Pair{
//
//	int first, second;
//
//	public Pair(int i, int j){
//
//		first = i;
//		second = j;
//
//	}
//
//};
//    boolean finddPair(int[] arr)
//    {
//        // Create an empty Hash to store mapping from sum to
//        // pair indexes
//        HashMap<Integer, Pair> map = new HashMap<>();
//        int n=arr.length;
//
//        // Traverse through all possible pairs of arr[]
//        for (int i=0; i<n; ++i)
//        {
//            for (int j=i+1; j<n; ++j)
//            {
//                // If sum of current pair is not in hash,
//                // then store it and continue to next pair
//                int sum = arr[i]+arr[j];
//                if (!map.containsKey(sum))
//                    map.put(sum,new Pair(i,j));
//
//                else // Else (Sum already present in hash)
//                {
//                    // Find previous pair
//                    Pair p = map.get(sum);
//
//                    // Since array elements are distinct, we don't
//                    // need to check if any element is common among pairs
//                    System.out.println("("+arr[p.first]+", "+arr[p.second]+
//                                      ") and ("+arr[i]+", "+arr[j]+")");
//                    return true;
//                }
//            }
//        }
//        return false;
//    }
//
//    }