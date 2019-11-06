package cc.lovezhy.cat;

public class ListOperationsInfo {
    public static ClassMethodNameInfo getInfo() {
        ClassMethodNameInfo classMethodNameInfo = new ClassMethodNameInfo("org/springframework/data/redis/core/DefaultListOperations", "LIST");
        classMethodNameInfo.addMethodName("range");
        classMethodNameInfo.addMethodName("trim");
        classMethodNameInfo.addMethodName("size");
        classMethodNameInfo.addMethodName("leftPush");
        classMethodNameInfo.addMethodName("leftPushAll");
        classMethodNameInfo.addMethodName("leftPushIfPresent");
        classMethodNameInfo.addMethodName("rightPush");
        classMethodNameInfo.addMethodName("rightPushAll");
        classMethodNameInfo.addMethodName("rightPushIfPresent");
        classMethodNameInfo.addMethodName("set");
        classMethodNameInfo.addMethodName("remove");
        classMethodNameInfo.addMethodName("index");
        classMethodNameInfo.addMethodName("leftPop");
        classMethodNameInfo.addMethodName("rightPop");
        classMethodNameInfo.addMethodName("rightPopAndLeftPush");
        return classMethodNameInfo;
    }
}
