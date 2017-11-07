package com.github.mavogel.ilias.lib.wrapper;/*
 *  The MIT License (MIT)
 *
 *  Copyright (c) 2017 Manuel Vogel
 *
 *  Permission is hereby granted, free of charge, to any person obtaining a copy
 *  of this software and associated documentation files (the "Software"), to deal
 *  in the Software without restriction, including without limitation the rights
 *  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *  copies of the Software, and to permit persons to whom the Software is
 *  furnished to do so, subject to the following conditions:
 *
 *  The above copyright notice and this permission notice shall be included in all
 *  copies or substantial portions of the Software.
 *
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 *  SOFTWARE.
 *
 *  https://opensource.org/licenses/MIT
 */

import com.github.mavogel.ilias.lib.EndpointBuilder;
import com.github.mavogel.ilias.lib.model.LoginConfiguration;
import com.github.mavogel.ilias.lib.wrapper.soap.SoapEndpoint;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * Created by mavogel on 11/6/17.
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({EndpointBuilder.class, SoapEndpoint.class})
public class EndpointBuilderTest {

    @Test
    public void shouldCreateASoapEndpoint() throws Exception {
        // == prepare
        LoginConfiguration loginConfiguration = LoginConfiguration.asLDAPLogin("ep", "client", "user", "pass", 5);

        // == train
        PowerMockito.whenNew(SoapEndpoint.class).withArguments(loginConfiguration).thenReturn(PowerMockito.mock(SoapEndpoint.class));

        // == go
        AbstractIliasEndpoint endpoint =
                EndpointBuilder.build(EndpointBuilder.Type.SOAP, loginConfiguration);

        // == verify
        assertNotNull(endpoint);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExceptionDueToRestEndpointNotImplemented() throws Exception {
        // == prepare
        LoginConfiguration loginConfiguration = LoginConfiguration.asLDAPLogin("ep", "client", "user", "pass", 5);

        // == go
        EndpointBuilder.build(EndpointBuilder.Type.REST, loginConfiguration);
        fail();
    }

    @Test(expected = NullPointerException.class)
    public void shouldThrowExceptionDueToNullEndpointType() throws Exception {
        // == prepare
        LoginConfiguration loginConfiguration = LoginConfiguration.asLDAPLogin("ep", "client", "user", "pass", 5);

        // == go
        try {
            EndpointBuilder.build(null, loginConfiguration);
        } catch (Exception e) {
            assertTrue(e.getMessage().contains("Endpoint.Type cannot be null"));
            throw e;
        }
    }
}
