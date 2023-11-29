package javacroc.matveeva.task13;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

class AuctionLot {
    private final AtomicInteger currentPrice;
    private final AtomicReference<String> highestBidder;
    private final long endTime;

    public AuctionLot(int startingPrice, long durationInSeconds) {
        this.currentPrice = new AtomicInteger(startingPrice);
        this.highestBidder = new AtomicReference<>("");
        this.endTime = System.currentTimeMillis() + (durationInSeconds * 1000);
    }

    public boolean placeBid(String bidderName, int bidAmount) {
        long currentTime = System.currentTimeMillis();
        if (currentTime < endTime && bidAmount > currentPrice.get()) {
            if (currentPrice.compareAndSet(currentPrice.get(), bidAmount)) {
                highestBidder.set(bidderName);
                return true;
            }
        }
        return false;
    }

    public int getCurrentBid() {
        return currentPrice.get();
    }

    public String getWinner() {
        return highestBidder.get().isEmpty() ? "No winner yet" : highestBidder.get();
    }

}
