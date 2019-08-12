package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
	
}
	

