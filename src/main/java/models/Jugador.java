package models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Jugador {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)

    private int id;
    private String nombre;
    private String nickname;

    public Jugador(){}

    public Jugador(String nombre, String nickname){
        this.nombre = nombre;
        this.nickname = nickname;
    }

    public int getID(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getNickname(){
        return nickname;
    }

    public void setNickname(String nickname){
        this.nickname = nickname;
    }
}
