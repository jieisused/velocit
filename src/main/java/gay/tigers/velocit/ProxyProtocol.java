package gay.tigers.velocit;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

import java.net.InetSocketAddress;

public class ProxyProtocol {
    public static ByteBuf createProxyHeader(InetSocketAddress clientAddress) {
        String header = String.format(
            "PROXY TCP4 %s %s %d %d\r\n",
            clientAddress.getAddress().getHostAddress(),
            "127.0.0.1",
            clientAddress.getPort(),
            25565
        );
        return Unpooled.wrappedBuffer(header.getBytes());
    }
}