import java.util.*;
import java.lang.*;

class nextCombo{
	static boolean nextCombo(int[] arr){
		int n = arr.length;
		if(n<=0) return false;

		int l = n-1;
		while(--l>=0 && arr[l]>arr[l+1]);
		if(l<0) return false;

		int r = n;
		while(--r>l && arr[r]<=arr[l]);
		if(r<=l) return false;

		int t = arr[l];
		arr[l] = arr[r];
		arr[r] = t;

		
		r = n;
		while(++l<(--r)){
			t = arr[l];
			arr[l] = arr[r];
			arr[r] = t;
		}
		return true;
	}

	public static void main(String[] args){
		String s = args[0];
		char[] ss = s.toCharArray();
		int[] arr = new int[ss.length];
		for(int i=0; i<ss.length; i++){
			arr[i] = Character.getNumericValue(ss[i]);
			System.out.print(arr[i]+" ");
		}
		System.out.println();

		while(nextCombo(arr)){
				for(int k : arr)
					System.out.print(k);
				System.out.println();
		}
	}
}