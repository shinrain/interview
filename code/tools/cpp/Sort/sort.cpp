#include<iostream>
#include<cmath>
#include "insert_sort.cpp"
using namespace std;


int main(){
        int N = 20;
        int a[20];

        for(int i=0; i<N; i++){
                a[i] = rand()%N;
                cout<<a[i]<<" ";
        }
        cout<<endl;


	// Insert search algorithm here
        insert(a,N);

	// END here


        for(int i = 0; i<N; i++)
                cout<<a[i]<<" ";

        cout<<endl;

}

