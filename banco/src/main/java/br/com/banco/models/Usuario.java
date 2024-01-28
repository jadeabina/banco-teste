
package br.com.banco.models;

import jakarta.persistence.*;

@Entity
@Table(name="USUARIO")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "CPF")
    private String cpf;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_EMPRESA",referencedColumnName = "ID")
    private Empresa empresa;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }



}

