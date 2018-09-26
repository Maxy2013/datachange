package com.data.datachange.module.nio;

/**
 * @author lz
 * 2018/8/27 17:49
 */

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

public class Client implements Runnable {
    private SocketChannel socketChannel;
    private ByteBuffer writeBuffer = ByteBuffer.allocate(1024);
    private ByteBuffer readBuffer = ByteBuffer.allocate(1024);

    public Client(String hostname, int port) {
        try {
            socketChannel = SocketChannel.open();
            socketChannel.connect(new InetSocketAddress(hostname, port));
            Scanner scanner = new Scanner(System.in);
            while (true) {
                String string = scanner.next();
                writeBuffer.put(string.getBytes());
                writeBuffer.flip();
                socketChannel.write(writeBuffer);
                writeBuffer.clear();
                while (socketChannel.read(readBuffer) != -1) {
                    readBuffer.flip();
                    byte[] dst = new byte[1024];
                    readBuffer.get(dst, 0, readBuffer.limit());
                    System.out.println(new String(dst));
                    readBuffer.clear();
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (socketChannel != null) {
                try {
                    socketChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Client client = new Client("127.0.0.1", 9999);
        new Thread(client).start();
    }

    @Override
    public void run() {
    }
}
