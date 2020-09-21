public class KLists{
	public double [] mergeKLists(double [][] outerArray){
		int counter=0;
		int totalSize=0;
		for(int i=0;i<outerArray.length; i++){
			totalSize+=outerArray[i].length;
		}
		//System.out.println(totalSize);
		double [] outputArray= new double[totalSize];
		if(outputArray.length>1){
			for(int j=0; j<outerArray.length; j++){
				for(int k=0; k<outerArray[j].length; k++){
					outputArray[counter]=outerArray[j][k];
					counter++;
				}
			}
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
			outputArray[0]=outerArray[0][0];
			return outputArray;

		}else{
			return outputArray;
		}
		
	}
	public static void main(String [] args){
		KLists k= new KLists();
		double [][] arr= new double[][] {{9.7,17.1},{15.8},{12.7,18.5,21.27}};
		//double [][] arr= new double [][] {};
		//System.out.println(arr[0].length);
		double [] sorted= k.mergeKLists(arr);
		System.out.println();
		if(sorted.length==0){
			System.out.println("[]");
		}else if(sorted.length==1){
			System.out.println("[" +sorted[0]+"]");

		}else{
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