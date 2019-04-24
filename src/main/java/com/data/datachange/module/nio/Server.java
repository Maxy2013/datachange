package com.data.datachange.module.nio;

/**
 * @author lz
 * 2018/8/27 16:28
 */

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class Server implements Runnable {
    private Selector selector;
    private ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
    private ByteBuffer writeBuffer = ByteBuffer.allocate(1024);

    public Server(int port) {
        try {    //1.打开多路复用器
            selector = Selector.open();
            //2.打开服务器通道
            ServerSocketChannel serverSocketChannel;
            serverSocketChannel = ServerSocketChannel.open();
            //3.设置为非阻塞模式
            serverSocketChannel.configureBlocking(false);
            //4.绑定端口号
            serverSocketChannel.bind(new InetSocketAddress(port));
            //5.将服务器通道注册到多路复用器上,并且监听阻塞状态
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void

    run()

    {
        while (true) {
            try {
                //1.多路复用器开始监听
                selector.select();
                //2.获取所有的selectedKeys结果集进行遍历
                Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                //3.进行遍历
                while (iterator.hasNext()) {
                    //4.获取选择的一个元素
                    SelectionKey selectionKey = iterator.next();
                    //5.从集合移除当前选择的selectionKey
                    iterator.remove();
                    //6.判断当前元素是否是有效的
                    if (selectionKey.isValid()) {
                        //7.如果是阻塞的话
                    if (selectionKey.isAcceptable()) {
                            //8.获取服务器的通道
                            ServerSocketChannel serverSocketChannel = (ServerSocketChannel) selectionKey.channel();
                            //9.进行等待
                            SocketChannel socketChannel = serverSocketChannel.accept();
                            // 10.设置为非阻塞的模式
                            socketChannel.configureBlocking(false);
                            // 11.将客户端注册到多路复用器上,监听可读事件
                            socketChannel.register(selector, SelectionKey.OP_READ);
                        }
                        //12.如果是可读状态
                        if (selectionKey.isReadable()) {
                            byteBuffer.clear();
                            //13.如果是可读状态
                            SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
                            int readCount = socketChannel.read(byteBuffer);
                            //14.如果没有数据
                            if (readCount < 0) {
                                selectionKey.channel().close();
                                selectionKey.cancel();
                                return;
                            }
                            //15.切换成读模式
                            byteBuffer.flip();
                            byte[] dst = new byte[byteBuffer.limit()];
                            byteBuffer.get(dst);
                            String result = new String(dst).trim();
                            //16.打印
                            System.out.println("Server : " + result);
                            //17.回应Client
                            byte[] b = new byte[writeBuffer.capacity()];
                            System.in.read(b, 0, b.length);
                            writeBuffer.put(b);
                            writeBuffer.flip();
                            socketChannel.write(writeBuffer);
                            writeBuffer.clear();
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new Thread(new Server(9999)).start();
    }

}