package array;


public class TwoDimensionalArray {

	public static void main(String[] args) {

		char[][] table = new char[12][3];
		String[] student = new String[table.length];
		Double[][] table2 = new Double[10][5];
		
		for (int row=0;row<table.length;row++){
			for (int col=0;col<table[row].length;col++){
				table[row][col] = 'A';
			}
		}
		
		table[11][1] = 'F';
		
		student[0] = "Bob";
		student[1] = "Susey";
		student[2] = "Lindsey";
		student[3] = "Kelsey";
		student[4] = "Billy";
		student[5] = "John";
		student[6] = "Tyler";
		student[7] = "Don";
		student[8] = "Nancey";
		student[9] = "Tom";
		student[10] = "Jessica";
		student[11] = "Daniel";
		

		for (int row=0;row<table.length;row++){
			System.out.println(student[row]);
			for (int col=0;col<table[row].length;col++){
				System.out.println(table[row][col]);
			}
			System.out.println();
			
			
		}	
	
			
		
		for (int row=0;row<table2.length;row++){
			for (int col=0;col<table2[row].length;col++){
				table2[row][col] = 100000.00;
			}
		}
		table2[6][2] = 1100.00;
		
/*		for (int row=0;row<table2.length;row++){
			for (int col=0;col<1;col++){
				table2[row][col] = 50000.00;
			}
		}*/
		
		for (int i=0;i<table2.length;i++){
			table2[i][0] = 50000.0;
		}
		
		for (int row=0;row<table2.length;row++){
			System.out.println(student[row]);
			for (int col=0;col<table2[row].length;col++){
				System.out.println(table2[row][col]);
			}
			System.out.println();
		}

	}

}
