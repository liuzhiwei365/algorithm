package base;

import java.util.ArrayList;
import java.util.List;


public class ForGeneric {
    public static void main(String[] args) {
        List<? extends Number> list1 = new ArrayList<Integer>();

       // List<? extends Number> list3 = new ArrayList<Object>();


        List<? super Number> list2 = new ArrayList<Object>();

        list2.add(new Integer(1));
        list2.add(new Float(1.2f));






    }

}
