package org.example.Modelo;

import java.util.ArrayList;
import java.util.List;

public class Departamento {
    private int id;
    private String nombre;
    private List<Empleado> empleados;

    public Departamento(String nombre, List<Empleado> empleados) {
        this.nombre = nombre;
        this.empleados = new ArrayList<>();
    }

    public Departamento() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }
}
