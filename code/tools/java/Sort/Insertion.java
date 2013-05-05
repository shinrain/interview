package Sort;

public class Insertion{

        static void Insertion(int[] a){
                int n = a.length;
                if(n<=0) return;

                for(int i=1; i<n; i++){
                        int p = a[i];
                        int j = i;
                        while(--j>=0 && a[j]>=p)        a[j+1] = a[j];
                        a[j+1] = p;
                }
        }

}
