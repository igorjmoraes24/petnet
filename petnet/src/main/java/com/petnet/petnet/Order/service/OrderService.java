package com.petnet.petnet.Order.service;


import com.petnet.petnet.Order.model.Order;
import com.petnet.petnet.Order.repository.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> showAllOrders() {
        return orderRepository.findAll();
    }

    public Order buscarPedidoPorId(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado com o ID: " + id));
    }

    @Transactional
    public Order salvar(Order order) {
        return orderRepository.save(order);
    }

    @Transactional
    public Order updateOrder(Long id, Order dto) {
        Order orderExistente = buscarPedidoPorId(id);

        orderExistente.setPetId(dto.getPetId());
        orderExistente.setPediStatus(dto.getPediStatus());
        orderExistente.setTipo(dto.getTipo());
        orderExistente.setDesc(dto.getDesc());
        orderExistente.setDatacri(dto.getDatacri());

        return orderRepository.save(orderExistente);
    }

    @Transactional
    public void deleteOrder(Long id) {
        Order order = buscarPedidoPorId(id);
        orderRepository.delete(order);
    }
}
