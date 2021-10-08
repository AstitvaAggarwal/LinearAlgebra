import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class GaussJacobiIterative {
	public static void main(String[] args) {
		double[][] matrix = new double[3][4];
		boolean flag0 = false;
		int niter;
		double[] iter = { 0, 0, 0, 3 };

		Scanner input = new Scanner(System.in);
		System.out.println(" : Enter the Correct (3X4 Auxiliary Matrix form) of system of linear equations :");
		System.out.println(" : The Matrix must follow condition of covergence : ");
		System.out.println(" : The leading diagonal elements of the coefficient matrix should be dominant : ");

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 4; j++) {
				matrix[i][j] = input.nextDouble();
			}
		}

		if ((matrix[0][0] >= matrix[0][1] + matrix[0][2]) && (matrix[1][1] >= matrix[1][0] + matrix[1][2])
				&& (matrix[2][2] >= matrix[2][1] + matrix[2][0])) {
			System.out.println("Correct Matrix form entered !");
			flag0 = true;
		} else {
			System.out.println("Wrong Matrix form entered !");
		}

		System.out.print("\nEnter the Decimal Precision : ");
		iter[3] = input.nextDouble();
		if (flag0) {

			System.out.print("Enter Number of Iterations : ");
			niter = input.nextInt();

			for (int i = 0; i < niter + 2; i++) {

				System.out.println("ITERATION " + (i - 1) + " : " + iter[0] + " " + iter[1] + " " + iter[2]);

				// GaussJacobi iterative step formula
				double temp1 = (matrix[0][3] - (matrix[0][1] * iter[1]) - (matrix[0][2] * iter[2])) / matrix[0][0];
				double temp2 = (matrix[1][3] - (matrix[1][0] * iter[0]) - (matrix[1][2] * iter[2])) / matrix[1][1];
				double temp3 = (matrix[2][3] - (matrix[2][0] * iter[0]) - (matrix[2][1] * iter[1])) / matrix[2][2];
				iter[0] = temp1;
				round(iter, 0);
				iter[1] = temp2;
				round(iter, 1);
				iter[2] = temp3;
				round(iter, 2);
			}
		}
		input.close();
	}

	public static void round(double[] iter, int i) {
		iter[i] = BigDecimal.valueOf(iter[i]).setScale((int) iter[3], RoundingMode.HALF_UP).doubleValue();
	}
}
