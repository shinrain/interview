import java.util.*;
import java.lang.*;

class findMedian{
	static int partition(int[] arr, int left, int right){
		if( arr.length <=0 || left<0 || right >= arr.length || left>right) return -1;

		int p = arr[left];
		int l = left -1;
		int r = right+1;

		while(l<r){
			while(++l<r && arr[l]<=p);
			while(--r>l && arr[r]>p);
			if(l>r) break;

			int t = arr[l];
			arr[l] = arr[r];
			arr[r] = t;
		}
		int t = arr[left];
		arr[left] = arr[r];
		arr[r] = t;
		return r;
	}

	static int findMedian(int[] arr){
		int n = arr.length;
		if(n<=0){
			System.out.println("error");
			return -1;
		}
		if(n==1)
			return arr[0];
		int l = 0;
		int r = n-1;
		int m = l+(r-l)/2;
		while(l<=r){
			System.out.format("l = %d, r = %d\n",l,r);
			int k = partition(arr, l, r);
			if(k==m)
				return arr[k];
			if(k>m)
				r = k-1;
			else{
				l = k+1;
				m = m-k-1;
			}
		}
		return l;
	}

	public static void main(String[] args){
		char[] s = args[0].toCharArray();
		int[] arr = new int[s.length];

		for(int i=0;i<s.length;i++){
			arr[i] = Character.getNumericValue(s[i]);
			System.out.print(arr[i]+" ");
		}

		System.out.println("The median is "+findMedian(arr));
	}

}