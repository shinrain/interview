import java.util.*;
import java.lang.Math.*;
import java.util.Scanner;
class run{
	static boolean checkPalindrome1(int N){
		if(N<0) N = -N;
		if(N<10) return true;

		int N2 = 0;
		int tmp = N;
		while(N!=0){
			N2 = N2*10+N%10;
			N /= 10;
		}
		return (tmp==N2);
	}

//	This function is for the situation that the Palindrome is overflow for int datastructure. In this case, N2 in above function will not work.
//	Surely, we can use long for N2. However, as to test cadidate, another one will be better.
// 	The idea is to compare bit by bit. Get the number of digits in input integer first.

	static int getDigit(int N, int i){
		if(N<0) N = -N;

		if(N<(int)(Math.pow(10,i))) {
			System.out.println("Error ( "+N+", "+i+" )");
			return -1;		
		}	
		return N%((int)(Math.pow(10,i+1))) / ((int)(Math.pow(10,i)));
	}

	static boolean checkPalidrome2(int N){
		if(N<0) N = -N;
		if(N<10) return true;

		int num_bit = 0;
		int tmp = N;		
		while(tmp > 0){
			num_bit ++;
			tmp /=10;
		}

		int n = num_bit / 2;
		System.out.println("n is "+n);
		for(int i =0; i< n; i++){
			if( getDigit(N,i) != getDigit(N,num_bit-i-1) )	{System.out.println("Error in "+ i); return false;}
		}
		return true;
	}

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		System.out.println("input number:");
		int N = in.nextInt();	
		
		if(checkPalindrome1(N))	System.out.println("Check 1: True");
		else	System.out.println("Check 1: false");

		if(checkPalidrome2(N))	System.out.println("Check 2: True");
		else	System.out.println("Check 1: false");
	}
}
