package br.com.banco.controller;

import br.com.banco.models.Conta;
import br.com.banco.models.Empresa;
import br.com.banco.persistence.ContaRepository;
import br.com.banco.persistence.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/empresa")
public class EmpresaController {
    private final EmpresaRepository empresaRepository;
    private final ContaRepository contaRepository;

    @Autowired
    public EmpresaController(EmpresaRepository empresaRepository, ContaRepository contaRepository) {
        this.empresaRepository = empresaRepository;
        this.contaRepository = contaRepository;
    }

    @PostMapping("/salvar")
    public Empresa salvarEmpresa(@RequestBody Empresa empresa) {
        Conta conta = contaRepository.findById(empresa.getConta().getId()).get();
        empresa.setConta(conta);
        return empresaRepository.save(empresa);
    }

    private Empresa save(Empresa empresa) {
        return empresaRepository.save(empresa);

    }

    @GetMapping("/buscarTodos")
    public List<Empresa> buscarTodasEmpresas() {
        return empresaRepository.findAll();
    }

    @GetMapping("/buscarPorId/{id}")
    public Empresa buscarEmpresaPorId(@PathVariable int id) {
        return empresaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Empresa não encontrado com ID: " + id));
    }

}