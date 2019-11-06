package cc.lovezhy.cat;

import java.util.HashSet;
import java.util.Set;

public class ClassMethodNameInfo {
    private String className;

    private String type;

    private Set<String> methodNameSets = new HashSet<>();

    public ClassMethodNameInfo(String className, String type) {
        this.className = className;
        this.type = type;
    }

    public void addMethodName(String methodName) {
        methodNameSets.add(methodName);
    }

    public String getClassName() {
        return className;
    }

    public String getType() {
        return type;
    }

    public boolean containsMethod(String methodName) {
        return methodNameSets.contains(methodName);
    }
}
