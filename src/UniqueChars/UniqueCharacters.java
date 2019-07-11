package UniqueChars;

public class UniqueCharacters {

	public boolean isUniqueChar(String str){
	
	boolean[] chk = new boolean[128];
	
	for(int i = 0; i<str.length(); i++){
		
		int val = str.charAt(i);
		
		if(chk[val]){
			return false;
		}
		chk[val]=true;
	}
			
	return true;
	}

	public static void main(String args[]){
		
		UniqueCharacters unc = new UniqueCharacters(); 
		String flag;
		String input = "abcdef"; 
				
		flag = unc.isUniqueChar(input) ? " Have Unique":"Does Not have Unique";		
		
		System.out.println("The given string "+ "( " + input + " )"+flag +" characters");
				
	}	

}
