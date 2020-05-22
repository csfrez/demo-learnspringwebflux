package com.csfrez.demo;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class FluxDemo {

    public static void main(String[] args) throws Exception {
        Flux<Integer> flux = Flux.just(1, 2, 3, 4, 5, 6, 7);
        flux.map(num -> num * 5) // 将所有数据扩大5倍
                .filter(num -> num > 10) // 只过滤出数值中超过10的数
                .map(String::valueOf) // 将数据转为String类型
                .publishOn(Schedulers.elastic()) // 使用弹性线程池来处理数据
                .subscribe(FluxDemo::println); // 消费数据
        Thread.sleep(3000L);
    }

    private static void println(Object object){
        System.out.println(Thread.currentThread().getName() + "==>" + object);
    }

}
