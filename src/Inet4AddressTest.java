import java.io.IOException;
import java.net.*;

public class Inet4AddressTest {
    public static void main(String[] args) {
        runAll();
    }

    static void runAll() {
        try {
            Inet4Address inetAddress = (Inet4Address) InetAddress.getByName("ora.example.com");
            System.out.println("getByName: " + inetAddress);

            InetAddress[] addresses = Inet4Address.getAllByName("ora.example.com");
            for (InetAddress addr : addresses) {
                System.out.println("getAllByName: " + addr);
            }

            byte[] byteAddr = inetAddress.getAddress();
            System.out.print("getAddress: ");
            for (byte b : byteAddr) {
                System.out.print((b & 0xFF) + ".");
            }
            System.out.println();

            InetAddress byByteAddr = Inet4Address.getByAddress(byteAddr);
            System.out.println("getByAddress(byte[]): " + byByteAddr);

            InetAddress byNameAndAddr = Inet4Address.getByAddress("customhost", byteAddr);
            System.out.println("getByAddress(String, byte[]): " + byNameAndAddr);

            System.out.println("getHostName: " + inetAddress.getHostName());
            System.out.println("getCanonicalHostName: " + inetAddress.getCanonicalHostName());
            System.out.println("getHostAddress: " + inetAddress.getHostAddress());

            System.out.println("hashCode: " + inetAddress.hashCode());

            System.out.println("toString: " + inetAddress.toString());

            System.out.println("getLocalHost: " + Inet4Address.getLocalHost());
            System.out.println("getLoopbackAddress: " + Inet4Address.getLoopbackAddress());

            if (inetAddress instanceof Inet4Address inet4Address) {
                System.out.println("isAnyLocalAddress: " + inet4Address.isAnyLocalAddress());
                System.out.println("isLinkLocalAddress: " + inet4Address.isLinkLocalAddress());
                System.out.println("isLoopbackAddress: " + inet4Address.isLoopbackAddress());
                System.out.println("isMCGlobal: " + inet4Address.isMCGlobal());
                System.out.println("isMCLinkLocal: " + inet4Address.isMCLinkLocal());
                System.out.println("isMCNodeLocal: " + inet4Address.isMCNodeLocal());
                System.out.println("isMCOrgLocal: " + inet4Address.isMCOrgLocal());
                System.out.println("isMCSiteLocal: " + inet4Address.isMCSiteLocal());
                System.out.println("isMulticastAddress: " + inet4Address.isMulticastAddress());
                System.out.println("isSiteLocalAddress: " + inet4Address.isSiteLocalAddress());

                InetAddress another = Inet4Address.getByName("ora.example.com");
                System.out.println("equals: " + inet4Address.equals(another));

                try {
                    System.out.println("isReachable(1000): " + inet4Address.isReachable(1000));
                } catch (IOException e) {
                    System.out.println("isReachable(int) threw IOException: " + e.getMessage());
                }

                try {
                    NetworkInterface netIf = NetworkInterface.getByInetAddress(inet4Address);
                    if (netIf != null) {
                        System.out.println("isReachable(NetworkInterface, 0, 1000): "
                                + inet4Address.isReachable(netIf, 0, 1000));
                    } else {
                        System.out.println("No NetworkInterface found for this address");
                    }
                } catch (IOException e) {
                    System.out.println("isReachable(NetworkInterface, int, int) threw IOException: " + e.getMessage());
                }
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
