package concurrent;

import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * REVIEW
 * @Description: GuavaFuture异步方法测试
 * <a hre="http://blog.csdn.net/tangyongzhe/article/details/49851769">文档链接</a>
 * @author xiaoxu.haung
 * @date 2016/11/4  10:54
 *
 */
public class GuavaFutureTest {

	public static int a = 0;

	public static void main(String[] args) throws ExecutionException, InterruptedException {

		//		JDKSyncTask();

		GuavaSyncTask();

		//主线程可以继续做其他的工作
		System.out.println("main thread is running");
	}

	/**
	 * jdk1.8以前的版本，轮训操作
	 * @throws ExecutionException
	 * @throws InterruptedException
	 */
	public static void JDKSyncTask() throws ExecutionException, InterruptedException {
		ExecutorService executor = Executors.newFixedThreadPool(1);
		// Future代表了线程执行完以后的结果，可以通过future获得执行的结果
		// 但是jdk1.8之前的Future有点鸡肋，并不能实现真正的异步，需要阻塞的获取结果，或者不断的轮询
		// 通常我们希望当线程执行完一些耗时的任务后，能够自动的通知我们结果，很遗憾这在原生jdk1.8之前
		// 是不支持的，但是我们可以通过第三方的库实现真正的异步回调
		Future<String> f = executor.submit(new Callable<String>() {
			@Override
			public String call() throws Exception {
				System.out.println("task started!");
				Thread.sleep(10000);
				System.out.println("task finished!");
				return "hello";
			}
		});

		//此处阻塞main线程
		System.out.println(f.get());
	}

	/**
	 * Guava使用事件的注册回调监听
	 */
	public static void GuavaSyncTask() {
		ExecutorService executor = Executors.newFixedThreadPool(1);

		// 使用guava提供的MoreExecutors工具类包装原始的线程池
		ListeningExecutorService listeningExecutor = MoreExecutors.listeningDecorator(executor);
		//向线程池中提交一个任务后，将会返回一个可监听的Future，该Future由Guava框架提供
		ListenableFuture<String> lf = listeningExecutor.submit(new Callable<String>() {

			@Override
			public String call() throws Exception {
				a++;
				return "sucess";
			}
		});
		//添加回调，回调由executor中的线程触发，但也可以指定一个新的线程
		Futures.addCallback(lf, new CallbackTask());
		try {
			listeningExecutor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
		} catch (InterruptedException e) {
		}

	}

	static class CallbackTask implements FutureCallback {

		private String obj;

		@Override
		public void onSuccess(Object result) {
			System.out.println("success " + result);

		}

		@Override
		public void onFailure(Throwable t) {
			System.out.println("failure");
		}
	}

}
