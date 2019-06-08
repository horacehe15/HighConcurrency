package chapter14;

/**
 * 
 * @author my
 * 懒汉式单例
 * 
 */
public class LHSingleton {
	//实例变量
	private byte[] data = new byte[1024]; 

	//定义实例，但是不直接初始化
	private static LHSingleton instance = null;

	//私有构造函数，不允许外部new
	private LHSingleton(){}

	public static LHSingleton getInstance(){
		if (null == instance){
			instance = new LHSingleton();
		}
		return instance ;
	}
}
