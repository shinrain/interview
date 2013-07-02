#include<iostream>
#include<stdlib.h>
using namespace std;

int func(int a, int b){
	if(b==0) { cout<< "b == 0\n";	exit(-1);}
	if(a == 0) return 0;
	bool neg = false;
	if((a<0 && b>0)||(a>0 && b<0))	{
			neg = true;
			if(a<0) a = 0-a;
			if(b<0) b = 0-b;
	}
	int res = 0, ckSume = b, count = 1;

	while(a>= ckSume || count>1){
		if(a>=ckSume){
			a -= ckSume;
			res+=count;
			count = count+count;
			ckSume = ckSume +ckSume;
		}else{
			count>>=1;
			ckSume >>=1;
		}
	}
	return (neg)?(0-res):res;
}

int main(){
	cout<<"Input a:\n";
	int a;
	cin>>a;
	cout<<"Input b:\n";
	int b;
	cin>>b;
	cout<<"The resule is: "<<func(a,b)<<endl;
	return 0;
}
