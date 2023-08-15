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
 * @author Nicolasfmc
 */

@Entity
@Table(name = "tb_curso")
public class Curso implements Serializable {
    @Id
    private Integer id;
    
    @Column(nullable = false, length = 100)
    private String descricao;
    
    @Column(nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar dt_conclusao;
    
    @Column(nullable = false, length = 100)
    private Integer cargahoraria;
    
    public Curso() {}

    public Integer getCargahoraria() {
        return cargahoraria;
    }

    public void setCargahoraria(Integer cargahoraria) {
        this.cargahoraria = cargahoraria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Calendar getDt_conclusao() {
        return dt_conclusao;
    }

    public void setDt_conclusao(Calendar dt_conclusao) {
        this.dt_conclusao = dt_conclusao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
