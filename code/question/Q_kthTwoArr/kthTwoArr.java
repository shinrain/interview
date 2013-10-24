import java.util.*;
import java.lang.*;

class run{
	static int kthTwoArr(int[] a, int[] b, int k){
		int m = a.length;
		int n = b.length;
		if(m<0 || n<0 || (m==0 && n<k ) || (n==0 && m<k)) System.exit(-1);
		System.out.format("m = %d, n = %d, k = %d\n",m,n,k);

		int begin = (0>k-n)?0:k-n;
		int end = (m>=k)?m:k;
		
		while(begin <= end){
			System.out.print("begin: "+begin+", end: "+end);
			int l = begin+(end-begin)/2;
			System.out.println(". mid = "+l);
			if(l<=m && a[l-1]>b[k-l])
				end = l;
			else if(l<m && a[l] < b[k-l-1])
				begin = l+1;
			else{
				begin = l;
				break;
			}
		}

		System.out.format("While end. begin = %d, end = %d\n",begin,end);
		if(begin == 0) return b[k-1];
		if(begin == k) return a[k-1];
		
		return (a[begin-1]>=b[k-begin-1])?a[begin-1]:b[k-begin-1];
	}

	public static void main(String[] args){
		String s1 = args[0];
		char[] ss1 = s1.toCharArray();
		int[] arr1 = new int[ss1.length];
		for(int i=0; i<ss1.length; i++){
			arr1[i] = Character.getNumericValue(ss1[i]);
		}

		String s2 = args[1];
		char[] ss2 = s2.toCharArray();
		int[] arr2 = new int[ss2.length];
		for(int i=0; i<ss2.length; i++){
			arr2[i] = Character.getNumericValue(ss2[i]);
		}

		int k = (arr1.length+arr2.length)/2;
		System.out.println(kthTwoArr(arr1, arr2,k));
	}
}