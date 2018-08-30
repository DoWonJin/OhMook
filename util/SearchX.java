package org.wonjin.ohmook.util;
import java.util.Random;

import org.wonjin.ohmook.util.*;
import org.wonjin.ohmook.cpu.*;
import org.wonjin.ohmook.core.*;
import org.wonjin.ohmook.object.*;

public class SearchX extends SearchO { // class search_O 를 상속받음.

	public int search_O_five(char a[][]) // 사용할 일은 없지만 search_O의 함수를 오버로딩함.
	{
		int n = a.length;
		for (int i = 0; i < n - 4; i++)
			for (int j = 0; j < n - 4; j++) {
				boolean case1 = ((a[i][j] == 'X') && (a[i][j + 1] == 'X') && (a[i][j + 2] == 'X')
						&& (a[i][j + 3] == 'X') && (a[i][j + 4] == 'X'));
				boolean case2 = ((a[i][j] == 'X') && (a[i + 1][j] == 'X') && (a[i + 2][j] == 'X')
						&& (a[i + 3][j] == 'X') && (a[i + 4][j] == 'X'));
				boolean case3 = ((a[i][j] == 'X') && (a[i + 1][j + 1] == 'X') && (a[i + 2][j + 2] == 'X')
						&& (a[i + 3][j + 3] == 'X') && (a[i + 4][j + 4] == 'X'));
				boolean case4 = ((a[i][j + 4] == 'X') && (a[i + 1][j + 3] == 'X') && (a[i + 2][j + 2] == 'X')
						&& (a[i + 3][j + 1] == 'X') && (a[i + 4][j] == 'X'));
				if (case1 == true || case2 == true || case3 == true || case4 == true) {
					System.out.println("search_O_five");
					return 2;
				}
			}
		return 0;
	}

	int search_X_five(char a[][]) // XXXXX
	{
		int n = a.length;
		for (int i = 0; i <= n - 5; i++)
			for (int j = 0; j <= n - 5; j++) {
				if ((a[i][j] == 'X') && (a[i][j + 1] == 'X') && (a[i][j + 2] == 'X') && (a[i][j + 3] == 'X')
						&& (a[i][j + 4] == 'X')) {
					System.out.println("search_X_five");
					return 1;
				}

				else if ((a[i][j] == 'X') && (a[i + 1][j] == 'X') && (a[i + 2][j] == 'X') && (a[i + 3][j] == 'X')
						&& (a[i + 4][j] == 'X')) {
					System.out.println("search_X_five");
					return 1;
				} else if ((a[i][j] == 'X') && (a[i + 1][j + 1] == 'X') && (a[i + 2][j + 2] == 'X')
						&& (a[i + 3][j + 3] == 'X') && (a[i + 4][j + 4] == 'X')) {
					System.out.println("search_X_five");
					return 1;
				} else if ((a[i][j + 4] == 'X') && (a[i + 1][j + 3] == 'X') && (a[i + 2][j + 2] == 'X')
						&& (a[i + 3][j + 1] == 'X') && (a[i + 4][j] == 'X')) {
					System.out.println("search_X_five");
					return 1;
				}
			}
		return 0;
	}

	public Value search_X_four_1(char a[][])// 백돌 4개 안 막힘
	{
		Random random = new Random();
		int b = random.nextInt() % 2;
		int n = a.length;
		Value P = new Value();
		P.res = 0;
		for (int i = 0; i <= n - 4; i++)
			for (int j = 0; j <= n - 4; j++) {
				if ((a[i][j] == 'X') && (a[i][j + 1] == 'X') && (a[i][j + 2] == 'X') && (a[i][j + 3] == 'X')
						&& (a[i][j - 1] == '_') && (a[i][j + 4] == '_')) { // 좌우로
					P.res = 1;
					System.out.println("search_X_four_1-1");
					if (b == 0) {
						P.x = i;
						P.y = j - 1;
					} else {
						P.x = i;
						P.y = j + 4;
					}
				} else if ((a[i][j] == 'X') && (a[i + 1][j] == 'X') && (a[i + 2][j] == 'X') && (a[i + 3][j] == 'X')
						&& (a[i - 1][j] == '_') && (a[i + 4][j] == '_')) { // 위아래로
					P.res = 1;
					System.out.println("search_X_four_1-2");
					if (b == 0) {
						P.x = i - 1;
						P.y = j;
					} else {
						P.x = i + 4;
						P.y = j;
					}
				} else if ((a[i][j] == 'X') && (a[i + 1][j + 1] == 'X') && (a[i + 2][j + 2] == 'X')
						&& (a[i + 3][j + 3] == 'X') && (a[i - 1][j - 1] == '_') && (a[i + 4][j + 4] == '_')) {// 오른쪽아래로대각선
					P.res = 1;
					System.out.println("search_X_four_1-3");
					if (b == 0) {
						P.x = i - 1;
						P.y = j - 1;
					} else {
						P.x = i + 4;
						P.y = j + 4;
					}
				} else if ((a[i][j + 2] == 'X') && (a[i + 1][j + 1] == 'X') && (a[i + 2][j] == 'X')
						&& (a[i + 3][j - 1] == 'X') && (a[i - 1][j + 3] == '_') && (a[i + 4][j - 2] == '_')) {
					P.res = 1;
					System.out.println("search_X_four_1-4");
					if (b == 0) {
						P.x = i - 1;
						P.y = j + 3;
					} else {
						P.x = i + 4;
						P.y = j - 2;
					}
				}
			}
		return P;
	}

