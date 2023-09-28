package br.edu.ifsul.cc.lpoo.om.test;

import br.edu.ifsul.cc.lpoo.om.model.*;
import br.edu.ifsul.cc.lpoo.om.model.dao.PersistenciaJDBC;
import java.util.Collection;
import org.junit.Test;

/**
 *
 * @author Nicolasfmc
 */
public class TestPersistenciaJDBC {

    //@Test
    public void testConexaoJDBC() throws Exception {
        //criar um objeto do tipo PersistenciaJPA.
        PersistenciaJDBC jdbc = new PersistenciaJDBC();
        if (jdbc.conexaoAberta()) {
            System.out.println("conectou no BD via jdbc ...");
            jdbc.fecharConexao();
        } else {
            System.out.println("nao conectou no BD via jdbc ...");

        }
    }

    @Test
    public void testPersistenciaListCargoJDBC() throws Exception {
        PersistenciaJDBC jdbc = new PersistenciaJDBC();
        if (jdbc.conexaoAberta()) {
            Collection<Cargo> colecaoCargo = (Collection<Cargo>) jdbc.listCargos();
            if (!colecaoCargo.isEmpty()) {
                System.out.println("Cargos encontrados: ");
                for (Cargo cargo : colecaoCargo) {
                    System.out.println(cargo.getDescricao() + "\n");
                    
                    cargo.setDescricao("Teste");
                    jdbc.persist(cargo);
                    jdbc.remover(cargo);
                }
            } else {
                Cargo c = new Cargo();
                c.setDescricao("teste");
                jdbc.persist(c);
                System.out.println("Cadastrou o cargo: " + c.getId());
            }
        } else {
            System.out.println("Não conectou no banco...");
        }   
    }

    //@Test
    public void testPersistenciaCargoJPA() throws Exception {
        //criar um objeto do tipo PersistenciaJPA.
        PersistenciaJDBC jpa = new PersistenciaJDBC();
        if (jpa.conexaoAberta()) {

            //Passo 1: encontrar o cargo id = 1
            Cargo cg = (Cargo) jpa.find(Cargo.class, Integer.valueOf("1"));
            if (cg != null) {
                System.out.println("Cargo encontrado: ");
                System.out.println("id: " + cg.getId() + " Descricao: " + cg.getDescricao());
                
            } else {
                System.out.println("Não encontro o cargo");
            }
        } else {
            System.out.println("nao conectou no BD via jdbc ...");
            //atribuir uma instancia para o cg
            //setar a descricao
            //persistir no banco de dados.
        }
    }
}
