package com.JCarlos67.logstats.model;

import java.time.LocalDateTime;

public record LogEntry (LocalDateTime timestamp, String level, String message) {}
