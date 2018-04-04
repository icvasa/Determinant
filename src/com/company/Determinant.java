package com.company;

public class Determinant {


    public static void main(String[] args) {
        int N = 3;
        int[][] arr = new int[N][N];
        generate_matrix(arr);
        display(arr);
        System.out.println("The determinant equals" +determinant(arr,N));
    }


    private static void generate_matrix(int arr[][]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = (int) (Math.random() * 10);
            }
        }
    }


    private static int determinant(int array[][], int n){
        int det = 0, sign = 1, p = 0, q = 0;

        if(n==1){
            det = array[0][0];
        }
        else{
            int b[][] = new int[n-1][n-1];
            for(int x = 0 ; x < n ; x++){
                p=0;q=0;
                for(int i = 1;i < n; i++){
                    for(int j = 0; j < n;j++){
                        if(j != x){
                            b[p][q++] = array[i][j];
                            if(q % (n-1) == 0){
                                p++;
                                q=0;
                            }
                        }
                    }
                }
                det = det + array[0][x] *
                        determinant(b, n-1) *
                        sign;
                sign = -sign;
            }
        }
        return det;
    }


    public static void display(int arr[][])
    {
        for (int i = 0; i < arr.length; i++)
        {
            for (int j = 0; j < arr[i].length; j++)
            {

                System.out.print(arr[i][j] + " ");


            }
            System.out.println();
        }


    }




}