/*
 * @(#)RNA.java 1.0 01/11/2016
 */
package connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Métodos que obtiene información de la red neuronal desde la base de datos.
 *
 * @author Alfredo de la Garza
 * @version 1.0 01/11/2016
 * @since 1.0
 */
public class RNA {

    /**
     * Retorna el identificador de la información de la red neuronal.
     *
     * @return identificador de la información de la red neuronal
     */
    public static int getId() {
        int id = 0;

        try {
            ResultSet resultSet = connection.Connection.executeQuery("select * from red");

            if (resultSet.next()) {
                id = resultSet.getInt("id");
                System.out.println("ID: " + id);
            }
        } catch (ClassNotFoundException | SQLException | InstantiationException | IllegalAccessException e) {
            Logger.getLogger(RNA.class.getName()).log(Level.SEVERE, null, e);
        }

        return id;
    }

    /**
     * Retorna el factor de aprendizaje almacenado en la base de datos.
     *
     * @return factor de aprendizaje
     */
    public static double getFactorAprendizaje() {
        double factor = 0;

        try {
            ResultSet resultSet = connection.Connection.executeQuery("select * from red");

            if (resultSet.next()) {
                factor = resultSet.getDouble("factorAprendizaje");
            }
        } catch (ClassNotFoundException | SQLException | InstantiationException | IllegalAccessException e) {
            Logger.getLogger(RNA.class.getName()).log(Level.SEVERE, null, e);
        }

        return factor;
    }

    /**
     * Retorna el error almacenado en la base de datos.
     *
     * @return error
     */
    public static double getError() {
        double error = 0;

        try {
            ResultSet resultSet = connection.Connection.executeQuery("select * from red");

            if (resultSet.next()) {
                error = resultSet.getDouble("error");
            }
        } catch (ClassNotFoundException | SQLException | InstantiationException | IllegalAccessException e) {
            Logger.getLogger(RNA.class.getName()).log(Level.SEVERE, null, e);
        }

        return error;
    }

    /**
     * Retorna el número de iteraciones máximas.
     *
     * @return iteraciones máximas
     */
    public static int getIteracionesMaximas() {
        int iteraciones = 0;

        try {
            ResultSet resultSet = connection.Connection.executeQuery("select * from red");

            if (resultSet.next()) {
                iteraciones = resultSet.getInt("iteracionesMaximas");
            }
        } catch (ClassNotFoundException | SQLException | InstantiationException | IllegalAccessException e) {
            Logger.getLogger(RNA.class.getName()).log(Level.SEVERE, null, e);
        }

        return iteraciones;
    }

    /**
     * Guarda la información nueva de la red neuronal en la base de datos.
     *
     * @param id identificador de la información a guardar
     * @param factor factor de aprendizaje a almacenar
     * @param error error admitido
     * @param iteraciones iteraciones máximas
     * @return 1 si hubo éxito, 2 si hubo error
     */
    public static int saveInformation(int id, double factor, double error, int iteraciones) {
        try {
            return Connection.executeUpdate("update red set factorAprendizaje = " + factor + ", error = " + error + ", iteracionesMaximas = " + iteraciones + " where id = " + id);
        } catch (ClassNotFoundException | SQLException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(Chars.class.getName()).log(Level.SEVERE, null, ex);
            javax.swing.JOptionPane.showMessageDialog(null, "Ha ocurrido un error al momento de guardar la información de la red \n\nMensaje de error: " + String.valueOf(ex), "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        }

        return 0;
    }

}
