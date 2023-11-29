package javacroc.matveeva.task13;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class LotFileReader {
    public AuctionLot readLotInfoFromFile(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String lotName = br.readLine();
            int startingPrice = Integer.parseInt(br.readLine());

            // Дополнительные проверки формата данных
            if (lotName == null || startingPrice <= 0) {
                throw new IllegalArgumentException("Неккоректные данные в файле лота");
            }

            return new AuctionLot(startingPrice, 60);
        } catch (IOException e) {
            System.err.println("Ошибка считывания лота из файла: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.err.println("Неккоректный формат в файле лота: " + e.getMessage());
        }

        return null;
    }
}
