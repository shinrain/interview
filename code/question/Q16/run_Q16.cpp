#include<iostream>
#include<algorithm>

using namespace std;

void f(int a[], int n){
	for(int i=0; i<n; i++){
		while(a[i]<n && a[i]>=0 && a[i]!=i && a[i]!=a[a[i]])
			swap(a[i],a[a[i]]);
		for(int i=0;i<4;i++)
		cout<<a[i]<<" ";
		cout<<endl;
	}


}

int main(){
	int a[] = {2,3,3,-2,0};
	f(a,4);
	for(int i=0;i<4;i++)
		cout<<a[i]<<" ";
	cout<<endl;

}
