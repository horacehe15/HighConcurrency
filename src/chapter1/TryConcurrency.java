package chapter1;

import java.util.concurrent.TimeUnit;

public class TryConcurrency {
    /* 若用以下的主函数，一直运行看新闻程序，听音乐的方法则永久得不到运行*/
    /*public static void main(String[] args){
        browseNews();
        enjoyMusic();
    }*/

    /* Browse the latest news.*/
    private static void browseNews(){
        for(;;){
            System.out.println("我在看新闻！");
            sleep(1);
        }
    }
    /* Listening and enjoy the music.*/

    private static void enjoyMusic(){
        for(;;){
            System. out.println("我在听音乐！");
            sleep(1);
        }
    }
    /* Simulate the wait and ignore exception.* eparam seconds*/
    private static void sleep(int seconds){
        try{
            TimeUnit.SECONDS.sleep( seconds);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Thread(){
            @Override
            public void run() {
                enjoyMusic();
            }
        }.start();
        
/** 	效果一致
 *        new Thread() {
        	@Override
            public void run() {
        		browseNews();
            }
        }.start();*/
        
        browseNews();
        
    }
}
