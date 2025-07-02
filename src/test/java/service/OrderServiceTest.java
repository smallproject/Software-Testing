package service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)      // 🚀 Bootstraps Mockito in JUnit 5
class OrderServiceTest {

    @Mock                                 // 🎭 Creates a mock PaymentGateway
    PaymentGateway mockGateway;

    @InjectMocks                           // 🧩 Creates an OrderService and injects mockGateway
    OrderService service;

    @Test
    void chargeReturnsTrueWhenGatewaySucceeds() {
        // 🔧 Stub the behavior: when gateway.charge(100) is called, return true
        when(mockGateway.charge(100)).thenReturn(true);

        // 🧪 Execute the method under test
        boolean result = service.charge(new Order(100));

        // ✔️ Assert it did the right thing
        assertTrue(result);
    }

    @Test
    void chargeReturnsFalseWhenGatewayDeclines() {
        // simulate a declined payment
        when(mockGateway.charge(50)).thenReturn(false);
        assertFalse(service.charge(new Order(50)));
    }

    @Test
    void chargePropagatesExceptionsFromGateway() {
        // simulate an error (e.g. network down)
        when(mockGateway.charge(anyInt())).thenThrow(new RuntimeException("Payment network unreachable"));

        // assert that our service doesn't swallow the exception
        var order = new Order(200);
        var ex = assertThrows(RuntimeException.class, () -> service.charge(order));
        assertEquals("Payment network unreachable", ex.getMessage());
    }

    @Test
    void verifyGatewayIsCalledExactlyOnceWithCorrectAmount() {
        when(mockGateway.charge(123)).thenReturn(true);

        service.charge(new Order(123));

        // confirm we called charge(123) exactly once, no more, no less
        verify(mockGateway, times(1)).charge(123);
        verifyNoMoreInteractions(mockGateway);
    }
}

