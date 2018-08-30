package org.wonjin.ohmook.util;


import org.wonjin.ohmook.util.*;
import org.wonjin.ohmook.cpu.*;
import org.wonjin.ohmook.core.*;
import org.wonjin.ohmook.object.*;

public class SearchO {
	public int search_O_five(char a[][]) // XXXXO
	{
		int n = a.length;
		for (int i = 0; i<n - 4; i++)
			for (int j = 0; j < n - 4; j++) {
				boolean case1 = ((a[i][j] == 'O') && (a[i][j + 1] == 'O') && (a[i][j + 2] == 'O') && (a[i][j + 3] == 'O') && (a[i][j + 4] == 'O'));
				boolean case2 = ((a[i][j] == 'O') && (a[i + 1][j] == 'O') && (a[i + 2][j] == 'O') && (a[i + 3][j] == 'O') && (a[i + 4][j] == 'O'));
				boolean case3 = ((a[i][j] == 'O') && (a[i + 1][j + 1] == 'O') && (a[i + 2][j + 2] == 'O') && (a[i + 3][j + 3] == 'O') && (a[i + 4][j + 4] == 'O'));
				boolean case4 = ((a[i][j + 4] == 'O') && (a[i + 1][j + 3] == 'O') && (a[i + 2][j + 2] == 'O') && (a[i + 3][j + 1] == 'O') && (a[i + 4][j] == 'O'));
				if (case1 == true || case2 == true || case3 == true || case4 == true) {
					System.out.println("search_O_five");
					System.out.println("User Win!!");
					return 1;
				}
			}
		return 0;
	}


	
	public Value search_O_four(char a[][]) // 흑돌 4개 한쪽 막힘
	 {
		int n = a.length;
		Value P = new Value();
		P.res = 0;//4줄을 찾았는지 확인하는 변수 res 을 0으로 세팅.
		for(int i=0; i<n-3; i++)
			for (int j = 0; j < n-3; j++) {
				if ((a[i][j] == 'O') && (a[i][j + 1] == 'O') && (a[i][j + 2] == 'O')&& (a[i][j + 3] == 'O')) {
					
					if ((a[i][j - 1] == 'X') && (a[i][j + 4] == '_')) {
						P.res = 1;
						P.x = i;
						P.y = j + 4;
						P.res = 1;
						System.out.println("search_O_four-1");
					}
					else if(((a[i][j - 1] == '_') && (a[i][j + 4] == 'X'))) {
						P.res = 1;
						P.x = i;
						P.y = j - 1;
						P.res = 1;
						System.out.println("search_O_four-2");
					}
				}
				else if ((a[i][j] == 'O') && (a[i+1][j] == 'O') && (a[i+2][j] == 'O') && (a[i+3][j] == 'O')) {
					
					if ((a[i-1][j] == 'X') && (a[i + 4][j ] == '_')) {
						P.res = 1;
						P.x = i+4;
						P.y = j;
						P.res = 1;
						System.out.println("search_O_four-3");
					}
					else if (((a[i - 1][j ] == '_') && (a[i + 4][j ] == 'X'))) {
						P.res = 1;
						P.x = i - 1;
						P.y = j;
						P.res = 1;
						System.out.println("search_O_four-4");
					}
				}
				else if ((a[i][j] == 'O') && (a[i + 1][j + 1] == 'O') && (a[i + 2][j + 2] == 'O') && (a[i + 3][j + 3] == 'O')) {//오른쪽아래로대각선
					if ((a[i - 1][j - 1] == 'X') && (a[i + 4][j + 4] == '_')) {
						P.res = 1;
						P.x = i + 4;
						P.y = j + 4;
						P.res = 1;
						System.out.println("search_O_four-5");
					}
					else if (((a[i - 1][j - 1] == '_') && (a[i + 4][j + 4] == 'X'))) {
						P.res = 1;
						P.x = i - 1;
						P.y = j - 1;
						P.res = 1;
						System.out.println("search_O_four-6");
					}
				}
				else if ((a[i][j+3] == 'O') && (a[i + 1][j + 2] == 'O') && (a[i + 2][j + 1] == 'O') && (a[i + 3][j] == 'O')) { //왼쪽 아래로 대각선
					if ((a[i - 1][j + 4] == 'X') && (a[i + 4][j - 1] == '_')) {
						P.res = 1;
						P.x = i + 4;
						P.y = j - 1;
						P.res = 1;
						System.out.println("search_O_four-7");
					}
					else if ((a[i - 1][j + 4] == '_') && (a[i + 4][j - 1] == 'X')) {
						P.res = 1;
						P.x = i - 1;
						P.y = j + 4;
						P.res = 1;
						System.out.println("search_O_four-8");
					}
				}
				else {
//					System.out.println("아무것도 못찾음");
				}
			}
		return P;
	}
	Value compare_X_around(char a[][],int x, int y, int z, int w) { //주변에 X가 많은 곳을 좌표로 리턴
		Value P = new Value();
		P.res = 1;
		int cnt1 = 0, cnt2 = 0;
		for (int i = x-1; i <= x+2 ; i++)
			for (int j = y - 1; j <= y + 2; j++)
			{
				if ((i == x) && (j == y))continue;
				if (a[i][j] == 'X')cnt1++;
			}
		for (int i = z - 1; i <= z + 2; i++)
			for (int j = w - 1; j <= w + 2; j++)
			{
				if ((i == z) && (j == w))continue;
				if (a[i][j] == 'X')cnt2++;
			}
		if (cnt1 > cnt2) {
			P.x = x;
			P.y = y;
		}
		else {
			P.x = z;
			P.y = w;
		}
		return P;
	}

