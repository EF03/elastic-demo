package com.example.elasticjobdemo.controller;

import cn.hutool.extra.spring.SpringUtil;
import cn.hutool.json.JSONUtil;
import com.example.elasticjobdemo.job.MyElasticJob;
import com.example.elasticjobdemo.request.JobReq;
import org.apache.shardingsphere.elasticjob.api.JobConfiguration;
import org.apache.shardingsphere.elasticjob.lite.api.bootstrap.impl.ScheduleJobBootstrap;
import org.apache.shardingsphere.elasticjob.lite.lifecycle.api.JobConfigurationAPI;
import org.apache.shardingsphere.elasticjob.lite.lifecycle.api.JobOperateAPI;
import org.apache.shardingsphere.elasticjob.lite.lifecycle.api.JobStatisticsAPI;
import org.apache.shardingsphere.elasticjob.lite.lifecycle.domain.JobBriefInfo;
import org.apache.shardingsphere.elasticjob.reg.base.CoordinatorRegistryCenter;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author Ron
 * @Created 10/02/2023
 */
@RequestMapping("/job")
@RestController
public class JobController {

    /**
     * 注入执行中要用到的API
     */
    @Resource
    private JobStatisticsAPI jobStatisticsAPI;

    @Resource
    private JobOperateAPI jobOperateAPI;

    @Resource
    private JobConfigurationAPI jobConfigurationAPI;


    @Resource
    private CoordinatorRegistryCenter coordinatorRegistryCenter;


    @PostMapping("/add")
    public String add(@RequestBody JobReq request) {
        new ScheduleJobBootstrap(coordinatorRegistryCenter, SpringUtil.getBean(MyElasticJob.class), createJobConfiguration(request.getId())).schedule();
        return "success";
    }

    private JobConfiguration createJobConfiguration(String id) {
        return JobConfiguration.newBuilder(id, 3).cron("0/10 * * * * ?").shardingItemParameters("0=Beijing-dynamic,1=Shanghai-dynamic,2=Guangzhou-dynamic").build();
    }

    @DeleteMapping("/remove")
    public void remove(@RequestBody JobReq request) {
        String name = "A01_" + request.getId();
        // 查询  如果不存在则为null
        JobBriefInfo jobBriefInfo = jobStatisticsAPI.getJobBriefInfo(name);
        if (jobBriefInfo != null) {
            // 从所有实例中移除job，UI显示为已下线，第二个参数为IP，为null时包含所有IP
            jobOperateAPI.remove(name, null);
            // jobName / serverIp
//            jobOperateAPI.disable();
            // 从注册中心删除job， UI不再显示
            jobConfigurationAPI.removeJobConfiguration(name);
        }
    }


    @GetMapping("/all")
    public Object all() {
        return JSONUtil.toJsonPrettyStr(jobStatisticsAPI.getAllJobsBriefInfo());
    }

}
