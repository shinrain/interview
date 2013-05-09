import java.util.*;

class run{


	static void palindString(String str){
		if( str == null) return;

		char[] st = str.toCharArray();

	// Check each single center

		// Global result 		
		int start = 0;
		int end = 0;
	
		for(int i=0; i<st.length; i++){
			int s = i;
			int e = i;
			while(e<st.length && s>=0 && st[s] == st[e]){ s--; e++;};
			
			if((e-s)>(end-start)){
				start = s;
				end = e;
			}
		}

	//  Check each pair of center
		


		for(int i=0; i<st.length-1; i++){
			int s = i+1;
			int e = i;
			while(e<st.length && s>=0 && st[s] == st[e]){ s--; e++;}
			
			if((e-s)>(end-start)){
				start = s;
				end = e;
			}
		}

		for(int i = start+1; i<end; i++) System.out.print(st[i]);
		System.out.println();
	}

	public static void  main(String[] args){
		String str = "abacdfgdcaba";
		
		palindString(str);
	}




}
