package scratchpad;

import java.text.DecimalFormat;
import java.util.HashSet;
import java.util.Random;
import java.util.Timer;

public class LotteryChanceBruteForce {
  public static void main(String[] args) {
    Random randomStream = new Random();

    long start = System.currentTimeMillis();
    HashSet<Byte> winners = new HashSet<>(6);
    while (winners.size() < 6) {
      winners.add((byte) randomStream.nextInt(1, 60));
    }
    HashSet<Byte> attempt = new HashSet<>(6);
    long count = 0;
    while (!attempt.equals(winners)) {
      attempt.clear();
      count = count + 1;
      while (attempt.size() < 6) {
        attempt.add((byte) randomStream.nextInt(1, 60));
      }
    }
    System.out.println("Count " + new DecimalFormat("#,###").format(count));
    System.out.println("Attempt " + attempt);
    System.out.println("Numbers were " + winners);
    long end = System.currentTimeMillis();
    System.out.println((float) (end - start) / 1000);
    System.out.println("Attempts per millisecond: " + ((float) count / (end - start)));
  }
}
