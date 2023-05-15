package hac.springthymeleafbasic.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;

/** IMPORTANT: IN ORDER TO RUN THIS EXAMPLE YOU NEED TO MANUALLY
 * navigate to
 * http://localhost:8080
 * to see this controller
 */
@Controller
public class HelloWorldController {

    private String name;

    // inject value
    //@Value("noname")

    // inject via application.properties
    @Value("${welcome.message}")
    private String message;

    private List<String> tasks = Arrays.asList("java", "threads", "jdbc", "servlets", "jsp", "spring", "annotations");

    /**
     * the main page, showing model data passed to a view
     * @param model
     * @return
     */
    @GetMapping("/")
    public String main(Model model) {
        model.addAttribute("message", message);
        model.addAttribute("tasks", tasks);

        return "welcome"; //view welcome.html
    }

    /** hello?name=someone
     * a controller to handle a GET request
     * @param name
     * @param model
     * @return
     */
    @GetMapping("/hello")
    public String mainWithParam(@RequestParam(name = "name", required = false, defaultValue = "") String name, Model model) {
        model.addAttribute("message", name);
        return "welcome2"; //view
    }

    /**
     * a controller to handle post request from a form
     * @param localname
     * @param model
     * @return
     */
    @PostMapping("/hello2")
    public String postWithParam(@RequestParam(name = "name", required = false, defaultValue = "<missing name>") String localname, Model model) {
        model.addAttribute("message", localname);
        return "welcome2"; //view
    }

}