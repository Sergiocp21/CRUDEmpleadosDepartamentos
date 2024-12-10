package org.example.Modelo;

public class Empleado {
    private int id;
    private String nombre;
    private int edad;
    private int idDepartamento;

    public Empleado() {
        super();
    }

    public Empleado(String nombre, int edad, int idDepartamento) {
        this.nombre = nombre;
        this.edad = edad;
        this.idDepartamento = idDepartamento;
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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

}
