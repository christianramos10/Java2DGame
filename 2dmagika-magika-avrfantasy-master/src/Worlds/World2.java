package Worlds;

import Game.Entities.Creatures.BowserJr;
import Game.Entities.Creatures.BowserJr2;
import Game.Entities.Creatures.Player;
import Game.Entities.Creatures.SkelyEnemy;
import Game.Entities.Statics.*;
import Game.GameStates.State;
import Main.Handler;



/**

 * Created by Elemental on 2/10/2017.

 */

public class World2 extends BaseWorld{

    private Handler handler;
    private Player player;

    



    public World2(Handler handler, String path, Player player) {

        super(handler,path,player);

        this.handler = handler;

        this.player=player;
        
        entityManager.addEntity(new BowserJr2(handler, 900, 900));
      

       


    }    
}