package com.example.elasticjobdemo.job;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.shardingsphere.elasticjob.api.ShardingContext;
import org.apache.shardingsphere.elasticjob.dataflow.job.DataflowJob;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author Ron
 * @Created 09/02/2023
 */
@Slf4j
@Component
public class SpringBootDataflowJob implements DataflowJob<String> {

    @Override
    public List<String> fetchData(final ShardingContext shardingContext) {
        List<String> dex = new ArrayList<>();
        dex.add(UUID.randomUUID().toString());
        dex.add(UUID.randomUUID().toString());
        dex.add(UUID.randomUUID().toString());
        return dex;
    }

    @SneakyThrows
    @Override
    public void processData(final ShardingContext shardingContext, final List<String> data) {
        for (String each : data) {
            log.info(String.format("定时任务-测试%s %s %d %s", shardingContext.getJobName(), shardingContext.getTaskId(), shardingContext.getShardingItem(), each));
        }
    }
}

