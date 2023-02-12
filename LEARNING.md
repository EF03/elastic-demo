* [Springboot + Elasticjob-lite 3.x + Elasticjob-lite-UI可视化](https://blog.csdn.net/qq_40096897/article/details/126745502)
* [浅析 ElasticJob-Lite 3.x 定时任务](https://juejin.cn/post/7114816346969341960)

# 提供API

* 配置类 API
* 操作类 API
* 操作分片的 API
* 作业统计 API
* 作业服务器状态展示 API
* 作业分片状态展示 API


> 新增需打接口，無法直接從UI介面調整
> UI提供 修改/觸發/無效/停止/刪除

# 策略

* 如何確保只分到一次
> A01,A02,A04,A05,C02,C08,E04
> 
> * 最多開 7*2=14
> * 最少開 7
> 
> 0 1 2 3 4 5 6 7 8 9 10 11 12 13

p:產品個數
n:切片總數

n > p 不執行

如果正式服務小於7時
如果同一產品被分配到兩個?

# 命名規則
* JOB ID
  * A01_JOB_NAME
  * ${product_id}任務名稱
* JOB參數多帶product_id


# APP更動
* 確認JOB帶的參數與APP配置的product_id一致


# WS更動
* 發給APP的MQ額外再發一個，只能被收到一次