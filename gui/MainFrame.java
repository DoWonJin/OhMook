package org.wonjin.ohmook.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.wonjin.ohmook.cpu.ComputerProcess;
import org.wonjin.ohmook.exception.StoneAlreadyExistsException;
import org.wonjin.ohmook.gui.Listener.BadukStoneListener;
import org.wonjin.ohmook.object.Stone;

public class MainFrame extends JFrame {

	
	private JPanel contentPane = new JPanel();;
	private BadukPanel badukPanel;
	private Stone currentStone;
	
	private boolean firstStone = true;
	private Stone stone;
	private int playCount = 0;

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 800, 800); //
		contentPane.setBorder(new EmptyBorder(5,5,5,5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		badukPanel = new BadukPanel(19);
		contentPane.add(badukPanel);
		//Scanner scan = new Scanner(System.in);
		int panSize;
//		System.out.printf("입력 : ");
		panSize = 19;
//		n = scan.nextInt();
		badukPanel.setPanSize(panSize);
		//scan.close();
		char ground[][] = new char[panSize][panSize];
		for (int i = 0; i < panSize; i++)
			for (int j = 0; j < panSize; j++)ground[i][j] = '_';
		ComputerProcess Comp = new ComputerProcess();
		badukPanel.addBadukStoneListener(new BadukStoneListener() {
			@Override
			public void stone(int x, int y) {
				currentStone = new Stone();
				ground[x][y] = 'O';
				currentStone.setColor(Stone.COLOR_BLACK);
				currentStone.setX(x);
				currentStone.setY(y);
				try {
					badukPanel.drawStone(currentStone);
				} catch (StoneAlreadyExistsException e) {
					JOptionPane.showMessageDialog(null,e.getMessage());
					
					e.printStackTrace();
					return;
				}
				if(firstStone) {
					try {
						badukPanel.drawStone(Comp.white_step_1st(ground));
					} catch (StoneAlreadyExistsException e) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null,"컴퓨터잘못");
						e.printStackTrace();
					}
					firstStone = false;
					playCount+=2;
					return;
				}
				stone = Comp.defence_process(ground); // 컴퓨터 착수
				try {
					badukPanel.drawStone(stone);
				} catch (StoneAlreadyExistsException e) {
					JOptionPane.showMessageDialog(null,"컴퓨터잘못");
					e.printStackTrace();
				}
				if (stone.result == 1) {
					System.out.print("결과: 승\n");
				}
				else if (stone.result == 2) {
					System.out.print("결과: 패\n");
				}
				else {
					System.out.println("계속진행");
				}
				playCount +=2;
				
				if(playCount == (panSize * panSize) ) {
					System.out.println("게임 오버");
				}
			}
		});
				
		//paintStone(currentStone);   //사용자의 흑돌 첫수를 착수
		
		try {
			Thread.sleep(2000);
		}catch(InterruptedException e) {
			
		}
		
		
		
		
	}
	

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {  //
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	

}
