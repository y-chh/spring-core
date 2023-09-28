package bean_scope.singleton;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SingletonBeanRestController {
    private final SingletonBean firstBean;
    private final SingletonBean secondBean;

    @Autowired
    public SingletonBeanRestController(SingletonBean firstBean, SingletonBean secondBean) {
        this.firstBean = firstBean;
        this.secondBean = secondBean;
    }

    @GetMapping("/compare")
    public String compareBeans() {
        return "Comparing beans = " + (firstBean == secondBean);
    }
}
