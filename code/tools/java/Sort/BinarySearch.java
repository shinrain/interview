package Sort;

public class BinarySearch{
	static int subsearch(int[] a, int left, int right, int item){
                int n = a.length;
                if(right<left || left<0 || right>=n) return -1;

                int mid = left+(right-left)/2;
                if(a[mid] == item) return mid;
                if(a[mid]<item) return subsearch(a,mid+1, right, item);
                else return subsearch(a,left,mid-1,item);

        }


        static int search(int[] a, int item){
                return subsearch(a,0,a.length-1,item);
        }

}
