import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.ArrayList;

public class HyperSudokuHeuristic {
	public static int count=0;
	public static void main(String[] args)
	{
		
		Scanner inputStream = null;
		//read the input file
		try{
			inputStream = new Scanner(new FileInputStream(args[0]));
		}
		catch(FileNotFoundException e){
			System.out.println("File was not found!");
		}
		
		//construct sudoku board base on the input
		int[] arr = new int[81];
		String temp=" ";
		
		for(int i=0 ; i<81 ; i++){
			temp = inputStream.next();
			if(temp.equals("-")){
				arr[i]=0;
			}
			else{
				//mark the original exist field with number over 20. Of course it can be other integer over 10.
				arr[i]=Integer.parseInt(temp)+20;
			}
		}
		
		//close inputstream
		inputStream.close();
		
		// your can use different indicator to implement indicatorInterface
		//heuristic indicator
		indicatorInterface indicatorSelector = new heuristicIndicator();
		//normal indicatr
		//indicatorInterface indicatorSelector = new normalIndicator();
		
		
		//get the indicator(the filed we need to fill)
		int indicator = -1;
		indicator=indicatorSelector.nextIndicator(arr, indicator);
		arr[indicator]=1;
		
		while(true){
			//if the current board is fine fill the next filed.
			if(constrainCehck(arr,indicator)){
				//indicatorSelector.stkPush(indicator);
				indicator=indicatorSelector.nextIndicator(arr, indicator);
				if(indicator==-1)
		 		{
		 			break;
		 		}
		 		arr[indicator]++;
				count++;
		 	}
		 	//otherwise go back the last step
		 	else{
		 		if(arr[indicator]<9){
		 			arr[indicator]++;
					count++;
		 		}
		 		else{
					indicator=indicatorSelector.lastIndicator(arr, indicator);
					if(indicator==-1){
							break;
					}
					arr[indicator]++;
					count++;
		 		}
		 	}
		 }
			
		//print out result and time
		for(int i=0 ; i<81 ; i++){
			if(i%9==0){
				System.out.println("");
			}
			if(arr[i]>20){
				arr[i]=arr[i]-20;
			}
			System.out.print(arr[i]);
			System.out.print(" ");
			
		}
		System.out.println("It expands " + count + " nodes.");

		//output to txt file
		PrintWriter outputStream = null;
		try{
			outputStream = new PrintWriter(new FileOutputStream(args[1]));
		}
		catch(FileNotFoundException e){
			System.out.println("Error opening file the output");
			System.exit(0);
		}
		
		for(int i=0 ; i<81 ; i++){
			if(i%9==0){
				outputStream.println("");
			}
			if(arr[i]>20){
				arr[i]=arr[i]-20;
			}
			outputStream.print(arr[i]);
			outputStream.print(" ");
		}
		outputStream.close();		
	}

	//inport different for the sudoku game
	private static boolean constrainCehck(int[] arr, int indicator){
		ArrayList<sudokuConstrainInterface> constrains = new ArrayList<sudokuConstrainInterface>();
		constrains.add(new normalSudokuConstrain());
		constrains.add(new hyperSudokuConstrain());
		//check if all the constrain is satisfied
		boolean result = true;
		for(sudokuConstrainInterface c:constrains){
			result &= c.check_constrain(arr,indicator);
		}

		return result;
	}
}
