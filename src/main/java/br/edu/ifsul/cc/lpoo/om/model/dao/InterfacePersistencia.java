/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.cc.lpoo.om.model.dao;

import br.edu.ifsul.cc.lpoo.om.model.*;
import java.util.Collection;

/**
 *
 * @author 20202PF.CC0012
 */
public interface InterfacePersistencia {
    public Boolean conexaoAberta();
    public void fecharConexao();
    public Object find(Class c, Object id) throws Exception;
    public void persist(Object o) throws Exception;
    public void remover(Object o) throws Exception;
    public Collection<Cargo> listCargo() throws Exception;
    public Collection<Funcionario> listFuncionario() throws Exception;
}
