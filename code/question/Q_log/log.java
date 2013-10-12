import java.util.*;
import java.lang.*;
import java.util.Scanner;
class log{
	static int sublog(int a, int b){
			if(a==0) return 0;
			if(b==0) return 1;
			if(a<0 || b<0) System.exit(-1);
			
			int subre = sublog(a, b/2);
			if(b%2==1){
					return subre*subre*a;
			}else{
					return subre*subre;
			}
	}

	static int log(int a, int b){
		if(a == 0)
			if(b<0) System.exit(-1);
			else
					return 0;
		if(b == 0) return 1;

		boolean minus = (a<0) && (b%2==1);
		boolean invert = (b<0);
		if(a<0)
			a *= -1;
		if(b<0)
			b *= -1;

		int re = sublog(a,b);
		if(minus)
			re *=-1;
		if(invert)
			if(re!=0)
				re = 1/re;
			else
				System.exit(-1);
		return re;
	}

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		System.out.println("Please input a = ");
		int a = in.nextInt();
		System.out.println("Please input b = ");
		int b = in.nextInt();

		System.out.println("Result is "+log(a,b));
		}
	}
