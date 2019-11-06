package cc.lovezhy.cat;

public class HashOperationsInfo {
    public static ClassMethodNameInfo getInfo() {
        ClassMethodNameInfo classMethodNameInfo = new ClassMethodNameInfo("org/springframework/data/redis/core/DefaultHashOperations", "HASH");
        classMethodNameInfo.addMethodName("delete");
        classMethodNameInfo.addMethodName("hasKey");
        classMethodNameInfo.addMethodName("get");
        classMethodNameInfo.addMethodName("multiGet");
        classMethodNameInfo.addMethodName("increment");
        classMethodNameInfo.addMethodName("keys");
        classMethodNameInfo.addMethodName("lengthOfValue");
        classMethodNameInfo.addMethodName("size");
        classMethodNameInfo.addMethodName("putAll");
        classMethodNameInfo.addMethodName("put");
        classMethodNameInfo.addMethodName("putIfAbsent");
        classMethodNameInfo.addMethodName("values");
        classMethodNameInfo.addMethodName("entries");
        classMethodNameInfo.addMethodName("scan");
        return classMethodNameInfo;
    }
}
