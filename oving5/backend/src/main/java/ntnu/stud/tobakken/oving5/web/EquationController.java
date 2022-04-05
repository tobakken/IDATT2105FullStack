package ntnu.stud.tobakken.oving5.web;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import ntnu.stud.tobakken.oving5.entity.Equation;
import ntnu.stud.tobakken.oving5.entity.User;
import ntnu.stud.tobakken.oving5.repository.EquationRepository;
import ntnu.stud.tobakken.oving5.repository.UserRepository;
import ntnu.stud.tobakken.oving5.service.EquationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/equation")
@CrossOrigin
public class EquationController {

    Logger LOG = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private EquationService simpleCalc;

    @Autowired
    private EquationRepository equationRepository;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/calculate")
    public ResponseEntity<Double> result(@RequestBody Map<String, String> eq ) {
        LOG.info("received POST request for calculation");
        System.out.println(eq.entrySet());
        double number1 = Double.parseDouble(eq.get("first_number"));
        String sign = eq.get("sign");
        double number2 = Double.parseDouble(eq.get("second_number"));
        Long id = Long.parseLong(eq.get("id"));

        System.out.println(number1 + sign + number2);

        double res;
        switch (sign) {
            case "+":
                res = simpleCalc.add(number1, number2);
                break;
            case "-":
                res = simpleCalc.subtract(number1, number2);
                break;
            case "*":
                res = simpleCalc.multiply(number1, number2);
                break;
            case "/":
                res = simpleCalc.divide(number1, number2);
                break;
            default:
                res = 0;
                break;
        }
        Equation equation = new Equation(String.valueOf(number1), sign, String.valueOf(number2), String.valueOf(res));
        Optional<User> optionalUser = userRepository.findById(id);
        optionalUser.ifPresent(equation::setUser);
        equationRepository.save(equation);

        LOG.info("Finished calculation");
        return ResponseEntity.ok(res);
    }

    @GetMapping("/history/{id}")
    public ResponseEntity<List<Equation>> previousCalculation(@PathVariable Long id){
        LOG.info("Received GET request for history");
        Optional<List<Equation>> optionalEquation = equationRepository.findAllByUser_Id(id);

        return optionalEquation.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.badRequest().body(null));
    }

}
