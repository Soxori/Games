package cz.educanet.webik;


import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;

@ApplicationScoped
public class GamesManager {

    private ArrayList<Games> games = new ArrayList<>();

    public ArrayList<Games> getGames(){
        return games;
    }
    public boolean create(Games games) {
        if(games.getRating() < 0 || games.getRating() > 100)
            return false;
        int generatedId = (int) (Math.random()*(100 +1));
        if (gameCheck(generatedId)){
            games.setId(generatedId);
        }
        return true;
    }
    public Games getGame (int id){
        return games.stream()
                .filter(gameDetailStream -> id == gameDetailStream.getId())
                .findAny()
                .orElse(null);
    }
    public boolean removeGame(int id){
        return  games.remove(getGame(id));
    }
    public boolean gameCheck(int id) {
        for (int i = 0; i < 100; i++){
            if (id != games.get(id).id) {
                return false;
            }
        }
        return true;
    }


}
