package BST;

public class node{
	int val;
	node left;
	node right;
	int id;
	static int seq;

	public	node(){
		int val = -1;
		left = right = null;
		id = -1;	
	}
	
	public node(int val){
		this();
		this.val = val;
		id = ++seq;
	}

	public 	void setLeft(node N){this.left = N;}

	public void setRight(node N){this.right = N;}

	public void setVal(int val){this.val = val; if(id == -1) id = ++seq;}

	public int getVal(){return val;}

	public node getRight(){return right;}
	
	public node getLeft(){return left;}
	
	public int getId(){return id;}

	public static int getTotal(){return seq;}
	
}

