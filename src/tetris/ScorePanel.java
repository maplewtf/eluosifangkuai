package tetris;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ScorePanel extends JPanel{
	private int l,s;

	private JPanel nextUnitPanel;
	private JLabel[][] nextUnit;
	private JLabel score;
	private JLabel level;
	private JButton start;
	public ScorePanel() {
		
		start = new JButton("开始");
		//start.setPreferredSize(new Dimension(30,20));
		score = new JLabel("分数:0");
		level = new JLabel("关卡:1");
		score.setPreferredSize(new Dimension(80,30));
		level.setPreferredSize(new Dimension(80,30));
		//score.setBorder(BorderFactory.createMatteBorder(1,1,1,1, Color.black));
		l = 1; s = 0;
		nextUnitPanel = new JPanel(new GridLayout(4,4));
		nextUnit = new JLabel[4][4];
		for(int i=0;i<4;i++)
			for(int j=0;j<4;j++) {
				nextUnit[i][j] = new JLabel();
				nextUnit[i][j].setPreferredSize(new Dimension(20,20));
				nextUnit[i][j].setBackground(Color.BLACK);
				//nextUnit[i][j].setOpaque(true);
				nextUnitPanel.add(nextUnit[i][j]);
			}
		this.setLayout(new FlowLayout());
		this.add(nextUnitPanel);
		this.add(start);
		this.add(score);
		this.add(level);
		
		this.setPreferredSize(new Dimension(100,400));
	}
	
	public void addOwnListener(MouseListener m,KeyListener k) {
		start.addMouseListener(m);
		start.addKeyListener(k);
	}
	public void updateData(int c,Unit p) {
		s += c * 100;
		score.setText("分数:"+s);
		l = s/1000 + 1;//+1000 level+1
		level.setText("关卡:" + l);
		for(int i=0;i<4;i++)
			for(int j=0;j<4;j++)
				nextUnit[i][j].setOpaque(false);
		for(Point u:p.getPaintShape())
			nextUnit[u.x][u.y].setOpaque(true);
		nextUnitPanel.updateUI();
	}
	
	public int getL() {
		return l;
	}

	public int getS() {
		return s;
	}
}
