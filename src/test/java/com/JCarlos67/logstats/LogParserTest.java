package com.JCarlos67.logstats;

import com.JCarlos67.logstats.model.LogEntry;
import com.JCarlos67.logstats.service.LogParser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

public class LogParserTest {
  @Test
  void readLogFileCorrectly() {
    LogParser logParser = new LogParser();
    List<LogEntry> logEntryList = logParser.readLogFile("/home/carlos/Dev/Java/Projetos/log-stats/src/main/resources/sample.log");

    Assertions.assertNotNull(logEntryList);
    Assertions.assertFalse(logEntryList.isEmpty(), "A lista de logs não deveria estar vazia");
  }

  @Test
  void shouldParseValidLine() {
    LogParser logParser = new LogParser();
    LogEntry logEntry = logParser.parseLine("[2024-02-05T10:00:00] INFO Iniciando sistema");
    Assertions.assertEquals(LocalDateTime.of(2024, 02, 05, 10, 00, 00), logEntry.timestamp());
    Assertions.assertEquals("INFO", logEntry.level());
    Assertions.assertEquals("Iniciando sistema", logEntry.message());
  }
}
