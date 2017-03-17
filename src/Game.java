import java.util.Random;
import java.util.Scanner;

public class Game {
	private Scanner scan=new Scanner(System.in);
	private Random rand=new Random();
	private String player1;//玩家1的名字
	private String player2;//玩家2的名字
	private int tossPlayer1;//玩家1掷骰子点数 1-6
	private int tossPlayer2;//玩家2掷骰子点数 1-6
	private int posPlayer1;//玩家1的位置
	private int posPlayer2;//玩家2的位置
	private boolean isPause1;//玩家1是否暂停
	private boolean isPause2;//玩家2是否暂停
	Map map=new Map();
	//设置玩家名字
	public void setPlayer(){
		System.out.println("请选择玩家：");
		System.out.println("1.戴高乐 2.艾森豪威尔 3.麦克阿瑟 4.巴顿");
tag1:		while(true){
			System.out.print("为玩家1选择角色：");
			switch(scan.nextInt()){
				case 1:{
					player1="戴高乐";
					break;
				}
				case 2:{
					player1="艾森豪威尔";
					break;
				}
				case 3:{
					player1="麦克阿瑟";
					break;
				}
				case 4:{
					player1="巴顿";
					break;
				}
				default:
					System.out.println("错误输入，请输入数字1-4");
					continue tag1;
			}
			break;
		}
		System.out.println();
tag2:		while(true){
			System.out.print("为玩家2选择角色：");
			switch(scan.nextInt()){
				case 1:{
					player2="戴高乐";
					break;
				}
				case 2:{
					player2="艾森豪威尔";
					break;
				}
				case 3:{
					player2="麦克阿瑟";
					break;
				}
				case 4:{
					player2="巴顿";
					break;
				}
				default:
					System.out.println("错误输入，请输入数字1-4");
					continue tag2;
			}
			break;
		}
		System.out.println();
		System.out.println("玩家1是"+player1+"，用A表示");
		System.out.println("玩家2是"+player2+"，用B表示");
	}
	//游戏主体包括逻辑判断和地图载入
	public void play(){
		map.setValue();
		setPlayer();
		while(true){
			if(posPlayer1==99){
				System.out.println(player1+"胜利到达终点，游戏结束");
				break;
			}else if(posPlayer2==99){
				System.out.println(player2+"胜利到达终点，游戏结束");
				break;
			}else{
				if(!isPause1){//如果玩家1不暂停且轮到玩家1掷骰子
					System.out.println(player1+",请按下任意键后回车掷骰子：");
					scan.next();
					tossPlayer1=rand.nextInt(6)+1;
					System.out.println("掷出的骰子数为："+tossPlayer1);
					posPlayer1+=tossPlayer1;
					switch(map.value[posPlayer1]){
					case 1:
						break;
					case 2:{//暂停
						System.out.println("悲剧啊，你要暂停一次");
						isPause1=true;
						}
						break;
					case 3:{//幸运轮盘
						System.out.print("幸运轮盘给你两种选择：1.和对方互换位置 2.使对方倒退6步");
						while(true){
							String choice=scan.next();
							if("1".equals(choice)){
								int temp=posPlayer1;
								posPlayer1=posPlayer2;
								posPlayer2=temp;
								break;
							}else if("2".equals(choice)){
								if(posPlayer2<6){
									posPlayer2=0;
								}else{
									posPlayer2-=6;
								}
								break;
							}else{
								System.out.println("你输入有误，请重新输入");
							}
						}
						}
						break;
					case 4:{//地雷
						System.out.println("你运气真差，踩到地雷了，倒退10步！");
						if(posPlayer1<10){
							posPlayer1=0;
						}else{
							posPlayer1-=10;
						}
						}
						break;
					case 5:{//时空隧道
						System.out.println("你运气真好，走到时光隧道，前进10步！");
						if(posPlayer1>89){
							posPlayer1=99;
						}else{
							posPlayer1+=10;
						}
						}
						break;
					default:
						break;
					}
					map.showMap(posPlayer1,posPlayer2);
				}else{//如果玩家1暂停且轮到玩家1掷骰子
					isPause1=false;
				}
				
				if(!isPause2){//如果玩家2不暂停且轮到玩家2掷骰子
					System.out.println(player2+",请按下任意键后回车掷骰子：");
					scan.next();
					tossPlayer2=rand.nextInt(6)+1;
					System.out.println("掷出的骰子数为："+tossPlayer2);
					posPlayer2+=tossPlayer2;
					switch(map.value[posPlayer2]){
					case 1:
						break;
					case 2:{//暂停
						System.out.println("悲剧啊，你要暂停一次");
						isPause2=true;
						}
						break;
					case 3:{//幸运轮盘
						System.out.print("幸运轮盘给你两种选择：1.和对方互换位置 2.使对方倒退6步");
						while(true){
							String choice=scan.next();
							if("1".equals(choice)){
								int temp=posPlayer2;
								posPlayer2=posPlayer1;
								posPlayer1=temp;
								break;
							}else if("2".equals(choice)){
								if(posPlayer1<6){
									posPlayer1=0;
								}else{
									posPlayer1-=6;
								}
								break;
							}else{
								System.out.println("你输入有误，请重新输入");
							}
						}
						}
						break;
					case 4:{//地雷
						System.out.println("你运气真差，踩到地雷了，倒退10步！");
						if(posPlayer2<10){
							posPlayer2=0;
						}else{
							posPlayer2-=10;
						}
						}
						break;
					case 5:{//时空隧道
						System.out.println("你运气真好，走到时光隧道，前进10步！");
						if(posPlayer2>89){
							posPlayer2=99;
						}else{
							posPlayer2+=10;
						}
						}
						break;
					default:
						break;
					}
					map.showMap(posPlayer1,posPlayer2);
				}else {//如果玩家2暂停且轮到玩家2掷骰子
					isPause2=false;
				}
			}
		}
	}
}