	public Value search_X_four_2(char a[][])// 한 쪽이 막혀있는 경우
	{
		int n = a.length;
		Value P = new Value();
		P.res = 0;
		for (int i = 0; i < n - 3; i++)
			for (int j = 0; j < n - 3; j++) {
				if ((a[i][j] == 'X') && (a[i][j + 1] == 'X') && (a[i][j + 2] == 'X') && (a[i][j + 3] == 'X')) { // 좌우
																												// 한쪽이
																												// 막혀있을
																												// 떄

					if ((a[i][j - 1] == 'O') && (a[i][j + 4] == '_')) {
						P.res = 1;
						System.out.println("search_X_four_2-1");
						P.x = i;
						P.y = j + 4;

					} else if (((a[i][j - 1] == '_') && (a[i][j + 4] == 'O'))) {
						P.res = 1;
						System.out.println("search_X_four_2-2");
						P.x = i;
						P.y = j - 1;
					}
				} else if ((a[i][j] == 'X') && (a[i + 1][j] == 'X') && (a[i + 2][j] == 'X') && (a[i + 3][j] == 'X')) { // 위아래
																														// 한쪽이
																														// 막혀있을
																														// 떄
					if ((a[i - 1][j] == 'O') && (a[i + 4][j] == '_')) {
						System.out.println("search_X_four_2-3");
						P.x = i + 4;
						P.y = j;
						P.res = 1;
					} else if (((a[i - 1][j] == '_') && (a[i + 4][j] == 'O'))) {
						System.out.println("search_X_four_2-4");
						P.x = i - 1;
						P.y = j;
						P.res = 1;
					}
				} else if ((a[i][j] == 'X') && (a[i + 1][j + 1] == 'X') && (a[i + 2][j + 2] == 'X')
						&& (a[i + 3][j + 3] == 'X')) { // 오른쪽아래로대각선
					if ((a[i - 1][j - 1] == 'O') && (a[i + 4][j + 4] == '_')) {
						P.x = i + 4;
						P.y = j + 4;
						P.res = 1;
						System.out.println("search_X_four_2-5");
					} else if (((a[i - 1][j - 1] == '_') && (a[i + 4][j + 4] == 'O'))) {
						P.x = i - 1;
						P.y = j - 1;
						P.res = 1;
						System.out.println("search_X_four_2-6");
					}
				} else if ((a[i][j + 2] == 'X') && (a[i + 1][j + 1] == 'X') && (a[i + 2][j] == 'X')
						&& (a[i + 3][j - 1] == 'X')) {
					if ((a[i - 1][j + 3] == 'O') && (a[i + 4][j - 2] == '_')) {
						P.x = i + 4;
						P.y = j - 2;
						P.res = 1;
						System.out.println("search_X_four_2-7");
					} else if ((a[i - 1][j + 3] == '_') && (a[i + 4][j - 2] == 'O')) {
						P.x = i - 1;
						P.y = j + 3;
						P.res = 1;
						System.out.println("search_X_four_2-8");
					}
				}
			}
		return P;
	}

	Value compare_O_around(char a[][], int x, int y, int z, int w) { // 백돌이 공격할 떄,후보가 되는 좌표가 2곳 있는데 이 두좌표를 입력받아 주변에
																		// 흑돌'O"가 많은 곳에 배치하도록 이용하자.
		Value P = new Value();
		P.res = 1;
		int cnt1 = 0, cnt2 = 0;
		for (int i = x - 1; i <= x + 1; i++)
			for (int j = y - 1; j <= y + 1; j++) {
				if ((i == x) && (j == y))
					continue;// 자신의 좌표는 제외
				if (a[i][j] == 'O')
					cnt1++;
			}
		for (int i = z - 1; i <= z + 1; i++)
			for (int j = w - 1; j <= w + 1; j++) {
				if ((i == z) && (j == w))
					continue;
				if (a[i][j] == 'O')
					cnt2++;
			}
		if (cnt1 > cnt2) {
			P.x = x;
			P.y = y;
		} else if (cnt1 < cnt2) {
			P.x = z;
			P.y = w;
		} else {//
			int cnt3 = 0, cnt4 = 0;
			for (int i = x - 2; i <= x + 2; i++)
				for (int j = y - 2; j <= y + 2; j++) {
					if ((i == x) && (j == y))
						continue;
					if (a[i][j] == 'O')
						cnt3++;
				}
			for (int i = z - 2; i <= z + 2; i++)
				for (int j = w - 2; j <= w + 2; j++) {
					if ((i == z) && (j == w))
						continue;
					if (a[i][j] == 'O')
						cnt4++;
				}
			if (cnt3 > cnt4) {
				P.x = x;
				P.y = y;
			} else {
				P.x = z;
				P.y = w;
			}
		}
		return P;
	}

