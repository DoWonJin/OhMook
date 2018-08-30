package org.wonjin.ohmook.util;
import java.util.Random;

import org.wonjin.ohmook.util.*;
import org.wonjin.ohmook.cpu.*;
import org.wonjin.ohmook.core.*;
import org.wonjin.ohmook.object.*;

public class SearchX extends SearchO { // class search_O �� ��ӹ���.

	public int search_O_five(char a[][]) // ����� ���� ������ search_O�� �Լ��� �����ε���.
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

	public Value search_X_four_1(char a[][])// �鵹 4�� �� ����
	{
		Random random = new Random();
		int b = random.nextInt() % 2;
		int n = a.length;
		Value P = new Value();
		P.res = 0;
		for (int i = 0; i <= n - 4; i++)
			for (int j = 0; j <= n - 4; j++) {
				if ((a[i][j] == 'X') && (a[i][j + 1] == 'X') && (a[i][j + 2] == 'X') && (a[i][j + 3] == 'X')
						&& (a[i][j - 1] == '_') && (a[i][j + 4] == '_')) { // �¿��
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
						&& (a[i - 1][j] == '_') && (a[i + 4][j] == '_')) { // ���Ʒ���
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
						&& (a[i + 3][j + 3] == 'X') && (a[i - 1][j - 1] == '_') && (a[i + 4][j + 4] == '_')) {// �����ʾƷ��δ밢��
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

	public Value search_X_four_2(char a[][])// �� ���� �����ִ� ���
	{
		int n = a.length;
		Value P = new Value();
		P.res = 0;
		for (int i = 0; i < n - 3; i++)
			for (int j = 0; j < n - 3; j++) {
				if ((a[i][j] == 'X') && (a[i][j + 1] == 'X') && (a[i][j + 2] == 'X') && (a[i][j + 3] == 'X')) { // �¿�
																												// ������
																												// ��������
																												// ��

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
				} else if ((a[i][j] == 'X') && (a[i + 1][j] == 'X') && (a[i + 2][j] == 'X') && (a[i + 3][j] == 'X')) { // ���Ʒ�
																														// ������
																														// ��������
																														// ��
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
						&& (a[i + 3][j + 3] == 'X')) { // �����ʾƷ��δ밢��
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

	Value compare_O_around(char a[][], int x, int y, int z, int w) { // �鵹�� ������ ��,�ĺ��� �Ǵ� ��ǥ�� 2�� �ִµ� �� ����ǥ�� �Է¹޾� �ֺ���
																		// �浹'O"�� ���� ���� ��ġ�ϵ��� �̿�����.
		Value P = new Value();
		P.res = 1;
		int cnt1 = 0, cnt2 = 0;
		for (int i = x - 1; i <= x + 1; i++)
			for (int j = y - 1; j <= y + 1; j++) {
				if ((i == x) && (j == y))
					continue;// �ڽ��� ��ǥ�� ����
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

	public Value search_X_three_1(char a[][])// �鵹 3�� �ȸ��� ������ 4���� �վ ��� ������.
	{
		int n = a.length;
		Value P = new Value();
		P.res = 0;// 4���� ã�Ҵ��� Ȯ���ϴ� ���� res �� 0���� ����.
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

	public Value search_X_three_2(char a[][])// �� ���� �����ִ� ��� XXXO , OXXX (�� ���� �ȸ��� �ִ� ���� ����ڰ� ������ ���� ���̶� �����Ͽ� ��� ���� ����)
	{
		int n = a.length;
		Value P = new Value();
		Random random = new Random();
		P.res = 0;
		for (int i = 0; i < n - 2; i++)
			for (int j = 0; j < n - 2; j++) {
				// �鵹 4���� ��ġ��(���� ��ġ�� ��� ������ ����...�Ф�)

				// �¿�� XXX
				if ((a[i][j] == 'X') && (a[i][j + 1] == 'X') && (a[i][j + 2] == 'X')) {// �¿�� XXX
					if ((a[i][j - 1] == 'O') && (a[i][j + 3] == '_')) { // OXXX �̰ų� XXXO
						
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
				// ���Ʒ��� X
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
				// �����ʾƷ��δ밢�� X
				// X
				// X
				else if ((a[i][j] == 'X') && (a[i + 1][j + 1] == 'X') && (a[i + 2][j + 2] == 'X')) {
					if ((a[i - 1][j - 1] == 'O') && (a[i + 3][j + 3] == '_')) { // ������ �����ִ� ���
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
				// ���� �Ʒ��δ밢�� X
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

	public Value search_X_three_3(char a[][])// _X_XX_ _XX_X_ �� ���
	{

		int n = a.length;
		Value P = new Value();
		P.res = 0;
		for (int i = 1; i < n - 5; i++)
			for (int j = 1; j < n - 5; j++) {
				if ((a[i][j - 1] == '_') && (a[i][j] == 'X') && (a[i][j + 1] == '_') && (a[i][j + 2] == 'X')
						&& (a[i][j + 3] == 'X') && (a[i][j + 4] == '_')) {// �¿�� _X_XX_
					P.x = i;
					P.y = j + 1;
					P.res = 1;
					System.out.println("search_X_three_3-1");
				} else if ((a[i][j - 1] == '_') && (a[i][j] == 'X') && (a[i][j + 1] == 'X') && (a[i][j + 2] == '_')
						&& (a[i][j + 3] == 'X') && (a[i][j + 4] == '_')) {// �¿�� _XX_X_
					P.x = i;
					P.y = j + 2;
					P.res = 1;
					System.out.println("search_X_three_3-2");
				} else if ((a[i - 1][j] == '_') && (a[i][j] == 'X') && (a[i + 1][j] == '_') && (a[i + 2][j] == 'X')
						&& (a[i + 3][j] == 'X') && (a[i + 4][j] == '_')) {// ���Ʒ��� _X_XX_
					P.x = i + 1;
					P.y = j;
					P.res = 1;
					System.out.println("search_X_three_3-3");
				} else if ((a[i - 1][j] == '_') && (a[i][j] == 'X') && (a[i + 1][j] == 'X') && (a[i + 2][j] == '_')
						&& (a[i + 3][j] == 'X') && (a[i + 4][j] == '_')) {// ���Ʒ��� _XX_X_
					P.x = i + 2;
					P.y = j;
					P.res = 1;
					System.out.println("search_X_three_3-4");
				} else if ((a[i - 1][j - 1] == '_') && (a[i][j] == 'X') && (a[i + 1][j + 1] == '_')
						&& (a[i + 2][j + 2] == 'X') && (a[i + 3][j + 3] == 'X') && (a[i + 4][j + 4] == '_')) {// �����ʾƷ���
																												// _X_XX_
					P.x = i + 1;
					P.y = j + 1;
					P.res = 1;
					System.out.println("search_X_three_3-5");
				} else if ((a[i - 1][j - 1] == '_') && (a[i][j] == 'X') && (a[i + 1][j + 1] == 'X')
						&& (a[i + 2][j + 2] == '_') && (a[i + 3][j + 3] == 'X') && (a[i + 4][j + 4] == '_')) {// �����ʾƷ���
																												// _XX_X_
					P.x = i + 2;
					P.y = j + 2;
					P.res = 1;
					System.out.println("search_X_three_3-6");
				} else if ((a[i - 1][j + 5] == '_') && (a[i][j + 4] == 'X') && (a[i + 1][j + 3] == '_')
						&& (a[i + 2][j + 2] == 'X') && (a[i + 3][j + 1] == 'X') && (a[i + 4][j] == '_')) {// ���ʾƷ���
																											// _X_XX_
					P.x = i + 1;
					P.y = j + 3;
					P.res = 1;
					System.out.println("search_X_three_3-7");
				} else if ((a[i - 1][j + 5] == '_') && (a[i][j + 4] == 'X') && (a[i + 1][j + 3] == 'X')
						&& (a[i + 2][j + 2] == '_') && (a[i + 3][j + 1] == 'X') && (a[i + 4][j] == '_')) {// ���ʾƷ���
																											// _XX_X_
					P.x = i + 2;
					P.y = j + 2;
					P.res = 1;
					System.out.println("search_X_three_3-8");
				}
			}
		return P;
	}

	public Value search_X_two_1(char a[][])// �� ���� ��� XX
	{
		int n = a.length;
		Value P = new Value();
		P.res = 0;
		for (int i = 0; i < n - 1; i++)
			for (int j = 0; j < n - 1; j++) {
				if ((i - 1 < 0) || (i + 2 > n - 1) || (j - 1 < 0) || (j + 2 > n - 1))
					continue; // �������
				if ((a[i - 1][j] == '_') && (a[i][j] == 'X') && (a[i][j + 1] == 'X') && (a[i][j + 2] == '_')) {
					System.out.println("search_X_two_1-1");
					return compare_O_around(a, i, j + 2, i, j - 1);// �¿�� XX
				} else if ((a[i - 1][j] == '_') && (a[i][j] == 'X') && (a[i + 1][j] == 'X') && (a[i + 2][j] == '_')) {
					System.out.println("search_X_two_1-2");
					return compare_O_around(a, i + 2, j, i - 1, j); // ���Ʒ��� XX
				} else if ((a[i - 1][j - 1] == '_') && (a[i][j] == 'X') && (a[i + 1][j + 1] == 'X')
						&& (a[i + 2][j + 2] == '_')) {
					System.out.println("search_X_two_1-3");
					return compare_O_around(a, i - 1, j - 1, i + 2, j + 2);// ������ �Ʒ���
				} else if ((a[i - 1][j + 2] == '_') && (a[i][j + 1] == 'X') && (a[i + 1][j] == 'X')
						&& (a[i + 2][j - 1] == '_')) {
					System.out.println("search_X_two_1-4");
					return compare_O_around(a, i - 1, j + 2, i + 2, j - 1);// ���� �Ʒ���
				}
				// �� �Ϸķ� ���� �ʰ� ��ġ���� ����� ���� ������. ���߿� �߰��� ��.
			}
		return P;
	}

	public Value search_X_two_2(char a[][])// �� ���� �����ִ� ��� XXO , OXX
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

				// �����ʾƷ��δ밢�� X
				// X
				else if ((a[i][j] == 'X') && (a[i + 1][j + 1] == 'X')) {
					if ((a[i - 1][j - 1] == 'O') && (a[i + 2][j + 2] == '_')) { // ������ �����ִ� ���
						
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
				// ���� �Ʒ��δ밢�� X
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

	public Value search_X_one_1(char a[][]) // X : �鵹 �Ѱ��� �ִ� ��츦 �˻�
	{
		int n = a.length;
		Value P = new Value();
		P.res = 0;
		int val = 0; // �ֺ��� X�� �ִ� �� �Ǵ��ϴ� ���� ( 0 :���� , 1:����)
		for (int i = 1; i < n - 1; i++)
			for (int j = 1; j < n - 1; j++) { // �ٵ��� ��ĵ�ϰ�
				if (a[i][j] != 'X')
					continue; // �鵹�� ��츸 ���ɻ� �� �ܴ� �����ϱ�
				else if (a[i][j] == 'X') {
					for (int k = i - 1; k < i + 2; k++) { // �鵹�� [i,j]��ġ�� �ѷ��� ��� ��ǥ�鿡 ���Ͽ� �ֺ��� �鵹�� �ִ��� Ž��
						for (int l = j - 1; l < j + 2; l++) {
							if ((a[k][l] == 'X') && (k != i) && (l != j)) {
								val = 1; // �ֺ��� �鵹�� ������ val���� 1�� ����.
							}
						}
					}
					if (val == 0) { // Ž���� ��ġ�� 1���� �������� ���� ��� **��� 1���� ���� �ִ� ���� ������ �� �� �ִµ��̤� ������ǥ�� �迭�� �����ϰ� ���
									// �迭��Ҹ� ���� �Ǵ��ؾ� �ϴµ� �Ф�;;
						P.res = 1;
						if (search_X_one_1_1sub(a, i, j).res == 1) {
							System.out.println("search_X_one_1-1");
							return search_X_one_1_1sub(a, i, j); // �鵹�� �ΰ��� �Ǹ鼭 �浹�� ������ �����ϱ�
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
		// �ܡ�
		// �� �� ��Ȳ���� �鵹�� ������ ���� ���� �ε����ϱ�
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
		// �ܡ�
		// �� �� ��Ȳ���� �鵹�� ���� ���� �ε����ϱ�
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
		// ��
		// ��
		// �� �� ��Ȳ���� �鵹�� 2ĭ �����ʿ� ���� �ε����ϱ�
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

		// ��
		// �� �� �� ��Ȳ���� �鵹�� 2ĭ ���ʿ� ���� �ε����ϱ�
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

	Value search_X_one_1_4sub(char a[][], int i, int j) { // �׿� �� ��� ����� ��
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
