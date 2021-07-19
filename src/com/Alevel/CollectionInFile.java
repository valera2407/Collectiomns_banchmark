package com.Alevel;

import java.io.*;
import java.util.*;

public class CollectionInFile implements CollectionDaoInterface{

    private Collection <Collections> collectionArray = new ArrayList<>();
    private Collection <Collections> collectionLinked = new LinkedList<>();
    private Collection <Collections> collectionHash = new HashSet<>();
    private Collection <Collections> collectionLinkedHash = new LinkedHashSet<>();
    private Collection <Collections> collectionTree = new TreeSet<>();

    public CollectionInFile(){}

    @Override
    public void create(Collections collections) {
        this.collectionArray.add(collections);
        writeInfoToFile();
        this.collectionLinked.add(collections);
        writeInfoToFile();
        this.collectionHash.add(collections);
        writeInfoToFile();
        this.collectionLinkedHash.add(collections);
        writeInfoToFile();
        this.collectionTree.add(collections);
        writeInfoToFile();
    }

    @Override
    public void delete() {
        userList = getInfoFromFile();
        if (CollectionUtils.isEmpty(userList)) {
            throw new RuntimeException("empty list");
        }
        User current = userList.stream().filter(u -> u.getId().equals(id)).findFirst().orElse(null);
        if (Objects.isNull(current)) {
            throw new RuntimeException("user not found");
        }
        userList.removeIf(u -> u.getId().equals(id));
        writeUsersToFile();
    }
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
        }
}
