package com.promineotech.jeeps.controller;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import com.promineotech.jeeps.controller.Supports.FetchJeepTestSupport;
import com.promineotech.jeeps.entity.JeepModel;
import com.promineotech.jeeps.entity.Jeeps;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@ActiveProfiles("Test")
@Sql(scripts = { "classpath:flyway/mirgrations/V1.0_Jeep_Schema.sql", 
                 "classpath:flyway/migrations/V1.1_Jeep_Data.sql"},
                  config = @SqlConfig(encoding = "utf-8"))

class FetchJeepTest extends FetchJeepTestSupport{
  
  @Test
  void testDb() {
    
  }
 
  @Autowired
  @LocalServerPort
  void testThatJeepAreReturnedWhenAValidModelAndTrimAreSupplied() {
    JeepModel model = JeepModel.WRANGLER;
    String trim = "Sport";
    String uri = String.format("http://localhost:%d/jeeps?model=%strim=%s", serverPort, model, trim);
    
    ResponseEntity<List<Jeeps>> response = restTemplate.exchange(uri, HttpMethod.GET, null, new ParameterizedTypeReference<>() {});
  
    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
  
  

    List<Jeeps> expected = buildExpected();
    assertThat(response.getBody()).isEqualTo(expected);
  }
  private TestRestTemplate restTemplate;
  
  private int serverPort;

}
