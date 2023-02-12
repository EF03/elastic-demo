package com.example.elasticjobdemo.job;

import cn.hutool.json.JSONUtil;
import com.example.elasticjobdemo.request.JobReq;
import lombok.extern.slf4j.Slf4j;
import org.apache.shardingsphere.elasticjob.api.ShardingContext;
import org.apache.shardingsphere.elasticjob.simple.job.SimpleJob;
import org.springframework.stereotype.Component;

/**
 * @author Ron
 * @Created 09/02/2023
 */
@Slf4j
@Component
public class MyElasticJob implements SimpleJob {

    /**
     * 要调度的具体任务，时间段轮循
     */
    @Override
    public void execute(ShardingContext shardingContext) {
        log.info(String.format("定时任务-测试%s %s %d %s",
                shardingContext.getJobName(),
                shardingContext.getTaskId(),
                shardingContext.getShardingItem(),
                JSONUtil.toBean(shardingContext.getJobParameter(), JobReq.class).getId()));
    }

}
