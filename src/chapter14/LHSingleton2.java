package chapter14;

/**
 * 
 * @author my
 * 懒汉式+同步单例
 * 
 */
public class LHSingleton2 {
	//实例变量
	private byte[] data = new byte[1024]; 

	//定义实例，但是不直接初始化
	private static LHSingleton2 instance = null;

	//私有构造函数，不允许外部new
	private LHSingleton2(){}

	public static synchronized LHSingleton2 getInstance(){
		if (null == instance){
			instance = new LHSingleton2();
		}
		return instance ;
	}
}
