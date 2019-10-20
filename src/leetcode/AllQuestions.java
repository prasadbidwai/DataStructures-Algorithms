package leetcode;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class AllQuestions {

	public static void main(String[] args) {
		
		int[] moleArray = {0, 1, 1, 0, 1, 1, 0, 1, 0, 0, 0};
		int w = 5;
		System.out.println(maxMoleKilled(moleArray, w));
		
		
		//451. Sort Characters By Frequency
		String maxCTogether = "cccaaa";
		System.out.println(maxCharTogether(maxCTogether)); 
		
		//347. Top K Frequent Elements		
		int[] topkAray = {1,1,1,2,2,3}; int k = 2;
		System.out.println(topKFrequent(topkAray, k));
		
		//692. Top K Frequent Words
		String[] aray = {"i", "love", "leetcode", "i", "love", "coding"}; 
		int kfwrds = 2;
		System.out.println(topKFrequentWords(aray, kfwrds));
//		assertEquals(expected, actual);
		
		/*	1002. Find common characters		  
			Example 1: Input: ["bella","label","roller"]	Output: ["e","l","l"]
			Example 2: Input: ["cool","lock","cook"]	Output: ["c","o"]
		 * */
		
		String[] inCmnCha = {"bella","label","roller"};
		commomnCharacters(inCmnCha);
		
		//Number of Islands
//		int[][] islandInput = {1,1,1,1,0
//				1,1,0,1,0
//				1,1,0,0,0
//				0,0,0,0,0}
		
	/*56. Merge Intervals
	 * Example 1:
		Input: [[1,3],[2,6],[8,10],[15,18]]	Output: [[1,6],[8,10],[15,18]]
		Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].

	  Example 2:	
		Input: [[1,4],[4,5]]	Output: [[1,5]]
		Explanation: Intervals [1,4] and [4,5] are considered overlapping.*/
		
		int[][] mergeIntervalsArray = {{1,3},
									   {2,6},
									   {8,10},
									   {15,18}};  
		
		int[][] mergeIntervalsResult = mergeIntervals(mergeIntervalsArray);
		
		System.out.println(String.valueOf(mergeIntervalsResult));
		
		/*	1086. High Five
		 * 	Generate the average sum of top 5 for each of the students below
		 * 	Ans for following input: [[1,87],[2,88]]
		 * */
		int[][] inputForHighFive = {{1,91},{1,92},{2,93},{2,97},{1,60},{2,77},{1,65},{1,87},{1,100},{2,100},{2,76}};
		System.out.println(highFive(inputForHighFive));

	}
	
	static int maxMoleKilled(int[] moleArray, int w) {
		int ans = 0;
		int max = 0;
		for(int i = 0 ; i < w ;i++) {
			if(moleArray[i]==1)
				ans++;
				max = ans;
		}
		
		for(int i = 1; i<moleArray.length-w; i++) {			
			
			if (moleArray[i+w-1] == 1 && moleArray[i-1]==0) {
				ans++;
			}else if (moleArray[i+w-1] == 0 && moleArray[i-1]==1) {
				ans--;
			}else if (moleArray[i+w-1] == 1 && moleArray[i-1]==1) {	
			}
				
			max = Math.max(ans, max);
		}
		
		return max;
	}
	
	static String maxCharTogether(String input) {
		
		int[] countAray = new int[128];
		CharAndCount[] frequqncyAray = new CharAndCount[128];
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < 128;i++) {
			frequqncyAray[i] = new CharAndCount();
		}
						
		for(int i = 0 ; i < input.length();i++) {
			char current = input.charAt(i);
			frequqncyAray[current].c = current;
			frequqncyAray[current].count++;
		}
			
		Arrays.sort(frequqncyAray);
		
		for(CharAndCount cc:frequqncyAray) {
			while(cc.count-- >0)
				sb.append(cc.c);
		}
		
		return sb.toString();
	}
	
	static class CharAndCount implements Comparable<CharAndCount>{
		char c;
		int count;
		public CharAndCount() {
			this.count = 0;
		}
		@Override
		public int compareTo(CharAndCount o) {
			// TODO Auto-generated method stub
			return (int)(this.count-o.count);
		}
		
	}
	
    public static List<Integer> topKFrequent(int[] nums, int k) {
		List<Integer> ans = new ArrayList<Integer>();
		NumberAndCount[] theAray = new NumberAndCount[nums.length];
		
		for(int i = 0 ;i < nums.length; i++) {
			theAray[i] = new NumberAndCount();
		}
		
		Arrays.sort(nums);

		int first = nums[0];		
		int lasti = 0;
		theAray[lasti].number = first;
		theAray[lasti].count = 1;
		
		for(int i = 1 ;i < nums.length; i++) {
			
			if(first == nums[i]) {
				theAray[lasti].count++;
			}else{
				lasti = i;	
				first = nums[i];
				theAray[lasti].number = first;
				theAray[lasti].count++;
			}
		}
				
		Arrays.sort(theAray);
		
		for(int i = 0; i<k ;i++) {
			ans.add(theAray[i].number);
		}
		
		return ans;
	}
    
    static class NumberAndCount implements Comparable<NumberAndCount>{
    	int number;
    	int count;
    	
    	public NumberAndCount() {
    		this.count = 0;
    	}

		@Override
		public int compareTo(NumberAndCount o) {
			return (int)(o.count-this.count);			
		}
    }
	
	public static List<String> topKFrequentWords(String[] words, int k) 
	{
	    
	    List<String> ans = new ArrayList<String>();
	    WordsAndFrequency[] wfAray = new WordsAndFrequency[words.length]; 
	    	
	    for(int i = 0 ; i < words.length ; i++) {
	    	wfAray[i] = new WordsAndFrequency();
	
	    }
	
	    Arrays.sort(words);
	    
	    String first = words[0];
	    int lasti = 0;
	    wfAray[lasti].word = first;
	    wfAray[lasti].frequency = 1;
	    
	    for(int i = 1; i < words.length; i++) {
	    	if (words[i].equals(first)) {
	    		wfAray[lasti].frequency++;
	    	}else {
	    		lasti = i;
	    		first = words[i];
	    		wfAray[lasti].word = first;
	    	    wfAray[lasti].frequency++;
	    	}
	    }
	    
	    Arrays.sort(wfAray);
	    
	    for(int i = 0 ;i< k;i++)
	    	ans.add(wfAray[i].word);
	    	
	    return ans;
	}
	
	static class WordsAndFrequency implements Comparable<WordsAndFrequency> {
		String word;
		int frequency;
		public WordsAndFrequency() {
			this.frequency = 0;
		}
		public int compareTo(WordsAndFrequency o) {
			return o.frequency - this.frequency;
		}
		
	}
	
	static List<Character> commomnCharacters(String[] input) {
		
		List<Character> chAns = new ArrayList<Character>();
		int[] count = new int[128];
		for(int i = 0 ; i < count.length ;i++) {
			count[i] = Integer.MAX_VALUE;
		}
		
		for(int i = 0 ; i < input.length ;i++) {
			String current = input[i];

			int[] cnt = new int[128];

			for(int j = 0; j < current.length();j++)
			{			
				int location = (int)(current.charAt(j));				
				cnt[location] += 1;
			}
			for(int k = 0 ; k < 128 ; k++) {
				count[k] = Math.min(cnt[k], count[k]);
			}
		}
		
		for(int i = 0 ; i < count.length; i++) {
			if(count[i]!=0) {
				for(int j = 0 ; j < count[i];j++)
				{chAns.add((char)(i));}
			}
				
		}

		return chAns;
	}
	
	//56. Merge Intervals
	public static int[][] mergeIntervals(int[][] intervals) {
        List<int[]> res = new ArrayList();
        
        if (intervals.length <= 1)
			return intervals;        
            
		// Sort by ascending starting point
		// Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));
        
        Arrays.sort(intervals, new Comparator<int[]>() {
          public int compare(int[] a, int[] b) { return a[0] - b[0]; }
        });
        
        int[] newInterval = intervals[0];
        
        res.add(intervals[0]);        
        for(int[] interval:intervals){

            if(interval[0]<=newInterval[1]){                
                newInterval[1]=Math.max(newInterval[1],interval[1]);
            }
            else {  // Disjoint intervals, add the new interval to the list
				newInterval = interval;
				res.add(newInterval);
			}            
        }
    
        return res.toArray(new int[res.size()][]);
    }
	
	//1086. High Five	
	public static int[][] highFive(int[][] items) {
        
		HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();
		
	    for(int i=0; i<items.length; i++) {
			hm.putIfAbsent(items[i][0], new ArrayList<Integer>());
			hm.get(items[i][0]).add(items[i][1]);
		}
	        
		List<int[]> res = new ArrayList();
        
		for(int k: hm.keySet()) {
			List<Integer> thelist = hm.get(k);
			Collections.sort(thelist);
			Collections.reverse(thelist);
			int sum = 0;
			for(int i=0; i<5; i++)
				sum+=thelist.get(i);
	        
	        int[] currentAns = new int[2];
	        
	        currentAns[0] = k;
	        currentAns[1] = (int)(sum/5);
			res.add(currentAns);
		}
		return res.toArray(new int[res.size()][]);
	}
	
	
}
	

