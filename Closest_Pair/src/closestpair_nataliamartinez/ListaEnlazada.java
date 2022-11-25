/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package closestpair_nataliamartinez;


/**
 *
 * @author natymartinez04
 */
public class ListaEnlazada {
    
    NodoC ptr;
    NodoC head;
    int tam;
    
    public ListaEnlazada(){
        this.ptr = null;
        this.head = null;
        this.tam = 0;
    }
    
    public void Agregar(Coordinate coordinate){
        if (ptr == null){
            ptr = new NodoC(coordinate);
        }else{
            NodoC p = ptr;
            while (p.link != null){
                p = p.link;
            }
            p.link = new NodoC(coordinate);
            head = p.link;
        }
        tam++;
    }
    
    public void printlist(ListaEnlazada lista){
        NodoC p = lista.ptr;
        while (p.link != null){
            System.out.println("x: "+p.coordinate.getX()+" y: "+p.coordinate.getY());
            p = p.link;
        }
    }
    
    public ListaEnlazada sortList(ListaEnlazada lista){
        Coordinate temp;
        if (lista.ptr != null){ 
            if (ptr.link != null){
                NodoC p = lista.ptr;
                NodoC c = lista.ptr.link;
                while (c != null){
                    if (p.coordinate.getX()>c.coordinate.getX()){
                        temp = c.coordinate;
                        c.coordinate = p.coordinate;
                        p.coordinate = temp;
                        if (c==ptr.link){
                            p = c;
                            c = c.link;
                        }else{
                            p = ptr;
                            c = ptr.link;
                        }
                    }else{
                        p = c;
                        c = c.link;
                    }
                }
            }
            
        }
        return lista;
    }
    
    public int getTam() {
        return tam;
    }
    
   
    
    
        
        
        
    
    

   
    
    
    

    
}
