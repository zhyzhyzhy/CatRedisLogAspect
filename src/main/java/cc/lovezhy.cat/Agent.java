package cc.lovezhy.cat;


import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.LoaderClassPath;

import java.io.ByteArrayInputStream;
import java.lang.instrument.Instrumentation;
import java.util.Objects;

public class Agent {

    static String packageName = "cc.lovezhy.RedisCatLog";

    public static void premain(String agentArgs, Instrumentation inst) {
        inst.addTransformer((classLoader, s, aClass, protectionDomain, bytes) -> {
            if (Objects.nonNull(ClassConfig.get(s))) {
                ClassMethodNameInfo classMethodNameInfo = ClassConfig.get(s);
                byte[] transformed = null;
                CtClass cl = null;
                try {
                    ClassPool pool = new ClassPool();
                    pool.insertClassPath(new LoaderClassPath(classLoader));
                    pool.importPackage(packageName);
                    cl = pool.makeClass(new ByteArrayInputStream(bytes));
                    CtMethod[] methods = cl.getDeclaredMethods();

                    for (int i = 0; i < methods.length; i++) {
                        if (classMethodNameInfo.containsMethod(methods[i].getName())) {
                            String methodName = methods[i].getName();
                            CtClass etype = ClassPool.getDefault().get("java.lang.Throwable");
                            methods[i].addCatch("{ RedisCatLog.endLog(false); throw $e; }", etype);
                            methods[i].insertBefore(before(classMethodNameInfo.getType() + "-" + methodName));
                            methods[i].insertAfter(after());
                        }
                    }

                    transformed = cl.toBytecode();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (cl != null) {
                        cl.detach();
                    }
                }
                return transformed;
            }
            return null;
        });
    }

    public static String before(String action) {
        return String.format("try { RedisCatLog.startLog(\"%s\", $1); } catch (Throwable e) {}", action);
    }

    public static String after() {
        return "try{ RedisCatLog.endLog(true);} catch (Throwable e) {}";
    }

}
