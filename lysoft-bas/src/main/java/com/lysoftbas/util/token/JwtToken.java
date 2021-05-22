package com.lysoftbas.util.token;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * lysoft
 * Creat by zmy on 2021-05-17 14:42
 */
public class JwtToken {

    /**
     * 公用密钥-保存在服务端，客户端是不会知道密钥的，以防被攻击
     */
    public static String SECRET = "FreeMa";
    /**
     * 生成Token
     */

    public static String createToken(){
        //签发时间
        Date iatDate = new Date();
        //过期时间 1分钟过期
        Calendar nowTime = Calendar.getInstance();
        nowTime.add(Calendar.MINUTE,1);
        Date expiresDate = nowTime.getTime();

        Map<String,Object> map = new HashMap<>();
        map.put("alg","HS256");
        map.put("typ","JWT");
        String token = JWT.create()
                .withHeader(map) //header
                .withClaim("name","张三") //payload
                .withClaim("age","26")
                .withClaim("org","头条")
                .withExpiresAt(expiresDate) //设置过期时间，过期时间要大于签发时间
                .withIssuedAt(iatDate) //设置签发时间
                .sign(Algorithm.HMAC256(SECRET)); //加密


        return token;
    }


    /**
     * 解密Token
     */
    public static Map<String, Claim> verifyToken(String token){

        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(SECRET)).build();
        DecodedJWT jwt = null;
        try {
            jwt = verifier.verify(token);
        }catch (Exception e){
            throw new RuntimeException("登录凭证已过期");

        }

        return jwt.getClaims();
    }











}
