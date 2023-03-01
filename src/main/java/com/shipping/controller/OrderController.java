package com.shipping.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.shipping.dto.OrderDTO;
import com.shipping.dto.ResponseOrderDTO;
import com.shipping.entity.Customer;
import com.shipping.entity.Order;
import com.shipping.entity.Product;
import com.shipping.enumeration.CustomerOrderStatus;
import com.shipping.service.CustomerService;
import com.shipping.service.OrderService;
import com.shipping.service.ProductService;
import com.shipping.util.DateUtil;

import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/endpoint/orders")

public class OrderController {
    
        private OrderService orderService;
        private ProductService productService;
        private CustomerService customerService;
    
    
        public OrderController(OrderService orderService, ProductService productService, CustomerService customerService) {
            this.orderService = orderService;
            this.productService = productService;
            this.customerService = customerService;
        }
    
        private Logger logger = LoggerFactory.getLogger(OrderController.class);
        
    
        @PostMapping("/{orderId}/status")
        public ResponseEntity<ResponseOrderDTO> placeOrder(@RequestBody OrderDTO orderDTO) {
            logger.info("Request Payload " + orderDTO.toString());
            ResponseOrderDTO responseOrderDTO = new ResponseOrderDTO();
            float amount = orderService.getCartAmount(orderDTO.getCartItems());
    
            Customer customer = new Customer(orderDTO.getCustomerName(), orderDTO.getCustomerEmail());
            Integer customerIdFromDb = customerService.isCustomerPresent(customer);
            if (customerIdFromDb != null) {
                customer.setId(customerIdFromDb);
                logger.info("Customer already present in db with id : " + customerIdFromDb);
            }else{
                customer = customerService.saveCustomer(customer);
                logger.info("Customer saved.. with id : " + customer.getId());
            }
            Order order = new Order(orderDTO.getOrderDescription(), customer, orderDTO.getCartItems());
            order = orderService.saveOrder(order);
            logger.info("Order processed successfully..");
    
            responseOrderDTO.setAmount(amount);
            responseOrderDTO.setDate(DateUtil.getCurrentDateTime());
            responseOrderDTO.setInvoiceNumber(new Random().nextInt(1000));
            responseOrderDTO.setOrderId(order.getId());
            CustomerOrderStatus.setValue(new Random().nextInt(3));
            responseOrderDTO.setOrderDescription(orderDTO.getOrderDescription());
    
            logger.info("test push..");
    
            return ResponseEntity.ok(responseOrderDTO);
        }
    
    }
