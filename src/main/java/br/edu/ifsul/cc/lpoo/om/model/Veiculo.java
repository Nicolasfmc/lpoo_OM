/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.cc.lpoo.om.model;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.*;

/**
 *
 * @author 20202PF.CC0012
 */

@Entity
@Table(name = "tb_veiculo")
public class Veiculo implements Serializable {
    @Id
    private String placa;
    
    @Column(nullable = false, length = 100)
    private String modelo;
    
    @Column(nullable = false, length = 100)
    private Integer ano;
    
    @Column(nullable = true, length = 100)
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar data_ultimo_servico;

    public Veiculo() {}
    
    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public Calendar getData_ultimo_servico() {
        return data_ultimo_servico;
    }

    public void setData_ultimo_servico(Calendar data_ultimo_servico) {
        this.data_ultimo_servico = data_ultimo_servico;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }
}
