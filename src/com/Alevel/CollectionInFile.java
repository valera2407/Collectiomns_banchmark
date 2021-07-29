package com.Alevel;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class CollectionInFile implements CollectionDaoInterface {

    Collection<Integer> collectionArray;
    Collection<Integer> collectionLinked;
    Collection<Integer> collectionHash;
    Collection<Integer> collectionLinkedHash;
    Collection<Integer> collectionTree;

    long startArray;
    long endArray;
    long startLinked;
    long endLinked;
    long startHash;
    long endHash;
    long startLinkedHash;
    long endLinkedHash;
    long startTree;
    long endTree;


    @Override
    public void create(int count, int iter) {
        this.collectionArray = new ArrayList<>();
        this.collectionLinked = new LinkedList<>();
        this.collectionHash = new HashSet<>();
        this.collectionLinkedHash = new LinkedHashSet<>();
        this.collectionTree = new TreeSet<>();

        for (int i = 0; i < iter; i++) {
            startArray = System.currentTimeMillis();
            for (Integer j = 0; j < count; j++) {
                this.collectionArray.add(j + 1);
            }
            endArray = System.currentTimeMillis() - startArray;
            write(collectionArray.toString());
        }
        for (int i = 0; i < iter; i++) {
            startLinked = System.currentTimeMillis();
            for (Integer j = 0; j < count; j++) {
                this.collectionLinked.add(j + 1);
            }
            endLinked = System.currentTimeMillis() - startLinked;
            write(collectionLinked.toString());
        }
        for (int i = 0; i < iter; i++) {
            startHash = System.currentTimeMillis();
            for (Integer j = 0; j < count; j++) {
                this.collectionHash.add(j + 1);
            }
            endHash = System.currentTimeMillis() - startHash;
            write(collectionHash.toString());
        }
        for (int i = 0; i < iter; i++) {
            startLinkedHash = System.currentTimeMillis();
            for (Integer j = 0; j < count; j++) {
                this.collectionLinkedHash.add(j + 1);
            }
            endLinkedHash = System.currentTimeMillis() - startLinkedHash;
            write(collectionLinkedHash.toString());
        }
        for (int i = 0; i < iter; i++) {
            startTree = System.currentTimeMillis();
            for (Integer j = 0; j < count; j++) {
                this.collectionTree.add(j + 1);
            }
            endTree = System.currentTimeMillis() - startTree;
            write(collectionTree.toString());
        }
    }

    @Override
    public void delete() {
        this.collectionArray.clear();
        this.collectionLinked.clear();
        this.collectionHash.clear();
        this.collectionLinkedHash.clear();
        this.collectionTree.clear();
    }

    @Override
    public String toString() {
        return "CollectionInFile{" +
                ", collectionArray=" + collectionArray + "\n" +
                ", collectionLinked=" + collectionLinked + "\n" +
                ", collectionHash=" + collectionHash + "\n" +
                ", collectionLinkedHash=" + collectionLinkedHash + "\n" +
                ", collectionTree=" + collectionTree +
                '}';
    }

    File toInfo = new File("test.txt");

    private void write(String time) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(toInfo, true));
            writer.write(time);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
    public void write1() {
        try(
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(FileType.FILE_PATH.getPath(), true));
                BufferedReader bufferedReader = new BufferedReader(new FileReader(FileType.FILE_PATH.getPath()))
        ) {
            bufferedWriter.write("\n");
            bufferedWriter.write("test7");
            bufferedWriter.flush();
            bufferedReader.lines().forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private Collection<Collections> getInfoFromFile() {
        try {
            String usersJson = FileUtils.readFileToString(new File(FileType.JSON_TYPE.getPath()), "UTF-8");
            if (StringUtils.isBlank(usersJson)) {
                return new ArrayList<>();
            }
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(usersJson, new TypeReference<>() {
            });
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        throw new RuntimeException("some problem from file");
    }

    private void writeInfoToFile() {
        Gson gson = new Gson();
        String usersOut = gson.toJson(this.userList);
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(FileType.JSON_TYPE.getPath()))) {
            writer.append(usersOut);
            writer.flush();
        } catch (IOException exception) {
            exception.printStackTrace();
        }*/
}


