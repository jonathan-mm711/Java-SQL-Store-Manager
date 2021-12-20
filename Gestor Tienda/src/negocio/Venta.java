/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author jhon_
 */
public class Venta{
    private int numero;
    private Date fecha;   
    public Producto producto;
    ArrayList<Producto> venta = new ArrayList();
    
    
    public Venta() {
        producto = new Producto() {};
    }

    public Venta(int numero, Date fecha) throws Exception {
        setNumero(numero);
        this.fecha = fecha;
        this.producto = producto;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) throws Exception {
      if (numero>0)
      {
        this.numero = numero;
      }
      else
      {
          throw new Exception("Ingrese el numero de venta");
      }
    }
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public ArrayList<Producto> getVenta() {
        return venta;
    }

    public void setVenta(ArrayList<Producto> venta) {
        this.venta = venta;
    }

    

    public String ImprimirComprobante() {
        return "============  N° venta:"+numero+"============  \n"+
                "Fecha"+fecha+"\n"+                
                "Productos:"+producto+"\n"+
                "---------------------------------------------- \n";
    }
                //"Total sin descuento:"+calcularTotal()+"\n"+
                //"Total (-10% empresa):"+calcularTotalConDescuento()+"\n"+
                //"---------------------------------------------- \n"     
    
    
    
}