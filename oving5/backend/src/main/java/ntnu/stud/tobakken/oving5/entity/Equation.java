package ntnu.stud.tobakken.oving5.entity;

import javax.persistence.*;

@Entity
public class Equation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String number1;

    private String sign;

    private String number2;

    private String result;

    @ManyToOne
    private User user;

    public Equation(String number1, String sign, String number2, String result){
        this.number1 = number1;
        this.sign = sign;
        this.number2 = number2;
        this.result = result;
    }

    public Equation() {}

    public int getId() {
        return id;
    }

    public String getNumber1() {
        return number1;
    }

    public void setNumber1(String number1) {
        this.number1 = number1;
    }

    public String getSign() {
        return sign;
    }

    public String getResult() {
        return result;
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

    public void setResult(String result) {
        this.result = result;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Equation: " + id + " " + number1 + " " + sign + " " + number2 + " = " + result;
    }
}
