/*
 * Copyright 2017 Michal Nikodim
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.cuberact.json.benchmark;

import org.HdrHistogram.Histogram;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

/**
 * @author Michal Nikodim (michal.nikodim@gmail.com)
 */
public class Benchmark {

    private static final int BENCHMARK_ITERATIONS = 1;
    private static BenchmarkInput[] inputs = new BenchmarkInput[]{
            new BenchmarkInput("/small-real-data.json"),
            new BenchmarkInput("/middle-real-data.json"),
            new BenchmarkInput("/big-real-data.json"),
            new BenchmarkInput(100),
            new BenchmarkInput(1000),
            new BenchmarkInput(10000),
            new BenchmarkInput(1000000),
            new BenchmarkInput(10000000),
    };

    private static Object fakeResult;

    public static void main(String[] args) throws Throwable {
        Thread benchmarkThread = new Thread(new BenchmarkRunnable());
        benchmarkThread.setPriority(Thread.MAX_PRIORITY);
        benchmarkThread.start();
    }

    private static class BenchmarkRunnable implements Runnable {

        @Override
        public void run() {
            try {
                System.out.println(
                        "--------------------------------------------\n" +
                                "BENCHMARK - JSON DESERIALIZATION FROM STRING\n" +
                                "--------------------------------------------\n" +
                                "Warm up:");
                BenchmarkInput warmUpInput = new BenchmarkInput(1234567);
                System.out.println(warmUpInput);
                for (BenchmarkLibrary benchmarkLibrary : BenchmarkLibrary.values()) {
                    Histogram histogram = new Histogram(1, 80_000_000, 3);
                    long time = benchmark(benchmarkLibrary, 30, warmUpInput.getJsonAsString(), histogram);
                    print(benchmarkLibrary, time, warmUpInput.getJsonAsString().length(), histogram);
                }
                Map<BenchmarkLibrary, Statistics> statistics = new HashMap<>();
                for (int benchmarkIteration = 0; benchmarkIteration < BENCHMARK_ITERATIONS; benchmarkIteration++) {
                    System.gc();
                    System.out.println("\nSystem.gc() and sleep for 5 sec\n");
                    Thread.sleep(5000);
                    System.out.println("BENCHMARK - iteration " + (benchmarkIteration + 1) + "/" + BENCHMARK_ITERATIONS + " ************************************************************");
                    for (BenchmarkInput input : inputs) {
                        System.out.println("-------------------------------------------------------------------------------------");
                        System.out.println(input);
                        long bestTime = Long.MAX_VALUE;
                        BenchmarkLibrary bestLibrary = null;
                        for (BenchmarkLibrary library : BenchmarkLibrary.values()) {
                            Histogram histogram = new Histogram(1, 80_000_000, 3);
                            long time = benchmark(library, 100, input.getJsonAsString(), histogram);
                            print(library, time, input.getJsonAsString().length(), histogram);
                            if (time < bestTime) {
                                bestTime = time;
                                bestLibrary = library;
                            }
                            Statistics st = statistics.computeIfAbsent(library, Statistics::new);
                            st.timeSum += time;
                            st.charsSum += input.getJsonAsString().length();
                        }
                        statistics.computeIfAbsent(bestLibrary, Statistics::new).wins += 1;
                    }
                }
                System.out.println("\nRESULT: *****************************************************************************\n");
                List<Statistics> sortedBySumOfTime = new ArrayList<>(statistics.values());
                Collections.sort(sortedBySumOfTime);
                int order = 0;
                for (Statistics stats : sortedBySumOfTime) {
                    String w = String.valueOf(stats.wins);
                    System.out.print(++order + ". [wins: " + w + "]" + "    ".substring(0, 4 - w.length()));
                    print(stats.benchmarkLibrary, stats.timeSum, stats.charsSum, null);
                }
                if (fakeResult == null) { // only for work with this variable
                    System.out.println("Something wrong");
                }
            } catch (Throwable t) {
                throw new RuntimeException(t);
            }
        }
    }

    private static long benchmark(BenchmarkLibrary benchmarkLibrary, int repeatCount, String json, Histogram histogram) throws Throwable {
        long times = 0;
        for (int i = 0; i < repeatCount; i++) {
            Thread.sleep(10);
            long time = System.nanoTime();
            fakeResult = benchmarkLibrary.getJsonLibrary().deserialize(json);
            time = System.nanoTime() - time;
            times += time;
            histogram.recordValue(time / 1000);
        }
        return times / repeatCount;
    }

    private static String minAvgMax(Histogram avg) {
        if (avg == null || avg.getTotalCount() == 0) {
            return "n/a";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("min/avg/max = ");
        BigDecimal bdTime = new BigDecimal(avg.getMinValue() / 1000000.0).setScale(9, RoundingMode.HALF_UP);
        sb.append(bdTime.toPlainString());
        sb.append(" / ");
        bdTime = new BigDecimal(avg.getMean() / 1000000.0).setScale(9, RoundingMode.HALF_UP);
        sb.append(bdTime.toPlainString());
        sb.append(" / ");
        bdTime = new BigDecimal(avg.getMaxValueAsDouble() / 1000000.0).setScale(9, RoundingMode.HALF_UP);
        sb.append(bdTime.toPlainString());
        sb.append(" sec");
        return sb.toString();
    }

    private static void print(BenchmarkLibrary benchmarkLibrary, long time, long jsonSize, Histogram histogram) throws InterruptedException {
        StringBuilder sb = new StringBuilder("  ");
        sb.append(benchmarkLibrary.indentedName());
        sb.append(" - ");
        BigDecimal bdTime = new BigDecimal(time / 1000000000.0).setScale(9, RoundingMode.HALF_UP);
        sb.append(bdTime.toPlainString());
        sb.append(" sec");
        BigDecimal megaCharsPerSec = new BigDecimal(1)
                .divide(bdTime, 50, RoundingMode.HALF_UP)
                .multiply(new BigDecimal(jsonSize))
                .divide(new BigDecimal(1000000), 3, BigDecimal.ROUND_HALF_UP);
        sb.append(" [");
        int before = megaCharsPerSec.intValue();
        if (before < 10) {
            sb.append("  ");
        } else if (before < 100) {
            sb.append(" ");
        }
        sb.append(megaCharsPerSec.toPlainString()).append(" MegaChar/s] ");
        if (histogram != null) {
            sb.append(minAvgMax(histogram));
        }
        System.out.println(sb.toString());
    }

    private static class Statistics implements Comparable<Statistics> {
        private BenchmarkLibrary benchmarkLibrary;
        private long timeSum;
        private int wins;
        private long charsSum;

        private Statistics(BenchmarkLibrary benchmarkLibrary) {
            this.benchmarkLibrary = benchmarkLibrary;
        }

        @Override
        public int compareTo(Statistics o) {
            return Long.compare(timeSum, o.timeSum);
        }
    }
}
