package com.petnet.petnet.Servico.service;

import com.petnet.petnet.Order.model.Order;
import com.petnet.petnet.Servico.model.Servico;
import com.petnet.petnet.Servico.repository.ServicoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ServicoService {
    private final ServicoRepository servicoRepository;

    public ServicoService(ServicoRepository servicoRepository) {
        this.servicoRepository = servicoRepository;
    }

    public List<Servico> showAllServicos() {
        return servicoRepository.findAll();
    }

    public Servico buscarServicoPorId(Long id) {
        return servicoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Serviço não encontrado com o ID: " + id));
    }

    @Transactional
    public Servico salvar(Servico servico) {
        return servicoRepository.save(servico);
    }

    @Transactional
    public Servico updateServico(Long id, Servico dto) {
        Servico servicoExistente = buscarServicoPorId(id);

        servicoExistente.setPediId(dto.getPediId());
        servicoExistente.setId(dto.getId());

        return servicoRepository.save(servicoExistente);
    }

    @Transactional
    public void deleteServico(Long id) {
        Servico servico = buscarServicoPorId(id);
        servicoRepository.delete(servico);
    }
}
