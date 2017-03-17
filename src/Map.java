import java.util.Random;

public class Map {
	private Random rand=new Random();
	int[] value=new int[100];//定义一个长度为100的地图值
	//为长度为100的地图值赋值
	public void setValue(){
		int count=0;
		for(int i=0;i<5;i++){
			int a=rand.nextInt(10);//暂停
			int b=rand.nextInt(16);//地雷
			int c=rand.nextInt(20);//幸运轮盘
			int d=rand.nextInt(8);//时空隧道
			for(int j=0;j<20;j++){
				if(j==a){
					value[count]=2;
				}else if(j==b){
					value[count]=3;
				}else if(j==c){
					value[count]=4;
				}else if(j==d){
					value[count]=5;
				}else{
					value[count]=1;
				}
				count++;
			}
		}
	}
	//根据游戏情况实时显示地图对应的单个符号
	public String showSymbol(int value, int position,int posPlayer1, int posPlayer2){
		String symbol="";
		if(posPlayer1==posPlayer2){
			symbol="@";
		}else if(posPlayer1==position){
			symbol="A";
		}else if(posPlayer2==position){
			symbol="B";
		}else{
			switch(value){
			case 1:
				symbol="∷";//普通
				break;
			case 2:
				symbol="■";//暂停
				break;
			case 3:
				symbol="★";//幸运轮盘
				break;
			case 4:
				symbol="¤";//地雷
				break;
			case 5:
				symbol="〓";//时空隧道
				break;
			default:
				break;
			}
		}
		return symbol;
	}
	//根据游戏情况实时显示地图对应的行符号
	public void showLine(int begin, int end, int posPlayer1, int posPlayer2){
		for(int i=begin;i<=end;i++){
			System.out.print(showSymbol(value[i],i,posPlayer1,posPlayer2));
		}
		System.out.println();
	}
	//根据游戏情况实时显示地图对应的左排符号
	public void showLeftColumn(int begin, int end, int posPlayer1, int posPlayer2){ 
		for(int i=begin;i<=end;i++){
			System.out.println(showSymbol(value[i],i,posPlayer1,posPlayer2));
		}
	}
	//根据游戏情况实时显示地图对应的右排符号
	public void showRightColumn(int begin, int end, int posPlayer1, int posPlayer2){ 
		for(int i=begin;i<=end;i++){
			for(int j=0;j<29;j++){
				System.out.print(" ");
			}
			System.out.println(showSymbol(value[i],i,posPlayer1,posPlayer2));
		}
	}
	//根据游戏情况实时显示整个地图对应符号,最终需要的主方法，游戏运行时每次都需要显示地图
	public void showMap(int posPlayer1, int posPlayer2){
		System.out.println("图列：∷->普通\t■->暂停\t★->幸运轮盘\t¤->地雷\t〓->时空隧道");
		showLine(0, 29, posPlayer1, posPlayer2);
		showRightColumn(30, 34, posPlayer1, posPlayer2);
		showLine(35, 64, posPlayer1, posPlayer2);
		showLeftColumn(65,69, posPlayer1, posPlayer2);
		showLine(70, 99, posPlayer1, posPlayer2);
	}
}
