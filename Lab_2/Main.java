package nelsonni;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * Main interactive program that queries the user for the desired input.
 */
public class Main {
    private static final boolean DEBUG = false;

    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(System.in);
            boolean encrypt;
            String direction;
            System.out.print("E)ncrypt or D)ecrypt: ");
            direction = in.nextLine().toLowerCase();
            if (direction.equals("e")) {
                encrypt = true;
            } else if (direction.equals("d")) {
                encrypt = false;
            } else {
                throw new CrypArgumentException("Unknown direction: " + direction);
            }
            System.out.print("Method (rev, shift, xor): ");
            String method = in.nextLine().toLowerCase();
            Encrypter encrypter;
            if (method.equals("none")) {
                encrypter = new NullEncrypter();
            } else if (method.equals("rev")) {
                encrypter = new ReverseEncrypter();
            } else if (method.equals("shift")) {
                System.out.print("Shift amount: ");
                String line = in.nextLine();
                Scanner lineScanner = new Scanner(line);
                if(!lineScanner.hasNextInt()) {
                    throw new CrypArgumentException("Non-integer shift:"+line);
                }
                int shiftAmount = lineScanner.nextInt();
                encrypter = new ShiftEncrypter(shiftAmount);
            } else if (method.equals("xor")) {
                System.out.print("Key: ");
                String key = in.nextLine();
                encrypter = new XOREncrypter(key.getBytes(StandardCharsets.UTF_8));
            } else {
                throw new CrypArgumentException("Unknown method: " + direction);
            }
            System.out.println("Message: ");
            StringBuilder message = new StringBuilder();
            while(in.hasNextLine()) {
                message.append(in.nextLine()+"\n");
            }


            CrypStick stick = new CrypStick(encrypter);

            if(encrypt) {
                stick.setMessage(message.toString());
                if (DEBUG) {
                    // Set DEBUG to false at the top of this file to disable these messages in your
                    // final submission.
                    System.out.println("DEBUG: stick.getMessage() = " + stick.getMessage());
                    System.out.println("DEBUG: stick.getMedia() = " + stick.getMedia());
                    System.out.println(
                            "DEBUG: new String(stick.getMedia().get(), StandardCharsets.UTF_8) = "
                            + new String(stick.getMedia().get(), StandardCharsets.UTF_8));
                }
                System.out.println(stick.getMedia());
            } else { // decrypt
                stick.getMedia().set(message.toString());
                System.out.println(stick.getMessage());
            }
        } catch (CrypArgumentException e) {
            System.out.println("Error: "+e.getMessage());
        }
    }
}
