package security;

import jdk.net.NetworkPermission;
import org.junit.Test;

import java.io.File;
import java.io.FilePermission;
import java.net.SocketPermission;
import java.security.Permissions;
import java.security.Policy;

public class ForJvmSecurity {


    /**   启动安全管理器
     * -Djava.security.manager  -Djava.security.policy=My.policy  HelloWorld
     * 安全策略文件My.policy 内容模版：
     *  permission  java.io.FilePermission  "/tmp/*" , "read,write"
     *
     *  jdk 有自带的安全策略文件在：  ${JAVA_HOME}/jre/lib/security/java.policy
     *

     * 安全策略文件的作用： 建立了代码来源和访问权限的关系
     *
     * 可以自定义权限类，继承Permission类
     *
     */
    public static void main(String[] args) {
    }

    @Test
    public void testFilePermission(){
        //硬编码开启安全管理器
        System.setProperty("java.security.policy",
                "/Users/liuzhiwei/idea pro/algorithm/java_api/src/main/resources/My.policy");
        System.setSecurityManager(new SecurityManager());
        // FilePermission p = new FilePermission("/tmp/*","read,write");
        //File f = new File("/Users/liuzhiwei/idea pro/algorithm/java_api/src/main/resources/as1.txt");
        File f = new File("/Users/liuzhiwei/idea pro/algorithm/java_api/src/main/resources/1.txt");
        if(f.exists()){
            f.delete();
        }

    }


    @Test
    public void testSocketPermission(){
        SocketPermission p = new SocketPermission("localhost:80","listen,resolve");
        Permissions  ps = new Permissions();
        ps.add(p);

       // Policy.setPolicy();



    }




}
