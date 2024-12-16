package com.min.app10.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public interface IUserService {
    // 추상 메소드 선언  //  메소드는 HttpServletRequest를 매개변수로 받고, Map<String, Object>를 반환합니다.
    Map<String, Object> getUserList(HttpServletRequest request);

}
