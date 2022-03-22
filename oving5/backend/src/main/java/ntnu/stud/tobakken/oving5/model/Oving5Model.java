package ntnu.stud.tobakken.oving5.model;

import javax.persistence.*;

@Entity
@Table(name="equations")
public class Oving5Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "first_number")
    private String number1;
    @Column(name = "sign")
    private String sign;
    @Column(name = "second_number")
    private String number2;
    @Column(name = "result")
    private String result;

    public Oving5Model(String number1, String sign, String number2, String result){
        this.number1 = number1;
        this.sign = sign;
        this.number2 = number2;
        this.result = result;
    }

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

    @Override
    public String toString() {
        return "Equation: " + id + " " + number1 + " " + sign + " " + number2 + " = " + result;
    }
}
