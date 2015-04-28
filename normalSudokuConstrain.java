public class normalSudokuConstrain implements sudokuConstrainInterface{
	public boolean check_constrain(int[] arr, int indicator){
		int row = indicator/9;
		int col = indicator%9;
		boolean r = false;
		
		for(int i=0;i<81;i++)
		{
			if(((i/9==row || i%9==col) || (i/9/3==row/3 && i%9/3==col/3)) && (i != indicator))
			{
				if(arr[i]-20==arr[indicator] || arr[i]==arr[indicator])
				{
					//System.out.println("check constrain fail! indicator:" + indicator + "  i=" + i +"  arr[i]=" + arr[i] + "  arr[incidator]=" + arr[indicator]);
					r=false;
					return r;
				}
			}
		}
		//System.out.println("TRUE! indicator:" + indicator +   "  arr[incidator]=" + arr[indicator]);
		r = true;
		return r;
	}
}