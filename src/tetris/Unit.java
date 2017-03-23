package tetris;

import java.awt.Point;
/*
 * 方块位置和形状,和变换后的情况
 */
public class Unit {
	private Point location; //位置
	private int[] key;      //形状代号
	
	public Unit(Point l) {
		location = l;
		key = Shape.getRandomKey();
	}
	
	public Unit(Point l,int[] k) {
		location = l;
		key = k;
	}
	
	//获取当前形状
	public Point[] getPaintShape() {
		return Shape.getKeyShape(key);
	}
	
	//获取当前形状的坐标
	public Point[] getPaintLocation() {
		Point[] s = Shape.getKeyShape(key);
		Point[] p = new Point[s.length];
		
		
		for(int i = 0; i < s.length; i++) {
			p[i] = new Point(s[i].x + location.x,s[i].y + location.y);
		}
		return p;
	}
	
	//按照指令改变形状
	public Unit getChangeUnit(boolean isShapeChanged,int x,int y) {
		Point l = new Point(location.x + x, location.y + y);
		int[] k;
		if(isShapeChanged) 
			k = Shape.getNextKey(key);
		else
			k = new int[]{this.key[0],this.key[1]};
		return new Unit(l,k);
	}
	
	
}
