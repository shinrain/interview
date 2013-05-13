import java.util.*;

class run{
	
	static boolean checkPalindrome(char[] str, int i, int j){
		if(str == null || j < i || j>= str.length || i<0) return false;

		while(i<j){
			if(str[i++] != str[j--]) return false;	
		}
		return true;
	}
		
	static void splitPalindrome(String str){
		if(str == null){
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
			a[i] = 0;
			b[i] = -1;
		// re is used to store global result of a[i]

			int re = 2*n;
			
			for(int j = i-1 ; j>=-1; j--){

			// j = -1 means str[0 ... i] may be one palindromic string			

				if(j == -1){
					if(checkPalindrome(s, 0, i)){
						re = 1;
						b[i] = 0;
					}
					break;
				}

				try{
					if(a[j] > 0 && checkPalindrome(s, j+1, i) && (a[j]+1) < re){
						re = a[j] + 1;
						b[i] = j+1;
					}	
				}catch(Exception e){
					System.out.println("Error: "+j);
					System.exit(-1);
				}
			}		
			a[i] = re;
		}
		
		System.out.println("This string could be splitted into "+a[n-1]+" palindromic substrings:");
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
			System.out.println();
		}
	}
	public static void main(String[] args){
		String str = "abacbc";
		splitPalindrome(str);

	}
}

