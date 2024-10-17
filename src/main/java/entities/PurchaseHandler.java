package entities;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class PurchaseHandler {

    private LocalDate deliveryStartDate;
    private LocalDate deliveryEndDate;

    public void setDeliveryTimeWindow (LocalDate start, LocalDate end) {
        this.deliveryStartDate = start;
        this.deliveryEndDate= end;
        System.out.println("the delivery time window is between "+this.deliveryStartDate+" and "+ this.deliveryEndDate);
    }

    public double calculateTotal(List<Item> items, String voucher, String membership, String address) {

        double total = 0;

        // sum up totals
        for (Item item : items) {
            total+= item.getPrice();
        }

        // check voucher
        if (voucher.equalsIgnoreCase("DISCOUNT") || voucher.equalsIgnoreCase("CHEAPER")) {
            total = BigDecimal.valueOf(total*0.95).setScale(2).doubleValue();
        } else {
            System.out.println("Voucher Invalid");
        }

        // handle delivery fee
        if (membership.equalsIgnoreCase("GOLD")){
            System.out.println("Gold membership");
        } else {
            if (address.contains("TUN")) {
                total+=10;
            } else {
                total+=30;
            }
        }

        return total;
    }
}
