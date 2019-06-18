package ua.gladiator.controller.command;

import ua.gladiator.model.entity.Client;
import ua.gladiator.model.service.DiscountService;
import ua.gladiator.model.service.OrderService;
import ua.gladiator.model.service.impl.DiscountServiceImpl;
import ua.gladiator.model.service.impl.OrderServiceImpl;

import javax.servlet.http.HttpServletRequest;

public class UserHome implements Command {

    private OrderService orderService = new OrderServiceImpl();
    private DiscountService discountService = new DiscountServiceImpl();

    @Override
    public String execute(HttpServletRequest request) {
        Client client = (Client) request.getSession().getAttribute("client");

        request.setAttribute("client", client);
        request.setAttribute("specialDiscount", discountService.getSpecialDiscount());
        request.setAttribute("numOrders", orderService.getNumRides(client.getId()));

        if( request.getParameter("cancel") != null) {
             request.setAttribute("cancel", "cancel");
        }
        if( request.getParameter("success") != null) {
            request.setAttribute("success", "success");
        }

        return "home.jsp";
    }
}
