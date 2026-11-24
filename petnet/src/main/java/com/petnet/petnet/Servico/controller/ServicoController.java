package com.petnet.petnet.Servico.controller;

import com.petnet.petnet.Servico.model.Servico;
import com.petnet.petnet.Servico.service.ServicoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/servicos")
public class ServicoController {
    private final ServicoService servicoService;

    public ServicoController(ServicoService servicoService) {
        this.servicoService = servicoService;
    }

    @GetMapping
    public ResponseEntity<List<Servico>> showAllServicos() {
        List<Servico> servs = servicoService.showAllServicos();
        return ResponseEntity.ok(servs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Servico> buscarServPorId(@PathVariable Long id) {
        Servico serv = servicoService.buscarServicoPorId(id);
        return ResponseEntity.ok(serv);
    }

    @PostMapping
    public ResponseEntity<Servico> createOrder(@RequestBody Servico order) {
        Servico newServico = servicoService.salvar(order);
        return ResponseEntity.status(HttpStatus.CREATED).body(newServico);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Servico> updateServico(@PathVariable Long id, @RequestBody Servico serv) {
        Servico servAtualizado = servicoService.updateServico(id, serv);
        return ResponseEntity.ok(servAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteServico(@PathVariable Long id) {
        servicoService.deleteServico(id);
        return ResponseEntity.noContent().build();
    }
}
