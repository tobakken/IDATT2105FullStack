package ntnu.stud.tobakken.oving4.model;

import org.springframework.stereotype.Component;

@Component
public class Oving4Model {
    private String number1;
    private String sign;
    private String number2;

    public Oving4Model(){}

    public String getNumber1() {
        return number1;
    }

    public void setNumber1(String number1) {
        this.number1 = number1;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getNumber2() {
        return number2;
    }

    public void setNumber2(String number2) {
        this.number2 = number2;
    }

    public void reset(){
        this.number1 = null;
        this.number2 = null;
        this.sign = null;
    }

    @Override
    public String toString() {
        return number1 + sign + number2;
    }
}
