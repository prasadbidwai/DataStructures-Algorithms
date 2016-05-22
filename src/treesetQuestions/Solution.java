import java.util.*;

class Solution {

    public static void main(String[] args) 
    {

//        String testString;
//        int[] secondProb =  {1, 2, 3, 4, 5, 6, 7,8,9}; // 8 1 7 2 6 3 5 4
//        maxMin(secondProb);
        int prob = 223336226;
        System.out.println("the answer of interview question: " + solution2(prob));
    }

    public static int solution2(int X) {
        
        TreeSet<Character> ts  = new TreeSet<Character>(); 
        char[] charArray = String.valueOf(X).toCharArray();  
        for(int i = 0 ; i < charArray.length-1 ; i ++)
        {
            if(charArray[i] == charArray[i+1])
            {
                if(!ts.contains(charArray[i]))
                {
                    ts.add(charArray[i]);    
                }
            }
        }
        
    StringBuilder strngbldr = new StringBuilder();   
     
    int firstMin = ts.first();
    int j;
    
    for(j = 0 ; j < charArray.length-1 ; j++){
        
        if(firstMin == (int)charArray[j] && firstMin == (int)charArray[j+1])
        {
            break;
        }
        else 
        {
            strngbldr.append(String.valueOf(charArray[j]));
        }
    }
    
    while(j < charArray.length-1)
    {
        strngbldr.append(String.valueOf(charArray[j+1]));
        j++;
    }
    System.out.println(Integer.parseInt(new String(strngbldr)));
    return Integer.parseInt(new String(strngbldr));
    }

    public static int solution(String S) {
        // write your code in Java
        System.out.println(S);
        char[] charArray = S.toCharArray();
        int length = 0;
        for(int i = 0 ; i < charArray.length ; i ++)
        {
            if (String.valueOf(charArray[i]) == "\n");
            {
                //if(charArray[i+1] == "n")
                length ++;
            }
        }
    return length;
    }

    public static void maxMin(int[] arraay){

        Arrays.sort(arraay);
        int[] ansArray = new int[arraay.length+1];
        int k = -1;
        int i;
        int len = arraay.length-1;

        System.out.println("Inside maxMin Method");
        for (i = 0 ; i < ansArray.length - 1 ; i ++)
        {    
        if(k <= len)
            {                                               //{1, 2, 3, 4, 5, 6, 7,8}; // 8 1 7 2 6 3 5 4
                if((i % 2) == 0)
                {
                        ansArray[i] = arraay[len--];
                }
                
                else
                {
                        ansArray[i] = arraay[++k];
                        System.out.println(arraay[k]);
                        //k++;
                }
            }    
        }
        ansArray[i++] = arraay[k];
        System.out.println(" value of i "+ i);
        System.out.println("after for loop: "+arraay[k]);
        
        System.out.println("\n");

        for (int j = 0 ; j < ansArray.length - 1 ; j ++)
        {
            System.out.println(ansArray[j]);
        }

    }        
}
