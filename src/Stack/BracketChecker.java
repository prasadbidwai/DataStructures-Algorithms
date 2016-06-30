import java.util.*;

class BracketChecker{

	public void checkDelimeter(String s){

		Stack<Character> inStack = new Stack<Character>();
		//System.out.println(s);
		boolean flag = true;
		char er = ' ';
		int pos = 0; 

		for (int i = 0; i < s.length() ; i++ ) 
		{
			char ch = s.charAt(i);

			switch(ch)
			{
				case '(':
				case '[':
				case '{':
				inStack.push(ch);
				break;

				case ')':
				case ']':
				case '}':
				if(!inStack.empty())
				{
					char chx = inStack.pop();
					
					if((ch == ')' && chx != '(') || (ch == '}' && chx != '{') || 
							(ch == ']' && chx != '[') )
					//		System.out.println("Error: "+ ch+ "at "+ i);
						{
							er = ch;
							pos = i;
							flag = false;
						}
				}
				else
				//	System.out.println("Error: "+ ch+ "at "+ i);
					{
						er = ch;
						pos = i;
						flag = false;	
					}
				break;
			default:
				break;	
			}
		}	
			if(!inStack.empty()){
				flag = false;
				System.out.println("Error: missing right delimter");
			}

	if(flag)
	{
		System.out.println("string is fine !!");
	}
	else
		System.out.println("Error: "+ er+ "at "+ pos);
		
	}

}
