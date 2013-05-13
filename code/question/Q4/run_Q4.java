import java.util.*;

class run{

	static void log(String a, int t){
		if(t == 0)
			System.out.println(a);
		else 
			System.out.print(a);
	}

	static void log(char a, int t){
		if(t == 0)
			System.out.println(a);
		else 
			System.out.print(a);
	}

	static void log(int a, int t){
		if(t == 0)
			System.out.println(a);
		else 
			System.out.print(a);
	}

	
	static boolean checkPalindrome(char[] str, int i, int j){
		log("(28) Checking string ", 1);
		for(int k =i; k<=j; k++) log(str[k], 1);		
		log("",0);
		if(str == null || j < i || j>= str.length || i<0) return false;

		while(i<j){
			if(str[i++] != str[j--]) return false;	
		}
		return true;
	}
		
	static void splitPalindrome(String str){
		if(str == null){
			log("(41) Input string is NULL",0);		
			return;
		}		
		char[] s = str.toCharArray();
		int n = s.length;		
	
	// Store palindrome info; a[i] means str[0:i] could be splitted into a[i] substrings, which are palindromic. 
	// a[i] = 0 means not be palindromically splittable.

		int[] a = new int[n];

	// Store the info of most recent palindrome substring. str[b[i]...i] is palindrome to splitted. 
	// b[i] = -1, means not a palindrome position.

		int[] b = new int[n];
	
		for(int i = 0; i<n; i++){
			log("(58) Checking position "+i+":",0);
			a[i] = 0;
			b[i] = -1;
		// re is used to store global result of a[i]

			int re = 2*n;
			
			for(int j = i-1 ; j>=-1; j--){
				log("(66) *** Checking substring from "+(j+1)+" to "+i, 0);
			// j = -1 means str[0 ... i] may be one palindromic string			
				if(j == -1){
					log("(69) ****** Check whole string from "+0+" to "+ i,0);
					if(checkPalindrome(s, 0, i)){
						log("(71) *********Updating a and b: ",1);
						re = 1;
						b[i] = 0;
						log("a["+i+"] = "+a[i]+", b["+i+"] = "+b[i],0);

					}
					break;
				}

				log("(80) ****** checking "+j+", when j!=-1",0);
				try{
					if(a[j] > 0 && checkPalindrome(s, j+1, i) && (a[j]+1) < re){
						log("(83) ********* String ",1);
						for(int k = j+1; k<=i; k++) log(s[k],1);
						log(" is palindromic and a["+j+"] is "+a[j]+". So updated re = "+ (a[j] + 1)+" , and b["+i+"] = "+(j+1),0);
						re = a[j] + 1;
						b[i] = j+1;
					}	
				}catch(Exception e){
					System.out.println("Error: "+j);
					System.exit(-1);
				}
			}		
			a[i] = re;
			log("(95) *** a["+i+"] is updated to "+re, 0);

			log("(97) *** a is",1);
			for(int j:a) log(j+",",1);
			log("\n*** b is",1);
			for(int j:b) log(j+", ",1);
			log("",0);
		}
		
		System.out.println("This string could be splitted into "+a[n-1]+" palindromic substrings:");
		for(int i:a)	System.out.print(i+", ");
		System.out.println();
		for(int i: b)	System.out.print(i+", ");
		System.out.println();
		int start = n;
		int end = n-1;
		int i = n-1;
		if(b[n-1] == -1) return;
		while(end>=0){	

			start = b[start-1];
			for(int j = start; j<=end; j++){
				try{			
					System.out.print(s[j]);
				}catch(Exception e){
					System.out.println("Error: "+j);
					System.exit(-1);
				}
			}
			end = start - 1;	
			log("",0);	
		}
	}
	public static void main(String[] args){
		String str = "abacbc";
		log(str,0);
		log("",0);
		splitPalindrome(str);

	}
}

