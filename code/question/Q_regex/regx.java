import java.util.*;
import java.util.*;

class run{

	static boolean matchStar(String str, String pattern){
			if(pattern.isEmpty())
				return true;
			if(str.isEmpty())
				return false;
			int i = 0;
			
			while(i<str.length()){
				if(str.charAt(i)==pattern.charAt(0) && match(str.substring(i+1), pattern.substring(1)))
					return true;
				i++;
			}

			return false;

	}
	static boolean match(String str, String pattern){
			if(pattern.isEmpty())
				return true;
			if(str.isEmpty())
				return false;
			if(pattern.charAt(0) == '.')
				return match(str.substring(1),pattern.substring(1));
			if(pattern.charAt(0) == '*')
				return matchStar(str, pattern.substring(1));

			int i=0, j=0;

			while(i<str.length() && j<pattern.length()){
				if(pattern.charAt(j)=='.')
					return match(str.substring(1), pattern.substring(1));
				if(pattern.charAt(j)=='*')
					return matchStar(str, pattern.substring(1));
				if(str.charAt(i)!=pattern.charAt(j)){
					System.out.format("str at %d is %c, pattern at %d is %c\n", i, str.charAt(i),j, pattern.charAt(j));
					return match(str.substring(i+1),pattern);
				}
					
				i++;
				j++;
			}
			System.out.format("str at %d is %c, pattern at %d is %c\n", i, str.charAt(i-1),j, pattern.charAt(j-1));
			if(j == pattern.length())
				return true;
			else{
				System.out.println("j="+j);		
				return false;	
			}
	}
	

	public static void main(String[] args){

		for (String a:args)
			System.out.println(a);

		if(args.length < 0){
			System.out.println("No input.");
			return;
		}
		System.out.format("str %s, pattern %s\n", args[0], args[1]);

		if(match(args[1], args[0]))
			System.out.println("Match!");
		else
			System.out.println("Not match!");

	}

}