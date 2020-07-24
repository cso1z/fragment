package com.xyz.fragment;

/**
 * created by shenyonghui on 2020/7/21
 */
class Log {
    private long lastTime = 0;
    private String clazzName;

    private Log() {

    }

    private volatile static Log log;

    static Log getInstance() {
        if (log == null) {
            log = new Log();
        }
        return log;
    }

    void logCurrentMethod(Class clazz) {
        if (System.currentTimeMillis() - lastTime > 1000 && lastTime != 0) {
            if (clazz.getSimpleName().equals(clazzName)) {
                log("||||||||||||||||" + clazz.getSimpleName() + "||||||||||||||||||||");
            } else {
                log("||||||||||||||||||||||||||||||||||||");
            }
        }
        if (!clazz.getSimpleName().equals(clazzName)) {
            log("--------------" + clazz.getSimpleName() + "--------------");
        }
        log(Thread.currentThread().getStackTrace()[3].getMethodName() + "()");
        lastTime = System.currentTimeMillis();
        clazzName = clazz.getSimpleName();
    }

    private void log(String text) {
        android.util.Log.e("xx", text);
    }
}
