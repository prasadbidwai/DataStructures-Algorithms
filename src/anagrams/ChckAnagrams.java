import java.util.*;

public class ChckAnagrams {

public String sort1(String s1){
    
    char[] s1c = s1.toCharArray();
    Arrays.sort(s1c);
    return String.valueOf(s1c);
}
    
public boolean chckStrings(String s1, String s2)
{
    String s1c = sort1(s1.toLowerCase().replaceAll("\\s", ""));
    String s2c = sort1(s2.toLowerCase().replaceAll("\\s", ""));
    
    if(s1c.length() != s2c.length())
    {   
        System.out.println(s1c.length()+ " "+s2c.length() + "lenghts are not same");
        return false;
    }
    System.out.println(s1+"  "+s2);
    return s1c.equals(s2c);
}

//Method 2 using String builder

static void isAnagram(String s1, String s2)     
{
    String copyOfs1 = s1.replaceAll("\\s", "").toLowerCase();
    String copyOfs2 = s2.replaceAll("\\s", "").toLowerCase();

    boolean status = true;
 
        if(copyOfs1.length() != copyOfs2.length())
        {
            status = false;
        }
        else
        { 
            char[] s1Array = copyOfs1.toCharArray();
            StringBuilder sb = new StringBuilder(copyOfs2);
//            System.out.println("stringBuilder sb:: "+sb);
            for (char c : s1Array)
            {
                int index = sb.indexOf(String.valueOf(c));
//                System.out.println(c+":  "+index);
 
                if (index != -1)
                {
                    sb = sb.deleteCharAt(index);
                }
                else
                {
                    status = false;
                    break;
                }
            }
        } 
        if(status)
        {
            System.out.println(s1+" and "+s2+" are anagrams");
            System.out.println("length of sb:");
        }
        else
        {
            System.out.println(s1+" and "+s2+" are not anagrams");
        }
        //edit
    }


    
    public static void main(String[] args)
    {
    
        ChckAnagrams cka = new ChckAnagrams();

        System.out.println(cka.chckStrings("Mother In Law", "Hitlerr Woman"));
        System.out.println(cka.chckStrings("a bcdef", "fdea bc"));
        System.out.println(cka.chckStrings("SiLeNt CAT", "LisTen AcT"));

        System.out.println("\nIs Anagram Method ::");

        isAnagram("Mother IIn Law ", "Hiitler Woman");
        isAnagram("aaabbbccd", "bbbccd aaa");

    }
}

