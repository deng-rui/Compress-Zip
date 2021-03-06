package org.apache.compress;

import java.util.zip.ZipException;

/**
 * If this extra field is added as the very first extra field of the
 * archive, Solaris will consider it an executable jar file.
 *
 * @since Ant 1.6.3
 * @author Apache
 */
public final class JarMarker implements ZipExtraField {

    private static final ZipShort ID = new ZipShort(0xCAFE);
    private static final ZipShort NULL = new ZipShort(0);
    private static final byte[] NO_BYTES = new byte[0];
    private static final JarMarker DEFAULT = new JarMarker();

    /** No-arg constructor */
    public JarMarker() {
        // empty
    }

    /**
     * Since JarMarker is stateless we can always use the same instance.
     * @return the DEFAULT jarmaker.
     */
    public static JarMarker getInstance() {
        return DEFAULT;
    }

    /**
     * The Header-ID.
     * @return the header id
     */
    @Override
    public ZipShort getHeaderId() {
        return ID;
    }

    /**
     * Length of the extra field in the local file data - without
     * Header-ID or length specifier.
     * @return 0
     */
    @Override
    public ZipShort getLocalFileDataLength() {
        return NULL;
    }

    /**
     * Length of the extra field in the central directory - without
     * Header-ID or length specifier.
     * @return 0
     */
    @Override
    public ZipShort getCentralDirectoryLength() {
        return NULL;
    }

    /**
     * The actual data to put into local file data - without Header-ID
     * or length specifier.
     * @return the data
     * @since 1.1
     */
    @Override
    public byte[] getLocalFileDataData() {
        return NO_BYTES;
    }

    /**
     * The actual data to put central directory - without Header-ID or
     * length specifier.
     * @return the data
     */
    @Override
    public byte[] getCentralDirectoryData() {
        return NO_BYTES;
    }

    /**
     * Populate data from this array as if it was in local file data.
     * @param data an array of bytes
     * @param offset the start offset
     * @param length the number of bytes in the array from offset
     *
     * @throws ZipException on error
     */
    @Override
    public void parseFromLocalFileData(byte[] data, int offset, int length)
        throws ZipException {
        if (length != 0) {
            throw new ZipException("JarMarker doesn't expect any data");
        }
    }
}