	public Value search_X_three_1(char a[][])// 백돌 3개 안막혀 무조건 4개로 잇어서 경기 끝내기.
	{
		int n = a.length;
		Value P = new Value();
		P.res = 0;// 4줄을 찾았는지 확인하는 변수 res 을 0으로 세팅.
		for (int i = 0; i < n - 2; i++)
			for (int j = 0; j < n - 2; j++) {
				if ((a[i][j] == 'X') && (a[i][j + 1] == 'X') && (a[i][j + 2] == 'X') && (a[i][j - 1] == '_')
						&& (a[i][j + 3] == '_')) {
					System.out.println("search_X_three_1-1");
					return compare_O_around(a, i, j + 3, i, j - 1);
				} else if ((a[i][j] == 'X') && (a[i + 1][j] == 'X') && (a[i + 2][j] == 'X') && (a[i - 1][j] == '_')
						&& (a[i + 3][j] == '_')) {
					System.out.println("search_X_three_1-2");
					return compare_O_around(a, i - 1, j, i + 3, j);
				} else if ((a[i][j] == 'X') && (a[i + 1][j + 1] == 'X') && (a[i + 2][j + 2] == 'X')
						&& (a[i - 1][j - 1] == '_') && (a[i + 3][j + 3] == '_')) {
					System.out.println("search_X_three_1-3");
					return compare_O_around(a, i - 1, j - 1, i + 3, j + 3);
				} else if ((a[i][j + 2] == 'X') && (a[i + 1][j + 1] == 'X') && (a[i + 2][j] == 'X')
						&& (a[i - 1][j + 3] == '_') && (a[i + 3][j - 1] == '_')) {
					System.out.println("search_X_three_1-4");
					return compare_O_around(a, i - 1, j + 3, i + 3, j - 1);
				}
			}
		return P;
	}

