package data;

import com.google.common.collect.Sets;

import java.util.Set;

/**
 * @author Bartłomiej Jańczak
 */
public class InvoiceRepository {
    Set<Invoice> invoiceRepository = Sets.newHashSet();

    public void addInvoice(Invoice invoice) {
        invoiceRepository.add(invoice);
    }

    public Integer getNumberOfInvoices() {
        return invoiceRepository.size();
    }
}
