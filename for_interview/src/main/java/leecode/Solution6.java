package leecode;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Objects;

public class Solution6{

    /**
     *输入：s = "PAYPALISHIRING", numRows = 4
     * 输出："PINALSIGYAHRPI"
     * 解释：
     * P     I    N
     * A   L S  I G
     * Y A   H R
     * P     I
     *
     * i10->>
     * x:4-> y:2
     */
    // 根据坐标 得到字符串下标

    public int getIndex(int x,int y , int numRows){

        int i;
        int base = (x-1)/(numRows-1);
        int tmp = (x-1)%(numRows-1);


        i=base*(2*(numRows-1));

        if(base%2==0){


        }else {


        }
        return i;
    }


    public static void main(String[] args) {

       String s = "PAYPALISHIRING"; int numRows = 4;

        String convert = new Solution6().convert3(s, numRows);

        System.out.println(convert);

       // System.out.println( new Solution6().getIndex(6,1,4));

    }

    public String convert2(String s, int numRows) {

        String fill = " ";
        StringBuilder sb = new StringBuilder();

        int x =(numRows-1)*(1+s.length()/(2*(numRows-1)));

        for(int j = 0;j<numRows;j++) {
            for (int i = 0; i <= x; i++) {

                if( (i%(numRows-1)==0 && 0<=j && j<=numRows-1)
                                            ||(i+j)%(numRows-1)==0){
                    sb.append(getIndex(i,j,numRows));
                }else {
                    sb.append(fill);
                }

        //        sb.append(map.get(t) != null ? map.get(t) : fill);

            }
            sb.append("\n\r");
        }

        return sb.toString();



    }
    public String convert4(String s, int numRows) {
        if(numRows < 2) return s;
        List<StringBuilder> rows = new ArrayList<StringBuilder>();
        for(int i = 0; i < numRows; i++) rows.add(new StringBuilder());
        int i = 0, flag = -1;
        for(char c : s.toCharArray()) {
            rows.get(i).append(c);
            if(i == 0 || i == numRows -1) flag = - flag;
            i += flag;
        }
        StringBuilder res = new StringBuilder();
        for(StringBuilder row : rows) res.append(row);
        return res.toString();


    }
    public String convert3(String s, int numRows) {
        if(numRows < 2) return s;
        List<StringBuilder> rows = new ArrayList<StringBuilder>();
        for(int i = 0; i < numRows; i++) rows.add(new StringBuilder());
        int i = 0, flag = -1,j=0,flag2 = -1;
        for(char c : s.toCharArray()) {
            StringBuilder rowi = rows.get(i);
            rowi.append(c);
            if(flag2==-1){
                if(++j==numRows){
                    flag2=1;j=0;
                }
            }else {
                rows.stream().filter(row -> row !=rowi).forEach(row -> row.append(" "));
                if(++j==numRows-2){
                    flag2=-1;j=0;
                }
            }

            if(i == 0 || i == numRows -1) flag = - flag;
            i += flag;
        }

        StringBuilder res = new StringBuilder();
        for(StringBuilder row : rows) res.append(row+"\n\r");
        return res.toString();
    }



    public String convert(String s, int numRows) {
        String fill = " ";
        StringBuilder sb = new StringBuilder();
        Hashtable map = new Hashtable<>();
        int tmp11 = (numRows-1)*2;

        for(int i = 0 ;i<s.length();i++){
            int a=i/(2*(numRows-1));int b= i%(2*(numRows-1));  int x,y;

            if(b<=numRows-1){
                x=a*(numRows-1);
                y=b;
            }else {
                int tmp = b - (numRows -1);
                x = a*(numRows-1)+tmp;
                y = numRows-1 - tmp;
            }

            System.out.println("i"+i +"->>\n\r"+"x:"+x+"->"+" y:"+y);
            map.put(new tuple(x,y),s.charAt(i));
        }

        int x =(numRows-1)*(1+s.length()/(2*(numRows-1)));

        for(int j = 0;j<numRows;j++) {
            for (int i = 0; i <= x; i++) {
                tuple t = new tuple(i, j);
                sb.append(map.get(t) != null ? map.get(t) : fill);
            }
            sb.append("\n\r");
        }

        return sb.toString();
    }


    class tuple {
        int i;
        int j;

        public tuple(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof tuple)) return false;
            tuple tuple = (tuple) o;
            return i == tuple.i && j == tuple.j;
        }

        @Override
        public int hashCode() {
            return Objects.hash(i, j);
        }
    }
}