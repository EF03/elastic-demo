package com.example.elasticjobdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ElasticjobDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ElasticjobDemoApplication.class, args);

        // 入口
//        new ScheduleJobBootstrap(createRegistryCenter(),new MyJob(),createJobConfiguration()).schedule();
    }

//    public static CoordinatorRegistryCenter createRegistryCenter(){
//        CoordinatorRegistryCenter registryCenter = new ZooKeeper RegistryCenter(
//                new  ZooKeeper Configuration("localhost:2181","my-job"));
//        // 初始化
//        registryCenter.init();
//        return registryCenter;
//    }
//
//    public static JobConfiguration createJobConfiguration() {
//        // 配置基本信息
//        JobConfiguration jobConfiguration = JobConfiguration.newBuilder("Myjob",3)
//                .cron("0 0/30 * * * ?").shardingItemParameters("0=Beijing,1=Shanghai,2=Guangzhou")
//                .jobErrorHandlerType("LOG").jobShardingStrategyType("ROUND_ROBIN").overwrite(true).failover(true)
//                .monitorExecution(true).build();
//        // 配置数据库日志 - 选配
//        TracingConfiguration tc = new TracingConfiguration("RDB",getDataSource());
//        jobConfiguration.getExtraConfigurations().add(tc);
//        return jobConfiguration;
//    }
//
//    public static BasicDataSource getDataSource(){
//        BasicDataSource dataSource = new BasicDataSource();
//        dataSource.setDriverClassName(com.mysql.cj.jdbc.Driver.class.getName());
//        dataSource.setUrl("jdbc:mysql://localhost:3306/batch_log?useUnicode=true&useSSL=false&characterEncoding=UTF-8&allowMultiQueries=true&serverTimezone=GMT%2B8");
//        dataSource.setUsername("root");
//        dataSource.setPassword(你的密码);
//        return dataSource;
//    }






}
