package org.apache.compress;

import java.io.Serializable;
import java.util.zip.ZipException;

/**
 * Exception thrown when attempting to read or write data for a zip
 * entry that uses ZIP features not supported by this library.
 * @since Ant 1.9.0
 * @author Apache
 */
public class UnsupportedZipFeatureException extends ZipException {

    private final Feature reason;
    private final transient ZipEntry entry;
    private static final long serialVersionUID = 20161221L;

    /**
     * Creates an exception.
     * @param reason the feature that is not supported
     * @param entry the entry using the feature
     */
    public UnsupportedZipFeatureException(Feature reason,
                                          ZipEntry entry) {
        super("unsupported feature " + reason +  " used in entry "
              + entry.getName());
        this.reason = reason;
        this.entry = entry;
    }

    /**
     * The unsupported feature that has been used.
     *
     * @return Feature
     */
    public Feature getFeature() {
        return reason;
    }

    /**
     * The entry using the unsupported feature.
     *
     * @return ZipEntry
     */
    public ZipEntry getEntry() {
        return entry;
    }

    /**
     * ZIP Features that may or may not be supported.
     */
    @SuppressWarnings("serial")
    public static class Feature implements Serializable {
        /**
         * The entry is encrypted.
         */
        public static final Feature ENCRYPTION = new Feature("encryption");
        /**
         * The entry used an unsupported compression method.
         */
        public static final Feature METHOD = new Feature("compression method");
        /**
         * The entry uses a data descriptor.
         */
        public static final Feature DATA_DESCRIPTOR = new Feature("data descriptor");

        private final String name;

        private Feature(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name;
        }
    }
}
