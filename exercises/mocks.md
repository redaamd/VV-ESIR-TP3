# Mocks to the rescue

The classes `SSLSocket`, `TLSProtocol` and `TLSSocketFactory` are included in the `sockets` package of the [`tp3-ssl`](../code/tp3-ssl) project.

The test class `TLSSocketFactoryTest` tests `TLSSocketFactory` and manually builds stubs and mocks for SSLSocket objects.

Rewrite these tests with the help of Mockito.

The initial tests fail to completely test the `TLSSockeetFactory`. In fact, if we *entirely* remove the code inside the body of `prepareSocket` no test case fails.

Propose a solution to this problem in your new Mockito-based test cases.

## Answer

To rewrite the `TLSSocketFactoryTest` using Mockito, we can mock the behavior of the `SSLSocket` interface to simulate different scenarios and verify interactions. So we refactored the test class using Mockito (the code is available in the code folder) 

**Explanations:**

1. Mocking with Mockito: We create a mock for the `SSLSocket` interface using `Mockito.mock()`. That would enable us to specify what that mock should return in case, for example, `getSupportedProtocols()` and `getEnabledProtocols()` are called.

2. Verification of interactions: After `prepareSocket()` is called, check that indeed `setEnabledProtocols()` has been called with the right arguments so that the socket can be prepared correctly.

3. Edge cases handling: The test `testPrepareSocket_NullProtocols()` checked that in the case of both supported and enabled protocols being null, the method `setEnabledProtocols()` was never called-a significant edge case.

This approach handles the original problem when one could remove logic from `prepareSocket` without failing the tests by covering key interactions.


**Explanation of the Tests:**

`testPrepareSocket_NullProtocols:`
This test aims to verify what happens when the socket returns null for both supported and enabled protocols. The test ensures that setEnabledProtocols() is never called, thus performing a check that the factory does nothing in such a case.

`testPrepareSocket_Typical:`
Here, it tests the typical case where the socket supports many protocols, but only some of them are enabled.
Immediately after the call to the prepareSocket, the test checks that-setEnabledProtocols() is invoked with the appropriate protocols, listed in order of the TLS security levels in force.

`testPrepareSocket_AllSupportedProtocols:`
The test handles the case in which the socket already supports all the required protocols (TLSv1 and TLSv1.2); in this scenario, the prepareSocket must correctly enable the appropriate subset of the protocols.

And finally as we can see when we ran the new refactored the test class it worked : 

![test](https://github.com/user-attachments/assets/d8aac8c5-adcb-4cb4-81c3-77aa1bda1233)



