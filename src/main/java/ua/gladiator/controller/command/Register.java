package ua.gladiator.controller.command;

import javax.servlet.http.HttpServletRequest;

public class Register implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        return "/register.jsp";
    }
}
