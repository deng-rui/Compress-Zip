package org.apache.compress;

import java.util.zip.ZipException;

/**
 * Exception thrown when attempting to write data that requires Zip64
 * support to an archive and {@link ZipOutputStream#setUseZip64
 * UseZip64} has been set to {@link Zip64Mode#Never Never}.
 * @since Ant 1.9.0
 * @author Apache
 */
public class Zip64RequiredException extends ZipException {

    private static final long serialVersionUID = 20110809L;

    /**
     * Helper to format "entry too big" messages.
     */
    static String getEntryTooBigMessage(ZipEntry ze) {
        return ze.getName() + "'s size exceeds the limit of 4GByte.";
    }

    static final String ARCHIVE_TOO_BIG_MESSAGE =
        "archive's size exceeds the limit of 4GByte.";

    static final String TOO_MANY_ENTRIES_MESSAGE =
        "archive contains more than 65535 entries.";

    public Zip64RequiredException(String reason) {
        super(reason);
    }
}
