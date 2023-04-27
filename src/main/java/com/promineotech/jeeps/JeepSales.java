package com.promineotech.jeeps;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.promineotech.ComponentScarnMaker;

@SpringBootApplication(scanBasePackageClasses = { ComponentScarnMaker.class})
public class JeepSales {

  public static void main(String[] args) {
  SpringApplication.run(JeepSales.class, args);
}
}
