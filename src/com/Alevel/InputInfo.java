package com.Alevel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputInfo {

    private final CollectionDaoInterface collection = ObjectFactory.getInstance().getImplClass(CollectionDaoInterface.class);

    public void run(){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("You can select :");
        String position;
        try {
            while ((position = reader.readLine()) != null){
                cd(position, reader);
                position = reader.readLine();
                if (position.equals("0")){
                    System.exit(0);
                }
                cd(position, reader);
            }
        } catch (IOException exception){
            System.out.println("We have it`s problem : " + exception.getMessage());
        }
    }

    private void cd(String position, BufferedReader reader) {
        switch (position) {
            case "1" : createCollection(reader); break;
            case "2" : deleteCollection(reader); break;
        }
        runNavigation();
    }

    private void runNavigation() {
        System.out.println();
        System.out.println("if you want create collectiont, please enter 1");
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
            Collections collections = new Collections();
            collections.setCount(Integer.parseInt(count));
            collections.setIter(Integer.parseInt(iter));
            collection.create(collections);
        } catch (IOException exception) {
            System.out.println("problem: = " + exception.getMessage());
        }
    }

    private void deleteCollection(BufferedReader reader) {
        System.out.println("We can delete your collection.");
        try {
            System.out.println("Please, enter id");
            String id = reader.readLine();
            collection.delete(id);
        } catch (IOException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }
}
