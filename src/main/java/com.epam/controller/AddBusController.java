package com.epam.controller;

import com.epam.dao.BusDAO;
import com.epam.dao.MiniDAO;
import com.epam.dao.RouteDAO;
import com.epam.entity.Bus;
import com.epam.entity.Mini;
import com.epam.entity.Route;
import com.epam.util.Factory;
import com.epam.util.HibernateUtil;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Set;

@Controller
public class AddBusController {

    @RequestMapping("/bus")
    public ModelAndView add(HttpServletRequest request, HttpServletResponse responce, Bus bus, BindingResult result)
    {

       //bus.setRoute_id(22L);
       //bus.setNumber("67");

        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        Validator validator = validatorFactory.getValidator();
        validator.validate(bus);

       if(result.hasErrors())
       {
           ModelAndView mv = new ModelAndView();
           mv.setViewName("display.jsp");

           return mv;
       }



       /*ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
       Validator validator = validatorFactory.getValidator();
       Set<ConstraintViolation<Bus>> constraintViolations = validator.validate(bus);
       for(ConstraintViolation constraintViolation: constraintViolations)
       {
           System.out.println(constraintViolation.getMessage());
       }*/



        try {
            Factory.getInstance().getBusDAO().addBus(bus);

            /*
            route = new RouteDAO().getRouteById(22L);
            Set<Bus> busses = route.getBusses();
            for(Bus bus:busses)
            {
                System.out.println(bus.getNumber());
            }*/
            //bus.setRoute_id(22L);
            //bus.setNumber("14");
            /*Bus bus2 = Factory.getInstance().getBusDAO().getBusById(30L);
            bus2.setNumber("15");
            Factory.getInstance().getBusDAO().mergeBus(bus2);*/
            //Factory.getInstance().getBusDAO().addBus(bus);
            //bus.setId(28L);
            //Factory.getInstance().getBusDAO().deleteBus(bus);
            //Bus bus = Factory.getInstance().getBusDAO().getBusById(27L);
            //bus.setNumber("13");
            //Bus bus2 = Factory.getInstance().getBusDAO().getBusById(30L);
           // bus2.setNumber("15");
            //Bus bus3 = Factory.getInstance().getBusDAO().getBusById(31L);
            //bus3.setNumber("18");
            //Factory.getInstance().getBusDAO().replicateBus(bus3);

            //Factory.getInstance().getBusDAO().mergeBus(bus3);
            //ArrayList<Bus> list = (ArrayList)Factory.getInstance().getBusDAO().getAllBusses();
            //String number = Factory.getInstance().getBusDAO().getBusById(10L).getNumber();
            //System.out.println(number);
            //new MiniDAO().addMini(mini);



        } catch (SQLException e) {
            e.printStackTrace();
        }


        ModelAndView mv = new ModelAndView();
        mv.setViewName("display.jsp");

        return mv;
    }
}
