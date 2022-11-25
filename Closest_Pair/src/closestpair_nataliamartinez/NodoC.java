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
public class NodoC {
    
    NodoC link;
    Coordinate coordinate;
    
    public NodoC(Coordinate coordinate){
        this.coordinate = coordinate;
        this.link = null;
    }

    public NodoC getLink() {
        return link;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }
    
}
