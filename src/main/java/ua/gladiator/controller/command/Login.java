package ua.gladiator.controller.command;

import javax.servlet.http.HttpServletRequest;

public class Login implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        String name = request.getParameter("name");
        String pass = request.getParameter("pass");
        //System.out.println(name + " " + pass);
        if(name.equals("1") && pass.equals("1")){
            return "redirect/user/userbase.jsp";
        }
        return "/login.jsp";
    }
}
