package management;

import org.junit.Test;

import javax.management.MBeanServer;
import javax.management.MBeanServerFactory;
import javax.management.ObjectName;
import javax.management.remote.JMXConnectorServer;
import javax.management.remote.JMXConnectorServerFactory;
import javax.management.remote.JMXServiceURL;
import java.lang.management.ManagementFactory;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import com.sun.jdmk.comm.HtmlAdaptorServer;

/**
 标准的MBean，要遵守创建规则。
 建了HelloWorld这个MBean，这个MBean就是实现了HelloWorldMBean这个接口。所以符合规范。
 而真正的问题出在这里，这个类和接口必须放在同一个包中，不然 报错。
 *
 * 接口名字 必须以 "MBean" 结尾
 */
public class ForTestMBeanServer {


    public static void main(String[] args) throws Exception{

        testHtml();

    }

    //不能用 junit 来测试
    public void  testJmxConnServer() throws Exception{
        MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();
        ObjectName helloName = new ObjectName("HelloMbean:name=Hello");
        mBeanServer.registerMBean(new Hello(), helloName);

        Registry registry = LocateRegistry.createRegistry(1099);
        JMXServiceURL jmxServiceURL = new JMXServiceURL("service:jmx:rmi:///jndi/rmi://localhost:1099/jmxrmi");

        JMXConnectorServer jmxConnectorServer = JMXConnectorServerFactory.newJMXConnectorServer(jmxServiceURL, null, mBeanServer);
        jmxConnectorServer.start();
        System.out.println("JMXConnectorServer is running");
    }



    // 不能用 junit 来测试
    public static void  testHtml() throws Exception{
        MBeanServer server = MBeanServerFactory.createMBeanServer();
        ObjectName helloName = new ObjectName("chengang:name=HelloWorld");
        server.registerMBean(new Hello(), helloName);

        ObjectName adapterName = new ObjectName("HelloAgent:name=htmladapter,port=8082");
        HtmlAdaptorServer adapter = new HtmlAdaptorServer();
        server.registerMBean(adapter, adapterName);


        adapter.start();
        System.out.println("start.....");
    }


}
