import java.util.Scanner;

public class Auction {
    Publisher publisher;
    Scanner inputNumber;
    Scanner inputString;

    public Auction() {
        inputNumber = new Scanner(System.in);
        inputString = new Scanner(System.in);

        publisher = new Publisher();
    }

    public void preparation() {
        while (true) {
            System.out.println("Auction Preparation Stage:");
            System.out.println("#1 Add Bidders");
            System.out.println("#2 Remove Bidders");
            System.out.println("#3 View All Bidders");
            System.out.println("#4 Preparation Done!");
            System.out.print("Enter option: ");

            int option = inputNumber.nextInt();
            String name;

            switch (option) {
                case 1:
                    System.out.print("Enter Name: ");
                    name = inputString.nextLine();
                    publisher.addSubscriber(new SubscriberBidder(name));
                    break;
                case 2:
                    System.out.print("Enter Name: ");
                    name = inputString.nextLine();
                    publisher.removeSubscriber(name);
                    break;
                case 3:
                    publisher.viewSubscriber();
                    break;
                case 4:
                    return;
            }
        }
    }

    public void bid() {
        System.out.println("Auction has begun !!!");
        while (true) {
            System.out.println("#1 Place Bid\n#2 End Bid");
            System.out.print("Enter option: ");

            int option = inputNumber.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Enter Name: ");
                    String name = inputString.nextLine();
                    System.out.print("Enter Bid: ");
                    int bid = inputNumber.nextInt();

                    publisher.setBid(name, bid);
                    break;
                case 2:
                    if (publisher.currentBid == 100) System.out.println("--> Item Unsold");
                    else System.out.println("--> Item sold to " + publisher.highestBidder + " for $" + publisher.currentBid);
                    return;
            }
        }
    }

}
