package sample;

import java.util.Scanner;

public class Game {
	Map map = new Map();
	Role role = new Role();

	/* 初始化游戏 */
	public void initialize() {
		role.initializ();
	}

	/* 游戏登陆界面 */
	public void beganInterface() {
		System.out.println("※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※");
		System.out.println("//                                                       //\t");
		System.out.println("//                                                       //\t");
		System.out.println("//                      骑士飞行棋                          //\t");
		System.out.println("//                                                       //\t");
		System.out.println("//                                                       //\t");
		System.out.println("※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※※\n\n\n");
		System.out.println("……………………………………………………………………两 人 对 战……………………………………………………………………");
		Scanner input = new Scanner(System.in);
		System.out.println("请选择角色：1.戴高乐 2.艾神豪威尔 3.麦克阿瑟 4.巴顿");
		System.out.print("请选玩家1的角色：");
		int one = input.nextInt();
		boolean isSame = true;
		System.out.println();
		int two;
		do {
			System.out.print("请选玩家2的角色：");
			two = input.nextInt();
			if (two == one) {
				System.out.println("玩家已存在，请重新选择！");
				isSame = false;
			} else {
				isSame = true;
			}
		} while (!isSame);
		switch (one) {
		case 1:
			role.roleNames[0] = "戴高乐";
			break;
		case 2:
			role.roleNames[0] = "艾神豪威尔";
			break;
		case 3:
			role.roleNames[0] = "麦克阿瑟";
			break;
		case 4:
			role.roleNames[0] = "巴顿";
			break;
		}
		switch (two) {
		case 1:
			role.roleNames[1] = "戴高乐";
			break;
		case 2:
			role.roleNames[1] = "艾神豪威尔";
			break;
		case 3:
			role.roleNames[1] = "麦克阿瑟";
			break;
		case 4:
			role.roleNames[1] = "巴顿";
			break;
		}
	}

	/* 开始游戏 */
	public void playGame() {
		System.out.println("*******************************************************************\n");
		System.out.println("　　　　　　　　　　　　　　　　　　　　　GAME　START　　　　　　　　　　　　　　　　　　　　  \n");
		System.out.println("*******************************************************************\n\n");
		System.out.println("☆" + role.roleNames[0] + "的士兵：A");
		System.out.println("☆" + role.roleNames[1] + "的士兵：B");
		System.out.println("\n\n");
		System.out.println("图列：∷.普通 ¤.地雷 〓.时空隧道 ■.暂停 ★.幸运轮盘\n\n");
		map.showMap(0, 0);
	}

	/* 开始游戏 */
	public void playing() {
		boolean isTurnOne = true;// 记录谁抛骰子
		do {
			if (role.indexs[0] < 99 && role.indexs[1] < 99) {
				do {
					if (isTurnOne && role.onOrPauses[0]) {
						setDice(0);
						isTurnOne = false;
						role.onOrPauses[1] = true;
					} else if (!isTurnOne && role.onOrPauses[1]) {
						setDice(1);
						isTurnOne = true;
						role.onOrPauses[1] = true;
					} else if (isTurnOne && !role.onOrPauses[0]) {
						setDice(1);
						isTurnOne = true;
						role.onOrPauses[0] = true;
					} else if (isTurnOne && !role.onOrPauses[1]) {
						setDice(0);
						isTurnOne = false;
						role.onOrPauses[1] = true;
					}
				} while (isTurnOne);
			} else if (role.indexs[0] >= 99 && role.indexs[1] <= 99) {
				System.out.println(role.roleNames[0] + "到达终点，获得胜利，游戏结束！");
				break;
			} else if (role.indexs[1] >= 99 && role.indexs[0] <= 99) {
				System.out.println(role.roleNames[1] + "到达终点，获得胜利，游戏结束！");
				break;
			} else {
				System.out.print(role.indexs[0] + " " + role.roleNames[1] + "你们都到达终点，游戏结束！");
				break;
			}
		} while (true);
	}

	/* 投骰子后判断位置 */
	public void setDice(int i) {
		System.out.print(role.roleNames[i] + "请输入任意字母后回车启动：");
		Scanner input = new Scanner(System.in);
		String sc = input.next();
		System.out.println("\n\n");
		if (sc != null) {
			role.counts[i] =(int)(Math.random()*10+1);
			role.indexs[i] += role.counts[i];
			System.out.println("骰子数：" + role.counts[i] + "\n\n");
			switch (role.indexs[i]) {
			case 9:
			case 27:
			case 60:
			case 93:
				System.out.println("悲剧啊，你要暂停一次");
				role.onOrPauses[i] = false;
				break;
			case 6:
			case 23:
			case 40:
			case 55:
			case 69:
			case 83:
				boolean isRight = true;
				do {
					System.out.print("你运气真好，给你两种选择：1.和对方骑兵交换位置 2.轰炸对方骑兵，对方骑兵被炸退6步:");
					String num = input.next();
					if (num.equals("1")) {
						int temp = role.indexs[i];
						role.indexs[i] = role.indexs[1 - i];
						role.indexs[1 - i] = temp;
						isRight = true;
					} else if (num.equals("2")) {
						if (role.indexs[1 - i] >= 6) {
							role.indexs[1 - i] = role.indexs[1 - i] - 6;
						} else {
							role.indexs[1 - i] = 0;
						}
						isRight = true;
					} else {
						System.out.println("输入错误请重新输入！");
						isRight = false;
					}
				} while (!isRight);
				break;
			case 20:
			case 25:
			case 45:
			case 63:
			case 72:
			case 88:
			case 90:
				role.counts[i] += 10;
				System.out.println("运气真好，碰到时光隧道了！");
				break;
			case 5:
			case 13:
			case 17:
			case 33:
			case 50:
			case 64:
			case 80:
			case 94:
				if (role.indexs[i] >= 6) {
					role.indexs[i] -= 6;
				} else {
					role.indexs[i] = 0;
				}
				System.out.println("运气真差，踩到地雷了！");
				break;
			default:
				if (role.indexs[i] == role.indexs[1 - i]) {
					System.out.println("哈哈，踩到了！");
					role.indexs[i] = role.indexs[1 - i];
					role.indexs[1 - i] = 0;
				}
				break;
			}
			System.out.println("--------------------------------------------------------");
			System.out.println(role.roleNames[i] + "的当前位置：" + role.indexs[i]);
			System.out.println("对方的当前位置：" + role.indexs[1 - i]);
			map.showMap(role.indexs[i], role.indexs[1 - i]);
		}
	}
}