	public Value search_X_three_2(char a[][])// 한 쪽이 막혀있는 경우 XXXO , OXXX (양 쪽이 안막혀 있는 경우는 사용자가 무조건 막을 것이라 간주하여 고려 하지 않음)
	{
		int n = a.length;
		Value P = new Value();
		Random random = new Random();
		P.res = 0;
		for (int i = 0; i < n - 2; i++)
			for (int j = 0; j < n - 2; j++) {
				// 백돌 4개로 뭉치기(놓는 위치의 경우 굉장히 많음...ㅠㅠ)

				// 좌우로 XXX
				if ((a[i][j] == 'X') && (a[i][j + 1] == 'X') && (a[i][j + 2] == 'X')) {// 좌우로 XXX
					if ((a[i][j - 1] == 'O') && (a[i][j + 3] == '_')) { // OXXX 이거나 XXXO
						
						System.out.println("search_X_three_2_1");
							if (a[i - 1][j] == '_') {
								P.x = i - 1;
								P.y = j;
								P.res = 1;
							}
							else if (a[i - 1][j + 1] == '_') {
								P.x = i - 1;
								P.y = j + 1;
								P.res = 1;
							}
							else if (a[i - 1][j + 2] == '_') {
								P.x = i + 1;
								P.y = j - 1;
								P.res = 1;
							}
							else if (a[i][j + 3] == '_') {
								P.x = i;
								P.y = j + 3;
								P.res = 1;
							}
							else if (a[i + 1][j] == '_') {
								P.x = i + 1;
								P.y = j;
								P.res = 1;
							}
							else if (a[i + 1][j + 1] == '_') {
								P.x = i + 1;
								P.y = j + 1;
								P.res = 1;
							}
							else if (a[i + 1][j + 2] == '_') {
								P.x = i + 1;
								P.y = j + 2;
								P.res = 1;
							}
						
					} else if ((a[i][j - 1] == '_') && (a[i][j + 3] == 'O')) {
						
						System.out.println("search_X_three_2-2");
							if (a[i - 1][j] == '_') {
								P.x = i - 1;
								P.y = j;
							}
							else if (a[i - 1][j + 1] == '_') {
								P.x = i - 1;
								P.y = j + 1;
								P.res = 1;
							}
							else if (a[i - 1][j + 2] == '_') {
								P.x = i + 1;
								P.y = j - 1;
								P.res = 1;
							}
							else if (a[i][j + 3] == '_') {
								P.x = i;
								P.y = j + 3;
								P.res = 1;
							}
							else if (a[i + 1][j] == '_') {
								P.x = i + 1;
								P.y = j;
								P.res = 1;
							}
							else if (a[i + 1][j + 1] == '_') {
								P.x = i + 1;
								P.y = j + 1;
								P.res = 1;
							}
							else if (a[i][j - 1] == '_') {
								P.x = i;
								P.y = j - 1;
								P.res = 1;
							}
						
					}
				}
				// 위아래로 X
				// X
				// X
				else if ((a[i][j] == 'X') && (a[i + 1][j] == 'X') && (a[i + 2][j] == 'X')) {
					if ((a[i - 1][j] == 'O') && (a[i + 3][j] == '_')) {
						System.out.println("search_X_three_2-3");
							if (a[i][j - 1] == '_') {
								P.x = i;
								P.y = j - 1;
								P.res = 1;
							}
							else if (a[i][j + 1] == '_') {
								P.x = i;
								P.y = j + 1;
								P.res = 1;
							}
							else if (a[i + 1][j - 1] == '_') {
								P.x = i + 1;
								P.y = j - 1;
								P.res = 1;
							}
							else if (a[i + 1][j + 1] == '_') {
								P.x = i + 1;
								P.y = j + 1;
								P.res = 1;
							}
							else if (a[i + 2][j - 1] == '_') {
								P.x = i + 2;
								P.y = j - 1;
								P.res = 1;
							}
							else if (a[i + 2][j + 1] == '_') {
								P.x = i + 2;
								P.y = j + 1;
								P.res = 1;
							}
							else if (a[i - 1][j + 1] == '_') {
								P.x = i - 1;
								P.y = j + 1;
								P.res = 1;
							}
						}
					 
				else if ((a[i - 1][j] == '_') && (a[i + 3][j] == 'O')) {
						System.out.println("search_X_three_2-4");
							if (a[i][j - 1] == '_') {
								P.x = i;
								P.y = j - 1;
								P.res = 1;
							}
							else if (a[i][j + 1] == '_') {
								P.x = i;
								P.y = j + 1;
								P.res = 1;
							}
							else if (a[i + 1][j - 1] == '_') {
								P.x = i + 1;
								P.y = j - 1;
								P.res = 1;
							}
							else if (a[i + 1][j + 1] == '_') {
								P.x = i + 1;
								P.y = j + 1;
								P.res = 1;
							}
							else if (a[i + 2][j - 1] == '_') {
								P.x = i + 2;
								P.y = j - 1;
								P.res = 1;
							}
							else if (a[i + 2][j + 1] == '_') {
								P.x = i + 2;
								P.y = j + 1;
								P.res = 1;
							}
							else if (a[i + 3][j] == '_') {
								P.x = i + 3;
								P.y = j;
								P.res = 1;
							}
						
					
				}
				}
				// 오른쪽아래로대각선 X
				// X
				// X
				else if ((a[i][j] == 'X') && (a[i + 1][j + 1] == 'X') && (a[i + 2][j + 2] == 'X')) {
					if ((a[i - 1][j - 1] == 'O') && (a[i + 3][j + 3] == '_')) { // 한쪽이 막혀있는 경우
						P.res = 1;
						System.out.println("search_X_three_2-5");
							if (a[i][j + 2] == '_') {
								P.x = i;
								P.y = j + 2;
								P.res = 1;
							}
							else if (a[i + 1][j + 2] == '_') {
								P.x = i + 1;
								P.y = j + 2;
								P.res = 1;
							}
							else if (a[i + 2][j] == '_') {
								P.x = i + 2;
								P.y = j;
								P.res = 1;
							}
							else if (a[i + 2][j + 1] == '_') {
								P.x = i + 2;
								P.y = j + 1;
								P.res = 1;
							}
							else if (a[i + 3][j + 3] == '_') {
								P.x = i + 3;
								P.y = j + 3;
								P.res = 1;
							}

						
					} else if ((a[i - 1][j - 1] == '_') && (a[i + 3][j + 3] == 'O')) {
						
						System.out.println("search_X_three_2-6");
							if (a[i][j + 2] == '_') {
								P.x = i;
								P.y = j + 2;
								P.res = 1;
							}
							else if (a[i][j + 1] == '_') {
								P.x = i;
								P.y = j + 1;
								P.res = 1;
							}
							else if (a[i + 2][j] == '_') {
								P.x = i + 2;
								P.y = j;
								P.res = 1;
							}
							else if (a[i + 1][j] == '_') {
								P.x = i + 1;
								P.y = j;
								P.res = 1;
							}
							else if (a[i - 1][j - 1] == '_') {
								P.x = i - 1;
								P.y = j - 1;
								P.res = 1;
							}

						
					}
				}
				// 왼쪽 아래로대각선 X
				// X
				// X
				else if ((a[i][j + 2] == 'X') && (a[i + 1][j + 1] == 'X') && (a[i + 2][j] == 'X')) {
					if ((a[i - 1][j + 1] == 'O') && (a[i + 3][j - 1] == '_')) {
						P.res = 1;
						System.out.println("search_X_three_2-7");
							if (a[i][j - 2] == '_') {
								P.x = i;
								P.y = j - 2;
								P.res = 1;
							}
							else if (a[i + 1][j - 2] == '_') {
								P.x = i + 1;
								P.y = j - 2;
								P.res = 1;
							}
							else if (a[i + 2][j - 1] == '_') {
								P.x = i + 2;
								P.y = j - 1;
								P.res = 1;							}
							else if (a[i + 2][j] == '_') {
								P.x = i + 2;
								P.y = j;
								P.res = 1;							}
							else if (a[i + 3][j - 3] == '_') {
								P.x = i + 3;
								P.y = j - 3;
								P.res = 1;							}

					} else if ((a[i - 1][j + 3] == '_') && (a[i + 3][j - 1] == 'O')) {
						System.out.println("search_X_three_2-8");
							if (a[i][j] == '_') {
								P.x = i;
								P.y = j;
								P.res = 1;
								System.out.println("search_X_three_2-8-1");
								P.res = 1; 							}
							else if (a[i + 2][j + 2] == '_') {
								P.x = i + 2;
								P.y = j + 2;
								P.res = 1;
								System.out.println("search_X_three_2-8-2");
								P.res = 1;
							}
					}

				}
			}
		return P;
	}

