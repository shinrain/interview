import java.util.*;
import java.lang.Math;

class node{
	int s;
	int p;

	node(int s, int p){
		this.s = s;
		this.p = p;
	}	

}

class run{
	
	static void longConsec(int[] a){
		if(a == null) return;

		HashMap<Integer, node> map = new HashMap<Integer, node>();
		
		for(int i:a){
			map.put(i,new node(-1,-1));
		}

		for(int i:a){
			int s = i-1;
			int p = i+1;
			if(map.containsKey(i-1)) p = i-1;
			if(map.containsKey(i+1)) s = i+1;
			map.put(i, new node(s,p));
		}

		int start = 0;
		int end = 0;
		for(int i:a){
			if(!map.containsKey(i)) continue;
			int st = 0;
			int en = 0;
			int num = i;
			while(map.get(num).p<num){
				if(num!=i) map.remove(num);
				num--;
			}	
			st = num;
			if(num!=i) map.remove(num);

			num = i;
			while(map.get(num).s>num){
				if(num!=i) map.remove(num);
				num++;
			}
			en = num;
			if(num!=i) map.remove(num);
			map.remove(i);
			if(en-st > end - start){
				start = st;
				end = en;		
			}	
		}
		System.out.println("The length is "+ (end - start+1));
		for(int i = start; i<=end;i++)		
			System.out.print(i+" ");
		System.out.println();
	}

	public static void main(String[] args){
		int[] a = {100, 4, 200, 1, 3, 2,0,-1};
		longConsec(a);

	}	




}
