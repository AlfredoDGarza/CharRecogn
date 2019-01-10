/*
 * @(#)Connection.java 1.0 31/10/2016
 */
package connection;

import java.sql.CallableStatement;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

/**
 * Contiene todo lo referente a la conexión con la base de datos como
 * preparedStatement, CallableStatement, Query's, etc.
 *
 * @author Alfredo de la Garza
 * @version 1.0 31/10/2016
 * @since 1.0
 */
public class Connection {

    /**
     * Nombre de la base de datos
     */
    public static final String DATABASE = "char_recogn";
    /**
     * Nombre de usuario para conectar con la base de datos
     */
    public static final String USERNAME = "root";
    /**
     * Contraseña para conectar con la base de datos
     */
    public static final String USERPASS = "";
    /**
     * Dirección donde se encuentra alojada la base de datos
     */
    public static final String URL = "jdbc:mysql://localhost/" + DATABASE;
    /**
     * Driver utilizado para la base de datos
     */
    public static final String DRIVER = "com.mysql.jdbc.Driver";

    static java.sql.Connection connection = null;
    static ResultSet resultSet = null;
    static PreparedStatement preparedStatement = null;
    static CallableStatement callableStatement = null;

    /**
     * Retorna una conexión con la base de datos. <br>
     * Si ya existe una conexión la retorna siempre y cuando no esté cerrada,
     * sino crea una nueva.
     *
     * @return Conexión con la base de datos.
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     * @throws java.lang.InstantiationException
     * @throws java.lang.IllegalAccessException
     */
    public static java.sql.Connection getConnection() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        if (connection == null) {
            Class.forName(DRIVER).newInstance();
            connection = DriverManager.getConnection(URL, USERNAME, USERPASS);
        }

        return connection;
    }

    /**
     * Convierte un String (el cuál es la sentencia SQL a ejecutar) en un
     * PreparedStatement.
     *
     * @param query Sentencia SQL a ejecutar.
     * @return PreparedStatement de la sentencia SQL a ejecutar.
     */
    private static PreparedStatement getPreparedStatement(String query) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        return getConnection().prepareStatement(query);
    }

    /**
     * Convierte un String (el cuál es la sentencia SQL a ejecutar) en un
     * CallableStatement. <br>
     * Éste método se utilizará solo cuando se mande a llamar a un Stored
     * Procedure de la base de datos.
     *
     * @param query Llamada SQL a ejecutar.
     * @return CallableStatement de la llamada SQL al Stored Procedure a
     * ejecutar.
     */
    private static CallableStatement getCallableStatement(String query) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        return getConnection().prepareCall(query);
    }

    /**
     * Ejecuta una llamada a un Stored Procedure de la base de datos, pasando
     * los parámetros de la llamada como ?.
     *
     * @param query Llamada SQL a ejecutar.
     * @param output Retorno de valor. <br> Se utiliza solo cuando el Stored
     * Procedure tiene un parámetro a devolver, tipo <b>OUT</b> o <b>INOUT</b>.
     * @param parameters Parámetros que recibe el Stored Procedure.
     * @return Valor el cuál evaluará si la llamada se realizó o no con éxito.
     * <br>Retornos del método:
     * <ul>
     * <li><b>1: </b>Cuando la llamads se realizó con éxito al Stored
     * Procedure.</li>
     * <li><b>2: </b>Cuando hubo algún error en el momento de ejecutar la
     * llamada al Stored Procedure.</li>
     * </ul>
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     * @throws java.lang.InstantiationException
     * @throws java.lang.IllegalAccessException
     */
    public static int executeCallableQuery(String query, boolean output, Object... parameters) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        callableStatement = getCallableStatement(query);
        int parameterIndex = 1;
        int value;

        for (Object parameter : parameters) {
            callableStatement.setObject(parameterIndex, parameter);
            parameterIndex++;
        }

        if (output) {
            callableStatement.registerOutParameter(1, Types.INTEGER);
            callableStatement.executeUpdate();

            value = callableStatement.getInt(1);
            callableStatement.close();
        } else {
            value = callableStatement.executeUpdate();
            callableStatement.close();
        }

        return value;
    }

    /**
     * Ejecuta una sentencia a la base de datos, recibiendo parámetros de la
     * manera ?.
     *
     * @param query Sentencia SQL a ejecutar.
     * @param parameters Parámetros dados a la sentencia.
     * @return ResultSet con los resultados de la sentencia, siempre y cuando se
     * hay realizado correctamente, en caso de que ocurra un error, mandará un
     * resultado tipo <b>Null</b>
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     * @throws java.lang.InstantiationException
     * @throws java.lang.IllegalAccessException
     */
    public static ResultSet executeQuery(String query, Object... parameters) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        preparedStatement = getPreparedStatement(query);

        int parameterIndex = 1;

        if (parameters != null) {
            for (Object parameter : parameters) {
                preparedStatement.setObject(parameterIndex, parameter);
                parameterIndex++;
            }
        }

        resultSet = preparedStatement.executeQuery();

        return resultSet;
    }

    /**
     * Ejecuta una sentencia a la base de dato sin recibir parámetros.
     *
     * @param query Sentencia SQL a ejecutar.
     * @return ResultSet con los resultados de la sentencia, siempre y cuando se
     * hay realizado correctamente, en caso de que ocurra un error, mandará un
     * resultado tipo <b>Null</b>
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     * @throws java.lang.InstantiationException
     * @throws java.lang.IllegalAccessException
     */
    public static ResultSet executeQuery(String query) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        preparedStatement = getPreparedStatement(query);

        resultSet = preparedStatement.executeQuery();

        return resultSet;
    }

    /**
     * Ejecuta una sentencia a la base de datos.
     * <p>
     * <b>NOTA:</b> Usar este método cuando se tenga que hacer una consulta de
     * tipo <b>UPDATE</b> o tipo <b>DELETE</b>
     *
     * @param query Sentencia SQL a ejecutar.
     * @return Valor de tipo entero que especifica si se realizó con éxito la
     * sentencia o hubo algún error, los valores a devolver son:
     * <b>1:</b> Si la sentencia fue ejecutada con éxito.
     * <b>2:</b> Si hubo algún error al momento de ejecutar la sentencia.
     * @throws ClassNotFoundException
     * @throws SQLException
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    public static int executeUpdate(String query) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
        int value;
        preparedStatement = getPreparedStatement(query);

        value = preparedStatement.executeUpdate();

        return value;
    }

}
