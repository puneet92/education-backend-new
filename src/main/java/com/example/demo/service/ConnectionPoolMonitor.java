package com.example.demo.service;

import com.zaxxer.hikari.HikariDataSource;
import com.zaxxer.hikari.HikariPoolMXBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;

@Service
public class ConnectionPoolMonitor {

    private static final Logger logger = LoggerFactory.getLogger(ConnectionPoolMonitor.class);

    @Autowired
    private DataSource dataSource;

    // Log pool stats every 60 seconds
    @Scheduled(fixedRate = 60000)
    public void logPoolStats() {
        if (dataSource instanceof HikariDataSource) {
            HikariDataSource hikariDataSource = (HikariDataSource) dataSource;
            HikariPoolMXBean pool = hikariDataSource.getHikariPoolMXBean();

            logger.info("=== Connection Pool Stats ===");
            logger.info("Active Connections: {}", pool.getActiveConnections());
            logger.info("Idle Connections: {}", pool.getIdleConnections());
            logger.info("Total Connections: {}", pool.getTotalConnections());
            logger.info("Threads Waiting: {}", pool.getThreadsAwaitingConnection());
            logger.info("Max Pool Size: {}", hikariDataSource.getMaximumPoolSize());
            logger.info("============================");
        }
    }
}
