package tetris;

import java.awt.Point;
import java.util.Random;

/*
 * 方块的具体形状
 * 用坐标表示方块情况
 */
public class Shape {
	/* oo
	 * oo
	 */
	private static final Point[] a1 = new Point[] {new Point(0,0),new Point(0,1),new Point(1,0),new Point(1,1)};
	private static final Point[][] a =  new Point[][]{a1};
	/*
	 * oooo
	 */
	private static final Point[] b1 = new Point[] {new Point(0,0),new Point(0,1),new Point(0,2),new Point(0,3)};
	private static final Point[] b2 = new Point[] {new Point(0,0),new Point(1,0),new Point(2,0),new Point(3,0)};
	private static final Point[][] b = new Point[][]{b1,b2};
	
	/* ooo
	 *  o
	 */
	private static final Point[] c1 = new Point[] {new Point(0,0),new Point(0,1),new Point(0,2),new Point(1,1)};
	private static final Point[] c2 = new Point[] {new Point(0,1),new Point(1,1),new Point(2,1),new Point(1,0)};
	private static final Point[] c3 = new Point[] {new Point(1,0),new Point(1,1),new Point(1,2),new Point(0,1)};
	private static final Point[] c4 = new Point[] {new Point(0,0),new Point(1,0),new Point(2,0),new Point(1,1)};
	private static final Point[][] c = new Point[][]{c1,c2,c3,c4};
	
	/* o
	 * oo
	 *  o
	 */
	private static final Point[] d1 = new Point[] {new Point(0,0),new Point(1,0),new Point(1,1),new Point(2,1)};
	private static final Point[] d2 = new Point[] {new Point(1,0),new Point(1,1),new Point(0,1),new Point(0,2)};
	private static final Point[][] d = new Point[][]{d1,d2};
	/*  o
	 * oo
	 * o
	 */
	private static final Point[] e1 = new Point[] {new Point(0,1),new Point(1,1),new Point(1,0),new Point(2,0)};
	private static final Point[] e2 = new Point[] {new Point(0,0),new Point(0,1),new Point(1,1),new Point(1,2)};
	private static final Point[][] e = new Point[][]{e1,e2};
	/* ooo
	 *   o
	 */
	private static final Point[] f1 = new Point[] {new Point(0,0),new Point(0,1),new Point(0,2),new Point(1,2)};
	private static final Point[] f2 = new Point[] {new Point(0,1),new Point(1,1),new Point(2,1),new Point(2,0)};
	private static final Point[] f3 = new Point[] {new Point(0,0),new Point(1,0),new Point(1,1),new Point(1,2)};
	private static final Point[] f4 = new Point[] {new Point(0,1),new Point(0,0),new Point(1,0),new Point(2,0)};
	private static final Point[][] f = new Point[][]{f1,f2,f3,f4};

	//所有方块形状列表
	private static final Point[][][] list = new Point[][][]{a,b,c,d,e,f};
	
	//通过key值获取方块的形状
	public static Point[] getKeyShape(int[] key) {
		return list[key[0]][key[1]%list[key[0]].length];
	}
	
	//随机产生
	public static int[] getRandomKey() {
		Random r = new Random();
		int i = r.nextInt(list.length);
		int j = r.nextInt(list[i].length);
		return new int[]{i,j};
	}
	
	//获取变形后的值
	public static int[] getNextKey(int[] key) {
		return new int[] {key[0],(key[1]+1)%list[key[0]].length};
	}
}
