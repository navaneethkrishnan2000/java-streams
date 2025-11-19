package com.example.interview_prep.intermediate;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FindDuplicate_IBS_interview {
    public static void main(String[] args) {

        int[] a = {1, 2, 3};
        int[] b = {3, 4, 5};
        int[] c = {4, 5, 6};

        List<Integer> collect =
                /**
                 * Combine Arrays into a Stream of Arrays. This creates a Stream<int[]> that contains the three arrays as individual elements: [{1, 2, 3}, {3, 4, 5}, {4, 5, 6}].
                 */
                Stream.of(a, b, c)
                /* Flatten the Stream into a Single IntStream. flatMapToInt transforms the stream of arrays into a single, flat IntStream of primitive integers. The Arrays::stream method ref. is used to turn each individual array into its own stream before flattening. The stream now looks like this: [1, 2, 3, 3, 4, 5, 4, 5, 6].*/
                .flatMapToInt(Arrays::stream)
                // Convert the primitive int to wrapper Integer. IntStream of primtives is converted into Stream<Integer> of wrapper objects. This is necessary because the subsequent steps, which involve Collectors methods, work with objects, not primitives. The stream is still [1, 2, 3, 3, 4, 5, 4, 5, 6], but the elements are now Integer objects.
                .boxed()
                // Group Elements and Count Occurrences
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                ))
                .entrySet() // Convert the Map back into a Stream of Entries
                .stream()
                .filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .toList();
        System.out.println(collect);

        String[] x = {"apple", "banana", "apple"};
        String[] y = {"banana", "orange", "grape"};
        String[] z = {"grape", "apple", "kiwi"};

        List<String> list = Stream.of(x, y, z)
                .flatMap(Arrays::stream)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                ))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .toList();
        System.out.println(list);

    }
}
