package c322.springFlowers.controllers;

import c322.springFlowers.model.Orders;
import c322.springFlowers.repository.OrdersRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/orders")
public class OrdersController {

    private OrdersRepository ordersRepository;

    public OrdersController(OrdersRepository ordersRepository){
        this.ordersRepository = ordersRepository;
    }


    @PostMapping
    public ResponseEntity add(@RequestBody Orders order){
        System.out.println("hit");
        List<Orders> s = ordersRepository.findAll();

        int i=0;
        for(Orders p : s){

            if(p.getId() >= i){
                i = p.getId() + 1;
            }
        }
        order.setId(i);
        try {
            ordersRepository.save(order);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(order);
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public List<Orders> get(@PathVariable int id){
        List<Orders> orders = ordersRepository.findAll();
        for(Orders o : orders){
            if(o.getId() != id){
                orders.remove(o);
            }
        }
        return orders;
    }


    @GetMapping
    public List<Orders> getAll(){
        List<Orders> orders = ordersRepository.findAll();

        return orders;
    }
}
