package org.gameboyz.hypertext.literature.been.jwt;


import java.lang.reflect.Field;

/**
 * @Description
 * @Author 余歌
 * @Date 2018/10/10
 **/

public class JwtHelper<T> {

    /**
     * 密钥
     */
    private String secretKey;

    /**
     * 加密方法
     */
    private String algorithm;

    /**
     * 有效时间 单位：秒(s)
     */
    private long effectiveTime;

    /**
     * jwt签发者
     */
    private String iss;

    /**
     * jwt所面对的用户
     */
    private String sub;

    /**
     * 接收jwt的一方
     */
    private String aud;

    public void setIss(String iss) {
        this.iss = iss;
    }

    public void setSub(String sub) {
        this.sub = sub;
    }

    public void setAud(String aud) {
        this.aud = aud;
    }

    /**
     * 创建一个Helper
     *
     * @param alg           加密算法
     * @param effectiveTime 有效时间
     * @param secretKey     密钥
     */
    public JwtHelper(String alg, long effectiveTime, String secretKey) {
        this.algorithm = alg;
        this.effectiveTime = effectiveTime;
        this.secretKey = secretKey;
    }

    private JwtHelper(JwtHelper helper) {
        this.secretKey = helper.secretKey;
        this.algorithm = helper.algorithm;
        this.aud = helper.aud;
        this.effectiveTime = helper.effectiveTime;
        this.iss = helper.iss;
        this.sub = helper.sub;
    }

    /**
     * 生成一个jwt
     *
     * @param t 放在负载的数据
     * @return 生成的jwt
     */
    public Jwt createJwt(T t) {

        Jwt jwt = new Jwt(algorithm, effectiveTime);
        if (iss != null) {
            jwt.setParameter("iss", iss);
        }
        if (sub != null) {
            jwt.setParameter("sub", sub);
        }
        if (aud != null) {
            jwt.setParameter("aud", aud);
        }

        if (t != null) {
            Field[] fields = t.getClass().getDeclaredFields();

            try {

                for (Field field : fields) {
                    field.setAccessible(true);
                    if (field.get(t) != null) {
                        jwt.setParameter(field.getName(), String.valueOf(field.get(t)));
                    }
                }

            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        jwt.initSecret(secretKey);

        return jwt;
    }

    /**
     * 从一个jwt字符串构造jwt对象
     *
     * @param jwtStr jwt字符串
     * @return 生成的jwt
     */


    /**
     * 验证jwt有效性
     *
     * @param jwt jwt
     * @return 正确与否
     */
    public boolean isAccess(Jwt jwt) {
        String headerJson = jwt.getHeaderJson();
        String playloadJson = jwt.getPlayloadJson();
        String secret = jwt.getSignature();

        String encodeHeader = SecretUtil.encodeBase64(headerJson);
        String encodePlayload = SecretUtil.encodeBase64(playloadJson);
        String text = encodeHeader + "." + encodePlayload;
        String encodeText = SecretUtil.encodeBase64(SecretUtil.encode(algorithm, secretKey, text));

        return encodeText.equals(secret);
    }

}
