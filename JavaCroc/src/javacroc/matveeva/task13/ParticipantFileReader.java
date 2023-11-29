package javacroc.matveeva.task13;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class ParticipantFileReader {
    public List<String> readParticipantsFromFile(String filePath) {
        List<String> participants = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                participants.add(line.trim()); // Добавление участника в список
            }
        } catch (IOException e) {
            System.err.println("Ошибка чтения файла с участниками: " + e.getMessage());
        }
        return participants;
    }
}