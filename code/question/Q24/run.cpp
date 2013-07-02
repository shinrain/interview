#include<iostream>
#include<map>
using namespace std;

int main(){
	char a[] = {'a','a','b','b','c','b','b','b','a','d','e','f'};
	int n = 12;
	map<char, int> mm;
	map<char, int>::iterator it;
	int re = 0;
	int start = 0;
	
	int i=0;
	int j=1;
	mm[a[i]] = 1;
	while(j<n){
		cout<<j<<endl;
		it = mm.find(a[j]);
		if(it == mm.end())
			if(mm.size()<2){
				
				mm[a[j]] = 1;
				j++;
				continue;
			}
			else{
				if((j-i)>re){
					start = i;
					re = j-i;
				}
				while(i<=j){
					it = mm.find(a[i]);
					it->second--;
					if(it->second ==0){
						mm.erase(a[i]);
						mm[a[j]] = 1;
						i++;
						break;
					}
					i++;
				}
				j++;
			}
		else{
			it->second++;
			j++;
			
		}
	}
	if((j-i)>re){
			start = i;
			re = j-i;
	}
	for(int ii = start; ii<start+re;ii++)
			cout<<a[ii];
	cout<<endl;
	return 0;
	
}
