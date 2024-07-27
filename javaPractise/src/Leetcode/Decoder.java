package Leetcode;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

    public class Decoder {

        public static String decode(String messageFile) {
            StringBuilder decodedMessage = new StringBuilder();

            try (BufferedReader reader = new BufferedReader(new FileReader(messageFile))) {
                String line;
                int lineNumber = 1;
                int targetNumber = 1;

                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split("\\s+", 2); // Split by whitespace, limit to 2 parts
                    int currentNumber = Integer.parseInt(parts[0]);

                    if (currentNumber == targetNumber) {
                        decodedMessage.append(parts[1]).append(" ");
                        targetNumber++;
                    }

                    lineNumber++;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            return decodedMessage.toString().trim();
        }

        public static void main(String[] args) {
            String messageFile = "path/to/your/message_file.txt";
            String decodedMessage = decode(messageFile);
            System.out.println(decodedMessage);
        }
    }


