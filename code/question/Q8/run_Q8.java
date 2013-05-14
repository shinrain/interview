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

		Q.push(m);

		// Define one more field: pre which is the pre word for current words.
		m.pre = null;

		char[] word = null;
		while(!Q.isEmpty()){
			word = Q.pop();
			if(word == n) break;
			char[] tmp = word;		
			for(int i = 0; i<N; i++){
				for(int j =0; j<26;j++){
					if(tmp[i] == letter[j]) continue;

					tmp[i] = letter[j];
					if(validateWord(tmp)){

						tmp.pre = word;
						Q.push(tmp);
					}
				}
			}
		}

		if(word == null) return;
		
		printSequence(word);

	}

	static void printSequence(char[] word){
			print(word);
	}

	static void print(char[] word){
			if(word.pre != null) print(word.pre);
			print(word);
	}


}
