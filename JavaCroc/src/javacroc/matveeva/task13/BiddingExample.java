package javacroc.matveeva.task13;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BiddingExample {

    public static void main(String[] args) {
        String[] lotInfo = readLotInfoFromFile("src/javacroc/matveeva/task13/lot.txt");
        String lotName = lotInfo[0];
        int startingPrice = Integer.parseInt(lotInfo[1]);

        AuctionLot lot = new AuctionLot(startingPrice, 60);

        List<String> participants = readParticipantsFromFile("src/javacroc/matveeva/task13/participants.txt");

        for (String participant : participants) {
            Thread thread = new Thread(() -> {
                for (int i = 0; i < 100; i++) {
                    int bidAmount = lot.getCurrentBid() + (int) (Math.random() * 1000);
                    boolean result = lot.placeBid(participant, bidAmount);
                    if (result) {
                        System.out.println(participant + " placed a bid of " + bidAmount);
                    } else {
                        System.out.println(participant + " failed to place a higher bid");
                    }
                    try {
                        TimeUnit.MILLISECONDS.sleep(100); // пауза между ставками
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            thread.start();
        }


        try {
            Thread.sleep(65000); // подождать до объявления победителя
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Auction Winner: " + lot.getWinner() + " with a bid of " + lot.getCurrentBid());
    }

    private static String[] readLotInfoFromFile(String filePath) {
        String[] lotInfo = new String[2];
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            lotInfo[0] = br.readLine().trim();
            lotInfo[1] = br.readLine().trim();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lotInfo;
    }

    private static List<String> readParticipantsFromFile(String filePath) {
        List<String> participants = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                participants.add(line.trim());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return participants;
    }


}
