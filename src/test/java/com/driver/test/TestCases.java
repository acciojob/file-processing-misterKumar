package com.driver.test;

import com.driver.FileProcessor;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;

public class TestCases {

    @Test
    public void testProcessFiles_BasicWordCounting() {
        List<String> fileNames = Arrays.asList("file1.txt", "file2.txt", "file3.txt");
        FileProcessor fileProcessor = new FileProcessor(fileNames);
        fileProcessor.processFiles();

        assertTrue(fileProcessor.wordCounts.containsKey("file1.txt"), "Word count for file1.txt is missing");
        assertTrue(fileProcessor.wordCounts.containsKey("file2.txt"), "Word count for file2.txt is missing");
        assertTrue(fileProcessor.wordCounts.containsKey("file3.txt"), "Word count for file3.txt is missing");

        System.out.println("Word Counts:");
        for (String fileName : fileProcessor.wordCounts.keySet()) {
            System.out.println(fileName + ": " + fileProcessor.wordCounts.get(fileName));
        }
    }
}
