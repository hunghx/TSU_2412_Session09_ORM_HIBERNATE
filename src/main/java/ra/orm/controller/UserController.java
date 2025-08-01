package ra.orm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ra.orm.dto.request.UserRequestDto;
import ra.orm.validator.UserValidator;

import javax.validation.Valid;

@Controller
public class UserController {
    @Autowired
    private UserValidator userValidator;
    @GetMapping("/show-form")
    public String showForm(Model model) {
        model.addAttribute("user", new UserRequestDto());
        return "user/index"; // This should return the name of the HTML template for the form
    }
    @PostMapping("/add-user")
    public String addUser(@Valid @ModelAttribute("user") UserRequestDto request, BindingResult result, Model model){
//        userValidator.validate(request,result);
        if(result.hasErrors()){
            // có lỗi- quay lại form cũ
            return "user/index";
        }
        model.addAttribute("user", request);
        return "user/infor";
    }
}
