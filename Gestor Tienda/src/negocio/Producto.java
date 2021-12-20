/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

/**
 *
 * @author jhon_
 */
public abstract class Producto{
    protected String codigo;
    protected String nombre;
    protected int precio;

    public Producto() {
    }
    
     
        
    
    
    public Producto(String codigo, String nombre, int precio) throws Exception {
        setCodigo(codigo);
        setNombre(nombre);
        setPrecio(precio);
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) throws Exception {
     if (codigo.trim().length()>=4)
     {
        this.codigo = codigo;
     }
     else
     {
         throw new Exception("Debe ingresar un código");
     }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) throws Exception {
    if (nombre.length()>0)
    {
        this.nombre = nombre;
    }
    else
    {
         throw new Exception("Ingrese el nombre del Producto");
    }
    }
    
    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) throws Exception {
      if (precio>0)
      {
        this.precio = precio;
      }
      else
      {
          throw new Exception("Ingrese un precio");
      }
    }



}
