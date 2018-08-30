package org.wonjin.ohmook.cpu;
import java.util.Random;

import org.wonjin.ohmook.util.*;
import org.wonjin.ohmook.cpu.*;
import org.wonjin.ohmook.core.*;
import org.wonjin.ohmook.object.*;

public class ComputerProcess{

	public Stone black_step_1st(char a[][]) {     //컴퓨터가 흑돌일 경우 중아에 돌 착수하기
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
	public Stone white_step_1st(char a[][]) {     //사용자가 흑돌일 경우 컴퓨터의 백돌을 첫수로 착수하는 함수
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
		stone.result =0; //게임을 계속진행: 0
		SearchX Find_X = new SearchX();
		if (Find_X.search_X_four_2(a).res != 0) {     // 끝내기 ○○○○●
			Q = Find_X.search_X_four_2(a);
			System.out.println("search_X_four_2("+Q.x+","+Q.y+")");
			a[Q.x][Q.y] = 'X';
			stone.result =2;  //흑돌승리: 1 ,백돌승리: 2 , 게임을 계속진행: 0
		}
		else if (Find_X.search_X_three_1(a).res != 0) {// ○○○
			Q = Find_X.search_X_three_1(a);
			System.out.println("search_X_three_1("+Q.x+","+Q.y+")");
			a[Q.x][Q.y] = 'X';
		}
		else if (Find_X.search_X_three_3(a).res!=0) { // ○○ ○ 인경우 공백에 채워서 4개로 만들기
			Q = Find_X.search_X_three_3(a);
			System.out.println("search_X_three_3("+Q.x+","+Q.y+")");
			a[Q.x][Q.y] = 'X';
		}
		else if (Find_X.search_X_three_2(a).res != 0) {//  ○○○●
			Q = Find_X.search_X_three_2(a);
			System.out.println("search_X_three_2("+Q.x+","+Q.y+")");
			a[Q.x][Q.y] = 'X';
		}
		else if (Find_X.search_X_two_1(a).res != 0) {  // 안 막혀있는 ○○ : 무조건 3개로 잇는다.
			Q = Find_X.search_X_two_1(a);
			System.out.println("search_X_two_1("+Q.x+","+Q.y+")");
			a[Q.x][Q.y] = 'X';
		}
		else if (Find_X.search_X_two_2(a).res != 0) {  // 막혀있는 ○○
			Q = Find_X.search_X_two_2(a);		//백돌 2개 이어진 곳 찾고 3개로 잇던가 뭉치기
			System.out.println("search_X_two_2("+Q.x+","+Q.y+")");
			a[Q.x][Q.y] = 'X';
		}
		else if (Find_X.search_X_one_1(a).res != 0) {  // ○      백돌 1개 있는 곳 찾기 함수 내부에 더 많은 경우의 수를 고려해 놓음
			Q = Find_X.search_X_one_1(a);
			System.out.println("search_X_one_1("+Q.x+","+Q.y+")");
			a[Q.x][Q.y] = 'X';
		}
		else
		{
			System.out.println("attackprocess에서 공격할 경우를 못찾음.");
		}
		stone.x = Q.x;
		stone.y = Q.y;
		System.out.println("attack함수내부:");
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
		stone.color = 1; //백돌로 설정

		P.res = 0;
		if (Find_O.search_O_five(a) == 1) { //흑돌이 5개이면 종료
			stone.result = 1; //흑돌승리: 1 ,백돌승리: 2 , 게임을 계속진행: 0
			return stone;
		}
		else if (Find_X.search_X_four_1(a).res != 0) {  //백돌이 4개로 안막혀 있을 때
			P = Find_X.search_X_four_1(a);  //구조체를 두번 쓰지 않도록 구조체를 다른 구조체로 대입하는 것을 따로 알아보자;;
			a[P.x][P.y] = 'X';	//공격하기
			System.out.println("search_X_four_1("+P.x+","+P.y+")");
			stone.result = 2;
			
		}
		else if (Find_X.search_X_four_2(a).res != 0) {  //○○○○●백돌이 4개로 한 쪽 막혀있을 때
			P = Find_X.search_X_four_2(a);
			a[P.x][P.y] = 'X';	//공격하기
			System.out.println("search_X_four_2("+P.x+","+P.y+")");
			stone.result = 2;
		}
		else if (Find_O.search_O_four(a).res != 0) {// ○●●●●흑돌 4개 한쪽이 막혀있음
			P = Find_O.search_O_four(a);
			a[P.x][P.y] = 'X';
			System.out.println("search_O_four("+P.x+","+P.y+")");
			stone.result = 0;
		}
		else if(Find_X.search_X_three_3(a).res!=0) { // _○○_○_인경우 공백에 ○를 넣도록 공격하기
			return attack_process(a);
		}
		
		else if (Find_X.search_X_three_1(a).res != 0) {  // ○○○백돌이 3개 안막혀있음.
			return attack_process(a);
		}
		else if (Find_O.search_O_three_3(a).res != 0) {// ●● ●
			P = Find_O.search_O_three_3(a);
			a[P.x][P.y] = 'X';
			System.out.println("search_O_three_3("+P.x+","+P.y+")");
			stone.result = 0;
		}
		else if (Find_O.search_O_three_1(a).res != 0) {// ●●● 흑돌 3개 안막혀있음) 무조건 수비
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
		else if (Find_O.search_O_three_2(a).res != 0) {// ●●●○ (흑돌 3개 한쪽이 막혀있음)

			if (random.nextInt() % 2 == 0) {
				return attack_process(a);//다른 곳 공격
			}
			else {
				P = Find_O.search_O_three_2(a); //수비 (반대쪽 막기)
				a[P.x][P.y] = 'X';
				System.out.println("search_O_three_2("+P.x+","+P.y+")");
				stone.result = 0;
			}
		}
		else { //그 외의 경우 
			return attack_process(a);            // 그냥 공격하자   
		}
		stone.x = P.x;
		stone.y = P.y;
		System.out.println("defence함수내부:");
		System.out.println(stone.x);
		System.out.println(stone.y);
		return stone; 
		
	}
	
	
}