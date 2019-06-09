package chapter14;

public class EnumSingleton2 {
	//实例变量
	private byte[] data = new byte[1024];
	private EnumSingleton2(){}
	//使用枚举变量充当 holder
	private enum EnumHolder{
	
		INSTANCE;
		private EnumSingleton2 instance;
		EnumHolder(){
			this.instance = new EnumSingleton2();
		}
		private EnumSingleton2 getSingleton(){
			return instance;
		}
		public static EnumSingleton2 getInstance(){
			return EnumHolder.INSTANCE.getSingleton();
		}
	}
}
