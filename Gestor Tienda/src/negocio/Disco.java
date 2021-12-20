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
public class Disco extends Producto{
    private String artista;
    private int annio;
    
    public Disco(){
        super();
    }

    public Disco(String artista, int annio, String codigo, String nombre, int precio, int cantidad) throws Exception {
        super(codigo, nombre, precio);
        setArtista(artista);
        setAnnio(annio);
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) throws Exception{
    if (artista.length()>0)
    {
        this.artista = artista;
    }
    else
    {
         throw new Exception("Ingrese el Artista del Album");
    }
    }

    public int getAnnio() {
        return annio;
    }

    public void setAnnio(int annio) throws Exception {
      if (annio>0)
      {
        this.annio = annio;
      }
      else
      {
          throw new Exception("Ingrese el año del Album");
      }
    }
    
    @Override
    public String toString()
    {
        return "=== Informacion Disco === \n"+
                "Codigo:"+super.codigo+"\n"+
                "Nombre:"+super.nombre+"\n"+
                "Precio:"+super.precio+"\n"+
                "Artista:"+artista+"\n"+
                "Año:"+annio+"\n";
                
                
    }
}
