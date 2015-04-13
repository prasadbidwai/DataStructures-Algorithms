package try2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;


public class DFS {

	
	public static List<String[]> oprPermutations = new ArrayList<String[]>();
	public static List<String[]> NumPermutations= new ArrayList<String[]>();
	
	String input = "+-*/";
	
	String[] operators={"+","-","/","*"};
	String[] digits={"20","1","4","3","60"};
	
	int conbinationSize = 4;
	int conbiNumSize=5;
	/**
	 * isChoosed[i] is true if the combination that is currently prepared
	 * contain index.charAt(i)
	 */
	boolean[] isChoosed = new boolean[input.length()];
	boolean[] isChoosedNum = new boolean[digits.length];


	public void generateOprCombination(String[] partialOutput) {
		if (partialOutput.length == conbinationSize) {
			oprPermutations.add(partialOutput);
			return;
		}
		for (int i = 0; i < input.length(); ++i) {
			if (/*!isChoosed[i]*/true) {
				isChoosed[i] = true;
				//generateOprCombination(partialOutput + input.charAt(i));
				String a3[]=joinArray(partialOutput, operators[i]);
				generateOprCombination(a3);
				isChoosed[i] = false;
			}
		}

	}

	public void generateNumCombinations(String[] partialNum){
	
		if(partialNum.length==conbiNumSize){
			NumPermutations.add(partialNum);
			return;
		}	

		for(int i=0;i<digits.length;++i){
			//System.out.println("inside for loop");	
			if(!isChoosedNum[i])
			{
				isChoosedNum[i]=true;
				String[]a3=joinArray(partialNum, digits[i]);
				generateNumCombinations(a3);
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

		for (String[] c : oprPermutations) {
			System.out.println(Arrays.toString(c));
		}
		System.out.println(oprPermutations.size());
	}

	void NumprintCombination() {

		for (String[] c : NumPermutations) {
			System.out.println(Arrays.toString(c));
		}
		System.out.println(NumPermutations.size());
	}

	public String[] mergeOps(String[]a1, String[]a2) throws ScriptException{
		String a3[]=new String[(a1.length+a2.length)];
		int n=0;
		int k;
		
		for(k=0;k<8;k++)
		{
			if(k==a1.length || k==a2.length){break;}
			a3[n]=a1[k];
			a3[n+1]=a2[k];
			n=n+2;
		}
		a3[n]=a1[k];	
		System.out.println(Arrays.toString(a3));
		return a3;
	}

	public double evaluate(String[] s) throws ScriptException{
		String foo="";
		ScriptEngineManager mgr = new ScriptEngineManager();
		ScriptEngine engine = mgr.getEngineByName("JavaScript");
		System.out.println("The Expression: "+Arrays.toString(s));
		String temp = Arrays.toString(s);
		System.out.println("temp: "+ temp);
		
		for(int i=0;i<temp.length();i++){
			if(temp.charAt(i) == ',' || temp.charAt(i) == '[' || temp.charAt(i) == ']'){
				// do nothing
			} else {
				foo+=temp.charAt(i);
			}

		}
		System.out.println(foo);
		return (double)(engine.eval(foo));

	} 



	public static void main(String[] args) throws ScriptException {
		
		DFS dfs = new DFS();
		
		dfs.generateNumCombinations(new String[0]);
		dfs.generateOprCombination(new String[0]);
				
		String[] a3= new String[9];
		
		double result;
		
		int numpercount = NumPermutations.size();
		
		int flag=0;
		int count1=0;
		while(count1 < numpercount && flag==0){
			for (String[] c : oprPermutations){
				System.out.println("in double loop");
				a3=dfs.mergeOps(NumPermutations.get(count1++), c);
				result= (double)dfs.evaluate(a3);
				System.out.println("Returned value: "+result);

				if (result==(42.0)) 
				{
					flag=1;
					break;
				}
			}

			numpercount--;

		}
	}
}