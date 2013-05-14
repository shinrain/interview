import java.util.*;
import java.lang.Math;

class run{

	static int[][] b;

	static int N = 10;
	

	static void propagate(int[][] a, int i, int j){
		if(i<0 || i>9 || j<0 || j>9 || a[i][j] == 0) return;
		if(b[i][j] == 1) return;
		b[i][j] = 1;
		propagate(a,i-1,j);
		propagate(a,i+1,j);
		propagate(a,i,j-1);
		propagate(a,i,j+1);
		return;
	}
	

	static void Capture(int[][] a){
		if(a == null) return ;
		int i, j;

		for(i=0;i<N;i++)
			for(j=0;j>N;j++)
				b[i][j] =2;

		for( i=0,j=0; i<N; i++){
			b[i][j] = a[i][j];
			if(b[i][j] == 1){
				propagate(a,i-1,j);
				propagate(a,i+1,j);
				propagate(a,i,j-1);
				propagate(a,i,j+1);
			}
		}
		for( i=0, j =0; j<N; j++) {
			b[i][j] = a[i][j];
			if(b[i][j] == 1){
				propagate(a,i-1,j);
				propagate(a,i+1,j);
				propagate(a,i,j-1);
				propagate(a,i,j+1);
			}
		}
		for( i=N-1,  j =0; j<N; j++){
			b[i][j] = a[i][j];
			if(b[i][j] == 1){
				propagate(a,i-1,j);
				propagate(a,i+1,j);
				propagate(a,i,j-1);
				propagate(a,i,j+1);
			}
		}
		for( i=0,  j = N-1; i<N; i++){
			 b[i][j] = a[i][j];
			if(b[i][j] == 1){
				propagate(a,i-1,j);
				propagate(a,i+1,j);
				propagate(a,i,j-1);
				propagate(a,i,j+1);
			}
		}
		
		return;
	}

	public static void main(String[] args){
		int[][] a = new int[N][N];
		for(int i =0; i<N; i++)
			for(int j=0; j<N; j++)
				a[i][j] = (int)(Math.random()+0.5)/1;
				
		System.out.println("The input Matrix is:");
		for(int i =0; i<N; i++){
			for(int j=0; j<N; j++){
				char f;
				if(a[i][j] ==0 ) f ='x';
				else f = 'o';
				System.out.print(f+" "); 
			}
			System.out.println();
		}

		b = new int[N][N];
		Capture(a);
		System.out.println("The output Matrix is:");
		for(int i =0; i<N; i++){
			for(int j=0; j<N; j++){
				char f;
				if(b[i][j] ==0 ) f ='x';
				else f = 'o';
				System.out.print(f+" "); 
			}
			System.out.println();
		}
	}


}
