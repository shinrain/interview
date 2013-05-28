import java.util.*;
import java.lang.Math.*;


class run{

	static void print(node head){
		node nd = head;
		while(nd!=null){
			if(nd.next!=null)	System.out.print(nd.val+"-->");
			else			System.out.println(nd.val);
			nd = nd.next;		
		}
	}

	static node gen(int n){
		if(n<=0) return null;
		node head = null;
		for(int i=0; i<n; i++){
			node nd = new node((int)(Math.random()*n));
			nd.next = head;
			head = nd;
		}
		return head;
	}

	public static void main(String[] args){
		
		int n = 20;
		node head = gen(n);
		print(head);
		
	}

}
