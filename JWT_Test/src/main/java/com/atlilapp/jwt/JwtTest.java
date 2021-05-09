package com.atlilapp.jwt;

import com.atlilapp.jwt.entity.Member;
import com.atlilapp.jwt.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import org.junit.Test;

/**
 * @author lilApp
 * @date 2021/4/16--21:58
 * @Version 1.0
 */
public class JwtTest {
    @Test
    public void testGenerageJwt(){
        Member member = new Member();
        member.setId("10000");
        member.setNickname("Helen");
        member.setAvatar("1.png");
        String jwt = JwtUtils.generateJwt(member);
        System.out.println(jwt);
    }

    @Test
    public void testCheckJwt(){

        /*Claims claims = JwtUtils.checkJwt("jwt字符串");

        String id = (String)claims.get("id");
        String nickname = (String)claims.get("nickname");
        String avatar = (String)claims.get("avatar");

        System.out.println(id);
        System.out.println(nickname);
        System.out.println(avatar);*/

        Claims claims = JwtUtils.checkJwt("eyJhbGciOiJIUzI1NiIsInR5cGUiOiJKV1QifQ.eyJqdGkiOiIxIiwic3ViIjoibGlsYXBwLXVzZXIiLCJpYXQiOjE2MTg1OTI4MTMsImV4cCI6MTYxODU5MjgxMywiaWQiOiIxMDAwMCIsIm5pY2tuYW1lIjoiSGVsZW4iLCJhdmF0YXIiOiIxLnBuZyJ9.s-PttQSqLblmxJvpNenwzfsLI-CxKCyig9fX4sGn9bs");
        String id = claims.getId();//默认字段 的jwi
        String id1 = claims.get("id", String.class);
        String id2 = (String) claims.get("id");

        String nickname = claims.get("nickname", String.class);
        String nickname1 = (String) claims.get("nickname");

        String avatar = claims.get("avatar", String.class);
        String avatar1 = (String) claims.get("avatar");

        System.out.println(id);
        System.out.println(id1);
        System.out.println(id2);
        System.out.println(nickname);
        System.out.println(nickname1);
        System.out.println(avatar);
        System.out.println(avatar1  );



    }

}
