package chapter14;

import java.net.Socket;
import java.sql.Connection;

public class DCSingleton {
	//实例变量
	private byte[] data = new byte[1024];
	private static DCSingleton instance = null ;
	Connection conn;
	Socket socket;
	private DCSingleton(){
		//this.conn	// 初始化conn
		//this.socket// 初始化socket
	}

	public static DCSingleton getInstance(){
		//当instance为null时，进入同步代码块，同时该判断避免了每次都需要进入同步代码块，可以提高效率
		if (null == instance){
			//只有一个线程能够获得Singleton.class关联的monitor
			synchronized (DCSingleton. class){
				//判断如果instance为null则创建
				if (null == instance){
					instance = new DCSingleton();
				}
			}
		}
		return instance ;
	}
}
