package ua.gladiator.controller.command;

import javax.servlet.http.HttpServletRequest;

public class Deny implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        return "deny.jsp";
    }
}
