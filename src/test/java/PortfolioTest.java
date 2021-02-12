import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class PortfolioTest {

    @Test
    public void price() {
        Stocks tsla = mock(Stocks.class);
        when(tsla.getCurrentPrice()).thenReturn(3.0);
        assertEquals(5.0, tsla.getCurrentPrice(),"price not the same");

    }
    @Test
    void testPrice() {
    }
}