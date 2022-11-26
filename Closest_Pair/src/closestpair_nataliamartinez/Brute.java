/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package closestpair_nataliamartinez;

    

import java.util.ArrayList;

/**
 *
 * @author natymartinez04
 */
public class Brute {
    
    
    ArrayList<Pairs> pairs = new ArrayList();
    long comparaciones = 0;

    public ArrayList<Pairs> getPairs() {
        return pairs;
    }
    
  
    public long getComparasiones() {
        return comparaciones;
    }

    public void setComparaciones(long comparaciones) {
        this.comparaciones = comparaciones;
    }
    
    
    //Brute force function: Finds the minimun distance between
    public double bruteForce(ListaEnlazada lista,double dmin){ 
        Coordinate temp;
        if (lista.ptr != null){ 
            if (lista.ptr.link != null){
                NodoC p = lista.ptr;
                NodoC c = lista.ptr.link;
                while (c != null){
                    if (distance(p.coordinate,c.coordinate)<=dmin){
                        dmin = distance(p.coordinate, c.coordinate);
                        pairs.add(new Pairs(p.coordinate,c.coordinate,dmin));
                    }
                    p = c;
                    c = c.link;
                        
                }
            }
            
        }     
        return dmin;
    }
    
   
    //Divide and Conquer function: Recursively finds the minimun distance between two points
    public double closestRecursive(ListaEnlazada lista,double dmin){
        int n = lista.getTam();
        comparaciones++;
        if (n<=3){
            return bruteForce(lista,dmin);
        }else{
            int mid = n/2;
            NodoC Cmid = lista.getCoordinate(lista, mid);
            double dl = closestRecursive(subList(lista,0,mid),dmin);
            double dr = closestRecursive(subList(lista,mid,n),dmin);    
            dmin = Math.min(dl,dr);
            ListaEnlazada strip = new ListaEnlazada();
            lista = Strip(strip,lista,Cmid.getCoordinate(),0,dmin);
        }
        
        return bruteForce(lista,dmin); 
    }

    
    //Function that adds to a new array the coordinates that have a distance smaller than the minimun distance found to the mid coordinate
    public ListaEnlazada Strip(ListaEnlazada strip,ListaEnlazada lista,Coordinate Cmid,int i,double dmin){
       while (i<lista.getTam()){
            if (Math.abs(lista.getCoordinate(lista, i).getCoordinate().getX() - Cmid.getX()) < dmin) {
                strip.Agregar(lista.getCoordinate(lista, i).getCoordinate());
            }
            i++;
        }
        return strip;
    }
    
    
    public ListaEnlazada subList(ListaEnlazada lista, int start, int end){
        ListaEnlazada subList = new ListaEnlazada();
        NodoC p = lista.getCoordinate(lista, start);
        for (int i = start; i<end; i++){
            subList.Agregar(p.getCoordinate());
            p = p.link;
        }
        return subList;    
    }
    
    //Calculates distance between two coordinates
    public double distance(Coordinate i,Coordinate j){
        return Math.sqrt(Math.pow(i.getX()-j.getX(),2)+Math.pow(i.getY()-j.getY(),2));
    }

}

