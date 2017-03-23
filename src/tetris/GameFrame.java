package tetris;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GameFrame extends JFrame{
	
	private static int x = 20;
	private static int y = 10;
	private GamePanel game = null;
	private ScorePanel watch = null;
	private Timer downMoveTimer = null;
	private int speed;
	
	public GameFrame() {
		super();
		this.setLayout(new FlowLayout());
		this.setBounds(500, 50, 600, 650);
		
		game = new GamePanel(x,y);
		watch = new ScorePanel();
		this.add(game);
		this.add(watch);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		downMoveTimer = new Timer(1000,new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!game.moveUnit(3)) {
					updateData();
				}
				
			}
		});
		addListener();
		
	}
	
	protected void resetGame() {
		
		game.resetGame();
		updateData();//System.out.println("resetGameData");
	}
	
	//更新数据
	public int updateData() {
		
		int c = game.removeRow();
		watch.updateData(c, game.createNextUnit());
		//System.out.println("updateData");
		speed = (int) (1000*Math.pow(0.75, watch.getL()-1));
		if(game.getNextUnit())
			downMoveTimer.setDelay(speed);
		else {
			stopGame();
		}
		return c;
	}
	
	protected void stopGame() {
		JOptionPane.showMessageDialog(null, "你的最终得分是："+watch.getS(), "俄罗斯方块", JOptionPane.ERROR_MESSAGE);
	}
	
	//开始游戏
	protected void startGame(){
		//System.out.println("startGame");
		resetGame();
		downMoveTimer.start();
	}

	private void addListener() {
		//System.out.println("addListener");
		watch.addOwnListener(new MouseAdapter(){

			@Override
			public void mouseClicked(MouseEvent e) {
				startGame();
			}
			
		}, 
		new KeyAdapter() {
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if(e.getKeyCode()==KeyEvent.VK_LEFT)
					game.moveUnit(1);
				else if(e.getKeyCode()==KeyEvent.VK_RIGHT)
					game.moveUnit(2);
				else if(e.getKeyCode()==KeyEvent.VK_DOWN)
					game.moveUnit(3);
				else if(e.getKeyCode()==KeyEvent.VK_SPACE)
					game.moveUnit(0);
			}
		});
	}
	
	public static void main(String[] args) {
		GameFrame player = new GameFrame();
		player.setVisible(true);
	}
}
