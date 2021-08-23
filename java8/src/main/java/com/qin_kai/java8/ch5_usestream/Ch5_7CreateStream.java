package com.qin_kai.java8.ch5_usestream;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * 5.7构建流
 *
 * @author qinkai
 * @date 2021/8/19
 */
public class Ch5_7CreateStream {

    public static void main(String[] args) throws IOException, URISyntaxException {
        // 由值创建流
//        ch5_7_1();

        // 由数组创建流
//        ch5_7_2();

        // 由文件生成流
//        ch5_7_3();

        // 由函数生成流：创建无限流
        ch5_7_4();

    }

    private static void ch5_7_4() {
        // 1、迭代
        Stream.iterate(0, n -> n + 2)
                .limit(100)
                .forEach(e -> System.out.print(e + " "));
        System.out.println();

        // 2、生成
        Stream.generate(Math::random)
                .limit(100)
                .forEach(e -> System.out.print(e + " "));

    }

    private static void ch5_7_3() throws URISyntaxException, IOException {
        URI uri = Ch5_7CreateStream.class.getResource("/stream-test.txt").toURI();
        try (Stream<String> fileLinesStream = Files.lines(Paths.get(uri), StandardCharsets.UTF_8)) {
            fileLinesStream.forEach(line -> System.out.print(line + " "));
        }
    }

    private static void ch5_7_2() {
        Arrays.stream(new int[]{1, 2, 3})
                .forEach(e -> System.out.print(e + " "));
    }

    /**
     * 由值创建流
     */
    private static void ch5_7_1() {
        Stream.of("test1", "test2", "test3")
                .forEach(e -> System.out.print(e + " "));
    }

}
