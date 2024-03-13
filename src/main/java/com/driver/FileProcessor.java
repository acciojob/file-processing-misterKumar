package com.driver;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class FileProcessor {
	
	    private List<String> fileNames;
	    public ConcurrentHashMap<String, Integer> wordCounts = new ConcurrentHashMap<>();

	    public FileProcessor(List<String> fileNames) {
	        // your code goes here
	    }

	    public void processFiles() {
	       // your code goes here
	    }

	    public void displayWordCounts() {
	        // your code goes here
	    }
	    

	    private class FileProcessorTask implements Runnable {
	        private String fileName;

	        public FileProcessorTask(String fileName) {
	            // your code goes here
	        }

	        public void run() {
	            // your code goes here
	        }
	    }

	    public static void main(String[] args) {
	    	List<String> fileNames = Arrays.asList("file1", "file2", "file3");
	        FileProcessor fileProcessor = new FileProcessor(fileNames);
	        fileProcessor.processFiles();
	        fileProcessor.displayWordCounts();
	    }
	

}
