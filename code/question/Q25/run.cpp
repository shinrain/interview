#include<iostream>

using namespace std;

bool set(char* arr, int size, int bit){
        if(bit>= size*8)
        	return false;

        int loc = bit/8;
        int bloc = bit%8;

        arr[loc] |= (1<<bloc);
        return true;
}

bool get(char* arr, int size, int bit){
        if(bit>= size*8)        return false;
        int loc = bit/8;
        int bloc = bit%8;
        return ((arr[loc]>>bloc)&1) == 1;

}

void printPrime(int N){
        if(N<=1) return;

        char* arr = new char[N/8+1];
        int size = N/8+1;

        for(int i = 2; i<N; i++){
                if(!get(arr,  size, i)){
                        cout<< i<<" ";
                        int sum = i*i;
                        while(sum<N){
                                if(!set(arr, size, sum)) exit(-1);
                                sum+=i;
                        }
                }
        }

}

int main(){
        int N = 100;
        printPrime(N);
        return 0;
}

