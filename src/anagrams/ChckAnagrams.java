import java.util.*;

public class ChckAnagrams {

public String sort1(String s1){
	
	char[] s1c = s1.toCharArray();
	Arrays.sort(s1c);
	return String.valueOf(s1c);
}
	
public boolean chckStrings(String s1, String s2){

	if(s1.length() != s2.length()){
		return false;
	}
	
	String s1c = sort1(s1.toLowerCase());

	s1c = s1c.replaceAll("\\s", "");	//Removes any white spaces present in string 

	String s2c = sort1(s2.toLowerCase());

	s2c = s2c.replaceAll("\\s", "");	//Removes any white spaces present in string

	System.out.println(s1c+"  "+s2c);

	return s1c.equals(s2c);
	
	}	
	
public static void main(String[] args){
	
	ChckAnagrams cka = new ChckAnagrams();

	System.out.println(cka.chckStrings("Mother In Law", "Hitler Woman"));
	System.out.println(cka.chckStrings("a bcdef", "fdea bc"));
	System.out.println(cka.chckStrings("SiLeNt CAT", "LisTen AcT"));
	
}

}

