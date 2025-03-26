package models;

import jakarta.persistence.*;

@Entity
public class Partida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String localizacion;

    @OneToOne
    @JoinColumn(name = "nickname_user", referencedColumnName = "nickname", nullable = false)
    private Jugador jugador;

    @OneToMany
    @JoinColumn(name = "id_partida", referencedColumnName = "id", nullable = false)
    private Game game;

    public Partida(){}

    public Partida(int id, String localizacion, Jugador jugador, Game game){
        this.id = id;
        this.localizacion = localizacion;
        this.jugador = jugador;
        this.game = game;
    }

    public int getID(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getLocalizacion(){
        return localizacion;
    }

    public void setLocalizacion(String localizacion){
        this.localizacion = localizacion;
    }

    public Jugador getJugador(){
        return jugador;
    }

    public void setJugador(Jugador jugador){
        this.jugador = jugador;
    }

    public Game getGame(){
        return game;
    }

    public void setGame(Game game){
        this.game = game;
    }
}
