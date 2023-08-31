/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.cc.lpoo.om.model;

import java.util.Collection;
import javax.persistence.*;

/**
 *
 * @author 20202PF.CC0012
 */

@Entity
@Table(name = "tb_cliente")
@DiscriminatorValue(value = "C")
public class Cliente extends Pessoa{
    
    @Column(nullable = true, length = 200)
    private String observacoes;
    
    
    @ManyToMany
    @JoinTable(name = "tb_cliente_veiculo", joinColumns = {@JoinColumn(name = "cliente_cpf")}, //agregacao, vai gerar uma tabela associativa.
                                       inverseJoinColumns = {@JoinColumn(name = "veiculo_id")})      
    private Collection<Veiculo> veiculo;

    public Cliente() {
    }

    /**
     * @return the observacoes
     */
    public String getObservacoes() {
        return observacoes;
    }

    /**
     * @param observacoes the observacoes to set
     */
    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public Collection<Veiculo> getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Collection<Veiculo> veiculo) {
        this.veiculo = veiculo;
    }
    
    
    
}