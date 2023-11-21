package javacroc.matveeva.task13;

import java.util.concurrent.locks.ReentrantLock;

class AuctionLot {
    private int currentPrice;
    private String highestBidder;
    private long endTime;
    private final ReentrantLock lock;

    public AuctionLot(int startingPrice, long durationInSeconds) {
        this.currentPrice = startingPrice;
        this.endTime = System.currentTimeMillis() + (durationInSeconds * 1000);
        this.lock = new ReentrantLock();
    }

    public boolean placeBid(String bidderName, int bidAmount) {
        lock.lock();
        try {
            long currentTime = System.currentTimeMillis();
            if (currentTime < endTime && bidAmount > currentPrice) {
                currentPrice = bidAmount;
                highestBidder = bidderName;
                return true;
            }
            return false;
        } finally {
            lock.unlock();
        }
    }

    public int getCurrentBid() {
        lock.lock();
        try {
            return currentPrice;
        } finally {
            lock.unlock();
        }
    }

    public String getWinner() {
        lock.lock();
        try {
            return highestBidder != null ? highestBidder : "No winner yet";
        } finally {
            lock.unlock();
        }
    }
}