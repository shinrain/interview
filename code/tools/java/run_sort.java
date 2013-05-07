import java.util.*;
import java.lang.Math;
import Sort.*;



class run{


  // Print array items
	private static void print(int[] a){
		for(int i:a)
			System.out.print(i+" ");
		System.out.println();
	}

  // Generate a random array
	private static int[] genArray(int N){
		if(N<=0) return null;

		int[] a = new int[N];

		for(int i = 0; i<N; i++)
			a[i] = (int)(Math.random()*N);
		return a;
	}

  // Create an identical array
	private static int[] cpArray(int[] a){
		int N = a.length;
		if(N<=0) return null;

		int[] b = new int[N];
		int i = 0;
		for(int j:a){
			b[i++] = j;
		}
		return b;
	}


	public static void main(String[] args){
		int n = 20;
		int[] a = genArray(n);
		int[] b = cpArray(a);
		print(a);

		Sort.MergeSort.MergeSortArray(a);
		System.out.print("Merge Sort using Array: ");
		print(a);

		Sort.MergeSort.MergeSortLL(b);
		System.out.print("Merge Sort using Linked List: ");
		print(b);
	}

}
