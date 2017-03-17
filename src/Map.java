import java.util.Random;

public class Map {
	private Random rand=new Random();
	int[] value=new int[100];//����һ������Ϊ100�ĵ�ͼֵ
	//Ϊ����Ϊ100�ĵ�ͼֵ��ֵ
	public void setValue(){
		int count=0;
		for(int i=0;i<5;i++){
			int a=rand.nextInt(10);//��ͣ
			int b=rand.nextInt(16);//����
			int c=rand.nextInt(20);//��������
			int d=rand.nextInt(8);//ʱ�����
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
	//������Ϸ���ʵʱ��ʾ��ͼ��Ӧ�ĵ�������
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
				symbol="��";//��ͨ
				break;
			case 2:
				symbol="��";//��ͣ
				break;
			case 3:
				symbol="��";//��������
				break;
			case 4:
				symbol="��";//����
				break;
			case 5:
				symbol="��";//ʱ�����
				break;
			default:
				break;
			}
		}
		return symbol;
	}
	//������Ϸ���ʵʱ��ʾ��ͼ��Ӧ���з���
	public void showLine(int begin, int end, int posPlayer1, int posPlayer2){
		for(int i=begin;i<=end;i++){
			System.out.print(showSymbol(value[i],i,posPlayer1,posPlayer2));
		}
		System.out.println();
	}
	//������Ϸ���ʵʱ��ʾ��ͼ��Ӧ�����ŷ���
	public void showLeftColumn(int begin, int end, int posPlayer1, int posPlayer2){ 
		for(int i=begin;i<=end;i++){
			System.out.println(showSymbol(value[i],i,posPlayer1,posPlayer2));
		}
	}
	//������Ϸ���ʵʱ��ʾ��ͼ��Ӧ�����ŷ���
	public void showRightColumn(int begin, int end, int posPlayer1, int posPlayer2){ 
		for(int i=begin;i<=end;i++){
			for(int j=0;j<29;j++){
				System.out.print(" ");
			}
			System.out.println(showSymbol(value[i],i,posPlayer1,posPlayer2));
		}
	}
	//������Ϸ���ʵʱ��ʾ������ͼ��Ӧ����,������Ҫ������������Ϸ����ʱÿ�ζ���Ҫ��ʾ��ͼ
	public void showMap(int posPlayer1, int posPlayer2){
		System.out.println("ͼ�У���->��ͨ\t��->��ͣ\t��->��������\t��->����\t��->ʱ�����");
		showLine(0, 29, posPlayer1, posPlayer2);
		showRightColumn(30, 34, posPlayer1, posPlayer2);
		showLine(35, 64, posPlayer1, posPlayer2);
		showLeftColumn(65,69, posPlayer1, posPlayer2);
		showLine(70, 99, posPlayer1, posPlayer2);
	}
}
