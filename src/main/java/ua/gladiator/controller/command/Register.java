package ua.gladiator.controller.command;

import ua.gladiator.model.entity.Client;
import ua.gladiator.model.entity.builders.ClientBuilder;
import ua.gladiator.model.entity.enums.Role;
import ua.gladiator.model.entity.enums.SocialStatus;
import ua.gladiator.model.service.ClientService;
import ua.gladiator.model.service.DiscountService;
import ua.gladiator.model.service.impl.ClientServiceImpl;
import ua.gladiator.model.service.impl.DiscountServiceImpl;

import javax.servlet.http.HttpServletRequest;

public class Register implements Command {
    private ClientService clientService = new ClientServiceImpl();
    private DiscountService discountService = new DiscountServiceImpl();

    @Override
    public String execute(HttpServletRequest request) {

        request.setAttribute("statuses", SocialStatus.values());
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        //System.out.println(name + " " + pass);
        if(username!=null) {
            if(!clientService.isRegistered(username)) {
                SocialStatus socialStatus = SocialStatus.valueOf(request.getParameter("socialStatus"));
                clientService.registerClient(new ClientBuilder()
                        .buildLogin(username)
                        .buildPassword(password)
                        .buildRole("ROLE_USER")
                        .buildSocialStatus(socialStatus)
                        .buildTotalSpentValue(0L)
                        .buildPersonalDiscount(discountService.getClientDiscount(0L, socialStatus))
                        .build());


                request.setAttribute("success", "success");
                return "register.jsp";
            }
            request.setAttribute("error", "error");
        }

        return "register.jsp";
    }
}
