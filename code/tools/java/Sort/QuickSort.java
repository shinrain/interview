package Sort;

public class QuickSort{

	static int partition(int[]a , int left, int right){
        //      System.out.println("Enter Here"+left+" "+right);
                int n = a.length;
                if(right<left || left<0 || right>=n) return -1;

                int p = a[left];

                int l = left-1;
                int r = right +1;

                while(l<=r){
                        while(++l<r && a[l]<=p);

                        while((--r)>l && a[r]>p);
                        if(l>r)  break;

                        int tmp = a[l];
                        a[l] = a[r];
                        a[r] = tmp;
                }

                int tmp = a[r];
                a[r] = a[left];
                a[left] = tmp;
                return r;
        }


        static void subqsort(int[] a, int left, int right){
                int p = partition(a,left, right);
                if(p==-1)       return;

//              System.out.println("Partition at "+p);

                subqsort(a,left,p-1);
                subqsort(a,p+1,right);

        }

	        public static void sort(int[] a){
                subqsort(a,0,a.length-1);

        }



}
