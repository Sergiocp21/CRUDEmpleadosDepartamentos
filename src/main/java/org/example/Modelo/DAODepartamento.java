package org.example.Modelo;

import org.example.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAODepartamento {

    private Connection conn;

    public DAODepartamento() {
        conn = DB.getConnection();
    }

    public List<Departamento> getAllDepartamentos(){
        try{
            List<Departamento> departamentos = new ArrayList<Departamento>();
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM departamento");
            ResultSet rs = pstmt.executeQuery();
            DAOEmpleado daoEmpleado = new DAOEmpleado();
            while(rs.next()){
                Departamento departamento = new Departamento();
                departamento.setId(rs.getInt("id"));
                departamento.setNombre(rs.getString("nombre"));

                //Obtiene empleados del departamento
                departamento.setEmpleados(daoEmpleado.getEmpleadosByDepartamentoId(departamento.getId()));

                departamentos.add(departamento);
            }
            return departamentos;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public Departamento getDepartamentoById(int id){
        try{
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM departamento WHERE id = ?");
            pstmt.setInt(1, id);

            ResultSet rs = pstmt.executeQuery();
            Departamento departamento = null;
            DAOEmpleado daoEmpleado = new DAOEmpleado();

            if(rs.next()){
                departamento = new Departamento();
                departamento.setId(rs.getInt("id"));
                departamento.setNombre(rs.getString("nombre"));

                // Obtiene los empleados del departamento
                departamento.setEmpleados(daoEmpleado.getEmpleadosByDepartamentoId(departamento.getId()));
            }

            return departamento;

        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    public int addDepartamento(Departamento departamento){
        try{
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO departamento (nombre) VALUES ?");

            pstmt.setString(1, departamento.getNombre());

            return pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int updateDepartamento(Departamento departamento){
        try{
            PreparedStatement pstmt = conn.prepareStatement("UPDATE departamento SET nombre = ? WHERE id = ?");
            pstmt.setString(1, departamento.getNombre());
            pstmt.setInt(2, departamento.getId());

            return pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int deleteDepartamento(int id){
        try{
            PreparedStatement pstmt = conn.prepareStatement("DELETE FROM departamento WHERE id = ?");

            pstmt.setInt(1, id);

            return pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}