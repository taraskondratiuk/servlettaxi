package ua.gladiator.controller.command;

import ua.gladiator.model.entity.Client;
import ua.gladiator.model.service.ClientService;
import ua.gladiator.model.service.UtilityService;
import ua.gladiator.model.service.impl.ClientServiceImpl;
import ua.gladiator.model.service.impl.UtilityServiceImpl;

import javax.servlet.http.HttpServletRequest;

public class ChangePassword implements Command {

    private UtilityService utilityService = new UtilityServiceImpl();
    private ClientService clientService = new ClientServiceImpl();

    @Override
    public String execute(HttpServletRequest request) {



        Client client = (Client) request.getSession().getAttribute("client");


        String oldpassword = request.getParameter("oldpassword");
        String newpassword = request.getParameter("newpassword");


        if (!client.getPassword().equals(oldpassword) && oldpassword != null) {
            request.setAttribute("error", "error");
            return "changepw.jsp";
        } else if(oldpassword != null){
            clientService.changePassword(oldpassword, newpassword, client.getLogin());
            request.setAttribute("pwchanged", "pwchanged");

        }


        return "changepw.jsp";
    }
}