	public Value search_X_three_3(char a[][])// _X_XX_ _XX_X_ 인 경우
	{

		int n = a.length;
		Value P = new Value();
		P.res = 0;
		for (int i = 1; i < n - 5; i++)
			for (int j = 1; j < n - 5; j++) {
				if ((a[i][j - 1] == '_') && (a[i][j] == 'X') && (a[i][j + 1] == '_') && (a[i][j + 2] == 'X')
						&& (a[i][j + 3] == 'X') && (a[i][j + 4] == '_')) {// 좌우로 _X_XX_
					P.x = i;
					P.y = j + 1;
					P.res = 1;
					System.out.println("search_X_three_3-1");
				} else if ((a[i][j - 1] == '_') && (a[i][j] == 'X') && (a[i][j + 1] == 'X') && (a[i][j + 2] == '_')
						&& (a[i][j + 3] == 'X') && (a[i][j + 4] == '_')) {// 좌우로 _XX_X_
					P.x = i;
					P.y = j + 2;
					P.res = 1;
					System.out.println("search_X_three_3-2");
				} else if ((a[i - 1][j] == '_') && (a[i][j] == 'X') && (a[i + 1][j] == '_') && (a[i + 2][j] == 'X')
						&& (a[i + 3][j] == 'X') && (a[i + 4][j] == '_')) {// 위아래로 _X_XX_
					P.x = i + 1;
					P.y = j;
					P.res = 1;
					System.out.println("search_X_three_3-3");
				} else if ((a[i - 1][j] == '_') && (a[i][j] == 'X') && (a[i + 1][j] == 'X') && (a[i + 2][j] == '_')
						&& (a[i + 3][j] == 'X') && (a[i + 4][j] == '_')) {// 위아래로 _XX_X_
					P.x = i + 2;
					P.y = j;
					P.res = 1;
					System.out.println("search_X_three_3-4");
				} else if ((a[i - 1][j - 1] == '_') && (a[i][j] == 'X') && (a[i + 1][j + 1] == '_')
						&& (a[i + 2][j + 2] == 'X') && (a[i + 3][j + 3] == 'X') && (a[i + 4][j + 4] == '_')) {// 오른쪽아래로
																												// _X_XX_
					P.x = i + 1;
					P.y = j + 1;
					P.res = 1;
					System.out.println("search_X_three_3-5");
				} else if ((a[i - 1][j - 1] == '_') && (a[i][j] == 'X') && (a[i + 1][j + 1] == 'X')
						&& (a[i + 2][j + 2] == '_') && (a[i + 3][j + 3] == 'X') && (a[i + 4][j + 4] == '_')) {// 오른쪽아래로
																												// _XX_X_
					P.x = i + 2;
					P.y = j + 2;
					P.res = 1;
					System.out.println("search_X_three_3-6");
				} else if ((a[i - 1][j + 5] == '_') && (a[i][j + 4] == 'X') && (a[i + 1][j + 3] == '_')
						&& (a[i + 2][j + 2] == 'X') && (a[i + 3][j + 1] == 'X') && (a[i + 4][j] == '_')) {// 왼쪽아래로
																											// _X_XX_
					P.x = i + 1;
					P.y = j + 3;
					P.res = 1;
					System.out.println("search_X_three_3-7");
				} else if ((a[i - 1][j + 5] == '_') && (a[i][j + 4] == 'X') && (a[i + 1][j + 3] == 'X')
						&& (a[i + 2][j + 2] == '_') && (a[i + 3][j + 1] == 'X') && (a[i + 4][j] == '_')) {// 왼쪽아래로
																											// _XX_X_
					P.x = i + 2;
					P.y = j + 2;
					P.res = 1;
					System.out.println("search_X_three_3-8");
				}
			}
		return P;
	}

	public Value search_X_two_1(char a[][])// 안 막힌 경우 XX
	{
		int n = a.length;
		Value P = new Value();
		P.res = 0;
		for (int i = 0; i < n - 1; i++)
			for (int j = 0; j < n - 1; j++) {
				if ((i - 1 < 0) || (i + 2 > n - 1) || (j - 1 < 0) || (j + 2 > n - 1))
					continue; // 경계조건
				if ((a[i - 1][j] == '_') && (a[i][j] == 'X') && (a[i][j + 1] == 'X') && (a[i][j + 2] == '_')) {
					System.out.println("search_X_two_1-1");
					return compare_O_around(a, i, j + 2, i, j - 1);// 좌우로 XX
				} else if ((a[i - 1][j] == '_') && (a[i][j] == 'X') && (a[i + 1][j] == 'X') && (a[i + 2][j] == '_')) {
					System.out.println("search_X_two_1-2");
					return compare_O_around(a, i + 2, j, i - 1, j); // 위아래로 XX
				} else if ((a[i - 1][j - 1] == '_') && (a[i][j] == 'X') && (a[i + 1][j + 1] == 'X')
						&& (a[i + 2][j + 2] == '_')) {
					System.out.println("search_X_two_1-3");
					return compare_O_around(a, i - 1, j - 1, i + 2, j + 2);// 오른쪽 아래로
				} else if ((a[i - 1][j + 2] == '_') && (a[i][j + 1] == 'X') && (a[i + 1][j] == 'X')
						&& (a[i + 2][j - 1] == '_')) {
					System.out.println("search_X_two_1-4");
					return compare_O_around(a, i - 1, j + 2, i + 2, j - 1);// 왼쪽 아래로
				}
				// 돌 일렬로 하지 않고 뭉치기의 경우의 수도 가능함. 나중에 추가할 것.
			}
		return P;
	}

