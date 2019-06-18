package ua.gladiator.controller.command;

import javax.servlet.http.HttpServletRequest;

public class Index implements Command {
    @Override
    public String execute(HttpServletRequest request) {



        return "index.jsp";
    }


}
