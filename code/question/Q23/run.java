import java.util.*;




class run{
	
	static void func(String s){
		char[] a = s.toCharArray();
		int n = a.length;
		
		int x=0, y = 0;

		while(x<n && a[x]!='x') x++; 
		if(x>=n) return;
	
		y=x;
		while(y<n){
			while(y<n && a[y]=='x') y++;
			if(y>=n) return;
			a[x++] = a[y++];
		}


		x--;
		y = n-1;
		while(x>=0){
			a[y] = a[x];
			if(a[x] == 'z'){
				a[--y] = 'z';
			}
			x--;
			y--;

		}
		for(char c:a)
			System.out.print(c);
		System.out.println();
	}


	public static void main(String[] args){
		String s = "axbzh";
		func(s);
	}

}
