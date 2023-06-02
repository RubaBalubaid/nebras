/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package approject;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Ruba
 */

@Entity
@Table(name="Player_state")
public class Player_state implements java.io.Serializable{
    
    @Id
    @Column(name="name_of_player")
    private String name_of_player;
    
    @Column(name="number_of_stars")
    private int numberOfStars;
    
    public Player_state(){
        
    }

    public Player_state(String name_of_player, int numberOfStars) {
        this.name_of_player = name_of_player;
        this.numberOfStars = numberOfStars;
    }

      

    public String getName_of_player() {
        return name_of_player;
    }

    public void setName_of_player(String name_of_player) {
        this.name_of_player = name_of_player;
    }

    public int getNumberOfStars() {
        return numberOfStars;
    }

    public void setNumberOfStars(int numberOfStars) {
        this.numberOfStars = numberOfStars;
    }
   
}