	public Value search_X_two_2(char a[][])// 한 쪽이 막혀있는 경우 XXO , OXX
	{
		int n = a.length;
		Value P = new Value();
		Random random = new Random();
		for (int i = 0; i < n - 1; i++)
			for (int j = 0; j < n - 1; j++) {
				if ((a[i][j] == 'X') && (a[i][j + 1] == 'X')) { 
					if (((a[i][j - 1] == 'O') && (a[i][j + 2] == '_'))) { // OXX_ 
						P.res = 1;
						System.out.println("search_X_two_2_1");
						if (a[i][j + 2] == '_') {
							P.x = i;
							P.y = j + 2;
							P.res = 1;
						}
						else if (a[i + 1][j] == '_') {
							P.x = i + 1;
							P.y = j;
							P.res = 1;
							}	
						else if (a[i - 1][j - 1] == '_')
						{
							P.x = i - 1;
							P.y = j - 1;
							P.res = 1;
							}
						else if (a[i - 1][j] == '_') {
								P.x = i - 1;
								P.y = j;
								P.res = 1;
							}
						else if (a[i + 1][j - 1] == '_') {
								P.x = i + 1;
								P.y = j - 1;
								P.res = 1;
							}
					} 
					else if ((a[i][j - 1] == '_') && (a[i][j + 2] == 'O')) { // _XXO
						P.res = 1;
						System.out.println("search_X_two_2_2");
							if (a[i][j - 1] == '_') {
								P.x = i;
								P.y = j - 1;
								P.res = 1;
							}
							else if (a[i - 1][j + 1] == '_') {
								P.x = i - 1;
								P.y = j + 1;
								P.res = 1;
							}
							else if (a[i - 1][j + 2] == '_') {
								P.x = i - 1;
								P.y = j + 2;
								P.res = 1;
							}
							else if (a[i + 1][j + 1] == '_') {
								P.x = i + 1;
								P.y = j + 1;
								P.res = 1;
							}
							else if (a[i + 1][j + 2] == '_') {
								P.x = i + 1;
								P.y = j + 2;
								P.res = 1;
							}
							
						}

					}
				else if ((a[i][j] == 'X') && (a[i + 1][j] == 'X')) {
					if ((a[i - 1][j] == 'O') && (a[i + 2][j] == '_')) {
						System.out.println("search_X_two_2_3");
						if (a[i + 2][j] == '_') {
							P.x = i + 2;
							P.y = j;
							P.res = 1;
						}	
						else if (a[i - 1][j - 1] == '_') {
								P.x = i - 1;
								P.y = j - 1;
								P.res = 1;
							}
						else if (a[i - 1][j + 1] == '_') {
								P.x = i - 1;
								P.y = j + 1;
								P.res = 1;
							}
						else if (a[i][j - 1] == '_') {
								P.x = i;
								P.y = j - 1;
								P.res = 1;
							}
						else if (a[i][j + 1] == '_') {
								P.x = i;
								P.y = j + 1;
								P.res = 1;
							}
							
					} 
					else if (((a[i - 1][j] == '_') && (a[i + 2][j] == 'O'))) {
						P.res = 1;
						System.out.println("search_X_two_2_4");
							if (a[i + 1][j - 1] == '_') {
								P.x = i + 1;
								P.y = j - 1;
								P.res = 1;
							}
							else if (a[i + 1][j + 1] == '_') {
								P.x = i + 1;
								P.y = j + 1;
								P.res = 1;
							}
							else if (a[i + 2][j - 1] == '_') {
								P.x = i;
								P.y = j - 1;
								P.res = 1;
							}
							else if (a[i + 2][j + 1] == '_') {
								P.x = i;
								P.y = j + 1;
								P.res = 1;
							}
							else if (a[i - 1][j] == '_') {
								P.x = i - 1;
								P.y = j;
								P.res = 1;
							}
						}
				}

				// 오른쪽아래로대각선 X
				// X
				else if ((a[i][j] == 'X') && (a[i + 1][j + 1] == 'X')) {
					if ((a[i - 1][j - 1] == 'O') && (a[i + 2][j + 2] == '_')) { // 한쪽이 막혀있는 경우
						
						System.out.println("search_X_two_2_5");
							if (a[i - 1][j + 1] == '_') {
								P.x = i - 1;
								P.y = j + 1;
								P.res = 1;
							}
							else if (a[i + 1][j - 1] == '_') {
								P.x = i + 1;
								P.y = j - 1;
								P.res = 1;
							}
							else if (a[i + 2][j + 2] == '_') {
								P.x = i + 2;
								P.y = j + 2;
								P.res = 1;
							}
						}
					 
					else if (((a[i - 1][j - 1] == '_') && (a[i + 2][j + 2] == 'O'))) {
						P.res = 1;
						System.out.println("search_X_two_2_6");
							if (a[i - 1][j - 1] == '_') {
								P.x = i - 1;
								P.y = j - 1;
								P.res = 1;
							}
							else if (a[i][j + 2] == '_') {
								P.x = i;
								P.y = j + 2;
								P.res = 1;
							}
							else if (a[i + 2][j] == '_') {
								P.x = i + 2;
								P.y = j;
								P.res = 1;
							}
						}
				}
				// 왼쪽 아래로대각선 X
				// X
				else if ((a[i][j + 1] == 'X') && (a[i + 1][j] == 'X')) {
					if (((a[i - 1][j + 2] == 'O') && (a[i + 2][j - 1] == '_'))) {
						P.res = 1;
						System.out.println("search_X_two_2_7");
							if (a[i - 1][j] == '_') {
								P.x = i - 1;
								P.y = j;
								P.res = 1;
							}
							else if (a[i + 1][j + 2] == '_') {
								P.x = i + 1;
								P.y = j + 2;
								P.res = 1;
							}
							else if (a[i + 2][j - 1] == '_') {
								P.x = i + 2;
								P.y = j - 1;
								P.res = 1;
							}
						}
					else if ((a[i - 1][j + 2] == '_') && (a[i + 2][j - 1] == 'O')) {
						P.res = 1;
						System.out.println("search_X_two_2_8");
							if (a[i - 1][j] == '_') {
								P.x = i - 1;
								P.y = j;
								P.res = 1;
							}
							else if (a[i + 1][j + 2] == '_') {
								P.x = i + 1;
								P.y = j + 2;
								P.res = 1;
							}
							else if (a[i - 1][j + 2] == '_') {
								P.x = i - 1;
								P.y = j + 2;
								P.res = 1;
							}
						}
				} 
			}

	

	return P;}

