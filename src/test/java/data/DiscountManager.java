package data;

/**
 * @author Bartłomiej Jańczak
 */
public class DiscountManager {

    private final DiscountCalculator discountCalculator;
    private final DiscountRepository discountRepository;

    public DiscountManager(DiscountCalculator discountCalculator, DiscountRepository discountRepository) {
        this.discountCalculator = discountCalculator;
        this.discountRepository = discountRepository;
    }

    public void initialize() {
        discountRepository.addlistener(new DiscountListener());
    }
}
