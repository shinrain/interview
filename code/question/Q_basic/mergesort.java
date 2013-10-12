import java.util.*;
import java.lang.*;

class node{
	int val;
	node next;

	node(int i){
		val = i;
		next = null;
	}

}

class mergesort{


	static void merge(int[] a, int[] b, int left, int mid, int right){
		int i = left;
		int j = mid;
		int k = 0;
		while(i<mid && j<=right){
			if(a[i]<=a[j])
				b[k++] = a[i++];
			else
				b[k++] = a[j++];
		}
		while(i<mid)
			b[k++] = a[i++];
		while(j<=right)
			b[k++] = a[j++];
		j = 0;
		i = left;
		while(j<k)
			a[i++] = b[j++];
	}

	static void subsort(int[] a, int[] b, int left, int right){
		if(left>=right) return;
		int mid = left+(right-left)/2;
		subsort(a,b,left, mid);
		subsort(a,b,mid+1,right);
		merge(a,b,left, mid+1,right);
	}

	static void sort(int[] arr){
		int n = arr.length;
		if(n<=0) return;

		int[] b = new int[n];
		subsort(arr, b, 0, n-1);
	}

	static node formLL(int[] a){
		int n = a.length;
		if(n<=0) return null;

		node head = null;
		for(int i = n-1; i>=0; i--){
			System.out.println("Get value"+a[i]);
			node nd = new node(a[i]);
			nd.next = head;
			head = nd;
		}
		return head;
	}

	static void printLL(node nd){
		node n = nd;
		while(n!=null){
			System.out.print(n.val+" ");
			n = n.next;
		}
		System.out.println();
	}

	static node mergeLL(node n1, node n2){
			if(n1==null) return n2;
			if(n2 == null) return n1;

			if(n1.val<=n2.val){
				n1.next = mergeLL(n1.next, n2);
				return n1;
			}else{
				n2.next = mergeLL(n1, n2.next);
				return n2;
			}

	}

	static node sortLL(node head1){
		if(head1==null || head1.next==null) return head1;
		node head = head1;
		node n1 = head;
		node n2 = head.next;
		node n = n2.next;
		n1.next = null;
		n2.next = null;
		int i=0;
		node nd;
		while(n!=null){
			if(i%2 == 0){
				nd = n.next;
				n.next = n1;
				n1 = n;
			}else{
				nd = n.next;
				n.next = n2;
				n2 = n;
			}
			i++;
			n = nd;
		}
		return mergeLL(sortLL(n1), sortLL(n2));
	}

	public static void main(String[] args){
		char[] s = args[0].toCharArray();
		int[] arr = new int[s.length];

		for(int i=0;i<s.length;i++){
			arr[i] = Character.getNumericValue(s[i]);
			System.out.print(arr[i]+" ");
		}
		System.out.println();
		//sort(arr);
		node nd = formLL(arr);
		node N = sortLL(nd);
		printLL(N);

		System.out.println();

	}
}