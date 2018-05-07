/*
 * Copyright 2014-2017 Aicai Group.
*/
package learn.ftp.test;

import java.io.IOException;

/**
 * A class that implements PGP interface for Java.
 * <p>
 * It calls gpg (GnuPG) program to do all the PGP processing. $Id:$
 *
 * @author Yaniv Yemini, January 2004.
 * @author Please include this text with any copy of this code.
 * @author .
 * @author License: GPL v3
 * @author Latest version of this code can be found at:
 * @author http://www.macnews.co.il/mageworks/java/gnupg/
 * @author .
 * @author Based on a class GnuPG by John Anderson, which can be found
 * @author at:
 * http://lists.gnupg.org/pipermail/gnupg-devel/2002-February/018098.html
 * @version 0.5
 * @see GnuPg - http://www.gnupg.org/
 */
public class GnuPg {
    private static final String CMD = "/usr/bin/gpg --batch --yes ";

    /**
     * Encrypt
     *
     * @param srcPath  input file to encrypt
     * @param destPath encrypt path
     * @param keyID    key ID of the key in GnuPG's key database to encrypt with
     * @return true upon success
     */
    public static boolean encrypt(String srcPath, String destPath, String keyID) {
        return runGnuPG("-r " + keyID + " -e -o " + destPath, srcPath);
    }

    /**
     * Decrypt
     *
     * @param srcPath    input string to decrypt
     * @param destPath   decrypt path
     * @param passPhrase passphrase for the personal private key to sign with
     * @return true upon success
     */
    public static boolean decrypt(String srcPath, String destPath, String passPhrase) {
        return runGnuPG("--passphrase " + passPhrase + " -d -o " + destPath, srcPath);
    }

    /**
     * Runs GnuPG external program
     *
     * @param commandArgs command line arguments
     * @param srcPath     key ID of the key in GnuPG's key database
     * @return true if success.
     */
    private static boolean runGnuPG(String commandArgs, String srcPath) {
        String fullCommand = CMD + " " + commandArgs + " " + srcPath;
        System.out.println(fullCommand);
        try {
            Runtime.getRuntime().exec(fullCommand);
        } catch (IOException io) {
            System.out.println("io Error" + io.getMessage());
            return false;
        }
        return true;
    }

}
