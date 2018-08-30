package org.wonjin.ohmook.cpu;
import java.util.Random;

import org.wonjin.ohmook.util.*;
import org.wonjin.ohmook.cpu.*;
import org.wonjin.ohmook.core.*;
import org.wonjin.ohmook.object.*;

public class ComputerProcess{

	public Stone black_step_1st(char a[][]) {     //��ǻ�Ͱ� �浹�� ��� �߾ƿ� �� �����ϱ�
		int n = a.length;
		int x,y;
		Stone stone = new Stone();

		x = (int)n/2;
		y = (int)n/2;
		a[x][y]='X';
		stone.x = x;
		stone.y = y;
		stone.color = 2;
		return stone;
		
	}
	public Stone white_step_1st(char a[][]) {     //����ڰ� �浹�� ��� ��ǻ���� �鵹�� ù���� �����ϴ� �Լ�
		int n = a.length;
		int b;
		Stone stone = new Stone();
		stone.color = 1;
		Random random = new Random();
		//srand(time(NULL));
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (a[i][j] == 'O') {
					b = random.nextInt() % 8;
					switch (b)
					{
					case 1:
						a[i - 1][j - 1] = 'X';
						stone.x = i-1;
						stone.y = j-1;
						break;
					case 2:
						a[i - 1][j] = 'X';
						stone.x = i-1;
						stone.y = j;
						break;
					case 3:
						a[i - 1][j + 1] = 'X';
						stone.x = i-1;
						stone.y = j+1;
						break;
					case 4:
						a[i - 1][j] = 'X';
						stone.x = i-1;
						stone.y = j;
						break;
					case 5:
						a[i - 1][j + 1] = 'X';
						stone.x = i-1;
						stone.y = j+1;
						break;
					case 6:
						a[i + 1][j - 1] = 'X';
						stone.x = i+1;
						stone.y = j-1;
						break;
					case 7:
						a[i + 1][j] = 'X';
						stone.x = i+1;
						stone.y = j;
						break;
					default:
						a[i + 1][j + 1] = 'X';
						stone.x = i+1;
						stone.y = j+1;
						break;
					}
				}
			}
		}
		return stone;

	}
	public Stone attack_process(char a[][]) {
		System.out.println("attack_process");
		Value Q = new Value();
		Stone stone = new Stone();
		stone.color = 1;
		stone.result =0; //������ �������: 0
		SearchX Find_X = new SearchX();
		if (Find_X.search_X_four_2(a).res != 0) {     // ������ �ۡۡۡۡ�
			Q = Find_X.search_X_four_2(a);
			System.out.println("search_X_four_2("+Q.x+","+Q.y+")");
			a[Q.x][Q.y] = 'X';
			stone.result =2;  //�浹�¸�: 1 ,�鵹�¸�: 2 , ������ �������: 0
		}
		else if (Find_X.search_X_three_1(a).res != 0) {// �ۡۡ�
			Q = Find_X.search_X_three_1(a);
			System.out.println("search_X_three_1("+Q.x+","+Q.y+")");
			a[Q.x][Q.y] = 'X';
		}
		else if (Find_X.search_X_three_3(a).res!=0) { // �ۡ� �� �ΰ�� ���鿡 ä���� 4���� �����
			Q = Find_X.search_X_three_3(a);
			System.out.println("search_X_three_3("+Q.x+","+Q.y+")");
			a[Q.x][Q.y] = 'X';
		}
		else if (Find_X.search_X_three_2(a).res != 0) {//  �ۡۡۡ�
			Q = Find_X.search_X_three_2(a);
			System.out.println("search_X_three_2("+Q.x+","+Q.y+")");
			a[Q.x][Q.y] = 'X';
		}
		else if (Find_X.search_X_two_1(a).res != 0) {  // �� �����ִ� �ۡ� : ������ 3���� �մ´�.
			Q = Find_X.search_X_two_1(a);
			System.out.println("search_X_two_1("+Q.x+","+Q.y+")");
			a[Q.x][Q.y] = 'X';
		}
		else if (Find_X.search_X_two_2(a).res != 0) {  // �����ִ� �ۡ�
			Q = Find_X.search_X_two_2(a);		//�鵹 2�� �̾��� �� ã�� 3���� �մ��� ��ġ��
			System.out.println("search_X_two_2("+Q.x+","+Q.y+")");
			a[Q.x][Q.y] = 'X';
		}
		else if (Find_X.search_X_one_1(a).res != 0) {  // ��      �鵹 1�� �ִ� �� ã�� �Լ� ���ο� �� ���� ����� ���� ����� ����
			Q = Find_X.search_X_one_1(a);
			System.out.println("search_X_one_1("+Q.x+","+Q.y+")");
			a[Q.x][Q.y] = 'X';
		}
		else
		{
			System.out.println("attackprocess���� ������ ��츦 ��ã��.");
		}
		stone.x = Q.x;
		stone.y = Q.y;
		System.out.println("attack�Լ�����:");
		System.out.println(stone.x);
		System.out.println(stone.y);
		return stone;
			
		
	}
	public Stone defence_process(char a[][]) {
		System.out.println("defence_process");
		Value P = new Value();
		SearchO Find_O = new SearchO();
		SearchX Find_X = new SearchX();
		Random random = new Random();
		Stone stone = new Stone();
		stone.color = 1; //�鵹�� ����

		P.res = 0;
		if (Find_O.search_O_five(a) == 1) { //�浹�� 5���̸� ����
			stone.result = 1; //�浹�¸�: 1 ,�鵹�¸�: 2 , ������ �������: 0
			return stone;
		}
		else if (Find_X.search_X_four_1(a).res != 0) {  //�鵹�� 4���� �ȸ��� ���� ��
			P = Find_X.search_X_four_1(a);  //����ü�� �ι� ���� �ʵ��� ����ü�� �ٸ� ����ü�� �����ϴ� ���� ���� �˾ƺ���;;
			a[P.x][P.y] = 'X';	//�����ϱ�
			System.out.println("search_X_four_1("+P.x+","+P.y+")");
			stone.result = 2;
			
		}
		else if (Find_X.search_X_four_2(a).res != 0) {  //�ܹۡۡۡۡ鵹�� 4���� �� �� �������� ��
			P = Find_X.search_X_four_2(a);
			a[P.x][P.y] = 'X';	//�����ϱ�
			System.out.println("search_X_four_2("+P.x+","+P.y+")");
			stone.result = 2;
		}
		else if (Find_O.search_O_four(a).res != 0) {// �ۡܡܡܡ��浹 4�� ������ ��������
			P = Find_O.search_O_four(a);
			a[P.x][P.y] = 'X';
			System.out.println("search_O_four("+P.x+","+P.y+")");
			stone.result = 0;
		}
		else if(Find_X.search_X_three_3(a).res!=0) { // _�ۡ�_��_�ΰ�� ���鿡 �۸� �ֵ��� �����ϱ�
			return attack_process(a);
		}
		
		else if (Find_X.search_X_three_1(a).res != 0) {  // �ۡۡ۹鵹�� 3�� �ȸ�������.
			return attack_process(a);
		}
		else if (Find_O.search_O_three_3(a).res != 0) {// �ܡ� ��
			P = Find_O.search_O_three_3(a);
			a[P.x][P.y] = 'X';
			System.out.println("search_O_three_3("+P.x+","+P.y+")");
			stone.result = 0;
		}
		else if (Find_O.search_O_three_1(a).res != 0) {// �ܡܡ� �浹 3�� �ȸ�������) ������ ����
			P = Find_O.search_O_three_1(a);
			a[P.x][P.y] = 'X';
			System.out.println("search_O_three_1("+P.x+","+P.y+")");
			stone.result = 0;
		}
		else if (Find_O.search_O_two_seperate(a).res != 0){
			P = Find_O.search_O_two_seperate(a); 
			a[P.x][P.y] = 'X';
			System.out.println("search_O_two_seperate("+P.x+","+P.y+")");
			stone.result = 0;
		}
		else if (Find_O.search_O_three_2(a).res != 0) {// �ܡܡܡ� (�浹 3�� ������ ��������)

			if (random.nextInt() % 2 == 0) {
				return attack_process(a);//�ٸ� �� ����
			}
			else {
				P = Find_O.search_O_three_2(a); //���� (�ݴ��� ����)
				a[P.x][P.y] = 'X';
				System.out.println("search_O_three_2("+P.x+","+P.y+")");
				stone.result = 0;
			}
		}
		else { //�� ���� ��� 
			return attack_process(a);            // �׳� ��������   
		}
		stone.x = P.x;
		stone.y = P.y;
		System.out.println("defence�Լ�����:");
		System.out.println(stone.x);
		System.out.println(stone.y);
		return stone; 
		
	}
	
	
}