/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

public class Tienda {
    private int codigo;
    private String marca;
    private String modelo;
    private String dimension;
    private String año;
    private int tipo;

    
    public Tienda(int codigo, String marca, String modelo, String dimension, int tipo){
        this.codigo=codigo;
        this.marca=marca;
        this.modelo=modelo;
        this.dimension=dimension;   
        this.año=año; 
        this.tipo=tipo;   
    }
    
    public Tienda(){
        this.marca="Marca de ejemplo";
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    public String getAño() {
        return año;
    }

    public void setAño(String año) {
        this.año = año;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

   
}
