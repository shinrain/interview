import java.util.*;


class run{
	static class node{
		int s;
		int e;

		node(int s, int e){
			this.s = s;
			this.e = e;
		}
	}

	static int find(int[] a, int b){
		int n = a.length;
		int l = 0;
		int r = n-1;

		while(l<r){
			int mid = (l+r)/2;
			if(b==a[mid]) return mid;
			if(b > a[mid] )
				if(a[mid+1]>b) return mid;
				else{
					l = mid+1;
				}
			else	r = mid-1;
		}
		return l;
	
	}

	static void merge(node[] list, int[] start){
		ArrayList<node> l = new ArrayList<node>();
		int n = list.length;
		int i=0;
		while(i<n){
			System.out.println(i);
			int e = list[i].e;
			int ind = find(start, e);
			if(ind == i) {
				l.add(new node(list[i].s, e));				
				i++;

				continue;
			}
			int max = e;
			for(int j = i+1;j<=ind; j++){
				if(list[j].e > max) max = list[j].e;
			}
			l.add(new node(list[i].s, max));
			i = ind+1;
			System.out.println("end"+i);
		}
		for(node nd : l)
			System.out.print("["+nd.s+", "+nd.e+"] ");
		System.out.println();	
	}
	
	public static void main(String[] args){
		int[] s = {1,2,8,15};
		int[] e = {3,6,10,18};
		int n =4;
		node[] list = new node[n];
		for(int i=0;i<n; i++)
			list[i] = new node(s[i],e[i]);
		merge(list, s);

	}

}
