package ntnu.stud.tobakken.oving5.dto;

public class EquationDTO {
    private String number1;

    private String sign;

    private String number2;

    private String result;

    public EquationDTO(String number1, String sign, String number2, String result){
        this.number1 = number1;
        this.sign = sign;
        this.number2 = number2;
        this.result = result;
    }

    public String getNumber1() {
        return number1;
    }

    public String getSign() {
        return sign;
    }

    public String getNumber2() {
        return number2;
    }

    public String getResult() {
        return result;
    }
}
