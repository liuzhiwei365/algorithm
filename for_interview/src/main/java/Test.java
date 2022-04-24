import java.io.File;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Test {
    public static void main(String[] args) {

        System.out.println(new Test().letterCombinations("23"));
        System.out.println( File.pathSeparator);
    }


    static HashMap<Character,String> map =new HashMap();

    static {
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
    }


    public List<String> letterCombinations(String digits) {
        LinkedList<String> li = new LinkedList();

        String stmp = map.get(digits.charAt(0));

        if(digits.length()!=1){
            for(int i =0 ;i<stmp.length();i++){
                for(String s : letterCombinations(digits.substring(1))){
                    li.add(stmp.charAt(i)+s);
                }
            }

        }else{
            for(int i =0 ;i<stmp.length();i++){
                li.add(stmp.charAt(i)+"");
            }
            return li;
        }

        return li;
    }


}
