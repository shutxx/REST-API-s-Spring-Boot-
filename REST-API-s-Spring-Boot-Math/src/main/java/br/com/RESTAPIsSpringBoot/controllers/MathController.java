package br.com.RESTAPIsSpringBoot.controllers;

import br.com.RESTAPIsSpringBoot.converters.NumberConverter;
import br.com.RESTAPIsSpringBoot.exceptions.UnsupportedMathOperationException;
import br.com.RESTAPIsSpringBoot.math.SimpleMath;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class MathController {

    private  final AtomicLong counter = new AtomicLong();
    private SimpleMath math = new SimpleMath();

    @RequestMapping(value = "/sum/{NumberOne}/{NumberTwo}", method = RequestMethod.GET)
    public Double sum(
            @PathVariable(value = "NumberOne") String numberOne,
            @PathVariable(value = "NumberTwo") String numberTwo
        ) throws Exception {
        if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Passe um valor numérico");
        }
        return math.sum(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
    }

    @RequestMapping(value = "/sub/{NumberOne}/{NumberTwo}", method = RequestMethod.GET)
    public Double subtraction(
            @PathVariable(value = "NumberOne") String numberOne,
            @PathVariable(value = "NumberTwo") String numberTwo
    ) throws Exception {
        if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Passe um valor numérico");
        }
        return math.subtraction(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
    }

    @RequestMapping(value = "/mult/{NumberOne}/{NumberTwo}", method = RequestMethod.GET)
    public Double multiplication(
            @PathVariable(value = "NumberOne") String numberOne,
            @PathVariable(value = "NumberTwo") String numberTwo
    ) throws Exception {
        if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Passe um valor numérico");
        }
        return math.multiplication(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
    }

    @RequestMapping(value = "/div/{NumberOne}/{NumberTwo}", method = RequestMethod.GET)
    public Double division(
            @PathVariable(value = "NumberOne") String numberOne,
            @PathVariable(value = "NumberTwo") String numberTwo
    ) throws Exception {
        if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Passe um valor numérico");
        }
        return math.division(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
    }

    @RequestMapping(value = "/mean/{NumberOne}/{NumberTwo}", method = RequestMethod.GET)
    public Double mean(
            @PathVariable(value = "NumberOne") String numberOne,
            @PathVariable(value = "NumberTwo") String numberTwo
    ) throws Exception {
        if(!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Passe um valor numérico");
        }
        return math.mean(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
    }

    @RequestMapping(value = "/squareRoot/{Number}", method = RequestMethod.GET)
    public Double squareRoot(
            @PathVariable(value = "Number") String number
    ) throws Exception {
        if(!NumberConverter.isNumeric(number)) {
            throw new UnsupportedMathOperationException("Passe um valor numérico");
        }
        return math.squareRoot(NumberConverter.convertToDouble(number));
    }
}
