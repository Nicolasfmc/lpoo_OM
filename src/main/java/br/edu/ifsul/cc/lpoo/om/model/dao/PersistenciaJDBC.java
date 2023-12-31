/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsul.cc.lpoo.om.model.dao;

import br.edu.ifsul.cc.lpoo.om.model.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author Nicolasfmc
 */
public class PersistenciaJDBC implements InterfacePersistencia {

    private final String DRIVER = "org.postgresql.Driver";
    private final String USER = "postgres";
    private final String SENHA = "123456";
    public static final String URL = "jdbc:postgresql://localhost:5432/db_om_lpoo_20232";
    private Connection con = null;

    public PersistenciaJDBC() throws ClassNotFoundException, SQLException {

        Class.forName(DRIVER); //carregamento do driver postgresql em tempo de execução
        System.out.println("Tentando estabelecer conexao JDBC com : " + URL + " ...");

        this.con = DriverManager.getConnection(URL, USER, SENHA);

    }

    @Override
    public Boolean conexaoAberta() {

        try {
            if (con != null) {
                return !con.isClosed();//verifica se a conexao está aberta
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public void fecharConexao() {
        try {
            this.con.close();//fecha a conexao.
            System.out.println("Fechou conexao JDBC");
        } catch (SQLException e) {
            e.printStackTrace();//gera uma pilha de erro na saida.
        }
    }

    @Override
    public Object find(Class c, Object id) throws Exception {
        if (c == Cargo.class) {
            PreparedStatement ps = this.con.prepareStatement(""
                    + "select id, descricao from tb_cargo where id = ?");

            ps.setInt(1, Integer.valueOf(id.toString()));

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Cargo crg = new Cargo();
                crg.setId(rs.getInt("id"));
                crg.setDescricao(rs.getString("descricao"));
                return crg;
            }
            ps.close();
            rs.close();

        } else if (c == Curso.class) {

        } else {

        }

        return null;
    }

    @Override
    public void persist(Object o) throws Exception {
        if (o instanceof Cargo) {
            Cargo crg = (Cargo) o;
            if (crg.getId() == null) {
                //executar um insert
                PreparedStatement ps = this.con.prepareCall("insert into "
                        + "tb_cargo (id, descricao) values (nextval('seq_cargo_id') , ? )");
                //definir os valores para os parametros
                ps.setString(1, crg.getDescricao());
                ps.execute();
                ps.close();
            } else {
                //executar um update
                PreparedStatement ps = this.con.prepareCall("udpate tb_cargo set descricao = ? "
                        + "where id = ?");

                //definir os valores para os parametros.
                ps.setString(1, crg.getDescricao());
                ps.setInt(2, crg.getId());
                ps.execute();
                ps.close();
            }
        } else if (o instanceof Curso) {

        } else if (o instanceof Funcionario) {

        }
    }

    @Override
    public void remover(Object o) throws Exception {
        if (o instanceof Cargo) {
            Cargo crg = (Cargo) o;

            PreparedStatement ps = this.con.prepareStatement("delete from "
                    + "tb_cargo where id = ?;"
            );
            ps.setInt(1, crg.getId());
            ps.execute();
            ps.close();
        } else {

        }
    }

    @Override
    public Collection<Cargo> listCargos() throws Exception {
        Collection<Cargo> colecaoRetorno = null;

        PreparedStatement ps = this.con.prepareStatement("select id, descricao from "
                + "td_cargo order by id asc");

        ResultSet rs = ps.executeQuery();

        colecaoRetorno = new ArrayList();

        while (rs.next()) {
            Cargo crg = new Cargo();
            crg.setId(rs.getInt("id"));
            crg.setDescricao(rs.getString("descricao"));
            colecaoRetorno.add(crg);
        }
        
        ps.close();

        return colecaoRetorno;
    }

    @Override
    public Collection<Funcionario> listFuncionarios() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
