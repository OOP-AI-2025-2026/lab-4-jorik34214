import ua.opnu.java.inheritance.bill.Employee;
import ua.opnu.java.inheritance.bill.GroceryBill;
import ua.opnu.java.inheritance.bill.Item;

public final class DiscountBill extends GroceryBill {
    private final boolean regularCustomer;
    private int discountCount = 0;
    private double discountAmount = 0.0;

    private static final double PERCENT_MULTIPLIER = 100.0;

    public DiscountBill(final Employee clerk, final boolean regularCustomer) {
        super(clerk);
        this.regularCustomer = regularCustomer;
    }

    @Override
    public void add(final Item i) {
        super.add(i);

        if (regularCustomer) {
            final double itemDiscount = i.getDiscount();
            if (itemDiscount > 0.0) {
                discountCount++;
                discountAmount += itemDiscount;
            }
        }
    }

    @Override
    public double getTotal() {
        final double totalFullPrice = super.getTotal();

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
        final double totalFullPrice = super.getTotal();

        if (!regularCustomer || totalFullPrice == 0.0) {
            return 0.0;
        }

        return (discountAmount * PERCENT_MULTIPLIER) / totalFullPrice;
    }
}