	public Value search_O_three_1(char a[][])// 흑돌 3개 안막힘
	{
		int n = a.length;
		Value P = new Value();
		P.res = 0;
		for (int i = 0; i<n - 2; i++)
			for (int j = 0; j < n - 2; j++) {
				if ((a[i][j] == 'O') && (a[i][j + 1] == 'O') && (a[i][j + 2] == 'O') && (a[i][j - 1] == '_') && (a[i][j + 3] == '_')) { //좌우로
					{
						System.out.println("search_O_three_1-1");
						return  compare_X_around(a,i, j + 3, i, j - 1);
					}
				}
				else if ((a[i][j] == 'O') && (a[i + 1][j] == 'O') && (a[i + 2][j] == 'O') && (a[i - 1][j] == '_') && (a[i + 3][j] == '_')) { //위아래로 
					{
						System.out.println("search_O_three_1-2");
						return  compare_X_around(a, i + 3, j, i-1, j);
					}
				}
				else if ((a[i][j] == 'O') && (a[i + 1][j + 1] == 'O') && (a[i + 2][j + 2] == 'O') && (a[i - 1][j - 1] == '_') && (a[i + 3][j + 3] == '_')) {//오른쪽아래로대각선
					{
						System.out.println("search_O_three_1-3");
						return  compare_X_around(a, i + 3, j+3, i - 1, j-1);
					}
				}
				else if ((a[i][j+2] == 'O') && (a[i + 1][j + 1] == 'O') && (a[i + 2][j] == 'O') && (a[i - 1][j + 3] == '_') && (a[i + 3][j - 1] == '_')) {//왼쪽 아래로 대각선
					{
						System.out.println("search_O_three_1-4");
						return  compare_X_around(a, i - 1, j + 3, i + 3, j - 1);
					}
				}
			}
		return P;
	}

