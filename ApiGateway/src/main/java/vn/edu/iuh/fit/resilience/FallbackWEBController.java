package vn.edu.iuh.fit.resilience;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/fallback")
public class FallbackWEBController {
    @RequestMapping("/post-fallback")
    public String handleError() {
        return "fallback";
    }
}
