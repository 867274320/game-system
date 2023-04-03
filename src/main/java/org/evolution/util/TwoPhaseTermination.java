package org.evolution.util;

public class TwoPhaseTermination {

    private Thread monitor;

    /*启动监控线程*/

    public void start() {
        monitor = new Thread(() -> {
            while (true) {
                Thread cur = Thread.currentThread();
                /*判断线程是否被打断*/
                if (cur.isInterrupted()) {
                    System.out.println("料理后事");
                    break;
                }
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    cur.interrupt();
                }
            }
        });

        monitor.start();
    }

    /*停止线程*/
    public void stop() {
        monitor.interrupt();
    }
}
