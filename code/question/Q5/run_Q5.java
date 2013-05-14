import java.util.*;
import java.lang.Math;

class run{

	static int[][] b;

	static int N = 10;
	
	static boolean check(int i, int j){
		if(i<0 || i>9 || j<0 || j>9 || b[i][j] == 0) return false;
		return true;
	}
	
	static boolean checkSurround(int i, int j){
			if(b[i][j]!=2) return b[i][j]==1;
			else{
				if(!check(i-1,j) && !check(i+1,j) && !check(i,j-1) && !check(i,j+1)) return false;
				return true;
			}

	}

	static void Capture(int[][] a){
		if(a == null) return ;
		int i, j;

		for(i=0;i<N;i++)
			for(j=0;j>N;j++)
				b[i][j] =2;

		for( i=0,j=0; i<N; i++)	b[i][j] = a[i][j];
		for( i=0,  j =0; j<N; j++) b[i][j] = a[i][j];
		for( i=N-1,  j =0; j<N; j++) b[i][j] = a[i][j];
		for( i=0,  j = N-1; i<N; i++) b[i][j] = a[i][j];

		for( i =1; i<N-1; i++)
			for( j =1; j<N-1; j++)
				if(a[i][j] == 1 && check(i,j))
					b[i][j] = 1;
				else 
					b[i][j] = 0;
		return;
	}

	public static void main(String[] args){
		int[][] a = new int[N][N];
		for(int i =0; i<N; i++)
			for(int j=0; j<N; j++)
				a[i][j] = (int)(Math.random()+0.5)/1;
				
		System.out.println("The input Matrix is:");
		for(int i =0; i<N; i++){
			for(int j=0; j<N; j++)
				System.out.print(a[i][j]+", "); 
			System.out.println();
		}

		b = new int[N][N];
		Capture(a);
		System.out.println("The output Matrix is:");
		for(int i =0; i<N; i++){
			for(int j=0; j<N; j++)
				System.out.print(b[i][j]+", "); 
			System.out.println();
		}
	}


}
