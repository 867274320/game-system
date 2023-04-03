package org.evolution.juc;

import javafx.concurrent.ScheduledService;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;

public class ThreadPoolAPI {

    public static void main(String[] args) {
        ScheduledThreadPoolExecutor stpl = (ScheduledThreadPoolExecutor) Executors.newFixedThreadPool(5);

//        stpl.schedule(
//        stpl.scheduleWithFixedDelay()
//        stpl.scheduleAtFixedRate()
    }
}
