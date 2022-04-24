package self;

public class DumpSort {
    public static void main(String[] args) {
        int[] arr ={3,5,12,6,8,98,4,45,61};

        buildDump(arr);

        //adjustDump(arr,0);
        for (int i : arr) {
            System.out.println(i);
        }
    }

    private static void buildDump(int[] arr) {
        int len = arr.length;

        for (int j = (len-1-1)/2; j >= 0; j--) {
            adjustDump(arr,j);
        }
    }

    public static int[] dumpSort(int[] arr,int n ,int k){
        return null;
    }



    public static void adjustDump(int[] arr,int k){

        int n = arr.length;
        if((n-1-1)/2 < k){
            return;
        }

        int maxIndex = k;
        if(2*k+1<=n-1 && arr[2*k+1] >arr[maxIndex]){
            maxIndex=2*k+1;
        }

        if(2*k+2<=n-1 && arr[2*k+2] >arr[maxIndex]){
            maxIndex=2*k+2;
        }

        if(maxIndex != k){
            swap(arr,maxIndex,k);
            //现在 maxIndex 是 2*k+1 或者  2*k+2
            adjustDump(arr,maxIndex);
        }

    }

    private static void swap(int[] arr, int k, int i) {
        int tmp = arr[k];
        arr[k]=arr[i];
        arr[i]=tmp;
    }


}
