package fr.istic.vv;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TLSSocketFactoryTestMocks {
  
  @Test
    public void testPrepareSocket_NullProtocols() {
        // Create a mock SSLSocket
        SSLSocket mockSocket = Mockito.mock(SSLSocket.class);

        // Configure the mock to return null for both methods
        when(mockSocket.getSupportedProtocols()).thenReturn(null);
        when(mockSocket.getEnabledProtocols()).thenReturn(null);

        // Instantiate TLSSocketFactory
        TLSSocketFactory factory = new TLSSocketFactory();

        // Call prepareSocket and verify setEnabledProtocols was never called
        factory.prepareSocket(mockSocket);
        verify(mockSocket, never()).setEnabledProtocols(any());
    }

    @Test
    public void testPrepareSocket_Typical() {
        // Create a mock SSLSocket
        SSLSocket mockSocket = Mockito.mock(SSLSocket.class);

        // Define mock behavior for supported and enabled protocols
        when(mockSocket.getSupportedProtocols()).thenReturn(new String[] {"SSLv3", "TLSv1", "TLSv1.1", "TLSv1.2"});
        when(mockSocket.getEnabledProtocols()).thenReturn(new String[] {"SSLv3", "TLSv1"});

        // Instantiate TLSSocketFactory
        TLSSocketFactory factory = new TLSSocketFactory();

        // Call prepareSocket
        factory.prepareSocket(mockSocket);

        // Verify that setEnabledProtocols was called with the correct order of protocols
        verify(mockSocket).setEnabledProtocols(new String[]{"TLSv1.2", "TLSv1.1", "TLSv1", "SSLv3"});
    }

    @Test
    public void testPrepareSocket_AllSupportedProtocols() {
        // Create a mock SSLSocket
        SSLSocket mockSocket = Mockito.mock(SSLSocket.class);

        // Simulate supported and enabled protocols
        when(mockSocket.getSupportedProtocols()).thenReturn(new String[] {"TLSv1", "TLSv1.2"});
        when(mockSocket.getEnabledProtocols()).thenReturn(new String[] {"TLSv1"});

        // Instantiate TLSSocketFactory
        TLSSocketFactory factory = new TLSSocketFactory();

        // Call prepareSocket
        factory.prepareSocket(mockSocket);

        // Verify that setEnabledProtocols was called with the correct order of protocols
        verify(mockSocket).setEnabledProtocols(new String[]{"TLSv1.2", "TLSv1"});
    }


}
