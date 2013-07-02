#include<iostream>


using namespace std;

int func(int* a, int n, int val){
	if(n<=0 || !a)	return -1;
	int l = 0, r = n-1;

	while(l<=r){
		cout<<"Search range: "<<l<<", "<<r<<"\n";
		int mid = l +(r-l)/2;
		if(val == a[mid]) return mid;
		else if(val < a[mid]){
			if((val <a[r]))	l = mid+1;
			else if(val == a[r]) return r;
			else	r = mid-1;
		}
		else{
			if(val > a[l]) r = mid-1;
			else if(val == a[l]) return l;
			else	l = mid+1;
		}
	}
	return -1;
}


int main(){
	int a[] = {5,6,7,8,9,0,1,2,3};
	for(int i = 0;i <8; i++)
		cout<<a[i]<<" ";
	cout<<endl;
	cout<< "To find:\n";
	int val;
	cin>>val;
	cout<<"\n"<<func(a,8,val)<<endl;
	
	return 0;
}
