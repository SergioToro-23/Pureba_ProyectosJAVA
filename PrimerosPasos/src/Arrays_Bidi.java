
public class Arrays_Bidi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		
		//int [][] matrix=new int[4][5];
		int [][] matrix= {
				{10,5,1,1,1},
				{10,5,1,1,1},
				{10,5,1,1,1},
				{10,5,1,1,1}				
		};
		/*//con un for normal
		for(int i=0;i<4;i++) {
			System.out.print("\n ");
			for(int j=0;j<5;j++) {
				System.out.print(matrix[i][j]+ " ");
				
			}		
			
		}
		*/
		// con un for each
		for(int[]fila:matrix) {
			System.out.println("");
			for(int z: fila) {
				System.out.print(z+ " ");
			}
		}
	}

}
