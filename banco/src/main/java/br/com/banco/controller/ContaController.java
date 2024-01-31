package br.com.banco.controller;
//sacar e depositar

import br.com.banco.business.Transacao;
import br.com.banco.models.Conta;
import br.com.banco.persistence.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/conta")
public class ContaController {

    private final ContaRepository contaRepository;

    @Autowired
    public ContaController(ContaRepository contaRepository) {
        this.contaRepository = contaRepository;
    }

    @PostMapping("/salvar")
    public Conta salvarConta(@RequestBody Conta conta) {
        return contaRepository.save(conta);
    }

    private Conta save(Conta conta) {
        return contaRepository.save(conta);

    }

    @PostMapping("/depositar/{id}/{valor}")
    public Conta deposito(@PathVariable Integer id, @PathVariable int valor) {
        Conta conta = contaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Conta não encontrada com ID: " + id));

        Transacao.deposito(valor);

        return contaRepository.save(conta);
    }

    @PostMapping("/sacar/{id}/{valor}")
    public Conta sacar(@PathVariable Integer id, @PathVariable int valor) {
        Conta conta = contaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Conta não encontrada com ID: " + id));

        if (conta.getSaldo() < valor) {
            throw new RuntimeException("Saldo insuficiente para sacar " + valor);
        }

        Transacao.sacar(valor);

        return contaRepository.save(conta);
    }

}
