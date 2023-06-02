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
@Table(name="Player")
public class Player implements java.io.Serializable{
    @Id
    @Column(name="player_name")
    private String playerName;
    
    @Column(name="player_email")
    private String playerEmail;
    
    @Column(name="player_password")
    private String playerPassword;
    
    public Player(){
        
    }

    public Player(String playerName, String playerEmail, String playerPassword) {
        this.playerName = playerName;
        this.playerEmail = playerEmail;
        this.playerPassword = playerPassword;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getPlayerEmail() {
        return playerEmail;
    }

    public void setPlayerEmail(String playerEmail) {
        this.playerEmail = playerEmail;
    }

    public String getPlayerPassword() {
        return playerPassword;
    }

    public void setPlayerPassword(String playerPassword) {
        this.playerPassword = playerPassword;
    }
    
    
    
}
