public interface ISubscriber {

    public String getName();
    public abstract void update(String highestBidder, int currentBid);

}
