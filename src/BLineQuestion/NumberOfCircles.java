package BLineQuestion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;



public class NumberOfCircles {

	public static Hashtable<Integer, List<Integer>> friendsMapping = new Hashtable<Integer, List<Integer>>();
	public static HashSet<Integer> friendsChecked= new HashSet<Integer>();
	

	public static void main(){
	
	int numFrnds = 0;
	String[] friends = new String[5];
	friends[0] = "YNNN";
	friends[1] = "NYNN";
	friends[2] = "NYNN";
	friends[3] = "NNYN";
	friends[4] = "NNNY";
	
	for(int i=0;i<friends.length;i++)
	{
		for(int j=0;j<friends.length;j++)
		{
			if( (friends[i].charAt(j) == 'Y'))
			{
					friendsMapping.get(i).add(j);
			}
		}
	}
	
	Set<Integer> frndSet= friendsMapping.keySet();
	
	
for(int key:frndSet){
		boolean isChecked1= isfrndChecked(key);
			if(!isChecked1){
				discoverFrnds(key);
				numFrnds++;			
			}
}
System.out.println("number of FriendCircles:"+ numFrnds);

	}

public static void discoverFrnds(int key){
	if(!isfrndChecked(key)){
		friendsChecked.add(key);
		List<Integer> num= friendsMapping.get(key);
		for(int i: num){
		discoverFrnds(i);
	}
}
	
}


private static boolean isfrndChecked(int key) {
	if(friendsChecked.contains(key)){
		return true;
	}
	return false;
}

	



}	
