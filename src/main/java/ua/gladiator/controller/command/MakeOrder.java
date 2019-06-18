package ua.gladiator.controller.command;

import ua.gladiator.model.entity.Car;
import ua.gladiator.model.entity.Client;
import ua.gladiator.model.entity.enums.CarType;
import ua.gladiator.model.entity.enums.Street;
import ua.gladiator.model.service.CarService;
import ua.gladiator.model.service.DiscountService;
import ua.gladiator.model.service.TimeService;
import ua.gladiator.model.service.UtilityService;
import ua.gladiator.model.service.impl.CarServiceImpl;
import ua.gladiator.model.service.impl.DiscountServiceImpl;
import ua.gladiator.model.service.impl.TimeServiceImpl;
import ua.gladiator.model.service.impl.UtilityServiceImpl;

import javax.servlet.http.HttpServletRequest;

public class MakeOrder implements Command {


    private DiscountService discountService = new DiscountServiceImpl();
    private CarService carService = new CarServiceImpl();
    private TimeService timeService = new TimeServiceImpl();
    private UtilityService utilityService = new UtilityServiceImpl();

    @Override
    public String execute(HttpServletRequest request) {
        System.out.println(timeService.findLongTime(Street.Brovary, Street.Kreschatyk) + " 12345");
        request.setAttribute("discount", 5L);
        request.setAttribute("types", CarType.values());
        request.setAttribute("streets", Street.values());


        if(request.getParameter("carType") != null) {
            request.setAttribute("cars", carService.getAvailableType(CarType.valueOf(request.getParameter("carType"))));
            request.setAttribute("initPlace", request.getParameter("initPlace"));
            request.setAttribute("destPlace", request.getParameter("destPlace"));
            request.setAttribute("carType", request.getParameter("carType"));
        }
        if(request.getParameter("carId") != null) {

            Car car = carService.getCarById(Long.parseLong(request.getParameter("carId")));


            Street initPlace = Street.valueOf( request.getParameter("initPlace"));
            Street destPlace = Street.valueOf(request.getParameter("destPlace"));

            request.setAttribute("waitTime", timeService.findLongTime(car.getPlace(), initPlace));
            request.setAttribute("timeId", timeService.findTime(initPlace, destPlace).getId());
            request.setAttribute("rideTime", timeService.findTime(initPlace, destPlace).getTime());


            request.setAttribute("price", utilityService.countPrice(
                    discountService.getClientDiscount(new Client()),
                    timeService.findLongTime(initPlace, destPlace)));
            request.setAttribute("car", car);
        }
        return "order.jsp";
    }
}
