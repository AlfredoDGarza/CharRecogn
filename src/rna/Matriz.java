/*
 * @(#)Matriz.java 1.0 30/10/2016
 */
package rna;

import java.text.DecimalFormat;

/**
 * Matriz que modela la red neuronal por 2 capas. <br><br>
 * entrada-oculta. <br>
 * oculta-salida. 
 *
 * @author Alfredo de la Garza
 * @version 1.0 30/10/2016
 * @since 1.0
 */
public class Matriz {

    /**
     * Número de filas de la matriz.
     */
    int filas = 0;
    /**
     * Número de columnas de la matriz.
     */
    int columnas = 0;
    /**
     * Matriz de inicio.
     */
    double matriz[][];

    /**
     * Constructor con un parámetro de tipo Matriz
     *
     * @param matriz
     */
    public Matriz(double[][] matriz) {
        this.matriz = matriz;
        this.filas = matriz.length;
        this.columnas = matriz[0].length;
    }

    /**
     * Constructor con un parámetro de tipo Vector
     *
     * @param matriz
     */
    public Matriz(double[] matriz) {
        this.matriz = new double[1][matriz.length];

        for (int i = 0; i < matriz.length; i++) {
            this.matriz[0][i] = matriz[i];
            this.filas = 1;
            this.columnas = matriz.length;
        }
    }

    /**
     * Retorna el número de columnas de la matriz recibida como parámetro
     *
     * @param matriz matriz
     * @return número de columnas
     */
    public static int getColumnas(Matriz matriz) {
        return matriz.columnas;
    }

    /**
     * Retorna el número de columnas
     *
     * @return número de columnas
     */
    public int getColumnas() {
        return this.columnas;
    }

    /**
     * Retorna el número de columnas en formato String
     *
     * @return número de columnas tipo String
     */
    public String getColumnasString() {
        return String.valueOf(this.columnas);
    }

    /**
     * Obtener columna
     *
     * @param indice indice de la columna a obtener
     * @return matriz columna con todos los valores de la columna indicada
     */
    public Matriz getColumna(int indice) {
        double temp[][] = new double[this.getFilas()][1];

        for (int x = 0; x < this.getFilas(); x++) {
            temp[x][0] = this.getMatriz()[x][indice];
        }

        Matriz retorno = new Matriz(temp);
        return retorno;
    }

    /**
     * Retorna el número de filas
     *
     * @param matriz matriz
     * @return número de filas
     */
    public static int getFilas(Matriz matriz) {
        return matriz.filas;
    }

    /**
     * Retorna el número de filas
     *
     * @return número de filas
     */
    public int getFilas() {
        return this.filas;
    }

    /**
     * Retorna el número de filas en formato String
     *
     * @return número de filas tipo String
     */
    public String getFilasString() {
        return String.valueOf(this.filas);
    }

    /**
     * Retorna la matriz. <b>toArray</b>
     *
     * @return matriz
     */
    public double[][] getMatriz() {
        return this.matriz;
    }

    /**
     * Retorna la matriz <b>toArray</b>
     *
     * @param matriz matriz
     * @return matriz
     */
    public static double[][] getMatriz(Matriz matriz) {
        return matriz.matriz;
    }

    /**
     * Coloca un valor en la posición [fila][columna]
     *
     * @param fila índice de la fila
     * @param columna índice de la columna
     * @param valor valor a colocar
     */
    public void setFilasColumnas(int fila, int columna, double valor) {
        this.matriz[fila][columna] = valor;
    }

    /**
     * Retorna el valor de la matriz en la posición [fila][columna]
     *
     * @param fila índice de la fila
     * @param columna índice de la columna
     * @return valor de la matriz
     */
    public double getFilasColumnas(int fila, int columna) {
        return this.matriz[fila][columna];
    }

    /**
     * Convierte la matriz en un String
     *
     * @param matriz matriz a convertir
     * @return matriz en tipo String
     */
    public static String toStringMatriz(Matriz matriz) {
        DecimalFormat decimal = new DecimalFormat("0.00");
        StringBuilder mat = new StringBuilder();

        for (int x = 0; x < matriz.getFilas(); x++) {
            for (int y = 0; y < matriz.getColumnas(); y++) {
                mat.append(" ");
                mat.append(decimal.format(matriz.getMatriz()[x][y]));
            }
            mat.append("\n");
        }

        String salida = mat.toString();
        return salida;
    }

    /**
     * Convierte la matriz en un String
     *
     * @return matriz en tipo String
     */
    public String toStringMatriz() {
        DecimalFormat decimal = new DecimalFormat("0.00");
        StringBuilder mat = new StringBuilder();

        for (int x = 0; x < this.getFilas(); x++) {
            for (int y = 0; y < this.getColumnas(); y++) {
                mat.append(" ");
                mat.append(decimal.format(this.getMatriz()[x][y]));
            }
            mat.append("\n");
        }

        String salida = mat.toString();
        return salida;
    }

