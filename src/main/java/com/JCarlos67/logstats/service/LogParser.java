package com.JCarlos67.logstats.service;

import com.JCarlos67.logstats.model.LogEntry;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class LogParser {

  public List<LogEntry> readLogFile (String pathLogFile) {
    try (BufferedReader bufferedReader = new BufferedReader(new FileReader(pathLogFile))) {
      List<LogEntry> logEntryDataLine = new ArrayList<>();
      String line = bufferedReader.readLine();
      while (line != null) {
        LogEntry logEntry = parseLine(line);
        if (logEntry != null)
          logEntryDataLine.add(logEntry);

        line = bufferedReader.readLine();
      }
      return logEntryDataLine;
    } catch (IOException e) {
      System.out.println("Error: " + e.getMessage());
      return null;
    }
  }

  public LogEntry parseLine(String line) {
    if (line != null && !line.isBlank()) {
      String[] lineData = line.split(" ", 3);
      LocalDateTime timeStamp = LocalDateTime.parse(lineData[0].substring(1, 20));
      return  new LogEntry(timeStamp, lineData[1], lineData[2]);
    }
    return null;
  }
}
