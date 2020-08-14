package com.todo;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CalculatorService {

	public double add(String numbersJson) {
		log.debug("Request : {}", numbersJson);
		double result = 0;
        if (numbersJson != null && !StringUtils.isEmpty(numbersJson)) {
            JSONObject jsonObject = new JSONObject(numbersJson);
            JSONArray jsonArray = jsonObject.getJSONArray("numbers");
            if (jsonArray != null && jsonArray.length() > 0) {
                for (int i = 0; i < jsonArray.length(); i++) {
                    result = result + jsonArray.getLong(i);
                }
            }
        }
        log.info("Addition Result:{}", result);
		return result;
	}
	
	public double subtraction(String numbersJson) {
		log.debug("Request : {}", numbersJson);
		double result = 0;
        if (numbersJson != null && !StringUtils.isEmpty(numbersJson)) {
            JSONObject jsonObject = new JSONObject(numbersJson);
            JSONArray jsonArray = jsonObject.getJSONArray("numbers");
            if (jsonArray != null && jsonArray.length() > 0) {
            	result = jsonArray.getLong(0);
                for (int i = 1; i < jsonArray.length(); i++) {
                    result = result - jsonArray.getLong(i);
                }
            }
        }
        log.info("Subtraction Result{}", result);
		return result;
	}
	
	public double multiplication(String numbersJson) {
		log.debug("Request : {}", numbersJson);
		double result = 1;
        if (numbersJson != null && !StringUtils.isEmpty(numbersJson)) {
            JSONObject jsonObject = new JSONObject(numbersJson);
            JSONArray jsonArray = jsonObject.getJSONArray("numbers");
            if (jsonArray != null && jsonArray.length() > 0) {
                for (int i = 0; i < jsonArray.length(); i++) {
                    result = result * jsonArray.getLong(i);
                }
            }
        }
        log.info("Multiplication Result:{}", result);
		return result;
	}
	
	public double division(String numbersJson) throws Exception{
		log.debug("Request : {}", numbersJson);
		double result = 0;
        if (numbersJson != null && !StringUtils.isEmpty(numbersJson)) {
            JSONObject jsonObject = new JSONObject(numbersJson);
            JSONArray jsonArray = jsonObject.getJSONArray("numbers");
            if (jsonArray != null && jsonArray.length() > 0) {
                for (int i = 0; i < jsonArray.length(); i++) {
                    double n = jsonArray.getDouble(i);
                    if (n != 0) {
                        if (result == 0) {
                        	result = n;
                        } else {
                        	result = result / n;
                        }
                    } else {
                    	result = 0;
                        log.error("Exception Divide by 0");
                        throw new Exception("Kan niet door nul delen");
                    }
                }
            }
        }
        log.info("Divide Result:{}", result);
		return result;
	}
}
