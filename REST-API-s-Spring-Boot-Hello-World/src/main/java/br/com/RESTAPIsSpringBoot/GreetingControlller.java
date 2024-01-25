package br.com.RESTAPIsSpringBoot;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingControlller {

    private  static  final String template = "Hello, %s!";
    private  static AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public  Greenting greenting(@RequestParam(value = "name", defaultValue = "World") String name){
        return  new Greenting(counter.incrementAndGet(), String.format(template,name));
    }

}
