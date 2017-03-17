package sample;

public class Role {
	int[] indexs = new int[2];//记录角色在地图上的位置
	boolean[] onOrPauses = new boolean[2];//记录角色是可以投骰子还是暂停
	String[] roleNames = new String[2];//记录角色名字
	int[] counts = new int[2];//记录角色投骰子的数字
	/*初始化角色*/
	public void initializ()
	{
		indexs[0]= 0;
		indexs[1]= 0;
		onOrPauses [0] = true;
		onOrPauses [1] = true;
		roleNames[0] = "";
		roleNames[1] = "";
		counts [0] = 0;
		counts [1] = 0; 
	}
	/*储存角色信息*/
	public void storeRoleInfo(int[] rindexs,boolean[] status,String[] rnames)
	{
		indexs = rindexs;
		onOrPauses = status;
		roleNames = rnames;
	}
}

