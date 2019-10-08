```java
public int[][] MatrixMultiplication(int[][] m1,int[][] m2){
        int[][] res = new int[m1.length][m2[0].length];
        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m2[0].length; j++) {
                for (int k = 0; k < m2.length; k++) {
                    res[i][j] += m1[i][k]*m2[k][j];
                }
            }
        }
        return res;
    }
```
