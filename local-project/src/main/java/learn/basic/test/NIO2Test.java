package learn.basic.test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.*;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/** 
 * Something can not be change
 * @author:LiuTaotao
 * @date:2018年1月1日下午9:51:21
 * @desc:
 */
public class NIO2Test {
	
	public static void main(String[] args) throws IOException {
		
		/*SocketChannel socketChannel = SocketChannel.open();
		socketChannel.connect(new InetSocketAddress("118.178.183.48",8080));
		String data = "New String to write to file..." + System.currentTimeMillis();
		 
		ByteBuffer writeBuf = ByteBuffer.allocate(48);
		writeBuf.clear();
		writeBuf.put(data.getBytes());
		writeBuf.flip();
		while(writeBuf.hasRemaining()) {
			socketChannel.write(writeBuf);
		}*/
		
		ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
		serverSocketChannel.socket().bind(new InetSocketAddress(80));	 
		//serverSocketChannel.configureBlocking(false);
		
		SocketChannel socketChannel = SocketChannel.open();
		socketChannel.connect(new InetSocketAddress(80));
		ByteBuffer writeBuf = ByteBuffer.allocate(48);
		writeBuf.put("abc".getBytes());
		while(writeBuf.hasRemaining()){
			socketChannel.write(writeBuf);
		}
		
		while(true){
			SocketChannel socketChannelAccept = serverSocketChannel.accept();
			if (socketChannelAccept != null) {
				ByteBuffer readBuffer = ByteBuffer.allocate(48);
				int readedByte = socketChannelAccept.read(readBuffer);
 				while (readedByte != -1) {
 					readBuffer.flip();
 					while(readBuffer.hasRemaining()){
 						System.out.println(readBuffer.get());
 					}
	 				readBuffer.clear();
	 				readedByte = socketChannelAccept.read(readBuffer);
				}	
			}
		}
		
		 
		
		
	}

}
