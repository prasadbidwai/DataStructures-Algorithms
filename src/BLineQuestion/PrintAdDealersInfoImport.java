import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.List;
import java.util.Set;

public class PrintAdDealersInfoImport {

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
