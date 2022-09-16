package Game.Entities.Statics;



import java.awt.Color;

import java.awt.Font;

import java.awt.Graphics;

import java.awt.Rectangle;



import Game.Entities.Creatures.Player;

import Game.Items.Item;

import Main.Handler;

import Resources.Images;



public class Chest extends StaticEntity {

	

	private Rectangle ir = new Rectangle();

	public Boolean EP = false;

	boolean flag=false;

	public static boolean chestIsOpen = false;



	public Chest(Handler handler, float x, float y) {

		super(handler, x, y, 50, 50);

		health = 10000;

		bounds.x = 0;

		bounds.y = 0;

		bounds.width = 50;

		bounds.height = 50;

		

		ir.width = bounds.width;

        ir.height = bounds.height;

        int irx=(int)(bounds.x-handler.getGameCamera().getxOffset()+x);

        int iry= (int)(bounds.y-handler.getGameCamera().getyOffset()+height+(height));

        ir.y=iry;

        ir.x=irx;

	}

	

	@Override

	public void render(Graphics g) {

		g.drawImage(Images.chest, (int)(x-handler.getGameCamera().getxOffset()),(int)(y-handler.getGameCamera().getyOffset()),width,height,null);
		g.setColor(Color.white);
		checkForPlayer(g, handler.getWorld().getEntityManager().getPlayer());
	}

		



	@Override

	public void tick() {

		 if(isBeinghurt()){

	            setHealth(10000);

	        }



	        if(handler.getKeyManager().attbut){

	            EP=true;



	        }else if(!handler.getKeyManager().attbut){

	            EP=false;

	        }

		

	}

	

	private void checkForPlayer(Graphics g, Player p) {

        Rectangle pr = p.getCollisionBounds(0,0);

        

        if(ir.contains(pr) && !EP){

            g.drawImage(Images.E,(int) (x+width-handler.getGameCamera().getxOffset()+10),(int) y-10,32,32,null);

        }

        else if(ir.contains(pr) && EP){

            g.drawImage(Images.EP,(int) (x+width-handler.getGameCamera().getxOffset()+10),(int) y-10,32,32,null);

            

            int counter = 0;

            for(Item item : p.getInventory().getInventoryItems()) {

             	if(item.getId() == Item.coinItem.getId() && item.getCount() >= 3) {

             		item.setCount(item.getCount() - 3);

             		counter++;

             	}

             	if(item.getId() == Item.skullItem.getId() && item.getCount() >= 3) {

             		item.setCount(item.getCount() -3);

             		counter++;

             	}

         	}

            

            if(counter >= 2) {

            	chestIsOpen=true;

            }

       

            flag=true;            

        }

        if(!ir.contains(pr)) {

        	flag=false;

        }

        if(flag) {

            g.fillRect((int)(x+width-handler.getGameCamera().getxOffset()+5), (int) (y-10),145,128);

            g.drawImage(Images.skull, (int)(x+width-handler.getGameCamera().getxOffset()+25), (int)(y+10), 40, 40, null);

            g.drawImage(Images.coin, (int)(x+width-handler.getGameCamera().getxOffset()+80), (int)(y+10), 40, 40, null);

            g.setFont(new Font("Times New Roman", Font.BOLD, 14));

            g.setColor(Color.red);

            g.drawString("Deliver 3 of each of", (int)(x+width-handler.getGameCamera().getxOffset()+15), (int) (y+60));

            g.drawString("these items and the", (int)(x+width-handler.getGameCamera().getxOffset()+15), (int) (y+80));

            g.drawString("door shall reveal itself", (int)(x+width-handler.getGameCamera().getxOffset()+10), (int) (y+100));

        }

        

    }

	

	@Override

	public void die() {
		
	}
	
	
	
}