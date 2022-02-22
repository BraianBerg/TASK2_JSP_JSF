
package beans;

/**
 *
 * @author braia
 */
import java.net.*;

public class HostBean implements java.io.Serializable{
    public HostBean(){}
    
    public static String getIP() throws UnknownHostException{
        String ip = "";
        InetAddress inetAddress = InetAddress.getLocalHost();
        ip = inetAddress.getHostAddress();
        return ip;
    }
    public static String getName() throws UnknownHostException{
        String name = "";
        InetAddress inetAddress = InetAddress.getLocalHost();
        name = inetAddress.getHostName();
        return name;
    }   
}
