/*
 * @(#)Char.java 1.0 31/10/2016
 */
package models;

/**
 * Modelo de un caracter, almacenando un ID, nombre caracter, y el vector de
 * bits del caracter.
 *
 * @author Alfredo de la Garza
 * @version 1.0 31/10/2016
 * @since 1.0
 */
public class Char {

    /**
     * Identificador de un caracter.
     */
    private int id;
    /**
     * Nombre del caracter.
     */
    private String character;
    /**
     * Vector de bits del caracter.
     */
    private String bits;

    /**
     * Constructor que recibe toda la información de un caracter.
     *
     * @param id identificador único de un caracter
     * @param character caracter almacenado
     * @param bits vector de bits del caracter
     */
    public Char(int id, String character, String bits) {
        this.id = id;
        this.character = character;
        this.bits = bits;
    }

    /**
     * Retorna el identificador del caracter.
     *
     * @return identificador
     */
    public int getId() {
        return id;
    }

    /**
     * Define el identificador del caracter.
     *
     * @param id identificador
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Retorna el nombre del caracter.
     *
     * @return nombre del caracter
     */
    public String getCharacter() {
        return character;
    }

    /**
     * Define el nombre del caracter.
     *
     * @param character nombre del caracter
     */
    public void setCharacter(String character) {
        this.character = character;
    }

    /**
     * Retorna el vector de bits del caracter.
     *
     * @return vector de bits del caracter
     */
    public String getBits() {
        return bits;
    }

    /**
     * Define el vector de bits del caracter.
     *
     * @param bits vector de bits del caracter_
     */
    public void setBits(String bits) {
        this.bits = bits;
    }

}
