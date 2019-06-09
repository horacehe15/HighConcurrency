package chapter12;

import java.util.concurrent.TimeUnit;

/**
 * 
 * @author horacehe15
  * 【volatile解决在多个线程访问共享资源时引起的数据不一致问题】
  *  一个线程负责读取当前变量并输出（Reader），一个线程负责修改当前变量并输出修改后的值（Updater）
  *  为了维护数据一致性，需要在变量前加volatile修饰
 */


public class VolatileFoo {
	//init_ value 的最大值
	final static int MAX = 5;

	//实验变量1 init_ value 的初始值
	//static int init_value = 0;
	
	//实验变量1
	static volatile int init_value = 0;

	public static void main(String[] args) {
		
		
		//启动Updater线程，主要用于对init_value的修改，当local_value>=5的时候则退出生命周期
		new Thread(() ->
		{
			int localValue = init_value;
			while (localValue < MAX){
				System.out.printf("当前变量将被【改】为 [%d]\n", ++localValue);
				init_value = localValue;
				try{
					//短暂休眠，目的是为了使Reader线程能够来得及输出变化内容
					TimeUnit.SECONDS.sleep(2);
				} catch(InterruptedException e){
					e.printStackTrace();
				}
			}
		}, "Updater").start();
	
		// 启动一个Reader线程, 当发现local_value和init_value不同时, 则输出init_value的修改信息
		new Thread(() ->
		{
			int localvalue = init_value;
			while (localvalue < MAX){
				if (init_value != localvalue){
					System.out.printf("当前变量已【更新】为 [%d]\n", init_value);
					//对localValue进行重新赋值
					localvalue = init_value;
				}
			}
		}, "Reader").start();	
	}
}
