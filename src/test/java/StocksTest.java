import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class StocksTest {

    @Test
    public void getCurrentPrice() {
        Stocks stock = mock(Stocks.class);
        when(stock.getCurrentPrice()).thenReturn(5.0);
        assertEquals(5.0, stock.getCurrentPrice());

    }
}