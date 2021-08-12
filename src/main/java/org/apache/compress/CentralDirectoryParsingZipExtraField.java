package org.apache.compress;

import java.util.zip.ZipException;

/**
 * {@link ZipExtraField ZipExtraField} that knows how to parse central
 * directory data.
 *
 * @since Ant 1.8.0
 * @author Apache
 */
public interface CentralDirectoryParsingZipExtraField extends ZipExtraField {
    /**
     * Populate data from this array as if it was in central directory data.
     * @param data an array of bytes
     * @param offset the start offset
     * @param length the number of bytes in the array from offset
     *
     * @throws ZipException on error
     */
    void parseFromCentralDirectoryData(byte[] data, int offset, int length)
        throws ZipException;
}
