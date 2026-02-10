package com.JCarlos67.logstats;

import com.JCarlos67.logstats.model.LogEntry;
import com.JCarlos67.logstats.service.LogParser;

import java.util.List;

public class App
{
    public static void main(String[] args) {
        LogParser logParser = new LogParser();
        List<LogEntry> logEntryList = logParser.readLogFile("src/main/resources/sample.log");
        for (LogEntry log : logEntryList)
            System.out.println(log);
    }
}
