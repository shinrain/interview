#include<iostream>
#include<cstring>
using namespace std;


void preCompute(string p, int* F){
	int n = p.length();
	F[0] = F[1] = 0;
		cout<<"OK\n";
	for(int i =2; i<=n; i++){
		int j = F[i-1];
		while(true){
			if(p[j] == p[i-1]){
				F[i] = j+1;
				break;
			}
			if(j == 0){
				F[i] = 0;
				break;			
			}
			j = F[j];
		}

	}

}

void match(string s, string p, int* F){
	int m = p.length();
	int n = s.length();

	int i = 0;
	int j = 0;

	while(true){
		while(i<n && j<m && s[i] == p[j]){
				i++; j++;
		}
	
		if(i == n){cout<<"Search done\n"; return;}
		if(j == m){cout<<"found at "<<i-m<<endl;return;}		
		if(j>0) j = F[j];
		else i++;	
	}
		

}

void KMP(string s, string p){
	int m = p.length();
	int n = s.length();

	if(m == 1){
		cout<<"m = "<<m<<endl;
		for(int i=0;i<n;i++)
			if(s[i]==p[0]){
				cout<<"Found: "<<i<<endl;
				return;
			}
		cout<<"Not found\n";
		return;
	}	
	else{

		int* F = new int[m+1];
		cout<<"OK\n";
		preCompute(p, F);

		match(s,p,F);
	}
}


int main(){
	string s = "abcdefg";
	string p = "bcd";

	KMP(s,p);
	return 0;
}