	public Value search_X_one_1(char a[][]) // X : 백돌 한개만 있는 경우를 검색
	{
		int n = a.length;
		Value P = new Value();
		P.res = 0;
		int val = 0; // 주변에 X가 있는 지 판단하는 변수 ( 0 :없음 , 1:있음)
		for (int i = 1; i < n - 1; i++)
			for (int j = 1; j < n - 1; j++) { // 바둑판 스캔하고
				if (a[i][j] != 'X')
					continue; // 백돌일 경우만 관심사 그 외는 제외하기
				else if (a[i][j] == 'X') {
					for (int k = i - 1; k < i + 2; k++) { // 백돌의 [i,j]위치를 둘러싼 모든 좌표들에 대하여 주변에 백돌이 있는지 탐색
						for (int l = j - 1; l < j + 2; l++) {
							if ((a[k][l] == 'X') && (k != i) && (l != j)) {
								val = 1; // 주변에 백돌이 있으면 val값을 1로 설정.
							}
						}
					}
					if (val == 0) { // 탐색을 거치고 1개만 놓여있을 때의 경우 **사실 1개만 놓여 있는 곳은 여러개 일 수 있는데ㅜㅜ 여러좌표를 배열에 저장하고 어느
									// 배열요소를 쓸지 판단해야 하는데 ㅠㅠ;;
						P.res = 1;
						if (search_X_one_1_1sub(a, i, j).res == 1) {
							System.out.println("search_X_one_1-1");
							return search_X_one_1_1sub(a, i, j); // 백돌은 두개가 되면서 흑돌의 진행을 방해하기
						} else if (search_X_one_1_2sub(a, i, j).res == 1) {
							System.out.println("search_X_one_1-2");
							return search_X_one_1_2sub(a, i, j);
						}

						else if (search_X_one_1_3sub(a, i, j).res == 1) {
							System.out.println("search_X_one_1-3");
							return search_X_one_1_3sub(a, i, j);
						}

						else {
							System.out.println("search_X_one_1-4");
							return search_X_one_1_4sub(a, i, j);
						}
					}
				}
			}
		return P;
	}

	Value search_X_one_1_1sub(char a[][], int i, int j) {
		Value S = new Value();
		S.res = 0;
		// ●●
		// ○ 인 상황에서 백돌이 오른쪽 위로 돌을 두도록하기
		//
		if ((((a[i - 1][j - 1] == 'O') && (a[i - 1][j] == 'O')) || ((a[i][j + 1] == 'O') && (a[i + 1][j + 1] == 'O')))
				&& a[i - 1][j + 1] == '_') {
			S.res = 1;
			S.x = i - 1;
			S.y = j + 1;
		} else if ((((a[i - 1][j] == 'O') && (a[i - 1][j + 1] == 'O'))
				|| ((a[i][j - 1] == 'O') && (a[i + 1][j - 1] == 'O'))) && a[i - 1][j - 1] == '_') {
			S.res = 1;
			S.x = i - 1;
			S.y = j - 1;
		} else if ((((a[i - 1][j + 1] == 'O') && (a[i][j + 1] == 'O'))
				|| ((a[i + 1][j - 1] == 'O') && (a[i + 1][j] == 'O'))) && a[i + 1][j + 1] == '_') {
			S.res = 1;
			S.x = i + 1;
			S.y = j + 1;
		} else if ((((a[i - 1][j - 1] == 'O') && (a[i][j - 1] == 'O'))
				|| (a[i + 1][j] == 'O') && (a[i + 1][j + 1] == 'O')) && a[i + 1][j - 1] == '_') {
			S.res = 1;
			S.x = i + 1;
			S.y = j - 1;
		}
		return S;
	}

