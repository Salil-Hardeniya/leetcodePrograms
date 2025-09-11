package com.learning.sorting;

import com.learning.ObjectSizeFetcher;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RadixSort {
    public static final int INT = 10_000_000;
    static int base = (int) Math.pow(2, 16); // 65536

    public static void main(String[] args) {
        Random random = new Random(312431241);

        int[] bases = {
                (1 << 12),  // 4096
                (1 << 14),  // 16384
                (1 << 16),  // 65536
        };
        for (int b : bases) {
            List<Long> list = new ArrayList<>(INT);
            for (int i = 0; i < INT; i++) {
                list.add(random.nextLong(Long.MAX_VALUE));
            }

            base = b;
            int bits = (int) (Math.log(base) / Math.log(2));
            System.out.println("\n=== Running with base = 2^" + bits + " (" + bits + " bits) ===");

            long start = System.currentTimeMillis();
            sortNumber(list);
            long end = System.currentTimeMillis();

            System.out.println("Total sort time: " + (end - start) + " ms for " + INT + " numbers");
        }
    }

    public static void sortNumber(List<Long> list) {
        long divisor = 1;
        int passes = (int) Math.ceil(64 / (Math.log(base) / Math.log(2))); // 64-bit long
        for (int i = 0; i < passes; i++) {
            sortSubRoutine(list, divisor);
            divisor *= base;
        }
    }

    @SuppressWarnings("unchecked")
    public static void sortSubRoutine(List<Long> list, long divisor) {
        List<Long>[] buckets = (List<Long>[]) Array.newInstance(List.class, base);
        for (long num : list) {
            int index = (int) ((num / divisor) % base);
            if (buckets[index] == null) {
                buckets[index] = new ArrayList<>();
            }
            buckets[index].add(num);
        }
        long bucketSize = ObjectSizeFetcher.getObjectSize(buckets);
        System.out.println("Buckets array size: " + formatBytes(bucketSize));
        long mergeStart = System.currentTimeMillis();

        list.clear();
        for (List<Long> bucket : buckets) {
            if (bucket != null && !bucket.isEmpty()) {
                list.addAll(bucket);
                bucket.clear();
            }
        }

        long mergeEnd = System.currentTimeMillis();
        System.out.println("Time to merge buckets: " + (mergeEnd - mergeStart) + " ms");
    }

    public static String formatBytes(long bytes) {
        if (bytes >= 1024L * 1024 * 1024) {
            return String.format("%.2f GB", bytes / (1024.0 * 1024 * 1024));
        } else if (bytes >= 1024L * 1024) {
            return String.format("%.2f MB", bytes / (1024.0 * 1024));
        } else if (bytes >= 1024L) {
            return String.format("%.2f KB", bytes / 1024.0);
        } else {
            return bytes + " bytes";
        }
    }

}
