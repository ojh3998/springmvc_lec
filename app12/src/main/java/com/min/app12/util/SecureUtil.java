package com.min.app12.util;

import java.security.MessageDigest;

import org.springframework.stereotype.Component;

@Component
public class SecureUtil {
  
  /**
   * 전달 받은 문자열을 SHA-256 방식의 해시 알고리즘 으로 변환한 결과를 반환하는 메소드
   * SHA-256 방식은 암호화는 가능하고 복호화는 불가능한 단방향 알고리즘
   * java.security 패키지 API를 사용
   * @param original 문자열 원본
   * @return SHA-256 방식으로 암호화 된 문자열
   */
  public String getSHA256(String original) {
    StringBuilder builder = new StringBuilder(); 
    try {
      MessageDigest md = MessageDigest.getInstance("SHA-256");
      md.update(original.getBytes());                             //getBytes() string을 byte[] 로바꿔주는 메소드
      byte[] b = md.digest(); // 결과는 256비트(32바이트) 64글자
      for(int i = 0; i < b.length; i++) {
        builder.append(String.format("%02x", b[i]));
      }
    } catch (Exception e) {
      e.printStackTrace();
    }  
    return builder.toString();
  }

  /**
   * 스크립트 코드를 입력해서 시스템을 공격하는 크로스 사이트 스크립팅
   * 공격을 무력화하기 위한 메소드
   * <code><script></code> 태그 입력을 무력화 하기 위해서
   * &lt; 과 &gt;을 이용하여 입력된 문자열을 반환함
   * @param original
   * @return
   */
  public String getPreventXSS(String original) {
    return original.replace("<script>", "&lt;script&gt;")
                    .replace("</script>", "&lt;/script&gt;");
        
  }
}