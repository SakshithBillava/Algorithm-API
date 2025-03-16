package com.example.algorithmapi.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class LogEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String algorithmName;
    private String inputData;
    private String outputData;

    public LogEntry(String algorithm, String input, String output) {
        algorithmName = algorithm;
        inputData = input;
        outputData = output;
    }
}