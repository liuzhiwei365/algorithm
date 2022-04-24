package base;

import java.net.URL;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.security.CodeSource;
import java.security.ProtectionDomain;

public class ForReflect {
    public static void main(String[] args){

        try{
            ProtectionDomain protectionDomain = ForReflect.class.getProtectionDomain();
            System.out.println(protectionDomain);

            CodeSource codeSource = protectionDomain.getCodeSource();
            System.out.println(codeSource);

            URL location = codeSource.getLocation();
            System.out.println(location);

            String decode = URLDecoder.decode(location.getPath(), Charset.defaultCharset().name());

            System.out.println(decode);
            System.out.println("---------------------------------------------------------");
        }catch (Exception e){
            e.printStackTrace();
        }

        try{
            Package apackage = ForReflect.class.getPackage();
            System.out.println(apackage);

            String name = apackage.getName();
            System.out.println(name);

            String name1 = Charset.defaultCharset().name();
            System.out.println(name1);
            System.out.println("---------------------------------------------------------");


        }catch (Exception e){
            e.printStackTrace();
        }



    }


    public void test(){
        Class<? extends ForReflect> aClass = getClass();
    }


}
