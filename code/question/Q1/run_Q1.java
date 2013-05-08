import java.util.*;
import java.lang.Math.*;


// Customized Tree for sorting ending times and count how many ending times are earlier than inserted one to compute the racer's score.
// Insertion is O(nlgn)

class node{
	int val;
	int below;
	node left;
	node right;
	node(int val){this.val = val; left = right = null; below = 0;}
}
class Tree{
	node root;
	
	Tree(){root = null;}

	int insert(int val){
		node N = root;
		if(N == null){
			root = new node(val);
			return 0;
		}
		int score = 0;
		node par = null;
		while(N!=null){
			if(val <= N.val){
				N.below++;
				par = N;
				N = N.left;
			}else{
				N.below++;								
				if(N.left == null) score++;
				else score += 2+N.left.below;
				par = N;
				N = N.right;
			}
		}
		if(val <= par.val){
			node nd = new node(val);
			par.left = nd;
			return score;
		}
		else{
			node nd = new node(val);
			par.right = nd;
			return score;
		}

	}

}

// racer class, to store the start and ending time for each racer

class racer{
	double start;
	double end;

	
	racer(double a, double b){
		start = a; end = b;	
	}

        // This function is helper function to create racer, since if start == end is not allowed.

	static racer genRacer(double a, double b){
		if(a < b) return new racer(a,b);
		else if(a > b) return new racer(b,a);
		return null;
	}

        // Comparison function, used in racer array sorting function accoring to starting time

	static boolean less(racer a, racer b){
		return (a.start <= b.start);
	}

        // Quick Sort for racer class, using comparison function above

	static int partition(racer[]a , int left, int right){

                int n = a.length;
                if(right<left || left<0 || right>=n) return -1;

                racer p = a[left];

                int l = left-1;
                int r = right +1;

                while(l<=r){
                        while(++l<r && less(a[l], p));

                        while((--r)>l && less(p, a[r]));
                        if(l>r)  break;

                        double tmp = a[l].start;
                        a[l].start = a[r].start;
                        a[r].start = tmp;

			tmp = a[l].end;
                        a[l].end = a[r].end;
                        a[r].end = tmp;
                }

               double tmp = a[left].start;
               a[left].start = a[r].start;
               a[r].start = tmp;

		tmp = a[left].end;
                a[left].end = a[r].end;
                a[r].end = tmp;
                return r;
        }


        static void subqsort(racer[] a, int left, int right){
                int p = partition(a,left, right);
                if(p==-1)       return;

//              System.out.println("Partition at "+p);

                subqsort(a,left,p-1);
                subqsort(a,p+1,right);

        }

	public static racer[] sort(racer[] arr){
		int N = arr.length;
		if(N<=0) return null;
  		subqsort(arr,0,arr.length-1);
		return arr;
	}

        // Print racer's time virtually

	public static void printRace(racer[] arr){
		int tt=0;
		for(racer i : arr){
			System.out.print("#"+(tt++)+":");
			int start = (int)(i.start*100);
			int end = (int)(i.end*100);
			for(int j =0; j<start; j++) System.out.print(" ");
			System.out.print("[");
			for(int j =0; j<end-start; j++) System.out.print("-");
			System.out.print("]");
			System.out.println();
		}


	}


}

// class to run this algorithm

class run{

        // Generate racers with random starting and ending times

	static racer[] genRace(int N){
		if(N <=0) return null;
		
		racer[] re = new racer[N];		

		for(int i = 0; i<N; i++){
			racer R = racer.genRacer(Math.random(), Math.random());
			while(R == null) R = racer.genRacer(Math.random(), Math.random());
			re[i] = R;
			System.out.print("( "+ R.start+", "+R.end+" ),  ");
		}
		System.out.println();
		return re;
	} 

        // Main function

	public static void main(String[] args){
		int N = 20;
		racer[] race = genRace(N);
		race = racer.sort(race);
	

		racer.printRace(race);

		Tree T = new Tree();

                // Insert into Tree and print out score

		for(int i = N-1; i>=0; i--){
			System.out.println("#"+i+" score is "+ T.insert((int)(race[i].end*100)));
		}
		
		
	}
}

