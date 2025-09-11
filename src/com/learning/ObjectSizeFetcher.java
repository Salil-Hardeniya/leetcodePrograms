package com.learning;

import java.lang.instrument.Instrumentation;

public class ObjectSizeFetcher {
    private static Instrumentation instrumentation;

    public static void premain(String args, Instrumentation inst) {
        System.out.println(">>> ObjectSizeFetcher agent attached!");
        instrumentation = inst;
    }

    public static long getObjectSize(Object o) {
        return instrumentation.getObjectSize(o);
    }
}