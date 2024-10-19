package br.edu.fatec.sjc;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class NumberAscOrderTest {

    @Mock
    CustomStack<Integer> customStack;

    @InjectMocks
    private NumberAscOrder<Integer> numberAscOrder;



    @Test
    public void deveOrdenarPilhaDeFormaCrescente() throws StackEmptyException {
        when(customStack.size()).thenReturn(6);
        when(customStack.pop()).thenReturn(5,8,20,14,149,1);

        List<Integer> sortedNumbers = numberAscOrder.sort();

        List<Integer> expectedOrder = Arrays.asList(1,5,8,14,20,149);
        assertEquals(expectedOrder, sortedNumbers);

        verify(customStack, times(6)).pop();
    }

    @Test
    public void deveLancarExceptionParaPilhaVazia() throws StackEmptyException {
        when(customStack.isEmpty()).thenReturn(true);
        assertThrows(StackEmptyException.class, numberAscOrder::sort);
    }
}