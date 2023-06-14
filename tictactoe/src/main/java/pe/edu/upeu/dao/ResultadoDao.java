/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.upeu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import pe.edu.upeu.coon.ConnS;
import pe.edu.upeu.modelo.ResultadoTO;

/**
 *
 * @author ACER
 */
public class ResultadoDao implements ResultadoDaoI {

    ConnS intance = ConnS.getInstance();
    Connection conexion = intance.getConnection();
    PreparedStatement ps;
    ResultSet rs;

    @Override
    public List listarResultados() {
        List<ResultadoTO> lista=new ArrayList();
        String sql="select * from resultados";
        try {
            ps=conexion.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()) {
               ResultadoTO to=new ResultadoTO();
               to.setIdResultado(rs.getInt("id_resultado"));
               to.setNombrePartida(rs.getString("nombre_partida"));
               to.setNombreJugador1(rs.getString("nombre_jugador1"));
               to.setNombreJugador2(rs.getString("nombre_jugador2"));
               to.setGanador(rs.getString("ganador"));
               to.setPunto(rs.getInt("punto"));
               to.setEstado(rs.getString("estado"));
               lista.add(to);
            }
            
        } catch (Exception e) {
        }
        return lista;
    }

    @Override
    public int create(ResultadoTO d) {
        int exec=0;
        int i=0;
        String sql="insert into resultados(nombre_partida, nombre_jugador1, nombre_jugador2, ganador, punto, estado) "
                + "VALUES(?,?,?,?,?,?);";
        try {
            ps=conexion.prepareStatement(sql);
            ps.setString(++i, d.getNombrePartida());
            ps.setString(++i, d.getNombreJugador1());
            ps.setString(++i, d.getNombreJugador2());
            ps.setString(++i, d.getGanador());
            ps.setInt(++i, d.getPunto());
            ps.setString(++i, d.getEstado());
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println("ERROR:"+e.getMessage());
        }
        return exec;
    }

    @Override
    public int update(ResultadoTO d) {
        System.out.println("actualizar d.getIdResultado: " + d.getIdResultado());
        int comit = 0;
        String sql = "UPDATE resultados SET "
                + "nombre_partida=?, "
                + "nombre_jugador1=?, "
                + "nombre_jugador2=?, "
                + "ganador=?, "
                + "punto=?, "
                + "estado=?, "              
                + "WHERE dni=?";
        int i = 0;
        try {
            ps = conexion.prepareStatement(sql);
            ps.setString(++i, d.getNombrePartida());
            ps.setString(++i, d.getNombreJugador1());
            ps.setString(++i, d.getNombreJugador2());
            ps.setString(++i, d.getGanador());
            ps.setInt(++i, d.getPunto());
            ps.setString(++i, d.getEstado());
            comit = ps.executeUpdate();
        } catch (SQLException ex) {
            System.err.println("error");
        }
        return comit;
    }

    }

  

   
