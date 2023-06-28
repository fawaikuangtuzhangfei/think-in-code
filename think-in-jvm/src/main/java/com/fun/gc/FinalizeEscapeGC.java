package com.fun.gc;

import java.util.concurrent.TimeUnit;

/**
 * 对象finalize()自救
 * @author Java男朋友
 * @date 2022-08-25 8:11
 */
public class FinalizeEscapeGC {

    public static FinalizeEscapeGC SAVE_HOOK = null;

    public void isAlive(){
        System.out.println("i am alive");
    }


    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        SAVE_HOOK = this;
        System.out.println("肖申克的救赎");
    }

    public static void main(String[] args) {
        SAVE_HOOK = new FinalizeEscapeGC();

        // 第一次可以成功拯救自己
        SAVE_HOOK = null;
        System.gc();

        try { TimeUnit.SECONDS.sleep(2); } catch (InterruptedException e) { e.printStackTrace(); }

        if(SAVE_HOOK == null){
            System.out.println("i am dead");
        }else{
            SAVE_HOOK.isAlive();
        }

        // 第二次可以救不了自己
        SAVE_HOOK = null;
        System.gc();

        try { TimeUnit.SECONDS.sleep(2); } catch (InterruptedException e) { e.printStackTrace(); }

        if(SAVE_HOOK == null){
            System.out.println("i am dead");
        }else{
            SAVE_HOOK.isAlive();
        }


    }
}
