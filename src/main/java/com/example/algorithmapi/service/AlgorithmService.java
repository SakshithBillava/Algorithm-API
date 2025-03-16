package com.example.algorithmapi.service;

import com.example.algorithmapi.model.LogEntry;
import com.example.algorithmapi.repository.LogRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AlgorithmService {

    private final LogRepository logRepository;

    public AlgorithmService(LogRepository logRepository) {
        this.logRepository = logRepository;
    }

    // Binary Search
    private boolean isSorted(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }
    public int binarySearch(int[] arr, int target) {

        if (!isSorted(arr)) {
            throw new IllegalArgumentException("Input array must be sorted for binary search");
        }

        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                saveLog("Binary Search", Arrays.toString(arr), String.valueOf(mid));
                return mid;
            }
            if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        saveLog("Binary Search", Arrays.toString(arr), "-1");
        return -1;
    }

    // Quick Sort
    public int[] quickSort(int[] arr) {
        quickSortAlgo(arr, 0, arr.length - 1);
        saveLog("Quick Sort", Arrays.toString(arr), Arrays.toString(arr));
        return arr;
    }

    private void quickSortAlgo(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSortAlgo(arr, low, pi - 1);
            quickSortAlgo(arr, pi + 1, high);
        }
    }

    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // BFS
    public List<String> bfs(Map<String, List<String>> graph, String start) {
        if (graph == null || graph.isEmpty()) {
            throw new IllegalArgumentException("Graph cannot be null or empty");
        }
        if (start == null || !graph.containsKey(start)) {
            throw new IllegalArgumentException("Invalid start node");
        }
        for (Map.Entry<?, ?> entry : ((Map<?, ?>) graph).entrySet()) {
            if (!(entry.getKey() instanceof String)) {
                throw new IllegalArgumentException("Map keys must be of type String");
            }
            if (!(entry.getValue() instanceof List)) {
                throw new IllegalArgumentException("Map values must be of type List");
            }
        }

        List<String> result = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            String node = queue.poll();
            result.add(node);
            for (String neighbor : graph.getOrDefault(node, new ArrayList<>())) {
                if (!visited.contains(neighbor)) {
                    queue.add(neighbor);
                    visited.add(neighbor);
                }
            }
        }

        saveLog("BFS", graph.toString(), result.toString());
        return result;
    }


    // Save logs
    private void saveLog(String algorithm, String input, String output) {
        LogEntry log = new LogEntry(algorithm, input, output);
        logRepository.save(log);
    }
}

