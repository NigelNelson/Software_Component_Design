/*
 * Course: SE2811
 * Winter 2020 - 031
 * Lab 2: CrypStick
 * Name: Nigel Nelson
 * Created: 12/10/20
 */
package nelsonni;

/**
 * Class whose encryption/decryption method is adding/subtracting a given number
 */
public class ShiftEncrypter implements Encrypter {

    /**
     * The largest number that can be represented by 8 bits
     */
    private static final int EIGHT_BIT_MAX = 255;
    private int amount;
    private byte byteAmount;

    /**
     * Constructor for ShiftEncrypter
     * @param amount the number that will be added/subtracted from each byte
     */
    public ShiftEncrypter(int amount) {
        this.amount = amount;
        byteAmount = (byte) amount;
    }

    @Override
    public byte[] decrypt(byte[] bytes) {
        byte[] decrypterBytes = new byte[bytes.length];
        for (int i = 0; i < bytes.length; i++){
            decrypterBytes[i] = (byte) ((bytes[i] - byteAmount)%EIGHT_BIT_MAX);
        }
        return decrypterBytes;
    }

    @Override
    public byte[] encrypt(byte[] bytes) {
        byte[] encrypterBytes = new byte[bytes.length];
        for (int i = 0; i < bytes.length; i++){
            encrypterBytes[i] = (byte) ((bytes[i] + byteAmount)%EIGHT_BIT_MAX);
        }
        return encrypterBytes;
    }
}
