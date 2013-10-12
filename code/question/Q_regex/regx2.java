import java.util.*;
import java.lang.*;

class regx2{
	static boolean submatch(String s, String p){
		if(p.isEmpty())
			return true;
		if(s.isEmpty())
			return false;
		
		int i=0, j=0;
		for(; i<p.length() && j<s.length(); i++, j++){
			if(s.charAt(i)!=p.charAt(j))
				break;
			if(p.charAt(j)=='*')
				return match(s.substring(i),p.substring(j+1));
			if(p.charAt(j)=='.')
				i--;
		}
		if(j==p.length())
			return true;
		else
			return false;
	}

	static boolean match(String s, String p){
		if(p.isEmpty())
			return true;
		if(s.isEmpty())
			return false;
		int i=0, j=0;
		for(;i<s.length() && j<p.length(); i++,j++){
			if(s.charAt(i)==p.charAt(j) && submatch(s.substring(i),p.substring(j)))
				 return true;
		}
		if(j==p.length()) return true;
		return false;
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