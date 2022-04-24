package self;

public class MaxSeqSum {
    public static void main(String[] args) {

        int[] t= {3,-4,2,-1,2,6,-5,4};

        getMaxsumSeq(t);
    }

    public static int[] fill;

    public static int[] getMaxsumSeq(int[] t){
        fill = new int[t.length];

        for(int i= t.length-1;i>=0;i--){
            fill[i] = lmax(i,t);
        }

        int max=0;
        for(int i=0;i<fill.length;i++){
            max= max>fill[i]?max:fill[i];
        }

        System.out.println(max);

        return null;
    }


    // 从 index出发 的最大值
    public static int lmax(int index, int[] t){
        if(index == t.length-1){
            return t[t.length-1];
        }
        return fill[index+1]>0? fill[index+1]+t[index]: t[index];
    }




}
