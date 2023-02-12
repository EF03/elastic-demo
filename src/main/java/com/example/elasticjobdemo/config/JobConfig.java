package com.example.elasticjobdemo.config;

import org.apache.shardingsphere.elasticjob.lite.lifecycle.api.JobConfigurationAPI;
import org.apache.shardingsphere.elasticjob.lite.lifecycle.api.JobOperateAPI;
import org.apache.shardingsphere.elasticjob.lite.lifecycle.api.JobStatisticsAPI;
import org.apache.shardingsphere.elasticjob.lite.lifecycle.internal.operate.JobOperateAPIImpl;
import org.apache.shardingsphere.elasticjob.lite.lifecycle.internal.settings.JobConfigurationAPIImpl;
import org.apache.shardingsphere.elasticjob.lite.lifecycle.internal.statistics.JobStatisticsAPIImpl;
import org.apache.shardingsphere.elasticjob.reg.zookeeper.ZookeeperRegistryCenter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Ron
 * @Created 10/02/2023
 */
@Configuration
public class JobConfig {

    @Autowired
    private ZookeeperRegistryCenter zookeeperRegistryCenter;

    @Bean
    public JobStatisticsAPI jobStatisticsAPI() {
        return new JobStatisticsAPIImpl(zookeeperRegistryCenter);
    }

    @Bean
    public JobOperateAPI jobOperateAPI() {
        return new JobOperateAPIImpl(zookeeperRegistryCenter);
    }

    @Bean
    public JobConfigurationAPI jobConfigurationAPI() {
        return new JobConfigurationAPIImpl(zookeeperRegistryCenter);
    }

}

