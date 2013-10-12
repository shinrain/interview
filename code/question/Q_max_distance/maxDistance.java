import java.util.*;
import java.lang.*;

class run{
	static int exec(int[] arr){
		Stack<Integer> s = new Stack<Integer>();

		for(int i=0;i<arr.length;i++){
			if(s.isEmpty() || arr[i]<arr[s.peek()])
				s.push(i);
		}

		int j = arr.length-1;
		int k = -1,  result =0;
		while(j>=0 && !s.isEmpty()){
			while(!s.isEmpty() && arr[j]>arr[s.peek()]){
				k = s.peek();
				s.pop();
			}
			System.out.format("j = %d, k = %d\n",j,k);
			if(s.isEmpty())
				return j-k;
			if(j-k+1>result)
				result = j-k;
			j--;
			k=j;

		}
		return -1;

	}

	public static void main(String[] args){
		String s = args[0];
		char[] ss = s.toCharArray();
		int[] arr = new int[ss.length];
		for(int i=0; i< ss.length; i++){
			arr[i] = Character.getNumericValue(ss[i]);
						System.out.format("ss[i] = %c, arr[i] = %d\n",ss[i],arr[i]);

		}
		System.out.println(exec(arr));
	}
}