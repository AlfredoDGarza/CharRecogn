/*
 * @(#)Chars.java 1.0 31/10/2016
 */
package connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Char;

/**
 * Métodos que obtienen información de un caracter desde la base de datos.
 *
 * @author Alfredo de la Garza
 * @version 1.0 31/10/2016
 * @since 1.0
 */
public class Chars {

    /**
     * Retorna una lista con todos los caracteres almacenados en la base de
     * datos.
     *
     * @return lista con todos los caracteres almacenados
     */
    public static List<Char> getAllCharacters() {
        List<Char> listAllCharacters = null;

        try {
            listAllCharacters = new ArrayList<>();
            ResultSet resultSet = connection.Connection.executeQuery("select * from caracter");

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String character = resultSet.getString("caracter");
                String bits = resultSet.getString("bits");

                Char charInformation = new Char(id, character, bits);
                listAllCharacters.add(charInformation);
            }
        } catch (SQLException | ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(Chars.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listAllCharacters;
    }

    /**
     * Retorna una matriz de tipo double con todos los vectores de bits de los
     * caracteres almacenados.
     *
     * @return matriz con todos los vectores de bits
     */
    public static double[][] getBitsAllCharacters() {
        List<Char> listCharacters = Chars.getAllCharacters();
        //matrizBits.length = N
        //matrizBits[0].length = 35
        double[][] matrizBits = new double[listCharacters.size()][35];
        double[] vectorBits = new double[35];

        for (int i = 0; i < listCharacters.size(); i++) {
            Char character = listCharacters.get(i);
            String bits = character.getBits();

            for (int j = 0; j < bits.length(); j++) {
                vectorBits[j] = Double.parseDouble(String.valueOf(bits.charAt(j)));
            }

            for (int j = 0; j < vectorBits.length; j++) {
                matrizBits[i][j] = vectorBits[j];
            }
        }

        return matrizBits;
    }

    /**
     * Retorna un vector con todos los bits de los caracteres almacenados.
     *
     * @return vector con todos los bits de los caracteres
     */
    public static String[] getBitsCharacters() {
        List<Char> listCharacters = Chars.getAllCharacters();
        String[] bits = new String[listCharacters.size()];

        for (int i = 0; i < listCharacters.size(); i++) {
            Char character = listCharacters.get(i);
            String bitsChar = character.getBits();

            bits[i] = bitsChar;
        }

        return bits;
    }

    /**
     * Retorna todos los nombres de los caracteres almacenados.
     *
     * @return vector con todos los nombres de los caracteres
     */
    public static String[] getNamesAllCharacters() {
        List<Char> listCharacters = Chars.getAllCharacters();
        String[] listNames = new String[listCharacters.size()];

        for (int i = 0; i < listCharacters.size(); i++) {
            Char character = listCharacters.get(i);
            String nameCharacter = character.getCharacter();

            listNames[i] = nameCharacter;
        }

        return listNames;
    }

    /**
     * Retorna en un vector todos los ID de los caracteres almacenados en la
     * base de datos
     *
     * @return vector con todos los ID de los caracteres
     */
    public static int[] getIdAllCharacters() {
        List<Char> listCharacters = Chars.getAllCharacters();
        int[] listId = new int[listCharacters.size()];

        for (int i = 0; i < listCharacters.size(); i++) {
            Char character = listCharacters.get(i);
            int id = character.getId();

            listId[i] = id;
        }

        return listId;
    }

    /**
     * Almacena un caracter en la base de datos.
     *
     * @param character nombre del caracter a almacenar
     * @param bits vector de bits del caracter a almacenar
     * @return 1 si hubo éxito, 2 si hubo error
     */
    public static int addCharacter(String character, String bits) {
        try {
            return Connection.executeUpdate("insert into caracter(caracter, bits) values ('" + character + "', '" + bits + "')");
        } catch (ClassNotFoundException | SQLException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(Chars.class.getName()).log(Level.SEVERE, null, ex);
            javax.swing.JOptionPane.showMessageDialog(null, "Ha ocurrido un error al momento de guardar el caracter \n\nMensaje de error: " + String.valueOf(ex), "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        }

        return 0;
    }

    /**
     * Elimina el caracter con id que se recibe como parámetro.
     *
     * @param id identificador único del caracter a eliminar
     * @return 1 si hubo éxito, 2 si hubo error
     */
    public static int deleteCharacter(int id) {
        try {
            return Connection.executeUpdate("delete from caracter where id = " + id);
        } catch (ClassNotFoundException | SQLException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(Chars.class.getName()).log(Level.SEVERE, null, ex);
            javax.swing.JOptionPane.showMessageDialog(null, "Ha ocurrido un error al momento de eliminar el caracter \n\nMensaje de error: " + String.valueOf(ex), "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        }

        return 0;
    }

    /**
     * Modifica la información de un caracter y lo guarda.
     *
     * @param id identificador único del caracter almacenados
     * @param caracter caracter a almacenar
     * @param bits vector de bits a almacenar
     * @return 1 si hubo éxito, 2 si hubo error
     */
    public static int modifyCharacter(int id, String caracter, String bits) {
        try {
            return Connection.executeUpdate("update caracter set caracter = '" + caracter + "', bits = '" + bits + "' where id = " + id);
        } catch (ClassNotFoundException | SQLException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(Chars.class.getName()).log(Level.SEVERE, null, ex);
            javax.swing.JOptionPane.showMessageDialog(null, "Ha ocurrido un error al momento de eliminar el caracter \n\nMensaje de error: " + String.valueOf(ex), "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        }

        return 0;
    }

}
