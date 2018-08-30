package org.wonjin.ohmook.gui;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import org.wonjin.ohmook.exception.StoneAlreadyExistsException;
import org.wonjin.ohmook.gui.Listener.BadukStoneListener;
import org.wonjin.ohmook.object.Stone;


public class BadukPanel extends JPanel {
	/**
	 *  바둑판 패널
	 */
	private static final long serialVersionUID = 1L;
	
	private List<BadukStoneListener> stoneListeners = new ArrayList<BadukStoneListener>();
	
	
	private int panSize = 19;								// o 바둑판 사이즈
	private int panMargin = 50;								// o 바둑판 마진


	private Stone[] stoneList;
	private int stoneIndex = 0;
	private Point[][] pan;	// o 바둑판 x,y 포인트 (마우스 이벤트 처리 용도)
	
	/*
	 * After paintComponent init
	 */
	
	private int lineCount;									// o 바둑판 라인 수
	private int width; 										// o 패널 넓이
	private int height;										// o 패널 높이
	private int innerWidth;									// o 바둑판 넓이 
	private int innerHeight;								// o 바둑판 높이
    

	private int lineHeight;									// o 바둑판 가로라인 크기
	private int lineWidth;									// o 바둑판 세로라인 크기
	
	
	private int mouseMatch;									//
	
	private boolean debugSysout = false;
	/*
	 *  o PadukPanel(panSize)
	 *  o panSize 만큼 바둑판 만듬
	 */
	public BadukPanel(int nPanSize) {
		this.setPanSize(nPanSize);
		// o 바둑판 클릭 이벤트 등록
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				super.mouseClicked(e);
				if(debugSysout)
					System.out.println("mouseClick : " + e.getPoint().toString());
				int xPoint = e.getX();
				int yPoint = e.getY();
				
				for(int x= 0; x <= lineCount ;x++) {
					for(int y = 0 ;y <= lineCount;y++) {
						
						int panX = (int)pan[x][y].getX();
						int panY = (int)pan[x][y].getY();
						// o 마우스 포인터값이 임계값 안에 들면
						if( Math.abs(xPoint - panX) < mouseMatch && Math.abs(yPoint - panY) < mouseMatch) {
							
							if(debugSysout)
								System.out.println("stone : " +x + ","+ y);
							
							// o 리스너 처리
							for (BadukStoneListener sListener : stoneListeners)
								sListener.stone(x, y);
						}
						
					}
				}
				
			}
		});
		
		repaint();
		
	}
	

	@Override 
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;
		
		lineCount = panSize - 1;
		width = getWidth(); 						// o 패널 넓이
		height = getHeight();						// o 패널 높이
		innerWidth = width - (panMargin * 2);		// o 바둑판 넓이 
		innerHeight = height - (panMargin * 2);		// o 바둑판 높이
	    

		lineHeight = innerHeight / lineCount;		// o 바둑판 가로라인 크기
		lineWidth = innerWidth / lineCount;			// o 바둑판 세로라인 크기
		
		if(lineHeight - lineWidth > 0) {
			mouseMatch = (int) lineWidth / 3;
		}else {
			mouseMatch = (int) lineHeight / 3;
		}
        
        // o 정사각형
		
        while (innerWidth % lineCount != 0) {
        	innerWidth = innerWidth -1;
        }

        while (innerHeight % lineCount != 0) {
        	innerHeight = innerHeight -1;
        }
        
        Color badukBackground = new Color(255, 215, 96);
        Color line = Color.BLACK;
        
        // o 배경
		g.setColor(badukBackground);
		g.fillRect(0, 0, width, height );
		
		// o 이너 테두리
		g.setColor(line);
		g.drawRect(panMargin, panMargin, innerWidth, innerHeight);
		
		
		// o 이너 판
		
		for(int i= 1; i < lineCount ;i++) {
			
			// o 가로 line
			g.drawLine(panMargin, lineHeight * i+ panMargin, innerWidth + panMargin, lineHeight * i + panMargin);
			
			// o 세로 line
			g.drawLine(lineWidth * i+ panMargin, panMargin, lineWidth * i+ panMargin, innerHeight+ panMargin);
			
			
		}
		
		// o mouse 좌표 값 저장
		for(int i= 0; i <= lineCount ;i++) {
			for(int u = 0 ;u <= lineCount;u++) {
				pan[i][u] = new Point(lineWidth * i + panMargin, lineHeight * u + panMargin);
				
			}
		}
		
		
		// o 바둑 그리기
		for(int i =0;i<stoneList.length;i++) {
			if(stoneList[i] == null) {
				break;
			}
			Stone stone = stoneList[i];
			Point stonePoint = pan[stone.getX()][stone.getY()];
			Color stoneColor;
			switch (stone.getColor()) {
			case Stone.COLOR_WHITE:
				stoneColor = Color.white;
				break;
			case Stone.COLOR_BLACK:
				stoneColor = Color.black;
				break;

			default:
				stoneColor = Color.DARK_GRAY;
				break;
			}
			
			
			g.setColor(stoneColor);
			Ellipse2D.Double circle = new Ellipse2D.Double(
					stonePoint.x -(lineWidth / 2) , stonePoint.y-(lineHeight/2), lineWidth-(lineWidth/10), lineHeight-(lineHeight/10)
					);
			 g2d.fill(circle);
		}
		

	}
	
	public void drawStone(Stone stone) throws StoneAlreadyExistsException {
		
		
		if(checkStone(stone)) {
			//printStoneList();
			throw new StoneAlreadyExistsException(stone.toString());
		}
		stoneList[stoneIndex] = stone;
		
		stoneIndex++;
		repaint();
		
	}

	
	private boolean checkStone(Stone stone) {
		for(int i =0 ;i<stoneList.length;i++) {
			if(stoneList[i] !=null)
				if(stoneList[i].getPoint().equals(stone.getPoint())) {
					return true;
				}
		}
		return false;
	}
	
	
	
	
	public void addBadukStoneListener(BadukStoneListener stoneListener) {
		stoneListeners.add(stoneListener);
    }

	public void setDebugSysout(boolean debugSysout) {
		this.debugSysout = debugSysout;
	}

	public int getPanSize() {
		return panSize;
	}

	public void setPanSize(int panSize) {
		this.panSize = panSize;
		pan = new Point[panSize][panSize];
		stoneList = new Stone[panSize*panSize];
		repaint();
	}

	public int getPanMargin() {
		return panMargin;
	}

	public void setPanMargin(int panMargin) {
		this.panMargin = panMargin;
		repaint();
	}



}
