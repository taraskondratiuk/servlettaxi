package ua.gladiator.controller.command;

import ua.gladiator.model.entity.Client;
import ua.gladiator.model.entity.Order;
import ua.gladiator.model.entity.builders.OrderBuilder;
import ua.gladiator.model.service.ClientService;
import ua.gladiator.model.service.DiscountService;
import ua.gladiator.model.service.OrderService;
import ua.gladiator.model.service.UtilityService;
import ua.gladiator.model.service.impl.ClientServiceImpl;
import ua.gladiator.model.service.impl.DiscountServiceImpl;
import ua.gladiator.model.service.impl.OrderServiceImpl;
import ua.gladiator.model.service.impl.UtilityServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


public class OrderHistory implements Command {

    private UtilityService utilityService = new UtilityServiceImpl();
    private OrderService orderService = new OrderServiceImpl();
    private ClientService clientService = new ClientServiceImpl();
    private DiscountService discountService = new DiscountServiceImpl();

    @Override
    public String execute(HttpServletRequest request) {

        Client client = (Client) request.getSession().getAttribute("client");
        if(request.getParameter("carId") != null) {
            orderService.addOrder(new OrderBuilder()

                    .buildCar_id(Long.parseLong( request.getParameter("carId")))
                    .buildClientId(client.getId())
                    .buildPrice(Long.parseLong(request.getParameter("price")))
                    .buildTime_id(Long.parseLong(request.getParameter("timeId")))
                    .buildWaitTime(Long.parseLong(request.getParameter("waitTime")))
                    .build());
            clientService.addToSpentValue(client.getId(), Long.parseLong(request.getParameter("price")));

            clientService.refreshDiscount(discountService.getClientDiscount(client), client.getLogin());


            request.setAttribute("success", "success");

        }

        Integer page = 0;
        if(request.getParameter("page") != null) {
            page = Integer.parseInt(request.getParameter("page"));
        }

        request.setAttribute("details", utilityService.buildListOrdersDetails(client, page, 7));
        return "orderHistory.jsp";
    }
}
