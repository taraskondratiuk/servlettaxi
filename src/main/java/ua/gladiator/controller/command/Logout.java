package ua.gladiator.controller.command;

import org.apache.log4j.Logger;
import ua.gladiator.model.entity.Client;

import javax.servlet.http.HttpServletRequest;

public class Logout implements Command{
    private static final Logger log = Logger.getLogger(Logout.class);
    @Override
    public String execute(HttpServletRequest request) {

        Client client = (Client) request.getSession().getAttribute("client");
        log.info(client.getRole() + " with id " + client.getId() + " logged out");
        request.getSession().setAttribute("client", null);

        request.getSession().setAttribute("logout", "logout");

        return "redirect/login";
    }
}
