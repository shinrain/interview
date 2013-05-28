package BST;

public class BST{
	node root;
	
	public	 BST(){
		root = null;
	}

	public BST(node N){
		root = N;
	}

	public node getRoot(){ return root;}


	private node find_recur(node N, int key){
		if(N == null || N.getVal() == key) return N; 
		if(key<N.getVal()) return find_recur(N.getLeft(), key);
		else return find_recur(N.getRight(),key);	
	}

	public node find(int key){

	// Result from recursive approach
		node re = find_recur(root, key);

	//Iterative approach way

		boolean found = false;
		node cur = root;

		while(cur!=null && !found){
	//	if(false){	
			if(cur.getVal() == key) found = true;
			else if(cur.getVal() > key) cur = cur.getLeft();
			else cur = cur.getRight();
		}
		
		if( re != cur){
			System.out.println("Two results do not match. BST has error!!");
			return null;
		}
		
		return re;
	}
	
	private void insertRecurSub(node N, int key){
		if(N == null) root = new node(key);
		
		if(key <= N.getVal())
			if(N.getLeft() == null) N.setLeft(new node(key));
			else insertRecurSub(N.getLeft(), key);
		else{
			if(N.getRight() == null) N.setRight(new node(key));
			else insertRecurSub(N.getRight(),key);
		}
	}
	
	public void insertRecur(int key){
		insertRecurSub(root, key);
	}

	public void buildBST(int[] a){
		if(a==null) root = null;
		
		root = new node(a[0]);
		
		for(int i = 1; i< a.length; i++)	insert(a[i]);
	}
	
	public void insert(int key){
		if(root == null){
			root = new node(key);
			return;
		}

		node par = null;
		node cur = root;

		while(cur != null){
			par = cur;			
			if(key <= cur.getVal())	cur = cur.getLeft();
			else cur = cur.getRight();
		}

		if(key <= par.getVal()) par.setLeft(new node(key));
		else par.setRight(new node(key));
	}

	public node getNext(node N){
		if(N == null || N.getRight() == null){
			System.out.println("Error in searching next biggest.");
			return null;		
		}
		node cur = N.getRight();
		node par = N;
		while(cur.getLeft() != null){ par = cur; cur = cur.getLeft(); }
		if(cur == N.getRight()){
			return cur;
		}
		if(cur.getRight() != null){
			par.setLeft(cur.getRight());
			cur.setRight(N.getRight());
			return cur;
		}else{
			par.setLeft(null);
			cur.setRight(N.getRight());
			return cur;
		}
	}

	public boolean delete(int key){
		node par = null;
		node cur = root;
		boolean left = true;
		while(cur!=null){
			if(key == cur.getVal()) break;
			par = cur;
			if(key<cur.getVal()){	left = true; cur = cur.getLeft();}
			else{	left =false; cur = cur.getRight();}
		}
		
		if(cur == null) return false;
		System.out.println("Found value is "+ cur.getVal()+", the parent is "+par.getVal());		
		if(cur.getLeft() == null && cur.getRight() == null){
			if(cur == root){
				root = null;
			}
			else{
				if(left) par.setLeft(null);
				else par.setRight(null);
			}
		}
		else if(cur.getLeft() == null){
			if(!left)	par.setRight(cur.getRight());
			else	par.setLeft(cur.getRight());
		}else if(cur.getRight() == null){
			if(left)
			par.setLeft(cur.getLeft());
			else par.setRight(cur.getLeft());	
		}else{
			node can = getNext(cur);
			if(left) par.setLeft(can);
			else par.setRight(can);
			can.setLeft(cur.getLeft());
			
		}
	
		return true;

	}

	public void preOrder(node N){}

	private void inOrderSub(node N){
		if(N == null) return;
		inOrderSub(N.getLeft());
		System.out.print(N.getVal()+" ");
		inOrderSub(N.getRight());
	}
	
	public void inOrder(){
		inOrderSub(root);
		System.out.println();

	}

	public void postOrder(node N){}

	public void preOrderIter(node N){}

	public void inOrderIter(node N){}

	public void postOrderIter(node N){}

	public void printTreeShape(){}

	public void printByLevel(){}

	public void printZigZag(){}

	public void printEdge(){}

	public void BST2List(){}

	public void List2BST(){}

	public void BalancingTree(){}

	public void reconstructBSTFromPreorder(int[] a){}

	public void reconstructBSTFromPostOrder(int[] a){}

	public void reconstructTreeFromPreInorder(int[] a, int[] b){}

	public void reconstructTreeFromPostInorder(int[] a, int[] b){}	

	public boolean checkBST(){return true;}
}
