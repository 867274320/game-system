package org.evolution.jvm;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

// ‐Xms10M ‐Xmx10M ‐XX:+PrintGCDetails ‐XX:+HeapDumpOnOutOfMemoryError ‐XX:HeapDumpPath=D:\jvm.dump
public class StackFlow {

    public static void main(String[] args) {
        List<Object> list = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (true) {
            list.add(new MyUser(i++, UUID.randomUUID().toString()));
        }
    }
}
