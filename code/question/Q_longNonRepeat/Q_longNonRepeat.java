import java.util.*;
import java.lang.*;

class run{

	static String find(String str){
		if(str.isEmpty()) return "";
		HashSet<Character> t = new HashSet<Character>();
		int start = 0, end = 0;
		int s=0, e=0;
		for(int i =0; i< str.length();i++){
			if(!t.contains(str.charAt(i))){
				t.add(str.charAt(i));
				e=i;
			}
			else{
				for(;s<=e;s++)
					if(str.charAt(s)==str.charAt(i)){
						s++;
						e=i;
						break;
					}
			}
			if(e-s>end-start){
				end = e;
				start = s;
			}
		}
		 String r;
		r = str.substring(start, end+1);
		return r;
	}

	public static void main(String[] args){
		String str = args[0];
		String re;
		if(!((re=find(str)).isEmpty()))
			System.out.println("The result is "+re);
		else
			System.out.println("Error!");
	}
}