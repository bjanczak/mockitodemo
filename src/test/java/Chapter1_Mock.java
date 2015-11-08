import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import data.Invoice;
import data.InvoiceRepository;
import data.InvoiceService;
import data.Item;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Matchers;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;

import static org.mockito.Mockito.*;

/**
 *  Mockito has certain limitations. It can not test the following constructs:
 *  - final classes
 *  - anonymous classes
 *  - primitive types
 *
 * @author Bartłomiej Jańczak
 */
public class Chapter1_Mock {

    @Test
    public void tesDummy() {
        Invoice invoice = mock(Invoice.class);

        InvoiceRepository invoiceRepository = new InvoiceRepository();
        invoiceRepository.addInvoice(invoice);

        Assert.assertEquals(invoiceRepository.getNumberOfInvoices(), Integer.valueOf(1));
    }

    @Test
    public void testStub() {
        Item item1 = new Item("Żywiec", BigDecimal.valueOf(2.60));
        Item item2 = new Item("Żubr", BigDecimal.valueOf(2.10));
        Item item3 = new Item("Mocne Full", BigDecimal.valueOf(1.60));

        Invoice invoice = mock(Invoice.class);
        when(invoice.getItemsList()).thenReturn(ImmutableList.<Item>builder()
                .add(item1)
                .add(item2)
                .add(item3)
                .build());

        InvoiceService invoiceService = new InvoiceService();
        Assert.assertEquals(invoiceService.getHighestPricedItem(invoice), item1);
    }

    @Test
    public void testMultipleReturnValue() {
        Iterator iterator = mock(Iterator.class);

        when(iterator.next())
                .thenReturn("Żywiec")
                .thenReturn("Żubr")
                .thenReturn("Mocne Full");

        String result = iterator.next() + " " + iterator.next() + " " + iterator.next();

        Assert.assertEquals(result, "Żywiec Żubr Mocne Full");
    }

    @Test
    public void testReturnValueDependentOnParameter() {
        List list = mock(List.class);

        when(list.get(0)).thenReturn("Żywiec");
        when(list.get(1)).thenReturn("Żubr");
        when(list.get(2)).thenReturn("Mocne Full");

        Assert.assertEquals(list.get(0), "Żywiec");
        Assert.assertEquals(list.get(1), "Żubr");
        Assert.assertEquals(list.get(2), "Mocne Full");
    }

    @Test
    public void testReturnValueInDependentOfParameter() {
        List list = mock(List.class);

        when(list.get(anyInt())).thenReturn("Żywiec");

        Assert.assertEquals(list.get(10), "Żywiec");
    }

    @Test
    public void testReturnValueInDependentOfParameterType() {
        List list = mock(List.class);

        when(list.contains(isA(Integer.class))).thenReturn(Boolean.FALSE);

        Assert.assertEquals(list.contains(10), Boolean.FALSE);
    }

    @Test(expected=IOException.class)
    public void testThrowIOException() throws IOException {
        OutputStream mockStream = mock(OutputStream.class);

        doThrow(new IOException()).when(mockStream).close();

        new OutputStreamWriter(mockStream).close();
    }

    @Test
    public void testVerify() {
        List list = mock(List.class);

        when(list.get(1)).thenReturn("Żubr");


        list.size();
        list.size();
        list.add("Perła");


        verify(list).add(Matchers.eq("Perła"));

        verify(list, times(2)).size();

        verify(list, never()).clear();

        verify(list, atLeastOnce()).size();

        verify(list, atLeast(2)).size();

        verify(list, atMost(3)).add("Perła");
    }

    @Test public void testSpy() {
        List list = Lists.newLinkedList();
        List spy = spy(list);

        doReturn("foo").when(spy).get(0);

        when(spy.get(0)).thenReturn("foo");

        Assert.assertEquals(spy.get(0), "foo");

        verify(spy).get(0);
        verifyNoMoreInteractions(spy);
    }
}
