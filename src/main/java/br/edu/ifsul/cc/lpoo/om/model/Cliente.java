/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.cc.lpoo.om.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author 20202PF.CC0012
 */

@Entity
@Table(name = "tb_cliente")
public class Cliente extends Pessoa implements Serializable {
    @Column(nullable = true)
    private String observacoes;

    @ManyToMany
    @Column(nullable = true)
    private List<Veiculo> veiculos;
    
    public Cliente() {}
    
    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }
    
    public List<Veiculo> getVeiculos() {
        return veiculos;
    }

    public void setVeiculos(List<Veiculo> veiculos) {
        this.veiculos = veiculos;
    }
}
