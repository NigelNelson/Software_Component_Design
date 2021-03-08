/*
 * Course: SE2811
 * Winter 2020 - 031
 * Lab 2: CrypStick
 * Name: Nigel Nelson
 * Created: 12/10/20
 */
package nelsonni;

/**
 * Class that uses the XOR operation for encryption/decryption
 */
public class XOREncrypter implements Encrypter {
    private byte[] key;

    /**
     * Constructor for XOREncrypter
     * @param key the byte array reprsentation of a key entered by the user
     */
    public XOREncrypter(byte[] key) {
        this.key = key;
    }

    @Override
    public byte[] decrypt(byte[] bytes) {
        byte[] decrypterBytes = new byte[bytes.length];
        for (int i = 0; i < bytes.length; i++){
            decrypterBytes[i] = (byte) (bytes[i]^key[i% key.length]);
        }
        return decrypterBytes;
    }

    @Override
    public byte[] encrypt(byte[] bytes) {
        byte[] encrypterBytes = new byte[bytes.length];
        for (int i = 0; i < bytes.length; i++){
            encrypterBytes[i] = (byte) (bytes[i]^key[i% key.length]);
        }
        return encrypterBytes;
    }
}
