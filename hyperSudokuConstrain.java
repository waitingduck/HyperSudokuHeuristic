public class hyperSudokuConstrain implements sudokuConstrainInterface{
	private static int[][] con = new int[][] {{10,11,12,19,20,21,28,29,30},
								   {14,15,16,23,24,25,32,33,34},
								   {46,47,48,55,56,57,64,65,66},
								   {50,51,52,59,60,61,68,69,70}};

	public boolean check_constrain(int[] arr, int indicator){
		boolean r = false;
		boolean nohave = true;
		for(int i=0;i<4;i++)
		{
			for(int j=0;j<9;j++)
			{
				if(indicator == con[i][j])
				{
					nohave=false;
					//System.out.println("hyper check! indicator:" + indicator);
					r = check_hyperconstrain(arr,indicator,i);
					return r|nohave;
				}
			}
		}
		
		
		return r|nohave;
	}

	//chech the hyper 9*9 board
	private static boolean check_hyperconstrain(int[] arr, int indicator, int group) 
	{
		boolean r = true;
		
		for(int i=0;i<9;i++)
		{
			if((arr[indicator]==arr[con[group][i]]-20 || arr[indicator]==arr[con[group][i]]) && indicator != con[group][i])
			{
				r=false;
				//System.out.println("hyper fail! indicator:" + indicator +"  con[group][i]=" + con[group][i] + " and its value is " + arr[con[group][i]] +"  arr[incidator]=" + arr[indicator]);
				return r;
			}
		}
		return r;
	}
}