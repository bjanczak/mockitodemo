import data.DiscountCalculator;
import data.DiscountListener;
import data.DiscountManager;
import data.DiscountRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;

/**
 * @author Bartłomiej Jańczak
 */
@RunWith(MockitoJUnitRunner.class)
public class Chapter2_MockInjection {

    @Mock
    private DiscountCalculator discountCalculator;
    @Mock
    private DiscountRepository discountRepository;

    @InjectMocks
    private DiscountManager discountManager;

    @Test
    public void testMockInjection() {

        discountManager.initialize();
        verify(discountRepository).addlistener(any(DiscountListener.class));
    }
}
