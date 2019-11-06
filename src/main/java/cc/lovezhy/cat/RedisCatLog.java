//import java.util.Objects;
//
//
//public class RedisCatLog {
//
//    public static final ThreadLocal<RedisCatLog> THREAD_LOCAL_CAT_LOG = new ThreadLocal<>();
//
//    public static void startLog(String action, Object data) {
//        THREAD_LOCAL_CAT_LOG.remove();
//        RedisCatLog redisCatLog = new RedisCatLog(action);
//        redisCatLog.before(String.valueOf(data));
//        THREAD_LOCAL_CAT_LOG.set(redisCatLog);
//    }
//
//    public static void endLog(boolean success) {
//        RedisCatLog redisCatLog = THREAD_LOCAL_CAT_LOG.get();
//        if (Objects.nonNull(redisCatLog)) {
//            redisCatLog.after(success);
//            THREAD_LOCAL_CAT_LOG.remove();
//        }
//    }
//
//    private String action;
//    private Transaction tranx;
//
//    public RedisCatLog(String action) {
//        this.action = action;
//    }
//
//    public void before(String data) {
//        this.tranx = Cat.newTransaction("Cache.", this.action);
//        this.tranx.addData("key", data);
//    }
//
//    public void after(boolean success) {
//        if (!success) {
//            this.tranx.setStatus("failed");
//        } else {
//            this.tranx.setStatus("0");
//        }
//        this.tranx.complete();
//    }
//}
