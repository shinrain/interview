#include<iostream>
#include<stdlib.h>
#include<algorithm>
using namespace std;

int func(int* a, int m, int* b, int n, int k){
	if(m+n<k) exit(-1);
	if(m+n == k) return max(a[m-1],a[n-1]);

	int l = max(0, k-n);
	int r = min(m, k);

	while(l<=r){
		int mid = l+(r-l)/2;
		if(mid-1< m && k-mid >=0 && a[mid-1] > b[k-mid]) r = mid;
		else if(mid<m && k-mid-1>0 && a[mid] < b[k-mid-1])	l = mid+1;
		else{
			l = mid-1;
			break;
		}

	}
	if(l==0)	return b[k-1];
	if(l==k)	return a[k-1];
	return max(a[l-1],b[k-l-1]);

}

int main(){
	int a[] = {0,2,4,6,8};
	int b[] = {1,3,5,7};
	int k;
	cin>>k;
	cout<<endl<<func(a,5,b,4,k)<<endl;
	return 0;
}
