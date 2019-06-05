package org.gameboyz.hypertext.literature.been.jwt;

import com.google.gson.Gson;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Description Jwt的实体
 * @Author 余歌
 * @Date 2018/10/10
 **/

public class Jwt {

    /**
     * 全局使用gson作为json解析器
     */
    private static final Gson GSON = new Gson();

    /**
     * jwt的首部
     */
    private Map<String, String> header;

    /**
     * jwt的负载
     */
    private Map<String, String> payload;

    /**
     * jwt的签名
     */
    private String signature;

    /**
     * 拿到头部的参数的map
     */
    public Map<String, String> getHeaderMap() {
        return header;
    }

    /**
     * 拿到负载的参数的map
     */
    public Map<String, String> getPlayloadMap() {
        return payload;
    }

    /**
     * 拿到未用base64编码的头部json串
     */
    public String getHeaderJson() {
        return GSON.toJson(header);
    }

    /**
     * 拿到未用base64编码的负载json串
     */
    public String getPlayloadJson() {
        return GSON.toJson(payload);
    }

    /**
     * 拿到签名，在此之前应该生成它
     */
    public String getSignature() {
        return signature;
    }

    /**
     * 私有化无参构造方法，并抛出异常来防止被使用反射调用
     */
    private Jwt() {
        throw new RuntimeException("could not do this");
    }

    /**
     * 在拿到一个jwt串后使用jwt串来构造jwt
     *
     * @param headerStr   已base64解码的头部
     * @param playloadStr 已base64解码的负载
     * @param signature   签名
     */
    public Jwt(String headerStr, String playloadStr, String signature) {

        header = GSON.fromJson(headerStr, LinkedHashMap.class);
        payload = GSON.fromJson(playloadStr, LinkedHashMap.class);

        this.signature = signature;
    }

    /**
     * 提供加密算法和有效时间来构造一个jwt
     *
     * @param algorithm     加密算法名
     * @param effectiveTime 有效时间
     */
    public Jwt(String algorithm, long effectiveTime) {
        header = new LinkedHashMap<>();
        payload = new LinkedHashMap<>();

        header.put("typ", "jwt");
        header.put("alg", algorithm);

        refreshEffectiveTime(effectiveTime);
    }

    /**
     * 刷新此jwt的有效时间
     *
     * @param effectiveTime 有效持续时间
     */
    public void refreshEffectiveTime(long effectiveTime) {
        Date date = new Date();
        long nowTime = date.getTime() / 1000;
        payload.put("nbf", String.valueOf(nowTime));
        payload.put("exp", String.valueOf(nowTime + effectiveTime));
    }

    public boolean isOvertime() {
        long now = System.currentTimeMillis() / 1000;
        long jwtExp = Long.parseLong(payload.get("exp"));
        long jwtNbf = Long.parseLong(payload.get("nbf"));
        return now > jwtExp || now < jwtNbf;
    }

    /**
     * 设置负载参数
     *
     * @param key   参数名
     * @param value 参数值
     */
    public void setParameter(String key, String value) {
        payload.put(key, value);
    }

    /**
     * 拿到负载参数
     *
     * @param key 参数名
     * @return 参数值
     */
    public Object getParameter(String key) {
        return payload.get(key);
    }

    /**
     * 生成签名
     *
     * @param key 加密的私钥
     */
    public void initSecret(String key) {
        String text = SecretUtil.encodeBase64(getHeaderJson()) + "." + SecretUtil.encodeBase64(getPlayloadJson());
        signature = SecretUtil.encodeBase64(SecretUtil.encode(header.get("alg"), key, text));
    }

    /**
     * 得到jwt串
     *
     * @return jwt
     */
    @Override
    public String toString() {
        if (signature != null) {
            String headerJson = getHeaderJson();
            String payloadJson = getPlayloadJson();
            return SecretUtil.encodeBase64(headerJson) + "." + SecretUtil.encodeBase64(payloadJson) + "." + signature;
        } else {
            throw new RuntimeException("jwt signature not init!");
        }
    }

    public static Jwt fromString(String jwtStr) {
        Jwt jwt = null;
        if (jwtStr != null) {
            String[] str = jwtStr.split("\\.");
            try {
                String header = SecretUtil.decodeBase64(str[0]);
                String payload = SecretUtil.decodeBase64(str[1]);
                String secret = str[2];
                jwt = new Jwt(header, payload, secret);
            } catch (Throwable e) {
                System.out.println("传入了错误的jwt" + jwtStr);
            }
        }
        return jwt;
    }

}