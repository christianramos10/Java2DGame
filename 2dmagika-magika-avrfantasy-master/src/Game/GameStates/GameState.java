package Game.GameStates;

import Game.Entities.Creatures.Player;
import Game.Entities.Creatures.Yoshi;
import Game.Items.Item;
import Main.Handler;
import Worlds.BaseWorld;
import Worlds.World1;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by Elemental on 12/10/2016.
 */
public class GameState extends State {

    public GameState(Handler handler){
        super(handler);
        Player player = new Player(handler, 100, 100);
        BaseWorld world = new World1(handler, "res/Maps/map1.map", player);
        handler.setWorld(world);
        handler.getWorld().getEntityManager().setPlayer(player);
        
    }


    @Override
    public void tick() {
        handler.getWorld().tick();
        for (Item i : handler.getWorld().getEntityManager().getPlayer().getInventory().getInventoryItems()) {
            if (i.getName() == "Yoshi's Egg"&& handler.getKeyManager().keyJustPressed(KeyEvent.VK_G)) {
            	handler.getWorld().getEntityManager().addEntity(new Yoshi( handler, 100, 100));
            	System.out.println("Yoshi's here!");
            	i.setCount(i.getCount()-1);
            	
            
            }
        }
    }

    @Override
    public void render(Graphics g) {
        handler.getWorld().render(g);

    }

}
