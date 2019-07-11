package Charcount;

public class PrintCharCount {

public String compress(String s1){
	
	String mystr="";
	int count=1;
	char[] s1array = s1.toCharArray();
	char last = s1array[0];
	
	for(int i = 1; i<s1.length(); i++){
		if (last == s1array[i]){
			count++;			
		}
		else{
			mystr += last+""+count;
			count = 1;
			last = s1array[i];			
		}		
	}	
	return mystr + last+""+count;	
	
}

public String compressBetter(String s1){
	

	StringBuffer strbfr = new StringBuffer();
	char last = s1.charAt(0);
	int count = 1;
	
	for(int i=1;i<s1.length();i++){		
		if(last == s1.charAt(i)){
			count++;			
		}		
		else{
				strbfr.append(last);
				strbfr.append(count);
				count = 1;
				last = s1.charAt(i);
			}
	}
	strbfr.append(last);
	strbfr.append(count);
	
	System.out.println("before compression size:"+s1.length());
	System.out.println("After compression size:"+strbfr.toString().length());
	
	return strbfr.toString();
}

public boolean isRotation(String s1, String s2){
	String s1s1=s1+s1;
	return s1s1.contains(s2);	
}

	public static void main(String[] args){

	////////compressing by counting number of occurances of word
	PrintCharCount pcc = new PrintCharCount();
	String ans = pcc.compress("aabbccdef");
	System.out.println(ans);
	
	//slightly differnt method using string buffer
	String ans1 = pcc.compressBetter("aabbcdefgg");
	System.out.println(ans1);
	
	
	System.out.println(pcc.isRotation("abcdef", "cdefab"));
}	
}
