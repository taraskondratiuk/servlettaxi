package ua.gladiator.controller.command;

import ua.gladiator.model.service.UtilityService;
import ua.gladiator.model.service.impl.UtilityServiceImpl;

import javax.servlet.http.HttpServletRequest;

public class ClientDetails implements Command {

    private UtilityService utilityService = new UtilityServiceImpl();

    @Override
    public String execute(HttpServletRequest request) {
        Integer page = 0;
        if(request.getParameter("page") != null) {
            page = Integer.parseInt(request.getParameter("page"));
        }
        request.setAttribute("clients", utilityService.buildListClients(page, 7));

        return "clients.jsp";
    }
}
