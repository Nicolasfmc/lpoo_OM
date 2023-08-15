package br.edu.ifsul.cc.lpoo.om.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author Nicolasfmc
 */

@Entity
@Table(name = "tb_cargo")
public class Cargo implements Serializable {
    @Id
    private Integer id;
    
    @Column(nullable = false, length = 100)
    private String descricao;
    
    public Cargo() {}

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
