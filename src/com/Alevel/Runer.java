package com.Alevel;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.*;

public class Runer {

    public  void run() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please, input collections size:");
        int count = scanner.nextInt();
        System.out.println("Please, input how much iterations do you want:");
        int iter = scanner.nextInt();
        new Measure().mesure(count, iter);
    }


}


