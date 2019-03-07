package com.favio.recyclerviewvolley.modelos;

public class Persona {

    private Integer Id;
    private String Nombre;
    private String Apellido;
    private Integer Edad;
    private String Telefono;

    public Persona(Integer id, String nombre, String apellido, Integer edad, String telefono){
        Id=id;
        Nombre=nombre;
        Apellido=apellido;
        Edad=edad;
        Telefono=telefono;
    }

    public void setId(Integer id){
        Id=id;
    }

    public Integer getId(){
        return Id;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setEdad(Integer edad) {
        Edad = edad;
    }

    public Integer getEdad() {
        return Edad;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String telefono) {
        Telefono = telefono;
    }

}