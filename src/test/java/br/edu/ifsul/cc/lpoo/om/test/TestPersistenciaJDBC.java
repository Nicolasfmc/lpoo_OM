/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.cc.lpoo.om.test;

import br.edu.ifsul.cc.lpoo.om.model.dao.PersistenciaJDBC;

/**
 *
 * @author Nicolasfmc
 */
public class TestPersistenciaJDBC {
     //@Test
    public void testPersistenciaProcedimento() throws Exception {
        
        //Reavaliação da Primeira Etapa
    }
    
    //@Test
    public void testPersistenciaConexao() throws Exception {
        
        //criar um objeto do tipo PersistenciaJDBC.
        PersistenciaJDBC jdbc = new PersistenciaJDBC();
        if(jdbc.conexaoAberta()){
            System.out.println("conectou no BD via jpa ...");
            jdbc.fecharConexao();
        }else{
            System.out.println("nao conectou no BD ...");
                        
        }
        
    }
}
