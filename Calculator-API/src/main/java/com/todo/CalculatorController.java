package com.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculator")
public class CalculatorController {
	@Autowired
	CalculatorService calculatorService;
    
    @CrossOrigin
    @PostMapping(value = "/add", consumes = "application/json")
    public double add(@RequestBody String numbersJson) {
        return  calculatorService.add(numbersJson);
    }

    @CrossOrigin
    @PostMapping(value = "/sub", consumes = "application/json")
    public double subtraction(@RequestBody String numbersJson) {
    	return calculatorService.subtraction(numbersJson);
    }

    @CrossOrigin
    @PostMapping(value = "/mul", consumes = "application/json")
    public double multiplication(@RequestBody String numbersJson) {
    	return calculatorService.multiplication(numbersJson);
    }

    @CrossOrigin
    @PostMapping(value = "/div", consumes = "application/json")
    public double division(@RequestBody String numbersJson) throws Exception {
    	return calculatorService.division(numbersJson);
    }
}