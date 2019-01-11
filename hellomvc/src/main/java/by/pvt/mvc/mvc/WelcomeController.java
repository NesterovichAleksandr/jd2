package by.pvt.mvc.mvc;

import by.pvt.mvc.domain.Department;
import by.pvt.mvc.repo.DepartmentDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.logging.Logger;

@Controller
@RequestMapping(value = "/welcome")
public class WelcomeController {

    @Autowired
    private DepartmentDaoImpl departmentDao;

    private static Logger log = Logger.getLogger(WelcomeController.class.getName());

    @RequestMapping(value = "/index.html", method = RequestMethod.GET)
    public String getWelcome(Model model) {
        model.addAttribute("departments", departmentDao.findAllOrderedByName());
        model.addAttribute("greeting", "Hello spring mvc");
        return "welcome";
    }

    @RequestMapping(value = "/add.html", method = RequestMethod.GET)
    public String getAddDepartment(Model model) {
        model.addAttribute("department", new Department());
        return "add";
    }

    @RequestMapping(value = "/add.html", method = RequestMethod.POST)
    public String addDepartment(Department department, BindingResult bindingResult) {
        departmentDao.register(department);
        log.info("call addDepartment(): " + department.getName() + " - " + bindingResult.toString());
        return "redirect:/welcome/index.html";
    }
}
