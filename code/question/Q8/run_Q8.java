class run{


	// Global shortest length of transformation

	static char[] letter = {'a',...,'z'};

	

	// length of transformed word
	static int N = 0;

	// Return true is a is a word; false if not.
	static boolean validateWord(char[] a);

	// Check equality of two words.	
	static boolean Equal(char[] m, char[] n);	
	
	static void findTransform(char[] m, char[] n){

		Queue<char[]> Q = new Queue<char[]>();
		Hashset<char[]> map = new Hashset<char[]>();
		Q.push(m);

		int count = 1; 		// use to identify if the current layer is done.

		ArrayList<char[]> re = new ArrayList<char[]>();

		// Define one more field: pre which is the pre word for current words.
		m.pre = null;
		boolean found = false;
		char[] word = null;
		while(!Q.isEmpty()){
			if(count == 0 && !found) count = Q.size();
			word = Q.pop();
			count --;
			if(word == n) { 
				found = true; 
				re.add(word); 
				if(count >0)	continue;
				else break;
			}
			map.add(word);
			char[] tmp = word;		
			for(int i = 0; i<N; i++){
				for(int j =0; j<26;j++){
					if(tmp[i] == letter[j]) continue;

					tmp[i] = letter[j];
					if(validateWord(tmp) && !map.hasKey(tmp)){

						tmp.pre = word;
						Q.push(tmp);
					}
				}
			}
		}

		if(!found){
			System.out.println("No routine");
			return;
		}
		for(word : re)
			if(word == null) return;
			else	printSequence(word);
	}

	static void printSequence(char[] word){
			print(word);
	}

	static void print(char[] word){
			if(word.pre != null) print(word.pre);
			print(word);
	}


}
