package ntnu.stud.tobakken.oving4.web;

import ntnu.stud.tobakken.oving4.model.Oving4Model;
import ntnu.stud.tobakken.oving4.service.Oving4Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class Oving4Controller {

    @Autowired
    private Oving4Service simpleCalc;

    @Autowired
    private Oving4Model equation;

    @GetMapping("/hello/{name}")
    public String hello(@PathVariable("name") String name) {
        return String.format("Hello %s", name);
    }

    @GetMapping("/calculate/{number1}/{sign}/{number2}")
    public double result(
            @PathVariable("number1") String number1,
            @PathVariable("sign") String sign,
            @PathVariable("number2") String number2
            ) {
        System.out.println("GET calculation");

        equation.setNumber1(number1);
        equation.setSign(sign);
        equation.setNumber2(number2);

        double res;
        switch (sign) {
            case "+":
                res = simpleCalc.add(Double.parseDouble(number1), Double.parseDouble(number2));
                break;
            case "-":
                res = simpleCalc.subtract(Double.parseDouble(number1), Double.parseDouble(number2));
                break;
            case "*":
                res = simpleCalc.multiply(Double.parseDouble(number1), Double.parseDouble(number2));
                break;
            case "div":
                res = simpleCalc.divide(Double.parseDouble(number1), Double.parseDouble(number2));
                break;
            default:
                res = 0;
                break;
        }
        System.out.println(res);
        return res;
    }

    @GetMapping("/previousCalc")
    public ResponseEntity<String> previousCalculation(){
        System.out.println("GET history");
        String eq = equation.toString();
        equation.reset();
        return ResponseEntity.status(HttpStatus.OK).body(eq);
    }

}
