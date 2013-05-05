using namespace std;


void insert(int* a, int n){
	if(!a) return;
	if(n<=0) return;

	for(int i = 1; i<n; i++){
		int p = a[i];
		int j = i-1;
		while(j>=0 && a[j]>p){
			a[j+1] = a[j];
                      j--;
		}
		a[j+1] = p;
	}

	return;
}

