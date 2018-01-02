package learn.basic.test;

import java.io.*;

/** 
 * Something can not be change
 * @author:LiuTaotao
 * @date:2017年12月31日下午7:41:00
 * @desc:
 */
public class IOTest {
	public static void main(String [] arg) throws IOException{
				
		File file1 = new File(".");
		String[] filePathList = file1.list();
		// .为根目录,是loca-project的根目录
		for(String filePath : filePathList){
			// System.out.println(filePath);
		}
		boolean isDir = file1.isDirectory();
		System.out.println(isDir);
		File file2 = new File("C:\\Users\\Administrator\\Desktop\\file.txt");
		if(!file2.exists()){
			// 创建文件
			file2.createNewFile();
		}
		// 缓冲输入文件
		FileReader fileReader = new FileReader(file2);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		StringBuilder stringBuilder = new StringBuilder();
		String s;
		while ((s = bufferedReader.readLine()) != null) {
			stringBuilder.append(s);
			stringBuilder.append("\n");
		}
		bufferedReader.close();
		System.out.println(stringBuilder);
		// 内存输入
		FileReader fileReader3 = new FileReader(file2);
 		DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream("中".getBytes()));
 		byte by;
 		// java.io.EOFException
 		/*while((by = dataInputStream.readByte()) != new Byte("-1").byteValue()){
 			 System.out.println(by);
 		}*/
 		
 		String hello= new String( "hello word!");
        byte[] byteArray= hello.getBytes();
        //因为是用字节流来写媒介，所以对应的是OutputStream 
        //又因为媒介对象是文件，所以用到子类是FileOutputStream
        OutputStream os= new FileOutputStream( file2);
        os.write( byteArray);
        os.close();
        // 管道
		final PipedOutputStream output = new PipedOutputStream();
		final PipedInputStream input = new PipedInputStream(output);
		Thread thread1 = new Thread(new Runnable() {
			public void run() {
				try {
					output.write("Hello world, pipe!".getBytes());
				} catch (IOException e) {
				}
			}
		});
		Thread thread2 = new Thread(new Runnable() {
			public void run() {
				try {
					int data = input.read();
					while (data != -1) {
						System.out.print((char) data);
						data = input.read();
					}
				} catch (IOException e) {
				} finally {
					try {
						input.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		});
		thread1.start();
		thread2.start();
        	      
 	}       
}
