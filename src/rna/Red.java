/*
 * @(#)Red.java 1.0 30/10/2016
 *
 * = NOTAS =
 * número de nodos de la capa de entrada: 35 (vector de bits de un caracter)
 * número de nodos de la capa oculta:     (Cantidad de caracteres + 10) 
 * número de nodos de la capa de salida:  Cantidad de caracteres almacenados
 */
package rna;

import connection.Chars;
import java.util.List;
import java.util.Random;
import models.Char;

/**
 * Simula la red neuronal artificial.
 *
 * @author Alfredo de la Garza
 * @version 1.0 30/10/2016
 * @since 1.0
 */
public class Red {

    /**
     * Matriz de pesos de la capa de entrada a la capa oculta. <br><br>
     * Longitud de vector de bits de un caracter: 35 <br>
     * Número de nodos de la capa oculta: 18 <br><br>
     * entrada-oculta [18x35]
     */
    Matriz pesosEntradas;
    /**
     * Matriz de pesos de la capa oculta a la capa de salida. <br><br>
     * Número de caracteres ingresados por el usuario: 10 <br>
     * Número de nodos de la capa oculta: 18 <br><br>
     * oculta-salida [10x18].
     */
    Matriz pesosSalida;
    /**
     * Caracteres que ingresó el usuario. <br>
     * Cada caracter tiene un vector de bits del tamaño de 35. <br>
     * El número de caracteres es N. <br>
     * Teniendo en cuenta lo demás, la matriz sería (por ejemplo, si tenemos 10
     * caracteres ingresados por el usuario): <br><br>
     *
     * - vector de bits x número de caracteres - <br>
     * [35 x 10]
     */
    Matriz patronesEntrada;
    /**
     * Lo que debe aprender la red neuronal para los caracteres ingresados.
     */
    Matriz patronesSalida;

    /**
     * Generador de pesos aleatorios para inicializar los pesos.
     */
    Random generadorPesos = new Random();
    /**
     * Número de épocas.
     */
    int epocas = 0;

    /**
     * Lista con todos los caracteres almacenados en la base de datos.
     */
    List<Char> listaCaracteres;
    /**
     * Almacena el número de caracteres almacenados en la base de datos.
     */
    static int cantidadCaracteresAlmacenados;

    /**
     * Cantidad de nodos que se alojan en la capa oculta
     */
    static int numeroNodosCapaOculta;

    /**
     * Constructor que recibe las matrices de patrones como parámetro.
     *
     * @param patronesEntrada matriz de patrones de entradas [35xN]
     * @param patronesSalida matriz de objetivos
     */
    public Red(Matriz patronesEntrada, Matriz patronesSalida) {
        this.patronesEntrada = patronesEntrada;
        this.patronesSalida = patronesSalida;

        listaCaracteres = Chars.getAllCharacters();
        cantidadCaracteresAlmacenados = listaCaracteres.size();
        numeroNodosCapaOculta = patronesEntrada.getColumnas() + 10;
    }

    /**
     * Retorna el número de nodos que hay en la capa oculta
     *
     * @return nodos de la capa oculta
     */
    public int getNumeroNodosCapaOculta() {
        return numeroNodosCapaOculta;
    }

    /**
     * Establece pesos, coloca las matrices de la capa oculta y la capa de
     * salida en el objeto Red.
     *
     * @param pesosEntrada pesos de la capa entrada-oculta.
     * @param pesosSalida pesos de la capa de oculta-salida.
     */
    public void setPesos(Matriz pesosEntrada, Matriz pesosSalida) {
        this.pesosEntradas = pesosEntrada;
        this.pesosSalida = pesosSalida;
    }

    /**
     * Inicializa los pesos de la red neuronal que recibe como parámetro con un
     * número aleatorio dentro de una distribución de probabilidad Gaussiana con
     * valores entre [-0.5, 0.5].
     *
     * @param red red neuronal artificial objetivo.
     */
    public static void iniciar(Red red) {
        double matEntrada[][] = new double[numeroNodosCapaOculta][35];
        double matSalida[][] = new double[cantidadCaracteresAlmacenados][numeroNodosCapaOculta];

        //pesos entrada-oculta
        for (int x = 0; x < matEntrada.length; x++) {
            for (int y = 0; y < matEntrada[0].length; y++) {
                matEntrada[x][y] = red.generadorPesos.nextGaussian() * 0.5;
            }
        }

        //pesos oculta-salida
        for (int x = 0; x < matSalida.length; x++) {
            for (int y = 0; y < matSalida[0].length; y++) {
                matSalida[x][y] = red.generadorPesos.nextGaussian() * 0.5;
            }
        }

        red.pesosEntradas = new Matriz(matEntrada);
        red.pesosSalida = new Matriz(matSalida);
    }

    /**
     * Retorna la matriz de pesos de entrada. <br><br>
     * Longitud de vector de bits de un caracter: 35 <br>
     * Número de nodos de la capa oculta: 18 <br><br>
     * pesos entrada-oculta.
     *
     * @return matriz de pesos de entrada [18x35]
     */
    public Matriz getPesosEntrada() {
        return this.pesosEntradas;
    }

