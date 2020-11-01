import java.util.ArrayList;
import java.util.List;

public class Publisher {
    List<ISubscriber> bidders;
    int currentBid;
    String highestBidder;

    public Publisher() {
        bidders = new ArrayList<>();
        currentBid  = 100;
    }

    public void addSubscriber(ISubscriber newBidder) {
        bidders.add(newBidder);
        System.out.println("--> A bidder has been added");
    }

    public void removeSubscriber(String bidderName) {
        for (ISubscriber bidder: bidders) {
            if (bidder.getName().equals(bidderName)) {
                bidders.remove(bidder);
                System.out.println("--> " + bidderName + " has been removed");
                return;
            }
        }

        System.out.println("--> Bidder is not present in the list");
    }

    public void viewSubscriber() {
        for (ISubscriber bidder: bidders) System.out.println("--> " + bidder.getName());
    }

    public void notifySubscribers() {
        for (ISubscriber bidder: bidders) {
            bidder.update(highestBidder, currentBid);
        }
    }

    public void setBid(String bidderName, int bid) {

        for (ISubscriber bidder: bidders) {
            if (bidder.getName().equals(bidderName)) {
                if(bid <= currentBid) {
                    System.out.println("--> Bid can not be less than or equal to current bid");
                }
                else {
                    currentBid = bid;
                    highestBidder = bidderName;
                    notifySubscribers();
                }
                return;
            }
        }
        System.out.println("--> Invalid Bidder Name!");
    }
}
