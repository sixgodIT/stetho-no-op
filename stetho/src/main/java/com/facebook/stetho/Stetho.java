/*
 * Copyright (c) 2014-present, Facebook, Inc.
 * All rights reserved.
 *
 * This source code is licensed under the BSD-style license found in the
 * LICENSE file in the root directory of this source tree. An additional grant
 * of patent rights can be found in the PATENTS file in the same directory.
 */

package com.facebook.stetho;

import android.content.Context;

/**
 * Initialization and configuration entry point for the Stetho debugging system.  Simple usage with
 * default plugins and features enabled:
 * <p/>
 * <pre>
 *   Stetho.initializeWithDefaults(context)
 * </pre>
 * <p/>
 * For more advanced configuration, see {@link #newInitializerBuilder(Context)} or
 * the {@code stetho-sample} for more information.
 */
public class Stetho {
    private Stetho() {
    }

    public static InitializerBuilder newInitializerBuilder(Context context) {
        return new InitializerBuilder(context);
    }

    /**
     * Start the listening server.  Most of the heavy lifting initialization is deferred until the
     * first socket connection is received, allowing this to be safely used for debug builds on
     * even low-end hardware without noticeably affecting performance.
     */
    public static void initializeWithDefaults(final Context context) {

    }

    /**
     * Start the listening service, providing a custom initializer as per
     * {@link #newInitializerBuilder}.
     *
     * @see #initializeWithDefaults(Context)
     */
    public static void initialize(final Initializer initializer) {

    }

    public static DumperPluginsProvider defaultDumperPluginsProvider(final Context context) {
        return null;
    }

    public static InspectorModulesProvider defaultInspectorModulesProvider(final Context context) {
        return null;
    }

    /**
     * Callers can choose to subclass this directly to provide the initialization configuration
     * or they can construct a concrete instance using {@link #newInitializerBuilder(Context)}.
     */
    public abstract static class Initializer {

    }

    /**
     * Configure what services are to be enabled in this instance of Stetho.
     */
    public static class InitializerBuilder {
        final Context mContext;

        private InitializerBuilder(Context context) {
            mContext = context.getApplicationContext();
        }


        public InitializerBuilder enableDumpapp(DumperPluginsProvider plugins) {
            return this;
        }

        public InitializerBuilder enableWebKitInspector(InspectorModulesProvider modules) {
            return this;
        }

        public Initializer build() {
            return new Initializer() {
            };
        }
    }

}
