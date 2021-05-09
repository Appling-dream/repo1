package com.atlilapp.jwt.utils;

import com.atlilapp.jwt.entity.Member;
import io.jsonwebtoken.*;

import java.util.Date;

/**
 * @author lilApp
 * @date 2021/4/16--21:28
 * @Version 1.0
 */
public class JwtUtils {

    public static final String SUBJECT = "lilapp-user";

    //    密钥
    public static final String APP_SECRECT = "79e7c69681b8270162386e6daa53d1dc";

    //    过期时间，毫秒，30分钟
    public static final long EXPIRE = 10;

    /**
     * 生成Jwt令牌
     *
     * @param member
     * @return
     */
    public static String generateJwt(Member member) {
        //创建builder对象
        JwtBuilder builder = Jwts.builder();
        //第一部分：Jwt头 header
        builder.setHeaderParam("alg", "HS256");//签名加密算法
        builder.setHeaderParam("type", "JWT");//令牌类型
        //有效载荷 Playload
        //默认字段
        builder.setId("1"); // jwt的唯一身份标识，主要用来作为一次性token,从而回避重放攻击。
        builder.setSubject(SUBJECT); //令牌主题
        builder.setIssuedAt(new Date());
        builder.setExpiration(new Date(System.currentTimeMillis() + EXPIRE));//过期时间

        //私有字段，自定义字段
        builder.claim("id", member.getId());
        builder.claim("nickname", member.getNickname());
        builder.claim("avatar", member.getAvatar());

        //第三部分：签名哈希 VERIFY SIGNATURE
        builder.signWith(SignatureAlgorithm.HS256, APP_SECRECT).compact();

        //第三部分连接起来
        String token = builder.compact();
        return token;
    }

    public static Claims checkJwt(String jwtToken) {
        Jws<Claims> claimsJws = Jwts.parser().setSigningKey(APP_SECRECT).parseClaimsJws(jwtToken);
        JwsHeader header = claimsJws.getHeader();
        Claims body = claimsJws.getBody();
        String signature = claimsJws.getSignature();

        return body ;

    }


}
