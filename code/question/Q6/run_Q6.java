import java.util.*;
import BST.*;

class run{
	static int sum =0;

	static void traceDown(node nd, int val){
		if(nd == null)	System.exit(-1);
		if(nd.getVal() < 0)	System.exit(0);
	
		val = val*10+nd.getVal();

		if(nd.getLeft() == null && nd.getRight() == null){
			sum += val;
			return;
		}
		if(nd.getLeft()!= null) traceDown(nd.getLeft(), val);
		if(nd.getRight()!= null) traceDown(nd.getRight(), val);	
	}	

	public static void main(String[] args){
		BST T = new BST();
		// .... Create a Binary Tree with non-negative value. ....//

		traceDown(T.getRoot(),0);

	}	

}
