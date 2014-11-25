import java.util.*;
import java.lang.*;

class solution
{
/*
+ ( * 1 ( + 1 2 3 ) ) => 6
+ ( * ( + 1 1 ) 17 ) => 34
+ 7 => 7
+ ( * 17 ( + 1 1 ) ) => 34
*/

	int RPN(String s)
	{
		s=s.trim();
		if(s.length()==0) return 0;
		String[] vals = s.split(" ");
		if(vals.length==0) return 0;

		Stack<String> st = new Stack<>();
		for(String ss:vals)
		{
			if(!ss.equals(")")) st.push(ss);
			else
			{
				List<String> nums = new ArrayList<>();
				while(!st.isEmpty() && !st.peek().equals("(")) nums.add(0,st.pop());
				if(st.isEmpty()) return 0;
				st.pop();
				st.push(eval(nums));
			}
		}
		List<String> num = new ArrayList<>();
		for(String ss:st)
			num.add(ss);

		return Integer.parseInt(eval(num));
	}

	String eval(List<String> r)
	{
		if(r.size()==0) return "0";
		String oper = r.remove(0);
		if(!oper.equals("+") && !oper.equals("*")) return "0";
		try
		{
			if(oper.equals("*"))
			{
				long re = 1;
				for(String ss:r)
				{
					re*= Integer.parseInt(ss);
				}
				if(re>Integer.MAX_VALUE) return Integer.toString(Integer.MAX_VALUE);
				return Integer.toString((int)re);
			}
			else
			{
				long re = 0;
				for(String ss:r)
				{
					re+= Integer.parseInt(ss);
				}
				if(re>Integer.MAX_VALUE) return Integer.toString(Integer.MAX_VALUE);
				return Integer.toString((int)re);
			}
		}
		catch(Exception o){}
		return "0";
	}

	public static void main(String[] args) {
		String[] s = {"+ ( * 1 ( + 1 2 3 ) )", "+ ( * ( + 1 1 ) 17 )", "+ 7", "+ ( * 17 ( + 1 1 ) )"};


		solution sol = new solution();
		for(String ss:s)
		{
			System.out.println(sol.RPN(ss));
		}
		// System.out.println(sol.RPN(s[0]));
	}
}