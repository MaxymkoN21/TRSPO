package com.main;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Generate input array of size 100000 with random values
        int size = 100000;

        Scanner choose = new Scanner(System.in);
        System.out.println("Choose what you want : 1)Random or 2)File Input   ?");
        int integer=choose.nextInt();
        int[] arr1 ;
        int[] arr2 ;
        if(integer==1) {
            // Generating a random array of size 100000
            arr1 = generateRandomArray(size);
            arr2 = generateRandomArray(size);
            System.out.println(" Two unsorted random arrays created: ");
        }
        else if(integer==2) {
            // Reading the input array from a file
            String inputFileName1 = "input1.txt";
            //String inputFileName2 = "input2.txt";
            arr1 = readArrayFromFile(inputFileName1);
            arr2 = readArrayFromFile(inputFileName1);
            System.out.println("Two unsorted input arrays created:");
        }
        else {
            int[] array = {124, 5, 32, 78, 43, 456, 12, 34, 67, 21};
            arr1 = array;
            arr2 = array;
        }

        long startTime1 = System.currentTimeMillis();
        selectionSort(arr1);
        System.out.println("Sorting array: " );
        String outputFileName1 = "output1.txt";
        saveArrayToFile(outputFileName1, arr1);
        System.out.println("Saved sorted array to file :" + outputFileName1);
        long endTime1 = System.currentTimeMillis();
        long elapsedTime1 = endTime1 - startTime1;
        System.out.println("Elapsed time: " + elapsedTime1 + " milliseconds");


        long startTime2 = System.currentTimeMillis();
        int numThreads = 5;
        // Sort the array using selection sort with multithreading
        selectionSortParallel(arr2, numThreads);
        System.out.println("Sorting array using multithreading: " );
        String outputFileName2 = "output2.txt";
        saveArrayToFile(outputFileName2, arr2);
        System.out.println("Saved sorted array to file :" + outputFileName2);
        long endTime2 = System.currentTimeMillis();
        long elapsedTime2 = endTime2 - startTime2;
        System.out.println("Elapsed time with multithreading: " + elapsedTime2 + " milliseconds");
    }

    public static void selectionSort(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            int min = i;
            for (int j = i+1; j < len; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            int k = arr[i];
            arr[i] = arr[min];
            arr[min] = k;
        }
    }

    public static void selectionSortParallel(int[] arr, int numThreads) {
        int length = arr.length;
        int chunkSize = length / numThreads; //size of thread
        Thread[] threads = new Thread[numThreads]; //thread array
        for (int i = 0; i < numThreads; i++) {
            int start = i * chunkSize;
            int end = (i == numThreads-1) ? length : (i+1) * chunkSize;
            threads[i] = new Thread(new SelectionSort(arr, start, end));
            threads[i].start();
        }
        for (int i = 0; i < numThreads; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                System.err.println("Thread interrupted: " + e.getMessage());
            }
        }
        for (int i = 1; i < length; i++) {
            int j = i;
            while (j > 0 && arr[j] < arr[j-1]) {
                int temp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = temp;
                j--;
            }
        }
    }
    public static void saveArrayToFile(String outputname, int[] arr) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputname));
            for (int i = 0; i < arr.length; i++) {
                writer.write(arr[i] + " ");
            }
            writer.close();
        } catch (IOException e) {
            System.err.println("Error writing to file" + e.getMessage());
        }
    }
    public static int[] readArrayFromFile(String inputname) {
        int[] arr =  null;
        try{
            BufferedReader reader = new BufferedReader(new FileReader(inputname));
            String line = reader.readLine();
            String[] tokens = line.split(" ");
            arr = new int[tokens.length];
            for(int i = 0; i< tokens.length;i++){
                arr[i] = Integer.parseInt(tokens[i]);
            }
            reader.close();
        }
        catch (IOException e){
            System.err.println("Error reading from file" + e.getMessage());
        }
        return arr;
    }
    public static int[] generateRandomArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = (int) (Math.random() * 1000);
        }
        return arr;
    }
}
