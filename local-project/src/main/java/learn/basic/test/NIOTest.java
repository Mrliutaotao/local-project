package learn.basic.test;

import java.io.*;
import java.nio.*;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

/**
 * Something can not be change
 * 
 * @author:LiuTaotao
 * @date:2017年12月31日下午11:08:20
 * @desc:
 */
public class NIOTest {

	public static void main(String[] args) throws IOException {
		File file = new File("C:\\Users\\Administrator\\Desktop\\file.txt");
		FileInputStream fileInputStream = new FileInputStream(file);
		/*FileChannel inChannel = fileInputStream.getChannel();
		ByteBuffer byteBuffer = ByteBuffer.allocate(2);
		int bytesRead = inChannel.read(byteBuffer);
		while (bytesRead != -1) {
			System.out.println("Read " + bytesRead);
			// 首先读取数据到Buffer，然后反转Buffer,接着再从Buffer中读取数据
			byteBuffer.flip();
			while (byteBuffer.hasRemaining()) {
				System.out.print((char) byteBuffer.get());
			}
			byteBuffer.clear();
			bytesRead = inChannel.read(byteBuffer);
		}
		fileInputStream.close();
		*/
		FileChannel multBufferChannel = fileInputStream.getChannel();
		ByteBuffer byteBuffer2 = ByteBuffer.allocate(5);
		ByteBuffer byteBuffer3 = ByteBuffer.allocate(5);
		ByteBuffer [] byteBuffers = {byteBuffer2,byteBuffer3};
		// 顺序读写,先写byteBuffer2后先byteBuffer3
		long byteRead1 = multBufferChannel.read(byteBuffers);
		while(byteRead1 != -1){
			System.out.println("read : " + byteRead1);
			byteBuffer2.flip();
			byteBuffer3.flip();
			while(byteBuffer2.hasRemaining()){
				System.out.println("buffer2 " + (char)byteBuffer2.get());
			}
			while(byteBuffer3.hasRemaining()){
				System.out.println("buffer3 " + (char)byteBuffer3.get());
			}
			byteBuffer2.clear();
			byteBuffer3.clear();
			byteRead1 = multBufferChannel.read(byteBuffers);
		}	
		
		SocketChannel channel = null ;// SocketChannel.open("127.0.0.1");
		Selector selector = Selector.open();
		channel.configureBlocking(false);
		channel.register(selector, SelectionKey.OP_READ);
		while(true) {
		  int readyChannels = selector.select();
		  if(readyChannels == 0) continue;
		  Set selectedKeys = selector.selectedKeys();
		  Iterator keyIterator = selectedKeys.iterator();
		  while(keyIterator.hasNext()) {
		    SelectionKey key = (SelectionKey) keyIterator.next();
		    if(key.isAcceptable()) {
		        // a connection was accepted by a ServerSocketChannel.
		    } else if (key.isConnectable()) {
		        // a connection was established with a remote server.
		    } else if (key.isReadable()) {
		        // a channel is ready for reading
		    } else if (key.isWritable()) {
		        // a channel is ready for writing
		    }
		    keyIterator.remove();
		  }
		}
	}

}
