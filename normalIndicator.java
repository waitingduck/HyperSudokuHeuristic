public class normalIndicator implements indicatorInterface{
	public int nextIndicator(int[] arr,int indicator){
		int next_indicator = indicator+1;
		
		if(next_indicator>80)
		{
			next_indicator=-1;
			return next_indicator;
		}
		
		while(arr[next_indicator]!=0)
		{
			next_indicator++;
			if(next_indicator>80)
			{
				next_indicator=-1;
				return next_indicator;
			}
			
		}
		return next_indicator;
	}
	public int lastIndicator(int[] arr,int indicator){
		int last_indicator = indicator-1;
		if(last_indicator<0)
		{
			last_indicator=-1;
			return last_indicator;
		}
		arr[indicator]=0;
		while(arr[last_indicator]>=9)
		{
			if(arr[last_indicator]<20)
			{
				arr[last_indicator]=0;
			}
			last_indicator--;
			if(last_indicator<0)
			{
				last_indicator=-1;
				return last_indicator;
			}
		}
		return last_indicator;
	}
}