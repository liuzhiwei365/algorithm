package management;

import javax.management.*;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;

public class ForTestMBeanClient {
    public static void main(String[] args) throws Exception{
        JMXServiceURL url = new JMXServiceURL(
                "service:jmx:rmi:///jndi/rmi://localhost:1099/jmxrmi");
        JMXConnector jmxc = JMXConnectorFactory.connect(url, null);
        MBeanServerConnection mbsc = jmxc.getMBeanServerConnection();

        // Get domains from MBeanServer
        //
        String domains[] = mbsc.getDomains();
        for (int i = 0; i < domains.length; i++) {
            System.out.println("Domain[" + i + "] = " + domains[i]);
        }

        // ------------------------>

        String domain = mbsc.getDefaultDomain();

        System.out.println(domain);




    }
}
