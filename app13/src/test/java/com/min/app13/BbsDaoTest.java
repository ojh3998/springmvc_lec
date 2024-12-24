package com.min.app13;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;


@SpringJUnitConfig(locations={"file:src/main/webapp/WEB-INF/spring/root-context.xml"
                            , "file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
class BbsDaoTest {

  @Test
  void test() {
    
  }

}
