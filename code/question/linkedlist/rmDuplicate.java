import java.util.*;
import java.lang.*;

class node{
	int val;
	node next;
	node(int val){
		this.val = val;
	}

}

class rmDuplicate{

	static node formList(int[] arr){
		node head = null;
		int n = arr.length;
		if(n<=0) return head;
		for(int i=n-1; i>=0; i--){
			node nd = new node(arr[i]);
			nd.next = head;
			head = nd;
		}
		return head;
	}
	static void print(node head){
		if(head == null) return;
		node nd = head;

		while(nd!=null){
			System.out.print(nd.val+" ");
			nd = nd.next;
		}
		System.out.println();
	}

	static node rmDuplicate(node head){
		if(head == null || head.next == null) return head;

		node cur = head;
		head = null;
		node prev = null;
		while(cur!=null){
			node nd = cur.next;
			while(nd!= null && nd.val == cur.val){
				nd = nd.next;
			}
			if(nd == null){
				if(cur.next == null)
					if(prev==null)
						head = cur;
					else
						prev.next = cur;
				else
					if(prev != null)
						prev.next = null;
				break;
			}
			else if(cur.next == nd){
				if(prev == null){
					head = cur;
					prev = cur;
				}
				else{
						prev.next = cur;
						prev = cur;
				}
			}
			cur = nd;

		}
		return head;
	}

	public static void main(String[] args){
		String s = args[0];
		char[] ss = s.toCharArray();
		int[] arr = new int[ss.length];
		for(int i=0; i<ss.length; i++){
			arr[i] = Character.getNumericValue(ss[i]);
		}
		System.out.println();
		node head = formList(arr);
		print(head);
		node head2 = rmDuplicate(head);
		print(head2);

	}
}