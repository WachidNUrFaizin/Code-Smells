import entities.Customer;
import entities.Item;
import entities.PurchaseHandler;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class App {

    public static void main(String[] args) {

        // initialize customer
        Customer customer = new Customer("MHZ","GOLD","adresse, TUN");
        String membership = customer.getMembership();
        String address = customer.getAddress();

        // initialize shopping list
        List<Item> shoppingList = Arrays.asList(new Item(10), new Item(50), new Item(40));

        // calculate total
        PurchaseHandler purchaseHandler = new PurchaseHandler();
        double total = purchaseHandler.calculateTotal(shoppingList,"voucher",membership, address);
        System.out.println("Total is "+total);
        purchaseHandler.setDeliveryTimeWindow(LocalDate.now().plusDays(1),LocalDate.now().plusDays(3));
    }
}
