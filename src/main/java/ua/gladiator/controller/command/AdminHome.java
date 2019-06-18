package ua.gladiator.controller.command;

import ua.gladiator.model.entity.Client;
import ua.gladiator.model.service.DiscountService;
import ua.gladiator.model.service.OrderService;
import ua.gladiator.model.service.impl.DiscountServiceImpl;
import ua.gladiator.model.service.impl.OrderServiceImpl;

import javax.servlet.http.HttpServletRequest;

public class AdminHome implements Command {
    private OrderService orderService = new OrderServiceImpl();
    private DiscountService discountService = new DiscountServiceImpl();

    @Override
    public String execute(HttpServletRequest request) {
        request.setAttribute("client", request.getSession().getAttribute("client"));


        return "home.jsp";
    }
}
