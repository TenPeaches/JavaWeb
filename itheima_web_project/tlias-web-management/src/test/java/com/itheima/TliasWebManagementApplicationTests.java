package com.itheima;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@SpringBootTest
class TliasWebManagementApplicationTests {

    @Test
    public void testUuid() {
        for (int i = 0; i < 1000; i++) {
            String uuid = UUID.randomUUID().toString();
            System.out.println(uuid);

        }
    }

    @Test
    public void tsetGenJwt(){
        Map<String,Object>claims=new HashMap<>();
        claims.put("id",1);
        claims.put("name","Tom");
        String jwt = Jwts.builder().signWith(SignatureAlgorithm.HS256, "itheima")//设置加密算法和密钥
                .setClaims(claims)//设置载荷
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24))//设置过期时间
                .compact();
        System.out.println(jwt);
    }

    @Test
    public void testParseJwt(){
        Claims claims = Jwts.parser()
                .setSigningKey("itheima")
                .parseClaimsJws("eyJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoiVG9tIiwiaWQiOjEsImV4cCI6MTcyODQ1ODgxMn0.xmpurCs7nOfsLDeS0zCCaoT_ZwKQLeHNOM_L-jWWjJ4")
                .getBody();
        System.out.println(claims);
    }
}
