    package com.example.wishcloud.controller;

    import com.example.wishcloud.model.UserModel;
    import com.example.wishcloud.service.UserService;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Controller;
    import org.springframework.ui.Model;
    import org.springframework.web.bind.annotation.GetMapping;
    import org.springframework.web.bind.annotation.PostMapping;
    import org.springframework.web.bind.annotation.RequestMapping;

    @Controller
    @RequestMapping("/users")
    public class UserController {

        private final UserService userService;

        @Autowired
        public UserController(UserService userService) {
            this.userService = userService;
        }


        @GetMapping("/signup")
        public String showSignUpForm(Model model) {
            model.addAttribute("user", new UserModel());
            return "signup";
        }

        @PostMapping("/signup")
        public String signUp(UserModel user, Model model) {
            userService.createUser(user);
            return "redirect:/";
        }


        @GetMapping("/login")
        public String showLoginForm() {
            return "redirect:/users/login";
        }

        @PostMapping("/login")
        public String login(String username, String password, Model model) {
            UserModel user = userService.validateLogin(username, password);
            if (user != null) {
                return "redirect:/users/dashboard";
            } else {
                model.addAttribute("error", "Forkert brugernavn eller adgangskode.");
                return "login";
            }
        }
        @GetMapping("/dashboard")
        public String showDashboard(Model model) {
            return "dashboard";
        }


    }