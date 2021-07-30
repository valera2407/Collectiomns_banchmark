package com.Alevel;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.*;

public class Measure {
    Collection<Integer> arraylist = new ArrayList<>();
    Collection<Integer> linkedList = new LinkedList<>();
    Collection<Integer> hashSet = new HashSet<>();
    Collection<Integer> linkedHashSet = new LinkedHashSet<>();
    Collection<Integer> treeSet = new TreeSet<>();
    Collection<?>[] collections = {arraylist, linkedList, hashSet, linkedHashSet, treeSet};

    public void mesure(int count, int iter) {

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("Count: ")
                .append(count)
                .append(", Iterations: ")
                .append(iter + "\n")
                .append("I hope that you spent it time great: ");

        for (Collection<?> collection : collections) {
            stringBuilder.append(Helper.getCollectionClassName(collection)).append("\n");
            Collection<Integer> run = (Collection<Integer>) collection;
            for (int i = 1; i <= iter; i++) {
                long start = System.currentTimeMillis();
                Helper.input(run, count);
                long end = System.currentTimeMillis() - start;
                stringBuilder.append("Add: ").append(end).append(" ");
                start = System.currentTimeMillis();
                Helper.delete(run);
                end = System.currentTimeMillis() - start;
                stringBuilder.append("Remove: ").append(end).append("\n");
            }
        }
        writeToFile(stringBuilder.toString().getBytes());

    }

    private final String PATH = "results.txt";

    private void writeToFile(byte[] bytes) {
        try {
            Files.write(Path.of(PATH), bytes,
                    StandardOpenOption.CREATE,
                    StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
