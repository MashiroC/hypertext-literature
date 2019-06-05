package org.gameboyz.hypertext.literature.util;

/**
 * @author: Shiina18
 * @date: 2019/6/4 20:45
 * @description:
 */
public final class TimeUtil {
    public static String nowTimeString() {
        return String.valueOf(nowTimeLong());
    }

    public static long nowTimeLong() {
        return System.currentTimeMillis() / 1000;
    }
}