    /**
     * Retorna la matriz de pesos de salida. <br><br>
     * Número de caracteres ingresados por el usuario: 10 <br>
     * Número de nodos de la capa oculta: 18 <br><br>
     * pesos oculta-salida.
     *
     * @return matriz de pesos de salida [10x18]
     */
    public Matriz getPesosSalida() {
        return this.pesosSalida;
    }

    /**
     * Retorna la matriz con los patrones de entrada de entrenamiento.
     *
     * @return matriz patrones de entrada [35x10]
     */
    public Matriz getPatronesEntrada() {
        return this.patronesEntrada;
    }

    /**
     * Retorna la matriz con los objetivos de entrenamiento.
     *
     * @return matriz patrones de salida [10x10]
     */
    public Matriz getPatronesSalida() {
        return this.patronesSalida;
    }

    /**
     * Evalúa la función sigmoidal 1 / (1 + e^-n) de un valor dado.
     *
     * @param valor valor a evaluar
     * @return 1 / (1 + e^-n)
     */
    public static double fNetLog(double valor) {
        double num = 1;
        double den;
        double f;

        double exp = (-1) * valor;
        den = (1 + Math.pow(Math.E, (exp)));
        f = num / den;

        return f;
    }

    /**
     * Evalúa la primera derivada de la función sigmoidal 1 / (1 + e^-n)
     *
     * @param valor valor a evaluar
     * @return (1 / (1 + e^-n)) * (1 - 1 / (1 + e^-n))
     */
    public static double fPrimaNetLog(double valor) {
        double f;

        f = Red.fNetLog(valor) * (1 - Red.fNetLog(valor));

        return f;
    }

    /**
     * Evalúa la función sigmoidal a toda una matriz
     *
     * @param matriz matriz a evaluar
     * @return matriz con sus elementos evaluados
     */
    public static Matriz fNetMatrizLog(Matriz matriz) {
        double retorno[][];

        retorno = new double[matriz.getFilas()][matriz.getColumnas()];
        Matriz res = new Matriz(retorno);

        for (int x = 0; x < matriz.getFilas(); x++) {
            for (int y = 0; y < matriz.getColumnas(); y++) {
                res.setFilasColumnas(x, y, Red.fNetLog(matriz.getFilasColumnas(x, y)));
            }
        }

        return res;
    }

    /**
     * Evalúa la derivada de la función sigmoidal a toda una matriz.
     *
     * @param matriz matriz a evaluar
     * @return matriz con sus elementos evaluados
     */
    public static Matriz fNetPrimaMatrizLog(Matriz matriz) {
        double retorno[][];

        retorno = new double[matriz.getFilas()][matriz.getColumnas()];
        Matriz res = new Matriz(retorno);

        for (int x = 0; x < matriz.getFilas(); x++) {
            for (int y = 0; y < matriz.getColumnas(); y++) {
                res.setFilasColumnas(x, y, Red.fPrimaNetLog(matriz.getFilasColumnas(x, y)));
            }
        }

        return res;
    }

    /**
     * Simula el comportamiento de la red neuronal. <br>
     * Multiplica matrices, evalúa las funciones de propagación y en general
     * propaga la red hacia adelante.
     *
     * @param red red neuronal artificial
     * @param matriz vector de entrada a evaluar (1 caracter) [35x1]
     * @return matriz con un vector de respuestas de la red [10x1]
     */
    public static Matriz simularRed(Red red, Matriz matriz) {
        Matriz netEntrada;
        Matriz fNetEntrada;

        Matriz netSalida;
        Matriz fNetSalida;

        netEntrada = Matriz.multiplicar(red.getPesosEntrada(), matriz);
        fNetEntrada = Red.fNetMatrizLog(netEntrada);

        netSalida = Matriz.multiplicar(red.getPesosSalida(), fNetEntrada);
        fNetSalida = Red.fNetMatrizLog(netSalida);

        return fNetSalida;
    }

    /**
     * Establece el número de épocas de entrenamiento que han transcurrido en un
     * proceso de entrenamiento tras la condición de salida.
     *
     * @param epoca contador de épocas
     */
    public void setEpocas(int epoca) {
        this.epocas = epoca;
    }

    /**
     * Retorna el número de épocas que tuvo la red neuronal para alcanzar la
     * condición de salida.
     *
     * @return número de épocas
     */
    public int getEpocas() {
        return this.epocas;
    }

    /**
     * Retorna el error cuadrático
     *
     * @param errores matriz con los errores (yd - o) [10x1]
     * @return sumatoria de los errores al cuadrado multiplicado por 1/2
     */
    public static double getErrorCuadratico(Matriz errores) {
        double temp = 0;

        for (int i = 0; i < errores.getFilas(); i++) {
            temp += Math.pow(errores.getFilasColumnas(i, 0), 2);
        }

        temp = temp * 0.5;

        return temp;
    }

