/*
 * Course: SE2811
 * Winter 2020 - 031
 * Lab 2: CrypStick
 * Name: Nigel Nelson
 * Created: 12/10/20
 */
package nelsonni;

/**
 * Class that has no encryption or decryption method, and
 * simply returns the bytes provided
 */
public class NullEncrypter implements Encrypter {

    @Override
    public byte[] decrypt(byte[] bytes) {
        return bytes;
    }

    @Override
    public byte[] encrypt(byte[] bytes) {
        return bytes;
    }
}
