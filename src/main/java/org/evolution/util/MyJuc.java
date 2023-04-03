package org.evolution.util;

public class MyJuc {

    /*两阶段终止模式*/
    public static void main(String[] args) throws Exception {
        TwoPhaseTermination twoPhaseTermination = new TwoPhaseTermination();
        twoPhaseTermination.start();


        Thread.sleep(3000);

        twoPhaseTermination.stop();
    }

}