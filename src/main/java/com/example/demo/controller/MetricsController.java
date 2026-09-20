package com.example.demo.controller;

import com.zaxxer.hikari.HikariDataSource;
import com.zaxxer.hikari.HikariPoolMXBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/metrics")
public class MetricsController {

    @Autowired
    private DataSource dataSource;

    @GetMapping("/connection-pool")
    public Map<String, Object> getConnectionPoolMetrics() {
        Map<String, Object> metrics = new HashMap<>();

        if (dataSource instanceof HikariDataSource) {
            HikariDataSource hikariDataSource = (HikariDataSource) dataSource;
            HikariPoolMXBean poolMXBean = hikariDataSource.getHikariPoolMXBean();

            metrics.put("activeConnections", poolMXBean.getActiveConnections());
            metrics.put("idleConnections", poolMXBean.getIdleConnections());
            metrics.put("totalConnections", poolMXBean.getTotalConnections());
            metrics.put("threadsAwaitingConnection", poolMXBean.getThreadsAwaitingConnection());
            metrics.put("maximumPoolSize", hikariDataSource.getMaximumPoolSize());
            metrics.put("minimumIdle", hikariDataSource.getMinimumIdle());
            metrics.put("connectionTimeout", hikariDataSource.getConnectionTimeout());
        } else {
            metrics.put("error", "DataSource is not HikariCP");
        }

        return metrics;
    }
}
