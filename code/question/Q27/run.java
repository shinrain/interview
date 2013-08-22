import java.util.*;
import java.lang.*;

class pathAbbreviate{

	static boolean cur = false;

	static void processDot(char[] str, int i, Stack<Character> s){
		if(str[i]!='.') return;
		if(s.isEmpty()){s.push(str[i]); return;}
		if(s.peek() != '.') s.push(str[i]);
		else{
			s.pop();
			if(s.isEmpty()){
				s.push('.');
				s.push('.');
			}
			else if(s.peek() == '/'){
				s.pop();
				while(!s.isEmpty() && s.peek()!='/')
					s.pop();
			}
		}

	}

	static void processSlash(char[] str, int i, Stack<Character> s){
		if(str[i]!='/') return;
		if(s.isEmpty()){ if(!cur) s.push(str[i]); return;}
		if(s.peek() == '.'){
			char tmp = s.pop();
			if(!s.isEmpty() && s.peek()!='/'){
				s.push('.');
				s.push('/');
			}else cur = true;			
		}
		else if(s.peek()!='/') s.push(str[i]);
	}

	static String trim(String in_str){
		if(in_str == null || in_str.length() == 0)	return in_str;
		Stack<Character> s = new Stack<Character>();

		char[] str = in_str.toCharArray();
		int n = str.length;
		int i = 0;

		while(i<n){
			if(s.isEmpty() || (str[i]!='.' && str[i]!= '/'))	s.push(str[i]);
			else{
				if(str[i] == '.') processDot(str, i, s);
				else processSlash(str, i, s);
			}
			i++;
		}
		String re = "";
		if(s.isEmpty()) re = "./";
		else{
			while(!s.isEmpty()) re = s.pop()+re;
		}
		return re;
	}

	public static void main(String[] args){
		if(args.length<1) return;
		System.out.println(trim(args[0]));
	}

}
