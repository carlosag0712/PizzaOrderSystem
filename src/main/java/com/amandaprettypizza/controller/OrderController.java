package com.amandaprettypizza.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.amandaprettypizza.domain.Customer;
import com.amandaprettypizza.domain.Order;
import com.amandaprettypizza.domain.Pizza;
import com.amandaprettypizza.repository.OrderRepository;


@Controller
@RequestMapping("/orders")
public class OrderController 
{

private OrderRepository orderRepo;
	
	@Autowired
	public void setOrderRepo(OrderRepository orderRepo) {
		this.orderRepo = orderRepo;
	}
	

	@RequestMapping(value="", method=RequestMethod.GET)
	public String orderGet (ModelMap model)
	{
		List<Order> orders = orderRepo.findAll();
		
		Order order = new Order();
		model.put("orders", orders);
		
		return "orders";
	}
	
	@RequestMapping(value="/{orderId}", method=RequestMethod.GET)
	public String orderGet (@PathVariable Long orderId, ModelMap model)
	{
		Order order = orderRepo.findOne(orderId);
		calculateOrderFinalPrice(order);
		
		model.put("order", order);
		return "orders";
		
	}


	private void calculateOrderFinalPrice(Order order) {
		double finalPrice = 0.0;
		
		for(Pizza pizza : order.getPizzas())
		{
			if(pizza.getPrice()!=null)
			{
				finalPrice+=pizza.getPrice();
			}
		}
		
		order.setFinalPrice(finalPrice);
	}
	
	@RequestMapping(value="/{orderId}", method=RequestMethod.POST)
	public String orderPost (@PathVariable Long orderId,@ModelAttribute Order order, ModelMap model)
	{
		return "redirect:/orders/"+orderId+"/pizzas";
		
	}
	
	
	@RequestMapping(value="/{orderId}/reviewOrder", method=RequestMethod.POST)
	public String reviewOrder (@PathVariable Long orderId, ModelMap model)
	{
		Order order = orderRepo.findOne(orderId);
		calculateOrderFinalPrice(order);
		model.put("order", order);
	
		return "reviewOrder";
	}
	
	
	@RequestMapping(value="/{orderId}/completeOrder", method=RequestMethod.POST)
	public String submitOrder (@PathVariable Long orderId, ModelMap model)
	{
		Order order = orderRepo.findOne(orderId);
		order.setCompleted(true);
		orderRepo.save(order);
		
		return "redirect:/orders/";
		
	}
	
	
	@RequestMapping(value="", method=RequestMethod.POST)
	public String orderPost (HttpServletRequest request,@ModelAttribute Order order, ModelMap model)
	{
		Customer customer =(Customer)request.getSession().getAttribute("customer");
		order.setCustomer(customer);
		Order savedOrder=orderRepo.save(order);
		
		return "redirect:/orders/"+savedOrder.getId()+"/pizzas";
	}
	
}
