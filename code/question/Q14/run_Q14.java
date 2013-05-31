import java.util.*;

class run{
	static boolean check(int[] a, int k, int[] b){
		if(b[k]!=-1) return b[k]==1;
		if(k == 0){	b[k] =1; return true;	}
		for(int j = k-1; j>=0; j--){
			if((k-j)<=a[j] && check(a,j,b)){
				b[k] = 1;
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args){
		int[] a = {2,3,1,1,4};

		int[] b = {-1, -1, -1, -1, -1};
	
		System.out.println(check(a,4,b));

		int[]c = {3,2,1,0,4};

		int[] d = {-1, -1, -1, -1, -1};
		System.out.println(check(c,4,d));


	}

}
