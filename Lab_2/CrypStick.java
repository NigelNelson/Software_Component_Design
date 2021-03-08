/*
 * Course: SE2811
 * Winter 2020 - 031
 * Lab 2: CrypStick
 * Name: Nigel Nelson
 * Created: 12/10/20
 */
package nelsonni;

import java.nio.charset.StandardCharsets;

/**
 * This class represents the USB stick.
 *
 * It accepts a message and stores it to the internal media.
 *
 * Think of it as a "secure SD card" adapter.
 */
public class CrypStick {
    private Media media;
    private Encrypter encrypter;

    /**
     * Constructor for the CrypStick
     * @param encrypter the encrypter that is to be used
     */
    public CrypStick(Encrypter encrypter) {
        media = new Media();
        this.encrypter = encrypter;
    }

    /**
     * Method that encrypts a message
     * @param message the message to be encrypted
     */
    public void setMessage(String message) {
        byte[] plaintext = message.getBytes(StandardCharsets.UTF_8);

        byte[] ciphertext = encrypter.encrypt(plaintext);
        media.set(ciphertext);
    }

    /**
     * Method that decrypts a message
     * @return the decrypted message
     */
    public String getMessage() {
        byte[] ciphertext = media.get();

        byte[] plaintext = encrypter.decrypt(ciphertext);
        return new String(plaintext, StandardCharsets.UTF_8);
    }

    /**
     * Getter for the media object
     * @return the media instance
     */
    protected Media getMedia() {
        return media;
    }
}
