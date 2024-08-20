package com.example.namo.DynamicFiltering;

import java.util.Arrays;
// import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class DynamicFilteringCont {

     @GetMapping("/dynamicfiltering") 
    public MappingJacksonValue staticFilter(){

        Example1 example1= new Example1( "field1" ,"field2" ,"field3" );
        MappingJacksonValue mappingJacksonValue= new MappingJacksonValue(example1);
        SimpleBeanPropertyFilter pf= SimpleBeanPropertyFilter.filterOutAllExcept("field1","field3");
        FilterProvider filter= new SimpleFilterProvider().addFilter("dynamicfiltr", pf);
        mappingJacksonValue.setFilters(filter);
        return mappingJacksonValue;

    }
  
    // Method is same for list also 

    @GetMapping("/dynamilfiltering-list") 
    public MappingJacksonValue  staticFilterList(){
        
         List<Example1> exampleList = Arrays.asList(
            new Example1("field1", "field2", "field3"),
            new Example1("field4", "field5", "field6"),
            new Example1("field7", "field8", "field9")
        );
            
        MappingJacksonValue mappingJacksonValue= new MappingJacksonValue(exampleList);
        SimpleBeanPropertyFilter pf= SimpleBeanPropertyFilter.filterOutAllExcept("field1","field2");
        FilterProvider filter= new SimpleFilterProvider().addFilter("dynamicfiltr", pf);
        mappingJacksonValue.setFilters(filter);
        return  mappingJacksonValue;
       
    }

    
}
