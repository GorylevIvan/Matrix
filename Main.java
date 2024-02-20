package com.company;


class Complex{
    int a, b;
    Complex(){
        a = 0;
        b = 0;
    }
    Complex(int a, int b){
        this.a = a;
        this.b = b;
    }
    Complex GetC(Complex num){
        return num;
    }
    Complex plus(Complex num2){
        return new Complex(this.a + num2.a, this.b + num2.b);
    }
    Complex minus(Complex num2){
        return new Complex(this.a - num2.a, this.b - num2.b);
    }
    Complex mult(Complex num2){
        return new Complex(this.a * num2.a - this.b * num2.b, this.a * num2.b + this.b * num2.a);
    }
    Complex div(Complex num2){
        return new Complex(this.a * num2.a + this.b * num2.b / num2.a * num2.a + num2.b * num2.b,
                this.b * num2.a - this.a * num2.b / num2.a * num2.a + num2.b * num2.b);
    }
    void prnt (){
        if (b != 0){
            System.out.print(a + "," + b + "  ");
        }
        else{
            System.out.print(a + "  ");
        }
    }
}

class Matrix{
    int n, m;
    Complex arr[][] = new Complex[n][m];
    Matrix(){
        n = 0;
        m = 0;
    }
    Matrix(int n, int m) {
        this.n = n;
        this.m = m;
        this.arr = new Complex[n][m];
    }
    Matrix(int n, int m, Complex arr[][]){
        this.n = n;
        this.m = m;
        this.arr = arr;
    }
    Matrix CreateMatrix(){
        Matrix mat = new Matrix(this.n, this.m);
        for (int i = 0; i < this.n; i++){
            for (int j = 0; j < this.m; j++){
                mat.arr[i][j] = new Complex((int)(Math.random() * 100),(int)(Math.random() * 100));
            }
        }
        return mat;
    }
    Matrix addition(Matrix a2){
        Matrix a1 = new Matrix (this.n, this.m, this.arr);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a1.arr[i][j] = this.arr[i][j].plus(a2.arr[i][j]);
            }
        }
        return a1;
    }
    Matrix trans(){
        Matrix a1 = new Matrix (this.n, this.m);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a1.arr[i][j] = this.arr[j][i];
            }
        }
        return a1;
    }
    Matrix multiplication(Matrix a2){
        if (this.m == a2.n){
            Matrix a1 = new Matrix (this.n, a2.m);
            for (int i = 0; i < this.n; i++){
                for (int j = 0; j < a2.m; j++){
                    a1.arr[i][j] = new Complex(0, 0);
                    for (int k = 0; k < a2.m; k++){
                        a1.arr[i][j] = a1.arr[i][j].plus(this.arr[i][k].mult(a2.arr[k][j]));
                    }
                }
            }
            return a1;
        }
        else{
            System.out.println("IT'S IMPOSSIBLE");
            return a2;
        }
    }

    void getmatrix(){
        for (int i = 0; i < this.n; i++){
            for (int j = 0; j < this.m; j++){
                this.arr[i][j].prnt();
            }
            System.out.println("");
        }
    }
}


public class Main {
    public static void main(String[] args) {
        /*
        Complex arr1[][] = {
                {new Complex(1, 1), new Complex(1, 0), new Complex(1, 0)},
                {new Complex(1, 0), new Complex(1, 0), new Complex(1, 0)},
                {new Complex(1, 0), new Complex(1, 0), new Complex(1, 0)}};
        Complex arr2[][] = {
                {new Complex(2, 0), new Complex(2, 0), new Complex(2, 0)},
                {new Complex(2, 0), new Complex(2, 0), new Complex(2, 0)},
                {new Complex(2, 0), new Complex(2, 0), new Complex(2, 0)}};
        System.out.println("");
        Matrix vesh1 = new Matrix(3, 3, arr1);
        vesh1.getmatrix();
        Matrix vesh2 = new Matrix(3, 3, arr2);
        System.out.println("");
        vesh2.getmatrix();
        Matrix vesh3 = vesh1.multiplication(vesh2);
        System.out.println("");
        vesh3.getmatrix();
        System.out.println("");
        Matrix vesh4 = vesh3.trans();
        vesh4.getmatrix();
        System.out.println("");*/

        Matrix vesh1 = new Matrix(2, 2);
        vesh1 = vesh1.CreateMatrix();
        vesh1.getmatrix();
        System.out.println("");
        Matrix vesh2 = new Matrix(2, 2);
        vesh2 = vesh2.CreateMatrix();
        vesh2.getmatrix();
        Matrix vesh3 = vesh1.multiplication(vesh2);
        System.out.println("");
        vesh3.getmatrix();
        Matrix vesh4 = vesh1.addition(vesh2);
        System.out.println("");
        vesh4.getmatrix();
        System.out.println("");
        Matrix vesh5 = vesh4.trans();
        vesh5.getmatrix();
    }
}
