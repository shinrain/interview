#include<iostream>
#include<stdlib.h>
using namespace std;

void func(char*a, int n, int l, int r){
	if(l<r) return;
	if(l+r == n)
		if(l!=r) return;
		else{
			for(int i=0;i<n;i++)
				cout<<a[i];
			cout<<endl;
		}
	else{
		if(l==n){
			a[l+r] = '(';
			func(a, n,l+1, r);
		}
		else{
			a[l+r] = '(';
			func(a, n,l+1, r);
			a[l+r] = ')';
			func(a, n,l, r+1);
		}
	}
}

int main(){
		int n = 3;
		char a[2*n];
		func(a, 2*n,0, 0);
		return 0;
}
