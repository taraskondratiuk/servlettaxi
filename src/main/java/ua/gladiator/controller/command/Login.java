package ua.gladiator.controller.command;

import org.apache.log4j.Logger;
import ua.gladiator.model.entity.Client;
import ua.gladiator.model.entity.enums.Role;
import ua.gladiator.model.service.ClientService;
import ua.gladiator.model.service.impl.ClientServiceImpl;

import javax.servlet.http.HttpServletRequest;

public class Login implements Command {


    private static final Logger log = Logger.getLogger(Login.class);

    private ClientService clientService = new ClientServiceImpl();
    @Override
    public String execute(HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        //System.out.println(name + " " + pass);
        if(username!=null) {
            if(clientService.isRegistered(username, password)) {
                Client client = clientService.getClient(username);
                request.getSession().setAttribute("client", client);
                if(client.getRole() == Role.ROLE_ADMIN) {
                    log.info(client.getRole() + " with id " + client.getId() + " logged in");
                    return "redirect/admin/home";
                } else if (client.getRole() == Role.ROLE_USER) {
                    log.info(client.getRole() + " with id " + client.getId() + " logged in");

                    return "redirect/user/home";
                }
            }
            request.setAttribute("error", "error");
        }

        if(request.getSession().getAttribute("logout") != null) {
            request.setAttribute("logout", "logout");
        }


        return "login.jsp";
    }
}
