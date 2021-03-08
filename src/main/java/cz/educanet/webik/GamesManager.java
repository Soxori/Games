package cz.educanet.webik;


import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;

@ApplicationScoped
public class GamesManager {

    private ArrayList<Games> games = new ArrayList<>();

    public ArrayList<Games> getGames(){
        return games;
    }

    public boolean create(Games game) {
        if(game.getRating() < 0 || game.getRating() > 100)
            return false;

        int newId = getGames().size() + 1;
        if (!gameCheck(newId)){
            game.setId(newId);
            games.add(game);
        }
        return true;
    }
    public Games getGame(int id){
        return games.stream()
                .filter(gamesStream -> id == gamesStream.getId())
                .findAny()
                .orElse(null);
    }
    public boolean removeGame(int id){
        return  games.remove(getGame(id));
    }
    public boolean gameCheck(int id) {
        return getGame(id) != null;
    }
    public boolean editGame(int id, Games game){
        if(gameCheck(id)){
            games.set(id, game);
            return true;
        } else {
            return false;
        }
    }
}
