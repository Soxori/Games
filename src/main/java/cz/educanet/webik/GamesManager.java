package cz.educanet.webik;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.lang.Math;

@ApplicationScoped
public class GamesManager {

    private ArrayList<Games> games = new ArrayList<>();

    public ArrayList<Games> getGames(){
        return games;
    }

    public boolean create(Games game) {

        int newId = (int) (Math.random()*(100 +1));

        if (gameCheck(newId)){
            game.setId(newId);

        }
        return true;
    }

    public Games getGame (int id){
        return  games.stream()
                .filter(gameStream -> id == gameStream.getId())
                .findAny()
                .orElse(null);
    }

    public boolean gameCheck(int id) {
        for (int i = 0; i < 100; i++){
            if (id != games.get(id).id) {
                return false;
            }
        } return true;
    }

    public boolean removeGame(int id){
        return  games.remove(getGame(id));
    }

    public boolean editGame(int id){


        if(gameCheck(id)){
            games.add(games);
            return true;
        } else {
            return false;
        }
    }

}
