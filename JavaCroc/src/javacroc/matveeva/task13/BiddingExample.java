package javacroc.matveeva.task13;

import java.util.List;

public class BiddingExample {

    public static void main(String[] args) {
        LotFileReader lotFileReader = new LotFileReader();
        AuctionLot lot = lotFileReader.readLotInfoFromFile("src/javacroc/matveeva/task13/lot.txt");

        if (lot != null) {
            List<String> participants = new ParticipantFileReader().readParticipantsFromFile("src/javacroc/matveeva/task13/participants.txt");

            for (String participant : participants) {
                Thread thread = new Thread(() -> {
                    for (int i = 0; i < 100; i++) {
                        int bidAmount = lot.getCurrentBid() + (int) (Math.random() * 1000);
                        boolean result = lot.placeBid(participant, bidAmount);
                        if (result) {
                            System.out.println(participant + " сделал ставку " + bidAmount);
                        }
                        try {
                            Thread.sleep(100); // пауза между ставками
                        } catch (InterruptedException e) {
                            System.err.println("Ошибка" + e.getMessage());
                        }
                    }
                });
                thread.start();
            }

            try {
                Thread.sleep(60000); // подождать до объявления победителя
            } catch (InterruptedException e) {
                System.err.println("Ошибка" + e.getMessage());
            }

            System.out.println("Победитель аукциона: " + lot.getWinner() + " со ставкой " + lot.getCurrentBid());
        } else {
            System.out.println("Ошибка");
        }
    }
}

