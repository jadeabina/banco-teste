package br.com.banco.models;

import jakarta.persistence.*;

@Entity
@Table(name="EMPRESA")
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column (name = "CNPJ")
    private  String cnpj;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_CONTA",referencedColumnName = "ID")
    private Conta conta;

    @Column(name = "TAXA")
    private Double taxa;

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    public Double getTaxa() { return taxa; }

    public void setTaxa(Double taxa) {this.taxa = taxa; }

}
