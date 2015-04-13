package NumOprnds;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author mifmif
 * 
 */
public class DFS1{

    /**
     * list of generated combination
     */
    List<String[]> operatorPermutations = new ArrayList<String[]>();
    List<String[]> numberPermutations= new ArrayList<String[]>();
    /**
     * input used to generate combination
     */
    String[] oprInput = {"+","-","/","*"};
    String[] numInput= {"1","3","4","20","60"};
    /**
     * the length of the combination
     */
    int conbinationSize = 3;
    int combiNumSize=5;
    /**
     * isChoosed[i] is true if the combination that is currently prepared
     * contain index.charAt(i)
     */
    boolean[] isChoosed = new boolean[oprInput.length];
    boolean[] isChoosedNum= new boolean[numInput.length];
    /**
     * the DFS method that will generate all possible combination
     * 
     * @param partialOutput
     */
    public void generateCombination(String[] partialOutput) {
        if (partialOutput.length == conbinationSize) {
            operatorPermutations.add(partialOutput);
            return;
        }
        for (int i = 0; i < oprInput.length; ++i) {
            if (!isChoosed[i]) {
                isChoosed[i] = true;
                joinArray(partialOutput, oprInput[i]);
                isChoosed[i] = false;
            }
        }

    }
    
    public void generateNumberCombination(String[] s){
    	if(s.length==combiNumSize)
    	{
    		numberPermutations.add(s);
    	}
    	
    for(int i=0;i<numInput.length;i++){
    	if(!isChoosedNum[i]){
    		isChoosedNum[i]=true;
    		String[]a3=joinArray(s, numInput[i]);
    		generateNumberCombination(a3);
    		isChoosedNum[i]=false;
    		
    		}
    	}
    }
    
    
    public String[] joinArray(String[]a1, String a2){
		String[] a3=new String[a1.length+1];
		int j;
		
		for(j=0;j<a1.length;j++)
		{
			a3[j]=a1[j];

		}	
		a3[j++]=a2;
		return a3;
    }

    void printCombination() {
        for (String[] c : numberPermutations) {
            System.out.println(Arrays.toString(c));
        }
    }

    public static void main(String[] args) {
        DFS1 dfs = new DFS1();
        dfs.generateNumberCombination(new String[0]);
        dfs.printCombination();
    }
}