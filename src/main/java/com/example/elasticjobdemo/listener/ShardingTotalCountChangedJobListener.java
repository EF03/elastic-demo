package com.example.elasticjobdemo.listener;

import org.apache.shardingsphere.elasticjob.reg.listener.DataChangedEvent;
import org.apache.shardingsphere.elasticjob.reg.listener.DataChangedEventListener;

/**
 * @author Ron
 * @Created 09/02/2023
 */
public class ShardingTotalCountChangedJobListener implements DataChangedEventListener {
    @Override
    public void onChange(final DataChangedEvent event) {
//        // 修改/config下配置 && 分片数不为0
//        if (configNode.isConfigPath(event.getKey()) && 0 != JobRegistry.getInstance().getCurrentShardingTotalCount(jobName)) {
//            int newShardingTotalCount = YamlEngine.unmarshal(event.getValue(), JobConfigurationPOJO.class).toJobConfiguration().getShardingTotalCount();
//            // 新分片数!=老分片数
//            if (newShardingTotalCount != JobRegistry.getInstance().getCurrentShardingTotalCount(jobName)) {
//                // 判断是否主节点，主节点才能执行
//                if (!leaderService.isLeaderUntilBlock()) {
//                    return;
//                }
//                // 在/leader/sharding节点下新增/necessary节点
//                jobNodeStorage.createJobNodeIfNeeded(ShardingNode.NECESSARY);
//                // 本地缓存分片数
//                JobRegistry.getInstance().setCurrentShardingTotalCount(jobName, newShardingTotalCount);
//            }
//        }
    }
}
