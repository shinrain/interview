import java.util.*;

class run{

	static int n ;
	static int[] m;

	static boolean check(int k, int i){
		for(int j = 0; j<k; j++)
			if(m[j] == i) return false;
			else if((k-j == i-m[j])||(k-j + i-m[j]) == 0) return false;
			
		return true;

	}

	static void print(){
		System.out.print("{");
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				if(j==m[i])
					System.out.print("Q ");
				else	System.out.print(".");
						
			}
			System.out.println();
		}
		System.out.println("}\n\n");
	}

	static void f(int k){
		if(k == n) return;
		
		for(int i=0; i<n; i++){
			if(check(k,i)){
				m[k] = i;
				if(k==n-1) print();
				f(k+1)	;	
			}
		}

	}

	public static void main(String[] args){

		n =4;
 		m = new int[n];
		f(0);

	}


}
