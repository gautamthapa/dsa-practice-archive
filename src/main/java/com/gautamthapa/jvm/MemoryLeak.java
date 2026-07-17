package com.gautamthapa.jvm;

import java.util.ArrayList;
import java.util.List;

public class MemoryLeak {
    static List<byte[]> list= new ArrayList<>();

    static void main() throws InterruptedException{
        while (true){
            list.add(new byte[1024*1024]);
            Thread.sleep(100);
        }
    }
}
