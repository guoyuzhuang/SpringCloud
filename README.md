Eureka-Server：Eureka集群项目


03-Eureka-Feign-Application-Client-HttpClient：
	客户端集成了Feign的通讯优化：压缩GZIP、替换HttpURLConnection为HttpClient
	
	
	
04-Eureka-Feign-Application-Client-Hystrix：
	使用feign解决服务的雪崩处理，解决方案有：降级、熔断、隔离
04-Eureka-Ribbon-Application-Client-Hystrix：
	使用ribbon解决服务的血本处理，解决方案为：降级（发现降级默认开启了熔断策略）
05-Eureka-Turbine：
	完成集群数据服务监控