    /**
     * Entrena la red neuronal para que reconozca los caracteres ingresados por
     * el usuario
     *
     * @param red red neuronal artificial
     * @param factorAprendizaje factor de aprendizaje
     * @param error error admitido para cada época
     * @param iteraciones número máximo de iteraciones
     * @return string con información acerca del entrenamiento
     */
    public static String entrenarRed(Red red, double factorAprendizaje, double error, int iteraciones) {
        Red.iniciar(red);

        int numeroEpocas = 0;
        int j = 0;

        Matriz netEntradas;
        Matriz fNetEntradas;
        Matriz fNetPrimaEntradas;
        Matriz pesosEntradas;
        Matriz erroresEntradas;
        Matriz dEntradas;

        Matriz netSalidas;
        Matriz fNetSalidas;
        Matriz fNetPrimaSalidas;
        Matriz pesosSalidas;
        Matriz erroresSalidas;
        Matriz dSalidas;

        double errorG[] = new double[cantidadCaracteresAlmacenados];
        double errorGValor = 0;
        double errorP;
        boolean huboError = true;

        red.setEpocas(0);

        while ((numeroEpocas < iteraciones) && huboError == true) {
            huboError = false;
            for (int i = 0; i < cantidadCaracteresAlmacenados; i++) {
                //paso hacia adelante
                //propagar la capa oculta
                //[18x1] = [18x35] * [35x1] Net=wIx
                netEntradas = Matriz.multiplicar(red.getPesosEntrada(), red.getPatronesEntrada().getColumna(i));
                //[18x1] = f([18x1])
                fNetEntradas = Red.fNetMatrizLog(netEntradas);

                //propagar la salida
                //[10x1] = [10x18] * [18x1]
                netSalidas = Matriz.multiplicar(red.getPesosSalida(), fNetEntradas);
                fNetSalidas = Red.fNetMatrizLog(netSalidas);

                //calcular los errores
                //[10x1] = [10x1] - [10x1] (yd-o)
                erroresSalidas = Matriz.restar(red.getPatronesSalida().getColumna(i), fNetSalidas);

                //calcular el error cuadratico
                errorP = Red.getErrorCuadratico(erroresSalidas);
                errorG[i] = errorP;

                if (errorP > error) {
                    huboError = true;

                    //se calculan las derivadas
                    //[18x1] = f'([18x1])
                    fNetPrimaEntradas = Red.fNetPrimaMatrizLog(netEntradas);

                    //[10x1] = f'([10x1])
                    fNetPrimaSalidas = Red.fNetPrimaMatrizLog(fNetSalidas);

                    //calcular dSalidas
                    //[10x1]=e[10x1]xe[10x1] = (yd-o)*f'(netSalidas)
                    dSalidas = Matriz.multiplicarElementos(erroresSalidas, fNetPrimaSalidas);

                    //calcular dEntradas .. error propagado
                    //[18x10]=[10x18]'T
                    Matriz pesosSalidasT = Matriz.transponer(red.getPesosSalida());
                    //[18x1]=[18x10]x[10x1]
                    Matriz temp = Matriz.multiplicar(pesosSalidasT, dSalidas);
                    //[18x1]=e[18x1]xe[18x1]
                    dEntradas = Matriz.multiplicarElementos(temp, fNetPrimaEntradas);

                    //actualizar los pesos
                    //[10x18]=[10x1][18x1]'T
                    Matriz deltaPesosSalidas = Matriz.multiplicarEscalar(Matriz.multiplicar(dSalidas, Matriz.transponer(fNetEntradas)), factorAprendizaje);
                    pesosSalidas = Matriz.sumar(red.getPesosSalida(), deltaPesosSalidas);

                    //[18x35]=[18x1][35x1]'T
                    Matriz deltaPesosEntradas = Matriz.multiplicarEscalar(Matriz.multiplicar(dEntradas, Matriz.transponer(red.getPatronesEntrada().getColumna(j))), factorAprendizaje);
                    pesosEntradas = Matriz.sumar(red.getPesosEntrada(), deltaPesosEntradas);

                    //se actualizan los pesos
                    red.setPesos(pesosEntradas, pesosSalidas);

                    //vuelve al primer patron
                }
            }
            //una época mas (iteracion)
            numeroEpocas++;
        }

        red.setEpocas(numeroEpocas);

        String epoca = String.valueOf(red.getEpocas());

        if (huboError == false) {
            for (int i = 0; i < cantidadCaracteresAlmacenados; i++) {
                errorGValor += errorG[i];
            }

            String errG = String.valueOf(errorGValor);
            return "¡Red entrenada con éxito! \n" + "Épocas: " + epoca + "\n"
                    + "Valor de error alcanzado \nError global: " + errG + "\n";
        } else {
            return "¡Red entrenada con éxito!\n" + "Épocas: " + epoca + "\nValor de error NO alcanzado\n";
        }
    }

}
