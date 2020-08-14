# Simple Calculator
 A simple calculator backend that can perform single calculations and calculations based on a list of input objects
 
# Build 
```
mvn clean package
```

# Run
```
java -jar SimpleCalculator-0.0.1-SNAPSHOT.jar com.todo.SimpleCalculatorApplication
```

# Application Endpoints

POST : http://localhost:8080/calculator/add

POST : http://localhost:8080/calculator/sub

POST : http://localhost:8080/calculator/mul

POST : http://localhost:8080/calculator/div

Example JSON BODY : {"numbers":[1,2,3]}
