package com.cml.demo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.shadow.com.univocity.parsers.common.CommonParserSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@SpringBootTest
public class PhoneNum {

    @Autowired
    private StringRedisTemplate sr;
@Test
void contextLoads() {
    send("133333");
}
//    public void verifyCode(String phone,String code){
//      String countKey=phone+"countKey:";
//      String codeKey=phone+"codeKey:";
//      String count = sr.opsForValue().get(countKey);
//      if(Integer.parseInt(count)==0){
//          sr.opsForValue().set(countKey,"1",2, TimeUnit.MINUTES);
//      }else if(Integer.parseInt(count)<3){
//         sr.opsForValue().increment(codeKey);
//      }else{
//          System.out.println("out of range");
//      }
//        String vCode = getCode();
//        sr.opsForValue().set(codeKey,vCode);
//    }
    public void send(String phone){
         String code=getCode();
         System.out.println(code);
         sr.opsForHash().put(phone,"code",code);
         sr.expire(phone,1, TimeUnit.DAYS);
        if(!sr.opsForHash().hasKey(phone,"count")){
            sr.opsForHash().put(phone,"count","1");
        }else if(Integer.parseInt((String) sr.opsForHash().get(phone,"count"))==1){
            sr.opsForHash().put(phone,"count","2");
        }else if(Integer.parseInt((String) sr.opsForHash().get(phone,"count"))==2){
            sr.opsForHash().put(phone,"count","3");
        }else{
            System.out.println("out..");
        }

//         if(sr.opsForHash().get(phone,"count")==null){
//         sr.opsForHash().put(phone,"count",1);}
    }

    public static String getCode(){
        Random random = new Random();
        String res="";
        for (int i=0;i<6;i++){
            res+=random.nextInt(10);
        }
         return res;
    }
}
