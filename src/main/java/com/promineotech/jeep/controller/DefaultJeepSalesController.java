package com.promineotech.jeep.controller;

import java.util.List;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.jeeps.entity.Jeeps;

@RestController


  public class DefaultJeepSalesController implements JeepSalesController {@Override
  public List<Jeeps> fetchJeeps(String model, String trim) {
    return null;
    
  }

   

  }

