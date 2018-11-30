package DataStructures.Matrix;

/**
*
* Java implementation of Matrix fast power
* It can calculate the high power of constant Matrix with O( log(K) )
* where K is the power of the Matrix
*
* In order to do that, Matrix must be square Matrix ( columns equals rows)
*
* Notice : large power of Matrix may cause overflow
*
*
* other Matrix basic operator is based on  @author Kyler Smith, 2017
*
* @author DDullahan, 2018
*
*/

class MatrixFastPower {

   /**
    * Matrix Fast Power
    *
    * @param matrix : square Matrix
    * @param k : power of Matrix
    * @return product
    */
   public static Matrix2 FastPower(Matrix2 matrix, int k) throws RuntimeException {

       if(matrix.getColumns() != matrix.getRows())
           throw new RuntimeException("Matrix is not square Matrix2.");

       int[][] newData = new int[matrix.getColumns()][matrix.getRows()];

       for(int i = 0; i < matrix.getColumns(); i++)
           newData[i][i] = 1;

       Matrix2 newMatrix = new Matrix2(newData),
       coMatrix = new Matrix2(matrix.data);

       while(k != 0) {

           if((k & 1) != 0)
               newMatrix = newMatrix.multiply(coMatrix);

           k >>= 1;
           coMatrix = coMatrix.multiply(coMatrix);

       }

       return newMatrix;
   }

   public static void main(String[] argv) {

       int[][] data = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
       Matrix2 matrix = new Matrix2(data);

       System.out.println("original matrix : ");
       System.out.println(matrix.toString());

       matrix = MatrixFastPower.FastPower(matrix, 5);

       System.out.println("after power : ");
       System.out.println(matrix.toString());

       matrix = MatrixFastPower.FastPower(matrix, 1000000);

       System.out.println("notice, large power may cause overflow : ");
       System.out.print(matrix.toString());
       System.out.println("you can use mod to fix that :-) ");

   }
}
class Matrix2 {
   public int[][] data;

   /**
    * Constructor for the matrix takes in a 2D array
    *
    * @param pData
    */
   public Matrix2(int[][] pData) {

       /** Make a deep copy of the data */
       if(pData.length != 0) {
           int[][] newData = new int[pData.length][pData[0].length];

           for(int i = 0; i < pData.length; i++)
               for(int j = 0; j < pData[0].length; j++)
                   newData[i][j] = pData[i][j];

           this.data = newData;
       } else {
           this.data = null;
       }
   }

   /**
    * Returns the element specified by the given location
    *
    * @param x : x cooridinate
    * @param y : y cooridinate
    * @return int : value at location
    */
   public int getElement(int x, int y) {
       return data[x][y];
   }

   /**
    * Returns the number of rows in the Matrix
    *
    * @return rows
    */
   public int getRows() {
       if(this.data == null)
           return 0;

       return data.length;
   }

   /**
    * Returns the number of rows in the Matrix
    *
    * @return columns
    */
   public int getColumns() {
       if(this.data == null)
           return 0;

       return data[0].length;
   }

   /**
    * Multiplies this matrix with another matrix.
    *
    * @param other : Matrix to be multiplied with
    * @return product
    */
   public Matrix2 multiply(Matrix2 other) throws RuntimeException {

       int[][] newData = new int[this.data.length][other.getColumns()];

       if(this.getColumns() != other.getRows())
           throw new RuntimeException("The two matrices cannot be multiplied.");

       int sum;

       for (int i = 0; i < this.getRows(); ++i)
           for(int j = 0; j < other.getColumns(); ++j) {
               sum = 0;

               for(int k = 0; k < this.getColumns(); ++k) {
                   sum += this.data[i][k] * other.getElement(k, j);
               }

               newData[i][j] = sum;
           }

       return new Matrix2(newData);
   }

   /**
   * Returns the Matrix as a String in the following format
   *
   * [ a b c ] ...
   * [ x y z ] ...
   * [ i j k ] ...
   *    ...
   *
   * @return Matrix as String
   * TODO: Work formatting for different digit sizes
   */
   public String toString() {
       String str = "";

       for(int i = 0; i < this.data.length; i++) {
           str += "[ ";

           for(int j = 0; j < this.data[0].length; j++) {
               str += data[i][j];
               str += " ";
           }

           str += "]";
           str += "\n";
       }

       return str;
   }

}

