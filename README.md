# microservice
- 基于Spring Cloud部署微服务

## 技术栈
- 服务的注册与发现：Spring Cloud Eureka (计划改用Consul)
- 反向代理：Nginx
- 负载均衡：Ribbon
- 服务间通信：Openfeign
- 消息队列：RabbitMQ (计划改用 ActiveMQ)
- 服务网关：Spring Cloud Zuul
- 熔断机制： Hystrix
- 分布式跟踪：Spring Cloud Zipkin + Spring Cloud Sleuth
- 数据库：MySQL
- 缓存：Redis
- 部署：Docker + Rancher
- 依赖管理：Maven

## 各模块简介
- eureka: 服务注册中心和服务订阅中心，服务调用中转站
- client: 测试用客户端
- config: 统一配置管理中心
- order: 订单服务中心
- product: 产品服务中心
- user: 用户服务中心
- api-gateway: 服务网关，把控、管理、转发服务间的交互 同时管理整体与外界交互

## Docker 环境搭建
