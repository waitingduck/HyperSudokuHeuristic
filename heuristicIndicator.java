import java.util.Stack;

public class heuristicIndicator implements indicatorInterface{
	//create a stack to remember every step
	private Stack<Integer> stk = new Stack<Integer>();


	public int nextIndicator(int[] arr,int indicator){
		stk.push(indicator);
		int les_constrain=-1;
		int les_location=-1;
		
		int temp_constrain=-1;
		int temp_location=-1;
		
		int[][] con = new int[][] {{10,11,12,19,20,21,28,29,30},
				   				   {14,15,16,23,24,25,32,33,34},
				   				   {46,47,48,55,56,57,64,65,66},
				   				   {50,51,52,59,60,61,68,69,70}};
		
		for(int i = 0;i<81;i++)  // we want to find indicator i
		{
			if(arr[i]==0) // find the 0, it might be our indicator
			{
				temp_location=i;
				// for the normal constrain
				for(int j = 0;j<81;j++)
				{
					if(arr[j] != 0 && i !=j)
					{
						if(j/9==i/9)
						{
							temp_constrain++;
						}
						if(j%9==i%9)
						{
							temp_constrain++;
						}
						if(j/9/3==i/9/3 && j%9/3==i%9/3)
						{
							temp_constrain++;
						}
					}
				}
				//for the hyper constrain
				for(int k=0;k<4;k++)
				{
					for(int w=0;w<9;w++)
					{
						if(i==con[k][w])
						{
							for(int a=0;a<9;a++)
							{
								if((arr[con[k][a]]==arr[i] && i!=con[k][a]) && arr[con[k][a]]!=0)
								{
									temp_constrain++;
								}
							}
							
						}
					}
				}
				
				if(temp_constrain > les_constrain)
				{
					les_location = temp_location;
					les_constrain = temp_constrain;
				}
			}
			temp_constrain=-1;
			temp_location=-1;
		}
		return les_location;
	}
	public int lastIndicator(int[] arr,int indicator){
		if(stk.empty()){
			return -1;
		}
		int last_indicator = (int) stk.pop();
		
		if(last_indicator<0)
		{
			last_indicator=-1;
			return last_indicator;
		}
		arr[indicator]=0;
		while(arr[last_indicator]>=9)
		{
			if(arr[last_indicator]<209)
			{
				arr[last_indicator]=0;
			}
			if(stk.empty())
			{
				last_indicator=-1;
				return last_indicator;
			}
			else
			{
				last_indicator = (int) stk.pop();
			}
		}
		return last_indicator;
	}
}