    /**
     * Transponer matriz. <br>
     * Transponer significa invertir las coordenadas de la matriz, por ejemplo,
     * una matriz de [5][10] se hace una matriz de [10][5]
     *
     * @param matriz matriz a transponer
     * @return matriz
     */
    public static Matriz transponer(Matriz matriz) {
        double retorno[][];
        retorno = new double[matriz.getColumnas()][matriz.getFilas()];

        for (int x = 0; x < matriz.getFilas(); x++) {
            for (int y = 0; y < matriz.getColumnas(); y++) {
                retorno[y][x] = matriz.getMatriz()[x][y];
            }
        }

        Matriz ret = new Matriz(retorno);
        return ret;
    }

    /**
     * Sumar las matrices
     *
     * @param mA matriz A
     * @param mB matriz B
     * @return matriz nueva (mA + mB)
     */
    public static Matriz sumar(Matriz mA, Matriz mB) {
        double retorno[][];
        retorno = new double[mB.getFilas()][mB.getColumnas()];
        Matriz ret = new Matriz(retorno);

        for (int x = 0; x < mA.getFilas(); x++) {
            for (int y = 0; y < mA.getColumnas(); y++) {
                ret.setFilasColumnas(x, y, (mA.getFilasColumnas(x, y) + mB.getFilasColumnas(x, y)));
            }
        }

        return ret;
    }

    /**
     * Restar las matrices
     *
     * @param mA matriz A
     * @param mB matriz B
     * @return matriz nueva (mA - mB)
     */
    public static Matriz restar(Matriz mA, Matriz mB) {
        double retorno[][];
        retorno = new double[mB.getFilas()][mB.getColumnas()];
        Matriz ret = new Matriz(retorno);

        for (int x = 0; x < mA.getFilas(); x++) {
            for (int y = 0; y < mA.getColumnas(); y++) {
                ret.setFilasColumnas(x, y, (mA.getFilasColumnas(x, y) - mB.getFilasColumnas(x, y)));
            }
        }

        return ret;
    }

    /**
     * Multiplicar matrices
     *
     * @param mA matriz A
     * @param mB matriz B
     * @return matriz nueva (mA * mB) con dimensiones [mA][mB]
     */
    public static Matriz multiplicar(Matriz mA, Matriz mB) {
        double retorno[][];
        double temp;

        retorno = new double[mA.getFilas()][mB.getColumnas()];
        Matriz ret = new Matriz(retorno);

        for (int x = 0; x < mA.getFilas(); x++) {
            for (int y = 0; y < mB.getColumnas(); y++) {
                temp = 0;

                for (int i = 0; i < mA.getColumnas(); i++) {
                    temp += mA.getFilasColumnas(x, i) * mB.getFilasColumnas(i, y);
                }
                ret.setFilasColumnas(x, y, temp);
            }
        }

        return ret;
    }

    /**
     * Calcula la respuestas mas probable
     *
     * @param respuestas matriz con las respuestas de la simulación
     * @param nombres vector de String con los nombres de los patrones
     * @return patron mas probable del vector
     */
    public static String masProbable(Matriz respuestas, String nombres[]) {
        int indice = 0;
        double temp = respuestas.getMatriz()[0][0];

        for (int y = 0; y < respuestas.getMatriz()[0].length; y++) {
            if (respuestas.getMatriz()[0][y] > temp) {
                temp = respuestas.getMatriz()[0][y];
                indice = y;
            }
        }

        return nombres[indice];
    }

    /**
     * Multiplicar matriz por escalar
     *
     * @param matriz matriz a multiplicar
     * @param factorEscalar factor escalar
     * @return matriz escalada
     */
    public static Matriz multiplicarEscalar(Matriz matriz, double factorEscalar) {
        double temp[][] = new double[matriz.getFilas()][matriz.getColumnas()];

        for (int x = 0; x < matriz.getFilas(); x++) {
            for (int y = 0; y < matriz.getColumnas(); y++) {
                temp[x][y] = matriz.getMatriz()[x][y] * factorEscalar;
            }
        }

        Matriz retorno = new Matriz(temp);
        return retorno;
    }

    /**
     * Multiplicar elementos entre matrices
     *
     * @param mA matriz A
     * @param mB matriz B
     * @return matriz con los productos de los elementos de mA * mB
     */
    public static Matriz multiplicarElementos(Matriz mA, Matriz mB) {
        double temp[][] = new double[mA.getFilas()][mB.getColumnas()];

        for (int x = 0; x < mA.getFilas(); x++) {
            for (int y = 0; y < mA.getColumnas(); y++) {
                temp[x][y] = mA.getMatriz()[x][y] * mB.getMatriz()[x][y];
            }
        }

        Matriz retorno = new Matriz(temp);
        return retorno;
    }

}
