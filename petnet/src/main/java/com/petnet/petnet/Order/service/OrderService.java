package com.petnet.petnet.Order.service;


import com.petnet.petnet.Exception.NotFoundException;
import com.petnet.petnet.Order.model.Order;
import com.petnet.petnet.Order.repository.OrderRepository;
import com.petnet.petnet.Servico.model.Servico;
import com.petnet.petnet.Servico.repository.ServicoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final ServicoRepository servicoRepository;

    public OrderService(OrderRepository orderRepository, ServicoRepository servicoRepository) {
        this.orderRepository = orderRepository;
        this.servicoRepository = servicoRepository;
    }

    public List<Order> showAllOrders() {
        return orderRepository.findAll();
    }

    public Order buscarPedidoPorId(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Pedido não encontrado com o ID: " + id));
    }

    @Transactional
    public Order salvar(Order order) {
        return orderRepository.save(order);
    }

    @Transactional
    public Order updateOrder(Long id, Order dto) {
        Order orderExistente = buscarPedidoPorId(id);

        orderExistente.setUserId(dto.getUserId());
        orderExistente.setPetId(dto.getPetId());
        orderExistente.setPediStatus(dto.getPediStatus());
        orderExistente.setDatacri(dto.getDatacri());

        return orderRepository.save(orderExistente);
    }

    @Transactional
    public void deleteOrder(Long id) {
        Order order = buscarPedidoPorId(id);
        orderRepository.delete(order);
    }
}
