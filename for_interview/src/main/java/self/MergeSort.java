package self;


/**
 * 两数组归并排序
 *
 *  数组A：“1，7，9，11，13，15，17，19”；
 *  数组b：“2，4，6，8，10” ；
 *  两个数组合并为数组c，按升序排列
 *
 */
public class MergeSort {
    public static void main(String[] args) {
        int[]  a= {1,7,9,11,13,15,17,19};
        int[] b = {2,4,6,8,10};
        //调用printArray方法，并将merge方法的返回值传给printArray
        printArray(merge(a, b));

    }

    /**
     *
     * @param a：a数组
     * @param b：b数组
     * @return c：c数组
     */
    public static int[] merge(int[] a,int [] b) {

        int[] c = new int[a.length+b.length];
        //i用于标记数组a
        int i=0;
        //j用于标记数组b
        int j=0;
        //用于标记数组c
        int k=0;

        //a，b数组都有元素时
        while(i<a.length && j<b.length) {
            if(a[i]<b[j]) {
                c[k++] = a[i++];
            }else {
                c[k++] = b[j++];
            }
        }

        //若a有剩余
        while(i<a.length) {
            c[k++] = a[i++];
        }

        //若b有剩余
        while(j<b.length) {
            c[k++] = b[j++];
        }

        return c;

    }

    //打印数组
    public static void printArray(int[]  arr) {
        for(int i:arr) {
            System.out.print(i+ "  ");
        }
    }



}

