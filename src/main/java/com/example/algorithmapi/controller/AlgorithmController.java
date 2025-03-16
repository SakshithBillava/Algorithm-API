package com.example.algorithmapi.controller;

import com.example.algorithmapi.service.AlgorithmService;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class AlgorithmController {

    private final AlgorithmService service;

    public AlgorithmController(AlgorithmService service) {
        this.service = service;
    }

    @PostMapping("/binary-search")
    public ResponseEntity<?> binarySearch(@RequestBody int[] input, @RequestParam int target) {
        try {
            int result = service.binarySearch(input, target);
            return ResponseEntity.ok(result);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/quick-sort")
    public int[] quickSort(@RequestBody int[] input) {
        return service.quickSort(input);
    }

    @PostMapping("/bfs")
    public ResponseEntity<?> bfs(@RequestBody Map<String, List<String>> graph, @RequestParam String start) {
        try {
            List<String> result = service.bfs(graph, start);
            return ResponseEntity.ok(result);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(Collections.singletonMap("error", e.getMessage()));
        }
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<?> handleHttpMessageNotReadableException(HttpMessageNotReadableException ex) {
        String errorMessage = "Invalid input: Expected a Map<String, List<String>>, but received invalid JSON structure";
        return ResponseEntity.badRequest().body(Collections.singletonMap("error", errorMessage));
    }

}
