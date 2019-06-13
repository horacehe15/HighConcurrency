package chapter15;

public interface TaskLifecycle<T> {
	//任务启动时会触发onStart方法
	void onStart (Thread thread) ;

	//任务正在运行时会触发onRunning方法,
	void onRunning (Thread thread);

	//任务运行结束时会触发onFinish方法，其中result是任务执行结束后的结果
	void onFinish(Thread thread, T result) ;

	//任务执行报错时会触发onError方法 
	void onError (Thread thread, Exception e);
	
	//生命周期接口的空实现（Adapter）
	class EmptyLifecycle<T> implements TaskLifecycle<T>{

		@Override
		public void onStart (Thread thread){
			//do nothing
		}

		@Override
		public void onRunning (Thread thread){
			//do nothing
		}

		@Override
		public void onFinish (Thread thread, T result){
			//do nothing
		}

		@Override
		public void onError (Thread thread, Exception e){
			//do nothing
		}
	}
}
