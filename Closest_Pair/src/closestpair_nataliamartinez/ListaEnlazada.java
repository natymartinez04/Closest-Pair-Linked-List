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
    
    //Add Coordinate to list
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
    
    //Returns coordinate wanted
    public NodoC getCoordinate(ListaEnlazada lista,int index){
        NodoC p = lista.ptr;
        int i = 0;
        while(p != null && i!=index){
            p = p.link;
            i++;
        }
        return p;
    }
    public void printlist(ListaEnlazada lista){
        NodoC p = lista.ptr;
        while (p != null){
            System.out.println("x: "+p.coordinate.getX()+" y: "+p.coordinate.getY());
            p = p.link;
        }
    }
    
    //Sorts list (depending on x value, in ascending order) using bubble sort
    public ListaEnlazada sortList(ListaEnlazada lista,Brute brute){
        Coordinate temp;
        if (lista.ptr != null){ 
            if (lista.ptr.link != null){
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
                    brute.setComparaciones(brute.comparaciones + 1);
                }
            }
            
        }
        return lista;
    }
    
    public int getTam() {
        return tam;
    }
    
    
}


