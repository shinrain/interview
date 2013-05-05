package Sort;
public class Bubble{

        static void bubble(int[] a){
                int n = a.length;
                if(n<=0) return;

                for(int i=1; i<n; i++){
                        for(int j = 0; j< n-i; j++){
                                if(a[j]>a[j+1]){
                                        int tmp = a[j];
                                        a[j] = a[j+1];
                                        a[j+1] = tmp;;
                                }
                        }

                }

        }

}
