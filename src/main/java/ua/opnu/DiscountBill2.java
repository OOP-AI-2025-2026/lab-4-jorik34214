import ua.opnu.java.inheritance.bill.Employee;
import ua.opnu.java.inheritance.bill.GroceryBill;
import ua.opnu.java.inheritance.bill.Item;

public final class DiscountBill2 {
    private final GroceryBill bill;
    private final boolean regularCustomer;
    private int discountCount = 0;
    private double discountAmount = 0.0;

    private static final double PERCENT_MULTIPLIER = 100.0;

    public DiscountBill2(final Employee clerk, final boolean regularCustomer) {
        this.bill = new GroceryBill(clerk);
        this.regularCustomer = regularCustomer;
    }

    public void add(final Item i) {
        bill.add(i);

        if (regularCustomer) {
            final double itemDiscount = i.getDiscount();
            if (itemDiscount > 0.0) {
                discountCount++;
                discountAmount += itemDiscount;
            }
        }
    }

    public double getTotal() {
        final double totalFullPrice = bill.getTotal();

        if (regularCustomer) {
            return totalFullPrice - discountAmount;
        }
        return totalFullPrice;
    }

    public int getDiscountCount() {
        return regularCustomer ? discountCount : 0;
    }

    public double getDiscountAmount() {
        return regularCustomer ? discountAmount : 0.0;
    }

    public double getDiscountPercent() {
        final double totalFullPrice = bill.getTotal();

        if (!regularCustomer || totalFullPrice == 0.0) {
            return 0.0;
        }

        return (discountAmount * PERCENT_MULTIPLIER) / totalFullPrice;
    }

    public Employee getClerk() {
        return bill.getClerk();
    }
}
