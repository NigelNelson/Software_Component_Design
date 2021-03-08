/*
 * Course: SE2811
 * Winter 2020 - 031
 * Lab 2: CrypStick
 * Name: Nigel Nelson
 * Created: 12/10/20
 */
package nelsonni;

/**
 * Class that reverses a message as an encryption and decryption method
 */
public class ReverseEncrypter implements Encrypter {
    @Override
    public byte[] decrypt(byte[] bytes) {
        byte[] decrypterBytes = new byte[bytes.length];
        for (int i = 0; i < bytes.length; i++){
            decrypterBytes[i] = bytes[bytes.length - 1 - i];
        }
        return decrypterBytes;
    }

    @Override
    public byte[] encrypt(byte[] bytes) {
        byte[] decrypterBytes = new byte[bytes.length];
        for (int i = 0; i < bytes.length; i++){
            decrypterBytes[i] = bytes[bytes.length - 1 - i];
        }
        return decrypterBytes;
    }
}
