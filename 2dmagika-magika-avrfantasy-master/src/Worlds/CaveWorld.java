package Worlds;
import Game.Entities.Creatures.BowserJr;
import Game.Entities.Creatures.Player;
import Game.Entities.Creatures.SkelyEnemy;
import Game.Entities.Statics.Door2;
import Main.Handler;

/**
 * Created by Elemental on 2/10/2017.
 */
public class CaveWorld extends BaseWorld{
    private Handler handler;
    private Player player;
    private BaseWorld world2;

    public CaveWorld(Handler handler, String path, Player player) {
        super(handler,path,player);
        this.handler = handler;
        this.player=player;
        
        world2 = new World2(handler,"res/Maps/map2.map",player);
        
        entityManager.addEntity(new Door2(handler, 100, 0,world2));
        entityManager.addEntity(new BowserJr(handler, 900, 900));
        



    }


}