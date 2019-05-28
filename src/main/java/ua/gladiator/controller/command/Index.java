package ua.gladiator.controller.command;

import javax.servlet.http.HttpServletRequest;

public class Index implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        System.out.println("++++++++++++++++");
        return "/index.jsp";
    }

    @Override
    public String toString() {
        return "=======================";
    }
}
