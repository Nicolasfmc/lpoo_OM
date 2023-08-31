package br.edu.ifsul.cc.lpoo.om.test;

import br.edu.ifsul.cc.lpoo.om.model.Cargo;
import br.edu.ifsul.cc.lpoo.om.model.Funcionario;
import br.edu.ifsul.cc.lpoo.om.model.dao.PersistenciaJPA;
import java.util.Collection;
import org.junit.Test;

/**
 *
 * @author Nicolas
 */

public class TestPersistenciaJPA {
    //@Test
    public void testConexaoJPA(){
        //criar um objeto do tipo PersistenciaJPA.
        PersistenciaJPA jpa = new PersistenciaJPA();
        if(jpa.conexaoAberta()){
            System.out.println("conectou no BD via jpa ...");
            jpa.fecharConexao();
        }else{
            System.out.println("nao conectou no BD ...");             
        }
    }
    
    //@Test
    public void testPersistenciaListCargoJPA() throws Exception {
        //criar um objeto do tipo PersistenciaJPA.
        PersistenciaJPA jpa = new PersistenciaJPA();
        if(jpa.conexaoAberta()){
            Collection<Cargo> cg = jpa.listCargo();
             if(!cg.isEmpty()){
            
                var i = 1;
                for(Cargo c : cg){
                    System.out.println("Cargo: "+ c.getDescricao());
                    c.setDescricao("Mudando a descricao " + i);
                    jpa.persist(c);
                    jpa.remover(c);
                    
                    i++;
                }
            } else {
                Cargo cargo = new Cargo();
                
                cargo.setDescricao("teste 1");
                jpa.persist(cargo);
                
                Cargo cargo2 = new Cargo();
                
                cargo2.setDescricao("teste 2");
                jpa.persist(cargo2);
            }
            
            
            jpa.fecharConexao();
        }else{
            System.out.println("nao conectou no BD ...");             
        }
    }
    
    @Test
    public void testPersistenciaListFuncionarioJPA()  throws Exception {
        //criar um objeto do tipo PersistenciaJPA.
        PersistenciaJPA jpa = new PersistenciaJPA();
        if(jpa.conexaoAberta()){
            //Passo 1: recuperar a coleção de funcionarios
            Collection<Funcionario> funcionarios = jpa.listFuncionario();
            //Passo 2: caso a coleção não esteja vazia - imprimir (inclusive os cursos), alterar e remover cada item.
            //Passo 3: caso a coleção esteja vazia, criar dois funcionarios com um Curso cada e inserir na tabela.
            
            jpa.fecharConexao();
        }else{
            System.out.println("nao conectou no BD ...");             
        }
    }
}