	Value search_X_one_1_2sub(char a[][], int i, int j) {
		Value S = new Value();
		S.res = 0;
		// ●●
		// ○ 인 상황에서 백돌이 위에 돌을 두도록하기
		//
		if ((((a[i - 1][j - 2] == 'O') && (a[i - 1][j - 1] == 'O'))
				|| ((a[i - 1][j + 1] == 'O') && (a[i - 1][j + 2] == 'O'))) && a[i - 1][j] == '_') {
			S.res = 1;
			S.x = i - 1;
			S.y = j;
		} else if ((((a[i + 1][j - 2] == 'O') && (a[i + 1][j - 1] == 'O'))
				|| ((a[i + 1][j + 1] == 'O') && (a[i + 1][j + 2] == 'O'))) && a[i + 1][j] == '_') {
			S.res = 1;
			S.x = i + 1;
			S.y = j;
		} else if ((((a[i - 2][j - 1] == 'O') && (a[i - 1][j - 1] == 'O'))
				|| ((a[i + 2][j - 1] == 'O') && (a[i + 1][j - 1] == 'O'))) && a[i][j - 1] == '_') {
			S.res = 1;
			S.x = i;
			S.y = j - 1;
		} else if ((((a[i - 2][j + 1] == 'O') && (a[i - 1][j + 1] == 'O'))
				|| ((a[i + 2][j + 1] == 'O') && (a[i + 1][j + 1] == 'O'))) && a[i][j + 1] == '_') {
			S.res = 1;
			S.x = i;
			S.y = j + 1;
		}
		return S;
	}

	Value search_X_one_1_3sub(char a[][], int i, int j) {
		Value S = new Value();
		S.res = 0;
		// ●
		// ●
		// ○ 인 상황에서 백돌이 2칸 오른쪽에 돌을 두도록하기
		//
		if (a[i - 2][j] == 'O' && a[i - 1][j + 1] == 'O' && a[i][j + 2] == '_') {
			S.res = 1;
			S.x = i;
			S.y = j + 2;
		} else if (a[i - 2][j] == 'O' && a[i - 1][j - 1] == 'O' && a[i][j - 2] == '_') {
			S.res = 1;
			S.x = i;
			S.y = j - 2;
		} else if (a[i + 2][j] == 'O' && a[i + 1][j - 1] == 'O' && a[i][j - 2] == '_') {
			S.res = 1;
			S.x = i;
			S.y = j - 2;
		} else if (a[i + 2][j] == 'O' && a[i + 1][j + 1] == 'O' && a[i][j + 2] == '_') {
			S.res = 1;
			S.x = i;
			S.y = j + 2;
		}

		// ●
		// ○ ● 인 상황에서 백돌이 2칸 위쪽에 돌을 두도록하기
		//
		if (a[i - 1][j + 1] == 'O' && a[i][j + 2] == 'O' && a[i - 2][j] == '_') {
			S.res = 1;
			S.x = i - 2;
			S.y = j;
		} else if (a[i + 1][j + 1] == 'O' && a[i][j + 2] == 'O' && a[i + 2][j] == '_') {
			S.res = 1;
			S.x = i + 2;
			S.y = j;
		} else if (a[i + 1][j - 1] == 'O' && a[i][j - 2] == 'O' && a[i + 2][j] == '_') {
			S.res = 1;
			S.x = i + 2;
			S.y = j;
		} else if (a[i - 1][j - 1] == 'O' && a[i][j - 2] == 'O' && a[i - 2][j] == '_') {
			S.res = 1;
			S.x = i - 2;
			S.y = j;
		}
		return S;
	}

	Value search_X_one_1_4sub(char a[][], int i, int j) { // 그외 의 모든 경우의 수
		Value S = new Value();
		S.res = 0;
			if (a[i - 1][j - 1] == '_') {
				S.res = 1;
				S.x = i - 1;
				S.y = j - 1;
			}
			else if (a[i - 1][j] == '_') {
				S.res = 1;
				S.x = i - 1;
				S.y = j;
			}
			else if (a[i - 1][j + 1] == '_') {
				S.res = 1;
				S.x = i - 1;
				S.y = j + 1;
			}
			else if (a[i][j - 1] == '_') {
				S.res = 1;
				S.x = i;
				S.y = j - 1;
			}
			else if (a[i][j + 1] == '_') {
				S.res = 1;
				S.x = i;
				S.y = j + 1;
			}
			else if (a[i + 1][j - 1] == '_') {
				S.res = 1;
				S.x = i + 1;
				S.y = j - 1;
			}
			else if (a[i + 1][j] == '_') {
				S.res = 1;
				S.x = i + 1;
				S.y = j;
			}
			else if (a[i + 1][j + 1] == '_') {
				S.res = 1;
				S.x = i + 1;
				S.y = j + 1;
			}
		
		return S;
	}

}
