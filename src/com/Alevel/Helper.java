package com.Alevel;

import java.io.*;
import java.util.Collection;
import java.util.Objects;

public class Helper {

    static void input(Collection<Integer> collection, int count) {
        for (int i = 0; i < count; i++) {
            collection.add(i);
        }
    }

    static void delete(Collection<Integer> collection) {
        collection.clear();
    }

    static String getCollectionClassName(Collection<?> collection) {
        return  collection.getClass().getSimpleName();
    }

    /*private final CollectionDaoInterface collection = new CollectionInFile();


    public void run() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("You can select :");
        String position;
        try {
            runNavigation();
            while ((position = reader.readLine()) != null) {
                if (position.equals("0")) {
                    System.exit(0);
                }
                cd(position, reader);
            }
        } catch (IOException exception) {
            System.out.println("We have it`s problem : " + exception.getMessage());
        }
    }

    private void cd(String position, BufferedReader reader) {
        switch (position) {
            case "1":
                createCollection(reader);
                break;
            case "2":
                deleteCollection();
                break;
        }
        runNavigation();
    }

    private void runNavigation() {
        System.out.println();
        System.out.println("if you want create collection, please enter 1");
        System.out.println("if you want delete collection, please enter 2");
        System.out.println("if you want exit, please enter 0");
        System.out.println();
    }

    private void createCollection(BufferedReader reader) {
        System.out.println("OK, we can create new collection.");
        try {
            System.out.println("Please, enter your count");
            String count = reader.readLine();
            System.out.println("Please, enter your iter");
            String iter = reader.readLine();
            collection.create(Integer.parseInt(count), Integer.parseInt(iter));
        } catch (IOException exception) {
            System.out.println("problem: = " + exception.getMessage());
        }
    }

    private void deleteCollection() {
        collection.delete();
    }*/


}
