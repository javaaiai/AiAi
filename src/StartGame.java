
public class StartGame {

	public static void main(String[] args) {
		//欢迎界面，显示标题
		for(int i=0;i<30;i++){
			System.out.print('※');
		}
		System.out.println();
		
		System.out.print('※');
		for(int i=0;i<105;i++){
			System.out.print(' ');
		}
		System.out.print('※');
		System.out.println();
		
		System.out.print('※');
		for(int i=0;i<74;i++){
			System.out.print(' ');
			if(i==37){
			System.out.print("骑   士   飞   行   棋");	
			}
		}
		System.out.print('※');
		System.out.println();
		
		System.out.print('※');
		for(int i=0;i<105;i++){
			System.out.print(' ');
		}
		System.out.print('※');
		System.out.println();
		
		for(int i=0;i<30;i++){
			System.out.print('※');
		}
		System.out.println();
		//开始游戏
		Game game=new Game();
		game.play();
	}

}