	public Value search_O_three_2(char a[][])//한 쪽이 막혀있는 경우
	{
		int n = a.length;
		Value P = new Value();
		P.res = 0;
		for (int i = 0; i<n - 2; i++)
			for (int j = 0; j < n - 2; j++) {
				if ((a[i][j] == 'O') && (a[i][j + 1] == 'O') && (a[i][j + 2] == 'O')) {       //좌우 한쪽이 막혀있을 떄
					if ((a[i][j - 1] == 'X') && (a[i][j + 3] == '_')) {
						P.x = i;
						P.y = j + 3;
						P.res = 1;
						System.out.println("search_O_three_2-1");
					}
					else if (((a[i][j - 1] == '_') && (a[i][j + 3] == 'X'))) {
						P.x = i;
						P.y = j - 1;
						P.res = 1;
						System.out.println("search_O_three_2-2");
					}
				}
				else if ((a[i][j] == 'O') && (a[i + 1][j] == 'O') && (a[i + 2][j] == 'O')) { //위아래 한쪽이 막혀있을 떄
					if ((a[i - 1][j] == 'X') && (a[i + 3][j] == '_')) {
						P.x = i + 3;
						P.y = j;
						P.res = 1;
						System.out.println("search_O_three_2-3");
					}
					else if (((a[i - 1][j] == '_') && (a[i + 3][j] == 'X'))) {
						P.x = i - 1;
						P.y = j;
						P.res = 1;
						System.out.println("search_O_three_2-4");
					}
				}
				else if ((a[i][j] == 'O') && (a[i + 1][j + 1] == 'O') && (a[i + 2][j + 2] == 'O')) {  //오른쪽아래로대각선
					if ((a[i - 1][j - 1] == 'X') && (a[i + 3][j + 3] == '_')) {
						P.x = i + 3;
						P.y = j + 3;
						P.res = 1;
						System.out.println("search_O_three_2-5");
					}
					else if (((a[i - 1][j - 1] == '_') && (a[i + 3][j + 3] == 'X'))) {
						P.x = i - 1;
						P.y = j - 1;
						P.res = 1;
						System.out.println("search_O_three_2-6");
					}
				}
				else if ((a[i][j+2] == 'O') && (a[i + 1][j + 1] == 'O') && (a[i + 2][j] == 'O')) { //왼쪽 아래로 대각선
					if ((a[i - 1][j + 1] == 'X') && (a[i + 3][j - 1] == '_')) {
						P.x = i + 3;
						P.y = j - 1;
						P.res = 1;
						System.out.println("search_O_three_2-7");
					}
					else if ((a[i - 1][j + 1] == '_') && (a[i + 3][j - 1] == 'X')) {
						P.x = i - 1;
						P.y = j + 1;
						P.res = 1;
						System.out.println("search_O_three_2-8");
					}
				}
			}
		return P;
	}
	public Value search_O_three_3(char a[][])// _O_OO_ _OO_O_ 인 경우
	{
		
		int n = a.length;
		Value P = new Value();
		P.res = 0;
		for (int i = 1; i < n - 5; i++)
			for (int j = 1; j < n - 5; j++) {
				if ((a[i][j-1] == '_') && (a[i][j] == 'O') && (a[i][j + 1] == '_') && (a[i][j + 2] == 'O')&& (a[i][j + 3] == 'O') && (a[i][j + 4] == '_')) {// 좌우로 _X_XX_
					P.x = i;
					P.y = j + 1;
					P.res=1;
					System.out.println("search_O_three_3-1");
				}
				else if ((a[i][j-1] == '_') && (a[i][j] == 'O') && (a[i][j + 1] == 'O') && (a[i][j + 2] == '_')&& (a[i][j + 3] == 'O') && (a[i][j + 4] == '_')) {// 좌우로 _OO_O_
					P.x = i;
					P.y = j + 2;
					P.res=1;
					System.out.println("search_O_three_3-2");
				}
				else if ((a[i-1][j] == '_') && (a[i][j] == 'O') && (a[i+ 1][j ] == '_') && (a[i+ 2][j ] == 'O')&& (a[i+ 3][j ] == 'O') && (a[i + 4][j] == '_')) {// 위아래로 _O_OO_
					P.x = i+1;
					P.y = j;
					P.res=1;
					System.out.println("search_O_three_3-3");
				}
				else if ((a[i-1][j] == '_') && (a[i][j] == 'O') && (a[i+ 1][j ] == 'O') && (a[i+ 2][j ] == '_')&& (a[i+ 3][j ] == 'O') && (a[i+ 4][j ] == '_')) {// 위아래로 _OO_O_
					P.x = i + 2;
					P.y = j;
					P.res=1;
					System.out.println("search_O_three_3-4");
				}
				else if ((a[i-1][j-1] == '_') && (a[i][j] == 'O') && (a[i+ 1][j+1] == '_') && (a[i+ 2][j+2] == 'O')&& (a[i+ 3][j+3] == 'O') && (a[i + 4][j+4] == '_')) {// 오른쪽아래로 _O_OO_
					P.x = i + 1;
					P.y = j + 1;
					P.res=1;
					System.out.println("search_O_three_3-5");
				}
				else if ((a[i-1][j-1] == '_') && (a[i][j] == 'O') && (a[i+ 1][j+1 ] == 'O') && (a[i+ 2][j+2 ] == '_')&& (a[i+ 3][j+3 ] == 'O') && (a[i+ 4][j+4 ] == '_')) {// 오른쪽아래로 _OO_O_
					P.x = i + 2;
					P.y = j + 2;
					P.res=1;
					System.out.println("search_O_three_3-6");
				}
				else if ((a[i-1][j+5] == '_') && (a[i][j+4] == 'O') && (a[i+ 1][j+3] == '_') && (a[i+ 2][j+2] == 'O')&& (a[i+ 3][j+1] == 'O') && (a[i + 4][j] == '_')) {// 왼쪽아래로 _O_OO_
					P.x = i + 1;
					P.y = j + 3;
					P.res=1;
					System.out.println("search_O_three_3-7");
				}
				else if ((a[i-1][j+5] == '_') && (a[i][j+4] == 'O') && (a[i+ 1][j+3] == 'O') && (a[i+ 2][j+2 ] == '_')&& (a[i+ 3][j+1 ] == 'O') && (a[i+ 4][j ] == '_')) {// 왼쪽아래로 _OO_O_
					P.x = i + 2;
					P.y = j + 2;
					P.res=1;
					System.out.println("search_O_three_3-8");
				}
			}
		return P;
	}
	
	
	public Value search_O_two_seperate(char a[][]) { //흑돌이 두개가 한 칸을 두고 서로 떨어져 있을 떄, 그 사이에 백돌을 두도록하기
		int n = a.length;
		Value P = new Value();
		P.res = 0;
		for (int i = 1; i <= n - 2; i++) {
			for (int j = 1; j <= n - 2; j++) {
				boolean res = (a[i - 1][j - 1] == 'O' && a[i + 1][j + 1] == 'O') || (a[i - 1][j] == 'O' && a[i + 1][j] == 'O') || (a[i - 1][j + 1] == 'O' && a[i + 1][j - 1] == 'O') || (a[i][j - 1] == 'O' && a[i][j + 1] == 'O');
				if ((a[i][j] == '_') && (res == true))
				{
					P.res = 1;
					System.out.println("search_O_two_seperate");
					P.x = i;
					P.y = j;
					return P;
				}
			}

		}
		return P;
	}
}
