package com.example.jenkinsdemo.util;

import java.util.Random;
import java.util.stream.Stream;

/**
 * RandomString
 */
public class RandomString {
  private static Random rand = new Random();
  private static final int DEFAULT_LEN = 10;

  public static String make(int n) {
    return Stream.generate(() -> rand.nextInt(126) + 1)
        .map(i -> String.valueOf((char) i.intValue())).filter(s -> s.matches("\\w"))
        .limit(n)
        .reduce("", (current, accumulate) -> accumulate + current);
  }
  public static String make() {
    return make(DEFAULT_LEN);
  }

}
