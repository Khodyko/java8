package com.company.web;

import jdk.dynalink.Operation;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.time.*;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@SuppressWarnings("all")
public class Main {
    public static String task6_field = "static field of enclosing context";

    public static void task6() {
        System.out.println("static method of enclosing context");
    }

    public static void main(String[] args) {
        //Task 1
        Predicate<Integer> t1 = e1 -> e1 > 0;
        System.out.println(t1.test(12));
        Consumer<Integer> t1_1 = e1 -> System.out.println(e1 + " super");
        t1_1.accept(12);
        Supplier<Integer> t1_2 = () -> {
            return 12;
        };
        System.out.println(t1_2.get());
        Function<String, Integer> t1_3 = e1 -> Integer.valueOf(e1) + 6;
        System.out.println(t1_3.apply("123"));
        //Task 2
        Runnable t2 = () -> System.out.println("Hello World");
        t2.run();
        Task2 t2_1 = (a) -> {
            return String.valueOf(a);
        };
        System.out.println(t2_1.t2(12));
        //Task 3
        Runnable t3 = () -> System.out.println("Hello World");
        Runnable t3_1 = () -> {
        };
        //Task 4
        Task4 t4 = () -> {
            return "abc";
        };
        Task4 t4_1 = () -> "abc";
        //Task 5
        Task5 t5 = () -> System.out.println("aaaa");
        //Task 6
        Runnable t6 = () -> {
            System.out.println(task6_field);
            task6();
        };
        //Task 7
        final String task7_field = "final local variable";
        Runnable t7 = () -> System.out.println(task7_field);
        //Task 8
        String task8_field = "effective final local variable";
        Runnable t8 = () -> {
            System.out.println(task8_field);
        };
        //Task 9
        Runnable t9 = Task9::methodStat;
        //Task 10
        Task9 t10_1 = new Task9();
        Runnable t10_2 = t10_1::method9;
        //Task 11
        Consumer<Task9> t11_1 = (a11) -> a11.method9();
        //Task 12
        Runnable t12 = Task9::new;
        //Task 13
        Stream t13 = Arrays.stream(new String[]{"12", "123"});
        t13.forEach(System.out::println);
        Stream t13_1 = Arrays.asList("123", "456", "789").stream();
        t13_1.forEach(System.out::println);
        //Task 14
        IntStream.range(1, 4).forEach(System.out::println);
        IntStream.empty().forEach(System.out::println);
        IntStream.of(12, 40, 43).forEach(System.out::println);
        IntStream.builder()
                .add(12)
                .add(12)
                .add(12)
                .build()
                .forEach(System.out::println);
        IntStream.generate(() -> 1).
                map(a -> a + 1)
                .limit(4).forEach(System.out::println);
        IntStream.iterate(1, a -> a + 1).limit(4).forEach(System.out::println);
        IntStream stream14 = IntStream.range(6, 10);
        stream14.forEach(System.out::println);
        IntStream stream14_1 = IntStream.rangeClosed(6, 10);
        stream14_1.forEach(System.out::println);
        IntStream.concat(IntStream.range(6, 10), IntStream.rangeClosed(6, 10)).forEach(element -> System.out.println(element));
        //Task 15
        Stream<String> t15 = Pattern.compile(",").
                splitAsStream("asddsad,asdsad");
        t15.forEach(System.out::println);
        IntStream t15_1 = "abc".chars();
        t15_1.forEach(System.out::println);
        //Task 16
        try {
            Stream t16 = Files.lines(Paths.get("src/com/company/web/text.txt"));
            t16.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //Task 17
        Arrays.asList("123", "1234", "456")
                .stream()
                .filter(a -> a.contains("1"))
                .map(a -> a + "456")
                .mapToInt(a -> Integer.parseInt(a))
                .mapToObj(a -> ((Integer) a).toString())
                .map(a -> a.split("2"))
                .flatMap(Arrays::stream)
                .flatMapToInt(a -> IntStream.of(Integer.parseInt(a)))
                .forEach(System.out::println);
        //Task 18
        Arrays.asList("123", "1234", "456", "123")
                .stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .limit(2)
                .forEach(System.out::println);
        //Task 19
        Arrays.asList("123", "1234", "456", "123")
                .stream()
                .peek(a19 -> System.out.println(a19 + " it works!"))
                .forEach(a19 -> System.out.println(a19 + " one more time!"));
        //Task 20
        Arrays.asList("123", "1234", "456", "123")
                .stream()
                .forEach(System.out::println);
        Arrays.asList("123", "1234", "456", "123")
                .stream()
                .forEachOrdered(System.out::println);
        //Task 21
        Optional t21 = Arrays.asList("12321", "1234", "456", "123")
                .stream()
                .findFirst();
        System.out.println(t21.get());
        Optional t21_1 = Arrays.asList("12321", "1234", "456", "123")
                .stream()
                .findAny();
        System.out.println(t21_1.get());
        // Task 22
        System.out.println(Arrays.asList("12321", "1234", "456", "123")
                .stream()
                .anyMatch(a -> a.contains("123")));
        System.out.println(Arrays.asList("12321", "1234", "456", "123")
                .stream()
                .noneMatch(a -> a.contains("123")));
        System.out.println(Arrays.asList("12321", "1234", "456", "123")
                .stream()
                .allMatch(a -> a.contains("123")));
        //Task 23
        System.out.println(Arrays.asList("12321", "1234", "456", "123")
                .stream()
                .count());
        System.out.println(Arrays.asList("12321", "1234", "456", "123")
                .stream()
                .min(Comparator.reverseOrder()));
        System.out.println(Arrays.asList("12321", "1234", "456", "123")
                .stream()
                .max(Comparator.reverseOrder()));
        //Task 24
        String[] t24 = Arrays.asList("12321", "1234", "456", "123")
                .stream()
                .toArray(String[]::new);
        System.out.println("t24 " + t24[0]);
        String t24_1 = Arrays.asList("12321", "1234", "456", "123")
                .stream()
                .reduce((a1, b1) -> a1 + b1).orElse("0");
        System.out.println("t24_1 " + t24_1);
        //Task 25
        List<String> t25_1 = Arrays.asList("12321", "1234", "456", "123")
                .stream()
                .collect(Collectors.toList());
        //Task 26
        Set<String> t26_1 = Arrays.asList("12321", "1234", "456", "123")
                .stream()
                .collect(Collectors.toSet());
        //Task 27
        Map<String, String> t27_1 = Arrays.asList("12321", "1234", "456", "123")
                .stream()
                .collect(Collectors.toMap((a) -> a, (b) -> b + "6"));
        Map<Boolean, List<String>> t27_2 = Arrays.asList("12321", "1234", "456", "123")
                .stream()
                .collect(Collectors.partitioningBy((p) -> p.contains("123")));

        Map<String, List<String>> t27_3 = Arrays.asList("162321", "14234", "456", "123")
                .stream()
                .collect(Collectors.groupingBy((p) -> p.substring(0, 3)));
        //Task 29
        System.out.println(IntStream
                .iterate(1, a -> a + 1)
                .limit(6).sum());
        System.out.println(IntStream
                .iterate(1, a -> a + 1)
                .limit(6).average());
        System.out.println(IntStream
                .iterate(1, a -> a + 1)
                .limit(6).mapToObj(a -> Integer.toBinaryString(a)));
        //Task 30
        IntStream.range(5, 12).parallel().forEach((a) -> System.out.println("(parallel) value: " + a + " current tread: " + Thread.currentThread().getName()));
        IntStream.range(5, 12).sequential().forEach((a) -> System.out.println("(sequential) value: " + a + " current tread: " + Thread.currentThread().getName()));
        // Task 31
        Optional o31 = Optional.empty();
        Optional<String> o31_1 = Optional.of("abc");
        Optional<String> o31_2 = Optional.ofNullable("abc");
        //Task 32
        Boolean o32 = Optional.of("abc").isPresent();
        Boolean o32_1 = Optional.of("abc").isEmpty();
        String o32_2 = Optional.of("abc").get();
        //Task 33
        String o33 = Optional.of("abc33").filter((a33) -> a33.equals("abc33")).get();
        System.out.println(o33);

        Optional<String> o33_1 = Optional.of("abc");
        Optional<Optional<String>> o33_2 = Optional.of(o33_1);
        String o33_3 = o33_2.flatMap(a33 -> a33).get();
        System.out.println(("o33_3: ") + o33_3);

        //Task 34
        String o34 = Optional.of("abc").map(a33 -> a33 + "34_1").orElse("123");
        String o34_1 = Optional.of("abc").map(a33 -> a33 + "34_1").orElseGet(() -> "else");
        try {
            String o34_2 = Optional.of("abc").map(a33 -> a33 + "34_1").orElseThrow(SQLException::new);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        //Task 35
        LocalDate d35 = LocalDate.now();
        LocalTime d35_1 = LocalTime.now();
        LocalDateTime d35_2 = LocalDateTime.now();
        System.out.println(d35);
        System.out.println(d35_1);
        System.out.println(d35_2);
        //Task 36
        ZoneId id36 = ZoneId.of("Asia/Tokyo");
        System.out.println(id36);
        ZonedDateTime d36 = ZonedDateTime.now(id36);
        System.out.println(d36);
        ZoneOffset offSet = ZoneOffset.of("+04:00");
        OffsetDateTime d36_1 = OffsetDateTime.now(offSet);
        System.out.println(d36_1);
        //Task 37
        Instant i37 = Instant.now();
        LocalDateTime d37 = LocalDateTime.ofInstant(i37, ZoneId.of("Asia/Tokyo"));
        LocalDate d37_1 = LocalDate.of(1991, 1, 9);
        LocalDate d37_2 = LocalDate.now();
        Period p37 = Period.between(d37_1, d37_2);
        System.out.println(p37);
        LocalDateTime d37_3 = LocalDateTime.of(1991, 1, 9, 2, 43);
        LocalDateTime d37_4 = LocalDateTime.now();
        Duration du37 = Duration.between(d37_3, d37_4);
        System.out.println(du37);
    }
}
