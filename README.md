# 基于Springboot进行的邮件发送

### 支持群发及带附件形式

### 使用依赖:
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-mail</artifactId>
    </dependency>
    <dependency>
        <groupId>com.fasterxml.jackson.core</groupId>
        <artifactId>jackson-databind</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-test</artifactId>
        <scope>test</scope>
    </dependency>
        
springboot版本：2.3.10.RELEASE    

### 较main分支的改进

整合了quartz、mysql、mybatis
将邮件发送至谁，邮件的内容都存到数据库中，配合quartz的cron表达式定时发送邮件
