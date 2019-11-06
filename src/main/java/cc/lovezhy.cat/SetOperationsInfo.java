package cc.lovezhy.cat;

public class SetOperationsInfo {
    public static ClassMethodNameInfo getInfo() {
        ClassMethodNameInfo classMethodNameInfo = new ClassMethodNameInfo("org/springframework/data/redis/core/DefaultSetOperations", "SET");
        classMethodNameInfo.addMethodName("add");
        classMethodNameInfo.addMethodName("remove");
        classMethodNameInfo.addMethodName("pop");
        classMethodNameInfo.addMethodName("move");
        classMethodNameInfo.addMethodName("size");
        classMethodNameInfo.addMethodName("isMember");
        classMethodNameInfo.addMethodName("intersect");
        classMethodNameInfo.addMethodName("intersectAndStore");
        classMethodNameInfo.addMethodName("union");
        classMethodNameInfo.addMethodName("unionAndStore");
        classMethodNameInfo.addMethodName("difference");
        classMethodNameInfo.addMethodName("differenceAndStore");
        classMethodNameInfo.addMethodName("members");
        classMethodNameInfo.addMethodName("randomMember");
        classMethodNameInfo.addMethodName("distinctRandomMembers");
        classMethodNameInfo.addMethodName("randomMembers");
        classMethodNameInfo.addMethodName("scan");
        return classMethodNameInfo;
    }
}
