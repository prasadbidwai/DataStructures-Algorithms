package anagrams;

public class ChckAnagrams {

public String sort1(String s1){
	
	char[] s1c = s1.toCharArray();
	java.util.Arrays.sort(s1c);
	return new String(s1c);
}
	
public boolean chckStrings(String s1, String s2){

	if(s1.length() != s2.length()){
		return false;
	}
	
	String s1c = sort1(s1);
	String s2c = sort1(s2);
	
	return s1c.equals(s2c);
	
	}	
	
public static void main(String[] args){
	
	ChckAnagrams cka = new ChckAnagrams();
	System.out.println(cka.chckStrings("abcdef", "fdeabc"));
	
}

}
