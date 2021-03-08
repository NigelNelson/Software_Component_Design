/*
 * Course: SE2811
 * Winter 2020 - 031
 * Lab 2: CrypStick
 * Name: Nigel Nelson
 * Created: 12/10/20
 */
package nelsonni;

/**
 * Interface class that defines the behavior of an encrypter
 */
public interface Encrypter {

    /**
     * Method that decrypts a message
     * @param bytes the bytes representation of the message
     * @return the bytes of the encrypted message
     */
    byte[] decrypt(byte[] bytes);

    /**
     * Method that decrypts a message
     * @param bytes the bytes representation of the encrypted message
     * @return the bytes of the decrypted message
     */
    byte[] encrypt(byte[] bytes);

}
