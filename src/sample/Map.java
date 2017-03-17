package sample;

public class Map {
	int[] imgLables = new int[100];// 地图图像标号

	int[] luckyTurn = { 6, 23, 40, 55, 69, 83 }; // 幸运轮盘 3

	int[] landMine = { 5, 13, 17, 33, 38, 50, 64, 80, 94 }; // 地雷位置 5

	int[] pause = { 9, 27, 60, 93 }; // 暂停 2

	int[] timeTunnel = { 20, 25, 45, 63, 72, 88, 90 }; // 时空隧道 4

	/* 创建地图 */
	public void creatMap() {
		/* 读入幸运轮盘 */
		for (int i = 0; i < luckyTurn.length; i++) {
			imgLables[luckyTurn[i]] = 3;
		}
		/* 读入地雷位置 */
		for (int i = 0; i < landMine.length; i++) {
			imgLables[landMine[i]] = 5;
		}
		/* 读入暂停 */
		for (int i = 0; i < pause.length; i++) {
			imgLables[pause[i]] = 2;
		}
		/* 读入时光隧道 */
		for (int i = 0; i < timeTunnel.length; i++) {
			imgLables[timeTunnel[i]] = 4;
		}
		/* 普通 */
		for (int i = 0; i < imgLables.length; i++) {
			if (imgLables[i] == 0) {
				imgLables[i] = 1;
			}
		}
	}

	/**
	 * 显示地图关卡对应的图形
	 * 
	 * @param i
	 *                        地图当前位置的关卡代号
	 * @param index
	 *                        当前地图位置编号
	 * @param playerPos1
	 *                        玩家1 的当前位置
	 * @param playerPos2
	 *                        玩家2 的当前位置
	 * @return 地图当前位置的图形       1代表玩家在地图上，0代表不在
	 */
	public String getGraph(int i, int index, int playerPos1, int playerPos2) {
		String graph = "";
		if (playerPos1 == index && playerPos2 == index) { // 两个玩家都位于地图当前位置index
			graph = "@@";
		} else if (playerPos1 == index) { // 玩家 1 位于地图当前位置
			graph = "Ａ";
		} else if (playerPos2 == index) { // 玩家 2 位于地图当前位置
			graph = "Ｂ";
		} else {
			switch (i) {
			// 关卡代号为1时：graph = "¤";
			// 关卡代号为2时：graph = "★";
			// 关卡代号为3时：graph = "■";
			// 关卡代号为4时：graph = "〓";
			// 其他：graph = "∷";
			case 1:
				graph = "∷";
				break;
			case 2:
				graph = "■";
				break;
			case 3:
				graph = "¤";
				break;
			case 4:
				graph = "〓";
				break;
			case 5:
				graph = "★";
				break;
			}
		}
		return graph;
	}

	public void showMap(int playerPos1, int playerPos2) {
		creatMap();
		showLine(0, 30, playerPos1, playerPos2);
		showRightColumm(31, 34, playerPos1, playerPos2);
		showMiddleLine(35, 65, playerPos1, playerPos2);
		showLeftColumm(66, 68, playerPos1, playerPos2);
		showLine(69, 99, playerPos1, playerPos2);
	}

	public void showLine(int start, int end, int playerPos1, int playerPos2) {
		for (int k = start; k <= end; k++) {
			System.out.print(getGraph(imgLables[k], k, playerPos1, playerPos2));
		}
		System.out.println();
	}

	public void showMiddleLine(int start, int end, int playerPos1, int playerPos2) {
		for (int k = end; k >= start; k--) {
			System.out.print(getGraph(imgLables[k], k, playerPos1, playerPos2));
		}
		System.out.println();
	}

	public void showRightColumm(int start, int end, int playerPos1, int playerPos2) {
		for (int c = start; c <= end; c++) {
			for (int i = 0; i <= 29; i++) {
				System.out.print("　");
			}
			System.out.print(getGraph(imgLables[c], c, playerPos1, playerPos2));
			System.out.println();
		}
	}

	public void showLeftColumm(int start, int end, int playerPos1, int playerPos2) {
		for (int c = start; c <= end; c++) {
			System.out.print(getGraph(imgLables[c], c, playerPos1, playerPos2));
			System.out.println();
		}
	}
}
