package data;

import com.google.common.base.Preconditions;
import com.google.common.collect.FluentIterable;

import java.util.Comparator;

/**
 * @author Bartłomiej Jańczak
 */
public class InvoiceService {

    public Item getHighestPricedItem(Invoice invoice) {
        Preconditions.checkState(!invoice.getItemsList().isEmpty());
        return FluentIterable.from(invoice.getItemsList()).toSortedList(new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                return -1 * o1.getValue().compareTo(o2.getValue());
            }
        }).get(0);
    }
}
