package BLineQuestion;

/**
 * 
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;

/**
 * @author Amit
 *
 */
public class PrintAdDealersInfoImport {
/*
	//table name
	static final String read_table = "printad.print_ad_frequency";
	static final String write_table = "printad.print_ad_dealers_info";
	
	//column names: dealer_mnfr_id, dealer_id, dealer_name, dealer_brand, base_url
	static final String DEALER_MNFR_ID = "dealer_mnfr_id";
	static final String DEALER_ID = "dealer_id";
	static final String DEALER_NAME = "dealer_name";
	static final String DEALER_BRAND = "dealer_brand";
	static final String DEALER_BASE_URL = "base_url";
	*/
	static Hashtable<Integer, List<Integer>> studentFriendsMapping = new Hashtable<Integer, List<Integer>>();
	static HashSet<Integer> studentsChecked = new HashSet<Integer>();
	static int circlesCount = 0;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] friends = new String[5];
		int length  = friends.length;
		String row0 = "YYNNN";
		String row1 = "YYNNN";
		String row2 = "NNYNN";
		String row3 = "NNNYN";
		String row4 = "NNNNY";
		friends[0] = row0;
		friends[1] = row1;
		friends[2] = row2;
		friends[3] = row3;
		friends[4] = row4;
		
		for(int i = 0; i<length;i++){
			studentFriendsMapping.put(i, new ArrayList<Integer>());
		}
		
		for(int i = 0; i<length; i++){
			
			for(int j = 0; j<length; j++){
				if( (friends[i].charAt(j) == 'Y')){
					studentFriendsMapping.get(i).add(j);
				}
			}
		}
		
		System.out.println(studentFriendsMapping);
		
	
		Set<Integer> keys = studentFriendsMapping.keySet();
		for(int key : keys){
			boolean isChecked = isStudentChecked(key);
			if(!isChecked){
				discoverFriends(key);
				circlesCount++;
			}
		}
		
		System.out.println("number of circles: " + circlesCount);
		System.out.println(studentsChecked);
		}
	
	
	
	private static void discoverFriends(int key) {
		if(!isStudentChecked(key)){
			studentsChecked.add(key);
			List<Integer> values = studentFriendsMapping.get(key);
			for(int value : values){
				
				discoverFriends(value);
			}
		}
	}

	private static boolean isStudentChecked(int key) {
		if(studentsChecked.contains(key)){
			return true;
		}
		return false;
	}

}
