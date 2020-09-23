public class KLists{
	public double [] mergeKLists(double [][] outerArray){
		//counter used for index of single array to copy materials from 2D array
		int counter=0;
		int totalSize=0;
		for(int i=0;i<outerArray.length; i++){
			totalSize+=outerArray[i].length;
		}
		//System.out.println(totalSize);
		double [] outputArray= new double[totalSize];

		//This check if length of array is greater than 1/ i.e. a large array
		if(outputArray.length>1){
			//the double for loop copies all parts of double array into single array
			for(int j=0; j<outerArray.length; j++){
				for(int k=0; k<outerArray[j].length; k++){
					outputArray[counter]=outerArray[j][k];
					counter++;
				}
			}
			//This for loop is an implementation of an insertion sort 
			for(int place=0; place<outputArray.length; place++){
				double temp= outputArray[place];
				int holder= place-1;
				while(holder>=0 && outputArray[holder]>temp){
					outputArray[holder+1]=outputArray[holder];
					--holder;
				}
				outputArray[holder+1]=temp;
			}
			return outputArray;
		}else if(outputArray.length==1){
			//returns the 1 item given from 2d array
			outputArray[0]=outerArray[0][0];
			return outputArray;

		}else{
			//if array is empty just return an emptya array
			return outputArray;
		}
		
	}
	public static void main(String [] args){
		KLists k= new KLists();
		double [][] arr= new double[][] {{9.7,17.1},{15.8},{12.7,18.5,21.27}};

		double [] sorted= k.mergeKLists(arr);
		System.out.println();
		//checks if array after mergeKlists has length of 0
		if(sorted.length==0){
			System.out.println("[]");
		//checks if it has a legnth of 1
		}else if(sorted.length==1){
			System.out.println("[" +sorted[0]+"]");

		}else{
			//if greater than length 1, prints in form needed by assignment
			System.out.print("[");
			for(int runner=0; runner<sorted.length; runner++){
				if(runner==sorted.length-1){
					System.out.println(sorted[runner]+"]");
				}else{
					System.out.print(sorted[runner]+", ");
				}
			}
		}
	}
}