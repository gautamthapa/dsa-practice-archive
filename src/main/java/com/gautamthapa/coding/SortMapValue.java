package com.gautamthapa.coding;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class SortMapValue {
    static void main() {
        Map<String, Integer> map=new HashMap<>();
        map.put("A", 20);
        map.put("B", 10);
        map.put("C", 5);
        map.put("D", 30);
        map.put("E", 12);

        LinkedHashMap<String,Integer> sortedMap=map.entrySet()
                .stream().sorted(Map.Entry.comparingByValue())
                .collect(
                        Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue,
                                (e1,e2)->e1, LinkedHashMap::new)
                );

        sortedMap.forEach((key, value) -> System.out.println(key+" - "+value));
    }
}
