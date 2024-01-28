package br.com.banco.business;

import br.com.banco.persitence.ContaRepository;
import br.com.banco.models.Conta;
import br.com.banco.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;


public class Transacao {
@Autowired //ANOTAÇÃO DO SPRING
ContaRepository contaRepository;

    public static void deposito(int valor) {
    }

    public static void sacar(int valor) {

    }

    public void saque(Usuario usuario, double valor) {
        Conta conta= usuario.getEmpresa().getConta();
        double valorSaldo= conta.getSaldo();
        double taxa= usuario.getEmpresa().getTaxa();
        if(valorSaldo+taxa>=valor){
            conta.setSaldo(valorSaldo + taxa - valor);
            contaRepository.save(conta);
        }
    }
    public void deposito(Usuario usuario, double valor) {
        Conta conta= usuario.getEmpresa().getConta();
        double valorSaldo= conta.getSaldo();
        double taxa= usuario.getEmpresa().getTaxa();
        if(valor+valorSaldo>=taxa){
            conta.setSaldo(valor + valorSaldo-taxa);
            contaRepository.save(conta);
        }
    }

}
