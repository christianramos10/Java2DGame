package Game.GameStates;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

import Main.Handler;
import Resources.Images;


public class GameWonState extends State{
	
	public GameWonState(Handler handler) {
		super(handler);
	}



	@Override

	public void tick() {
		if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_R)) {
			State.setState(handler.getGame().menuState);
		}	
	}



	@Override

	public void render(Graphics g) {

		g.setColor(Color.white);
		g.fillRect(0,0,handler.getWidth(),handler.getHeight());
        g.drawImage(Images.win,0,0,800,600,null);
        g.setFont(new Font("Monospaced Bold", Font.BOLD, 24));
        g.setColor(Color.black);
        g.drawString("Press R to play again", 275, 530);	

	}



}