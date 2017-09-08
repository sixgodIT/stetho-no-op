/*
 * Copyright (c) 2014-present, Facebook, Inc.
 * All rights reserved.
 *
 * This source code is licensed under the BSD-style license found in the
 * LICENSE file in the root directory of this source tree. An additional grant
 * of patent rights can be found in the PATENTS file in the same directory.
 */

package com.facebook.stetho.urlconnection;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;


public class StethoURLConnectionManager {

    public StethoURLConnectionManager(String friendlyName) {
    }

    public boolean isStethoEnabled() {
        return false;
    }

    /**
     * Indicates that the {@link HttpURLConnection} instance has been configured and is about
     * to be used to initiate an actual HTTP connection.  Call this method before any of the
     * active methods such as {@link HttpURLConnection#connect()},
     * {@link HttpURLConnection#getInputStream()}, or {@link HttpURLConnection#getOutputStream()}
     *
     * @param connection    Connection instance configured with a method and headers.
     * @param requestEntity Represents the request body if the request method supports it.
     */
    public void preConnect(
            HttpURLConnection connection,
            SimpleRequestEntity requestEntity) {

    }

    /**
     * Indicates that the {@link HttpURLConnection} has just successfully exchanged HTTP messages
     * (request headers + body and response headers) with the server but has not yet consumed
     * the response body.
     *
     * @throws IOException May throw an exception internally due to {@link HttpURLConnection}
     *                     method signatures.  The request should be considered aborted/failed if this method
     *                     throws.
     */
    public void postConnect() throws IOException {
    }

    /**
     * Indicates that there was a non-recoverable failure during HTTP message exchange at some
     * point between {@link #preConnect} and {@link #interpretResponseStream}.
     *
     * @param ex Relay the exception that was thrown from {@link HttpURLConnection}
     */
    public void httpExchangeFailed(IOException ex) {
    }

    /**
     * Deliver the response stream from {@link HttpURLConnection#getInputStream()} to
     * Stetho so that it can be intercepted.  Note that compression is transparently
     * supported on modern Android systems and no special awareness is necessary for
     * gzip compression on the wire.  Unfortunately this means that it is sometimes impossible
     * to determine whether compression actually occurred and so Stetho may report inflated
     * byte counts.
     * <p>
     * If the {@code Content-Length} header is provided by the server, this will be assumed to be
     * the raw byte count on the wire.
     *
     * @param responseStream Stream as furnished by {@link HttpURLConnection#getInputStream()}.
     * @return The filtering stream which is to be read after this method is called.
     */
    public InputStream interpretResponseStream(InputStream responseStream) {
        return responseStream;
    }

    public String getStethoRequestId() {
        return "";
    }
}
