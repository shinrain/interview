import java.util.*;
import java.lang.*;

class sqrt{
	
	static int sqrt(int val){
		int k = 1;
		try{
			while(k*k<val)
				{	System.out.println(" k = "+k);
					k = 2*k;
				}
		}catch(Exception o){
			System.out.println("Exception");
			k /=2;
		}
		System.out.println("k " + k);
		int l = k;
		int r = 2*k;

		while(l<r){
			System.out.format("l = %d, r = %d\n",l,r);
			int m = l+(r-l)/2;
			try{
				int m2 = m*m;
				if(m2 == val) return m;
				if(m2<val) l = m;
				else r = m-1;
			}catch(Exception o){
							System.out.println("Exception");

				r = m-1;
			}
		}
		if(r*r>val)
			r--;
		return r;	

	}

	public static void main(String[] args){
		int a = 531127023;
		System.out.println("The sqrt is "+sqrt(a));
	}

}