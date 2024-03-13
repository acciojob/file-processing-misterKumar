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
			this.fileNames=fileNames;
	    }

	    public void processFiles() {
	       // your code goes here
			ExecutorService executor = Executors.newFixedThreadPool(fileNames.size());

			for (String fileName : fileNames) {
				executor.execute(new FileProcessorTask(fileName));
			}

			executor.shutdown();
			try {
				executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
			} catch (InterruptedException e) {
				System.err.println("Error waiting for file processing to complete: " + e.getMessage());
			}
	    }

	    public void displayWordCounts() {
	        // your code goes here
			for (String fileName : wordCounts.keySet()) {
				System.out.println(fileName + "\t" + wordCounts.get(fileName) + " words");
			}
	    }
	    

	    private class FileProcessorTask implements Runnable {
			private String fileName;

			public FileProcessorTask(String fileName) {
				this.fileName = fileName;
			}

			public void run() {
				int count = countWords(fileName);
				wordCounts.put(fileName, count);
			}

			private int countWords(String fileName) {
				int count = 0;
				try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
					String line;
					while ((line = br.readLine()) != null) {
						String[] words = line.split("\\s+");
						count += words.length;
					}
				} catch (IOException e) {
					System.err.println("Error reading file " + fileName + ": " + e.getMessage());
				}
				return count;
			}
	    }

	    public static void main(String[] args) {
			List<String> fileNames = Arrays.asList("file1.txt", "file2.txt", "file3.txt");
			FileProcessor fileProcessor = new FileProcessor(fileNames);
			fileProcessor.processFiles();
			fileProcessor.displayWordCounts();
	    }
	

}
