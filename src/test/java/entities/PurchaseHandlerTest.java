package entities;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

public class PurchaseHandlerTest {

    private PurchaseHandler purchaseHandler = new PurchaseHandler();

    @Test
    public void should_calculate_total_without_voucher_and_membership_and_not_in_TUN() {

        List<Item> items = Arrays.asList(new Item(40), new Item(10));
        String voucher = "lol";
        String membership = "SILVER";
        String address = "address, US";

        //when
        double result = purchaseHandler.calculateTotal(items,voucher,membership,address);

        //then
        Assertions.assertThat(result).isEqualTo(80.0);
    }

    @Test
    public void should_calculate_total_without_voucher_and_membership_and_in_TUN() {
        //given
        List<Item> items = Arrays.asList(new Item(40), new Item(10));
        String voucher = "lol";
        String membership = "SILVER";
        String address = "address, TUN";

        double result = purchaseHandler.calculateTotal(items,voucher,membership,address);

        //then
        Assertions.assertThat(result).isEqualTo(60.0);
    }

    @Test
    public void should_calculate_total_without_voucher_and_gold_membership() {
        List<Item> items = Arrays.asList(new Item(40), new Item(10));
        String voucher = "lol";
        String membership = "GOLD";
        String address = "address, US";

        double result = purchaseHandler.calculateTotal(items,voucher,membership,address);

        Assertions.assertThat(result).isEqualTo(50.0);
    }

    @Test
    public void should_calculate_total_voucher_and_gold_membership() {
        //given
        List<Item> items = Arrays.asList(new Item(40), new Item(10));
        String voucher = "discount";
        String membership = "GOLD";
        String address = "address, US";

        //when
        double result = purchaseHandler.calculateTotal(items,voucher,membership,address);

        //then
        Assertions.assertThat(result).isEqualTo(47.5);
    }

    @Test
    public void should_set_window_time() {

        LocalDate start = LocalDate.of(2022, Month.JANUARY,20);
        LocalDate end = LocalDate.of(2022, Month.JANUARY,21);


        purchaseHandler.setDeliveryTimeWindow(start,end);


        Assertions.assertThat(purchaseHandler)
                .hasFieldOrPropertyWithValue("deliveryStartDate",start)
                .hasFieldOrPropertyWithValue("deliveryEndDate",end);
    }
}