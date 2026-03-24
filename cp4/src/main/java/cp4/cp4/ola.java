package cp4.cp4;



import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ola {

    @GetMapping("/ola")
    public String dizerOla() {
        return "SAFE";
    }
}