/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.cc.lpoo.om.model;

import java.util.*;
import javax.persistence.*;

/**
 *
 * @author Nicolasfmc
 */

@Entity
@DiscriminatorValue("F")
@Table(name = "tb_funcionario")
public class Funcionario extends Pessoa {
    @Column(nullable = false, length = 11)
    private String numero_ctps;
    
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)  
    private Calendar data_admmissao;
      
    @Column(nullable = true)
    @Temporal(TemporalType.DATE)    
    private Calendar data_demissao;

    public Funcionario() {
    }
    
    @ManyToOne
    @JoinColumn(name = "cargo_id")
    private Cargo cargo;

    @ManyToMany
    @JoinTable(name = "tb_funcionario_curso", joinColumns = {@JoinColumn(name = "funcionario_cpf")}, //agregacao, vai gerar uma tabela associativa.
                                       inverseJoinColumns = {@JoinColumn(name = "curso_id")})
    private Collection<Curso> cursos;


    public String getNumero_ctps() {
        return numero_ctps;
    }

    public void setNumero_ctps(String numero_ctps) {
        this.numero_ctps = numero_ctps;
    }

    public Calendar getData_admmissao() {
        return data_admmissao;
    }

    public void setData_admmissao(Calendar data_admmissao) {
        this.data_admmissao = data_admmissao;
    }

    public Calendar getData_demissao() {
        return data_demissao;
    }

    public void setData_demissao(Calendar data_demissao) {
        this.data_demissao = data_demissao;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public Collection<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(Collection<Curso> cursos) {
        if(this.cursos == null) {
            this.cursos = new ArrayList();
        }
        this.cursos = cursos;
    }
    
    public void setCurso(Curso curso) {
        this.cursos.add(curso);
    }
    
}