# CatRedisLogAspect
给SpringBoot的RedisTemplate进行方法的Cat打点

# 背景
SpringBoot中的各种Redis具体操作类都不是public，无法切面进行Cat打点耗时  
且RedisTemplate未提供可以插入代码的逻辑

# 使用
1. 复制RedisCatLog.java至项目的代码中
2. 修改Agent类中的packageName，改为真实项目的包路径
3. mvn package
4. 运行SpringBoot的jar包时带上agent包  
 `java -javaagent:'XX/cat-1.0-SNAPSHOT-jar-with-dependencies.jar' -jar XX.jar`
 
# 原理
javaagent插桩，参见Agent类

例如：DefaultZSetOperations的add方法
```java
public Boolean add(K key, V value, double score) {
    byte[] rawKey = rawKey(key);
    byte[] rawValue = rawValue(value);
    return execute(connection -> connection.zAdd(rawKey, score, rawValue), true);
}
```

修改后的代码
```java
public Boolean add(K key, V value, double score) {
    try {
        RedisCatLog.startLog("ZSET-add", key);
    } catch (Throwable var13) {
    }

    Boolean var10000;
    try {
        byte[] rawKey = this.rawKey(key);
        byte[] rawValue = this.rawValue(value);
        var10000 = (Boolean)this.execute((connection) -> {
            return connection.zAdd(rawKey, score, rawValue);
        }, true);
    } catch (Throwable var12) {
        RedisCatLog.endLog(false);
        throw var12;
    }

    Boolean var9 = var10000;

    try {
        RedisCatLog.endLog(true);
    } catch (Throwable var11) {
    }

    return var9;
}
```