import java.util.*;


class run{

	static boolean checkLetter(char character){
		return (((character >= 'a') && ( character <= 'z')) || ((character >= 'A') && (character <= 'Z')));

	}

	
	static boolean validatePalindrome(String str){
		char[] a = str.toCharArray();
		int n = a.length;

		if(n<=0) return true;

		int l = -1;
		int r = n;
		while(++l<=--r){
			while(l<=r && !checkLetter(a[l])){l++;}
			if(l>r) break;

			while(l<=r && !checkLetter(a[r])){r--;}
			if(l>r) break;

                        int tmp_l, tmp_r;

			if(a[l] > 'Z') tmp_l = a[l] - 'a';
			else		tmp_l = a[l] - 'A';
			if(a[r] > 'Z') tmp_r = a[r] - 'a';
                        else            tmp_r = a[r] - 'A';


			if(tmp_l!=tmp_r){
				 return false;
			}
		}
		return true;
	}

	public static void main(String[] args){

		String str = "A man, a plan, a canal: Panama";

		if(validatePalindrome(str)) System.out.println("Yes");
        	else System.out.println("false");
	}

}
