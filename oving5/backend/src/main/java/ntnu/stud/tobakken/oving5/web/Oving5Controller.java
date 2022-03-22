package ntnu.stud.tobakken.oving5.web;

import java.util.List;
import java.util.ArrayList;
import ntnu.stud.tobakken.oving5.model.Oving5Model;
import ntnu.stud.tobakken.oving5.repository.EquationRepository;
import ntnu.stud.tobakken.oving5.service.Oving5Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
public class Oving5Controller {

    Logger LOG = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private Oving5Service simpleCalc;

    @Autowired
    private EquationRepository equationRepository;

    @GetMapping("/hello/{name}")
    public String hello(@PathVariable("name") String name) {
        return String.format("Hello %s", name);
    }

    @PostMapping("/calculate/{number1}/{sign}/{number2}")
    public double result(
            @PathVariable("number1") String number1,
            @PathVariable("sign") String sign,
            @PathVariable("number2") String number2
            ) {
        LOG.info("received GET request for calculation");

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
        equationRepository.save(new Oving5Model(number1, sign, number2, String.valueOf(res)));

        LOG.info("Finished calculation");
        return res;
    }

    @GetMapping("/history")
    public ResponseEntity<List<Oving5Model>> previousCalculation(){
        LOG.info("Received GET request for history");
        try {
            List<Oving5Model> equations = new ArrayList<Oving5Model>();
            equationRepository.findAll().forEach(equations::add);
            if(equations.isEmpty()) return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            return new ResponseEntity<>(equations, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
