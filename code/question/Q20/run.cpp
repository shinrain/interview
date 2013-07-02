#include<iostream>

using namespace std;

char* a[9];



int size[] = {0,3,3,3,3,3,4,3,4};

void init(){
	a[0] =NULL;
	a[1] = 	new char[3];
	a[1][0] = 'a';
	a[1][1] = 'b';
	a[1][2] = 'c';
	
	a[2] =	new char[3];
	a[2][0] = 'd';
	a[2][1] = 'e';
	a[2][2] = 'f';
	
	a[3] = new char[3];
	a[3][0] = 'g';
	a[3][1] = 'h';
	a[3][2] = 'i';
	
	a[4] = new char[3];
	a[4][0] = 'j'; 	
	a[4][1] = 'k';
	a[4][2] = 'l';
	
	a[5] = 	new char[3];
	a[5][0] = 'm';
	a[5][1] = 'n';
	a[5][2] = 'o';
	
	a[6] = 	new char[4];
	a[6][0] = 'p';
	a[6][1] = 'q';
	a[6][2] = 'r';
	a[6][3] = 's';

	a[7] = new char[3];
	a[7][0] = 't';
	a[7][1] = 'u';
	a[7][2] = 'v';
	
	a[8] =	new char[4];
	a[8][0] ='w';
	a[8][1] ='x';
	a[8][2] ='y';
	a[8][3] ='z';


}

void func(int* c, int n){
	int b[n];
	int l = n-1;
	cout<<l<<endl;
	for(int i=0;i<n;i++)
		b[i] =0;
	b[n-1] = -1;
	while(true){
		while(l>=0 && b[l] >= size[c[l]]-1){
			b[l--] = 0;
		}
		if(l<0) break;
		b[l]++;
		for(int i=0;i<n; i++)

			cout<<*(*(a+c[i])+b[i]);
		
		l = n-1;
		cout<<endl;	
		
	}

}

int main(){
	init();
	int c[] = {2,3};
	func(c,2);
	return 0;

}
