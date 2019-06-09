package chapter14;

public class HolderSingleton {
	//实例变量
	private byte[] data = new byte[1024];

	private HolderSingleton(){}

	//在静态内部类中持有Singleton的实例，并且可被直接初始化
	private static class Holder{
		private static HolderSingleton instance = new HolderSingleton();
	}

	//调用getInstance方法，事实上是获得Holder的instance静态属性
	public static HolderSingleton getInstance(){
		return Holder.instance;
	}
}
