package Sort;

class node{
	
	int val;

	node next;

	node(){
		val = 0;
		next = null;
	}

	node(int val){
		this.val = val;
	}

}



public class MergeSort{


// This part is impl of merge sort using array

	private static void subMergeArray(int[] a, int[] b, int left, int mid, int right){
		if(left>=right || a.length<=right || left<0 || b.length < right-left+1 || mid >right || mid <left) return;

			
		int k = 0;
		int i = left;
		int j = mid;

		while(i<mid && j<=right){
			if(a[i]<=a[j]) b[k++] = a[i++];
			else b[k++] = a[j++];
		}

		if(i < mid)
			while(i < mid) b[k++] = a[i++];
		else
			while(j<=right) b[k++] = a[j++];
		k = 0;
		i = left;
		while(i <= right) a[i++] = b[k++]; 
	
	}

	private static void subSortArray(int[] a, int[] b, int left, int right){
		if(left <0 || right >= a.length || left >= right || b.length < right-left+1) return;
		
		int mid = left + (right-left)/2;
		
		subSortArray(a, b, left, mid);
		subSortArray(a, b, mid+1, right);

		subMergeArray(a, b, left, mid+1, right);
	}

// main function of merge sort based on array.

	public static void MergeSortArray(int[] a){
		int n = a.length;

		if(n<0) return;

		subSortArray(a, new int[n], 0, n-1);
	}




// This part is impl of merge sort using linked list
// The whole functionality uses heavy logging mode.

  // This function is used to print linked list

	private static void print(node N){
		node nd = N;
		while(nd!=null){System.out.print(nd.val+" ");nd = nd.next;}

	}
	
	private static node subMergeLL(node a, node b){
		if(a==null && b == null) return null;
		node N = null;

		System.out.print("\nNow Merge ");
		print(a);
		System.out.print(" and ");
		print(b);
		System.out.print(" ---> ");
		node N1 = a;
		node N2 = b;

		if(N1 == null) return b;
		if(N2 == null) return a;

		

		if(N1.val<=N2.val){
			N = N1;
			N.next = subMergeLL(N1.next, N2);
		}else{
			N = N2;
			N.next = subMergeLL(N1, N2.next);
		}
		print(N);
		System.out.println("\n\n\n");
		return N;
		

	}
	
	private static void subSortLL(node a){
		if(a == null) return;
		System.out.print("\n******Now sort ");
		print(a);
		System.out.println();
		node N = a;

		boolean flg = true;

		node b = null;
		node c = null;

		while(N!=null){

			node nd = N.next;

	
			if(flg){
				N.next = b;
				b = N;
				flg = !flg;
			}else{
				N.next = c;
				c = N;
				flg = !flg;
			}
			
			N = nd;			

		}
		System.out.print("****************Linked List: ");
		System.out.print(" divided ---> ");
		print(b);
		System.out.print(" and ");
		print(c);
		System.out.println();
		if(b == null) a = c;
		else if(c == null) a = b;
		else{
			subSortLL(b);
			subSortLL(c);

			a = subMergeLL(b, c);
		}
	}

  // The is the main function of merge sort in linked list

	public static void MergeSortLL(int[] a){
		int n = a.length;
		if(n <=0) return;

		node N = null;

		for(int i:a){
			node nd = new node(i);
			nd.next = N;
			N = nd;
		}

		node nd = N;
		System.out.println("Print Linked List here");		
		while(nd!=null){System.out.print(nd.val+" ");nd = nd.next;}
		System.out.println();		
	
		subSortLL(N);

		for(int i=0; N!=null; i++, N = N.next)
			a[i] = N.val;
			
	}




}
