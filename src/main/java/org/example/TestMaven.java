package org.example;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Objects;
import java.util.Properties;

public class TestMaven {
    public static void main(String[] args) {
        List<String> fruits = Lists.newArrayList("orange", "banana", "kiwi");
        fruits.forEach(System.out::println);

        List<String> reverseFruits = Lists.reverse(fruits);
        reverseFruits.forEach(System.out::println);

        Multimap<String, String> map = ArrayListMultimap.create();
        map.put("key", "firstValue");
        map.put("key", "secondValue");
        System.out.println(map);

        Properties props = new Properties();

        try (InputStream stream = TestMaven.class.getClassLoader().getResourceAsStream("config.properties")) {
            props.load(Objects.requireNonNull(stream));

            var val1 = props.get("props.local.hello");
            var val2 = props.get("props.mvn.hello");
            System.out.println(val1);
            System.out.println(val2);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
