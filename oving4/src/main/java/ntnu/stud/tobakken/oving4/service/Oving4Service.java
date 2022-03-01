package ntnu.stud.tobakken.oving4.service;

import org.springframework.stereotype.Service;

@Service
public class Oving4Service {

    public double add(double number1, double number2){
        return number1 + number2;
    }

    public double subtract(double number1, double number2) {
        return  number1 - number2;
    }

    public double multiply(double number1, double number2){
        return number1*number2;
    }

    public double divide(double number1, double number2) {
        return (number1/number2);
    }
}
