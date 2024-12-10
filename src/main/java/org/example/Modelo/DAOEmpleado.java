package org.example.Modelo;

import org.example.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAOEmpleado {
    private Connection conn;

    public DAOEmpleado() {
        conn = DB.getConnection();
    }

    public List<Empleado> getAllEmpleados(){
        List<Empleado> empleados = new ArrayList<>();

        try{
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM empleados");
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
            Empleado empleado = new Empleado();
            empleado.setId(rs.getInt("id"));
            empleado.setNombre(rs.getString("nombre"));
            empleado.setEdad(rs.getInt("edad"));
            empleado.setIdDepartamento(rs.getInt("dpto_id"));

            empleados.add(empleado);
            }

            return empleados;
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

    public Empleado getEmpleadoById(int id){
        Empleado empleado = null;

        try {
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM empleados WHERE id = ?");
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            Empleado e = null;
            if (rs.next()) {
                e = new Empleado();
                e.setId(rs.getInt("id"));
                e.setNombre(rs.getString("nombre"));
                e.setEdad(rs.getInt("edad"));
                e.setIdDepartamento(rs.getInt("dpto_id"));
            }

            return e;
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int addEmpleado(Empleado empleado){

        try {
            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO empleados (nombre, edad, dpto_id) values (?,?,?)");

            pstmt.setString(1, empleado.getNombre());
            pstmt.setInt(2, empleado.getEdad());
            pstmt.setInt(3, empleado.getIdDepartamento());

            return pstmt.executeUpdate();
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int updateEmpleado(Empleado empleado){
        try{
            PreparedStatement pstmt = conn.prepareStatement("UPDATE empleados SET nombre = ?, edad = ?, dpto_id = ?  WHERE id = ?");

            pstmt.setString(1, empleado.getNombre());
            pstmt.setInt(2, empleado.getEdad());
            pstmt.setInt(3, empleado.getIdDepartamento());
            pstmt.setInt(4, empleado.getId());

            return pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int deleteEmpleado(int id){
        try{
            PreparedStatement pstmt = conn.prepareStatement("DELETE FROM empleados WHERE id = ?");

            pstmt.setInt(1, id);

            return pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Empleado> getEmpleadosByDepartamentoId(int departamentoId) {
        List<Empleado> empleados = new ArrayList<>();
        try {
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM empleado WHERE departamento_id = ?");
            pstmt.setInt(1, departamentoId);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Empleado empleado = new Empleado();
                empleado.setId(rs.getInt("id"));
                empleado.setNombre(rs.getString("nombre"));
                empleado.setEdad(rs.getInt("edad"));
                empleado.setIdDepartamento(departamentoId);
                empleados.add(empleado);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return empleados;
    }



}
