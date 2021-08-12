package org.apache.compress;

/**
 * Info-ZIP Unicode Path Extra Field (0x7075):
 *
 * <p>Stores the UTF-8 version of the file name field as stored in the
 * local header and central directory header.</p>
 *
 * <p>See <a href="https://www.pkware.com/documents/casestudies/APPNOTE.TXT">PKWARE's
 * APPNOTE.TXT, section 4.6.9</a>.</p>
 * @author Apache
 */
public class UnicodePathExtraField extends AbstractUnicodeExtraField {

    public static final ZipShort UPATH_ID = new ZipShort(0x7075);

    public UnicodePathExtraField() {
    }

    /**
     * Assemble as unicode path extension from the name given as
     * text as well as the encoded bytes actually written to the archive.
     *
     * @param text The file name
     * @param bytes the bytes actually written to the archive
     * @param off The offset of the encoded filename in <code>bytes</code>.
     * @param len The length of the encoded filename or comment in
     * <code>bytes</code>.
     */
    public UnicodePathExtraField(final String text, final byte[] bytes, final int off, final int len) {
        super(text, bytes, off, len);
    }

    /**
     * Assemble as unicode path extension from the name given as
     * text as well as the encoded bytes actually written to the archive.
     *
     * @param name The file name
     * @param bytes the bytes actually written to the archive
     */
    public UnicodePathExtraField(final String name, final byte[] bytes) {
        super(name, bytes);
    }

    /** {@inheritDoc} */
    @Override
    public ZipShort getHeaderId() {
        return UPATH_ID;
    }
}
