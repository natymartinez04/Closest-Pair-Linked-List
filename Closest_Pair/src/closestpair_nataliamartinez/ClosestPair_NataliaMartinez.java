/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package closestpair_nataliamartinez;



import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;


/**
 *
 * @author natymartinez04
 */
public class ClosestPair_NataliaMartinez{
    
    

    public static void main(String[] args){
        
        long numberC,startSort,endSort;
        int iteraciones = 0;
        Long tiemposBrute[] = new Long[16];
        Long tiemposDivide[] = new Long[16];
        Long comparacionesBrute[] = new Long[16];
        Long comparacionesDivide[] = new Long[16];
        Brute brute = new Brute();
       
        TextFile text = new TextFile();
        
        while (iteraciones < 16){
            ListaEnlazada lista = new ListaEnlazada();
            numberC = (long) Math.pow(2, iteraciones+1);
            System.out.println("Amount of coordinates:"+numberC);
            System.out.println(" ");
            
            lista = GenerateCoordinates(lista,numberC);
            startSort = System.nanoTime();
            lista = lista.sortList(lista);
            endSort = System.nanoTime();
         
            
            tiemposBrute = getTime(lista,tiemposBrute,iteraciones,brute,endSort,startSort,false);
            comparacionesBrute[iteraciones] = brute.getComparasiones();
            brute.setComparaciones(0);
            
            tiemposDivide = getTime(lista,tiemposDivide,iteraciones,brute,endSort,startSort,true);
            comparacionesDivide[iteraciones] = brute.getComparasiones();
            brute.setComparaciones(0);
            
            iteraciones++;
        }
        
        text.writeTime("dataBruteForce.txt",tiemposBrute,iteraciones,comparacionesBrute);
        text.writeTime("dataDivideAndConquer.txt",tiemposDivide,iteraciones,comparacionesDivide);

        
    }

    
    //Method that stores time execution for both cases
    public static Long[] getTime(ListaEnlazada lista,Long[] tiempos,int iteraciones,Brute brute,long endSort,long startSort,boolean sw){
        long start,end;
        double dmin;
        if (sw == false){
            System.out.println("By brute force: ");
            start = System.nanoTime();
            dmin = brute.bruteForce(lista, 100000000);
            end = System.nanoTime();
            tiempos[iteraciones] = end-start + endSort-startSort; 
            Pairs pair = findPair(brute,dmin);
            System.out.println("La Coordenada "+pair.coordinate1.getName()+"("+
                    pair.coordinate1.getX()+","+pair.coordinate1.getY()+")"
                    +" y "+" la coordenada "+pair.coordinate2.getName()+"("+
                    pair.coordinate2.getX()+","+pair.coordinate2.getY()+")"
                    + " tienen la distancia mínima que es igual a:");
            System.out.println(dmin);
            System.out.println(" ");
        }else{
            System.out.println("Divide and Conquer: ");
            start = System.nanoTime();
            dmin = brute.closestRecursive(lista,10000000);
            end = System.nanoTime();
            tiempos[iteraciones] = end-start + endSort-startSort;
            Pairs pair = findPair(brute,dmin);
            System.out.println("La Coordenada "+pair.coordinate1.getName()+"("+
                    pair.coordinate1.getX()+","+pair.coordinate1.getY()+")"
                    +" y "+" la coordenada "+pair.coordinate2.getName()+"("+
                    pair.coordinate2.getX()+","+pair.coordinate2.getY()+")"
                    + " tienen la distancia mínima que es igual a:");
            System.out.println(dmin);
            System.out.println(" ");
        }
        brute.getPairs().removeAll(brute.getPairs());
        return tiempos;
    }
    
    //Method that finds the corresponding pair of coordinates that have the min distance founded
    public static Pairs findPair(Brute brute,double dmin){
        for (int i = 0;i<brute.pairs.size();i++){
            if (brute.pairs.get(i).getMinDistance() == dmin){
                return brute.pairs.get(i);
            }
        }
        return null;
    }
    
    
    
    //Method that generates the coordinates (x,y)
    public static ListaEnlazada GenerateCoordinates(ListaEnlazada lista,long numberC){
        int x;
        int y;
        Random random = new Random();
        for (int i = 0; i<numberC;i++){
            x = random.nextInt((int) Math.pow(5, i));
            y = random.nextInt(500);
            lista.Agregar(new Coordinate(Integer.toString(i),x,y)); 
        } 
        return lista;
    } 

}   

}   





