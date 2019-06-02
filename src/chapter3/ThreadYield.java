package chapter3;

import java.util.stream.IntStream;

public class ThreadYield {
    public static void main(String[] args) {
        IntStream.range(0, 2).mapToObj(ThreadYield::create).forEach(Thread::start);
    }

    // 若注释掉 if Thread.yield( );则0,1输出顺序不定
    private static Thread create(int index){
        return new Thread(()->{
            if (index==0)
                Thread.yield( );
            System.out.println(index);
        });
    }
}
