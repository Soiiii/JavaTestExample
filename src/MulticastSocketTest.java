import java.io.IOException;
import java.net.*;
import java.nio.channels.DatagramChannel;
import java.util.Set;

public class MulticastSocketTest {
    public static void main(String[] args) {
        try {
            InetAddress group = InetAddress.getByName("230.0.0.0");
            int port = 4446;

            MulticastSocket socket = new MulticastSocket(null);
            socket.bind(new InetSocketAddress(port));
            System.out.println("Bound: " + socket.isBound());

            // Basic info
            System.out.println("Local Address: " + socket.getLocalAddress());
            System.out.println("Local Port: " + socket.getLocalPort());
            System.out.println("Local SocketAddress: " + socket.getLocalSocketAddress());
            System.out.println("Is Connected: " + socket.isConnected());
            System.out.println("Is Closed: " + socket.isClosed());

            // TTL and loopback
            socket.setTimeToLive(2);
            socket.setLoopbackMode(false);
            System.out.println("Time To Live: " + socket.getTimeToLive());
            System.out.println("Loopback Mode: " + socket.getLoopbackMode());

            // Buffer sizes
            socket.setReceiveBufferSize(2048);
            socket.setSendBufferSize(2048);
            System.out.println("Receive Buffer Size: " + socket.getReceiveBufferSize());
            System.out.println("Send Buffer Size: " + socket.getSendBufferSize());

            // Timeout
            socket.setSoTimeout(2000);
            System.out.println("SoTimeout: " + socket.getSoTimeout());

            // Traffic class
            socket.setTrafficClass(0x10);
            System.out.println("Traffic Class: " + socket.getTrafficClass());

            // Network interface
            NetworkInterface netIf = NetworkInterface.getByInetAddress(InetAddress.getLocalHost());
            socket.setNetworkInterface(netIf);
            System.out.println("Network Interface: " + socket.getNetworkInterface());

            // Join/leave group
            socket.joinGroup(new InetSocketAddress(group, port), netIf);
            System.out.println("Joined group.");

            socket.leaveGroup(new InetSocketAddress(group, port), netIf);
            System.out.println("Left group.");

            // DatagramChannel
            DatagramChannel channel = socket.getChannel();
            System.out.println("Datagram Channel: " + channel);

            // Socket options (low-level)
            Set<SocketOption<?>> options = socket.supportedOptions();
            System.out.println("Supported Options:");
            for (SocketOption<?> opt : options) {
                System.out.println("  " + opt.name());
            }

            // Basic sending
            String msg = "Hello Multicast";
            DatagramPacket packet = new DatagramPacket(msg.getBytes(), msg.length(), group, port);
            socket.send(packet);
            System.out.println("Packet sent.");

            // Receiving (non-blocking with timeout)
            DatagramPacket received = new DatagramPacket(new byte[2048], 2048);
            try {
                socket.receive(received);
                System.out.println("Received packet: " + new String(received.getData(), 0, received.getLength()));
            } catch (SocketTimeoutException e) {
                System.out.println("No packet received (timeout).");
            }

            // Set/retrieve interface via legacy method
            socket.setInterface(InetAddress.getLocalHost());
            System.out.println("Legacy Interface: " + socket.getInterface());

            // Reuse address
            socket.setReuseAddress(true);
            System.out.println("Reuse Address: " + socket.getReuseAddress());

            // Broadcast
            socket.setBroadcast(true);
            System.out.println("Broadcast Enabled: " + socket.getBroadcast());

            // Connection APIs
            socket.connect(group, port);
            System.out.println("Connected to: " + socket.getInetAddress() + ":" + socket.getPort());
            System.out.println("Remote Socket Address: " + socket.getRemoteSocketAddress());

            socket.disconnect();
            System.out.println("Disconnected.");

            // Close
            socket.close();
            System.out.println("Socket closed: " + socket.isClosed());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
