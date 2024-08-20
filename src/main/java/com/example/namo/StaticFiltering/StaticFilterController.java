package com.example.namo.StaticFiltering;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StaticFilterController {
      
   @GetMapping("/filtering") 
    public Example staticFilter(){

        return new Example( "field1" ,"field2" ,"field3" );

    }
  
    // Method is same for list also 

    @GetMapping("/filtering-list") 
    public List<Example> staticFilterList(){
        
        return Arrays.asList(new Example( "field1" ,"field2" ,"field3" ),new Example( "field4" ,"field5" ,"field6" ),new Example( "field7" ,"field8" ,"field9" )) ;

    }
    
}
