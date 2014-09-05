package com.mediasilo.sdk.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class UrlStringUtility {

    /**
	 * Extract File Name
     *
     * @param url URL from which to extract file name.
     * @return File name from URL, or an empty String if URL has unsupported character encoding.
     */
    public static String extractFileName(String url) {
        String decodedUrl = decode(url);
        String[] splitUrl = decodedUrl.split("/");
        String fileName = splitUrl[splitUrl.length -1]; // Keep everything after the last "/".
        if (fileName.contains("?"))
            fileName = fileName.substring(0, fileName.indexOf("?")); // Drop any query parameters that are present.

        return fileName;
    }

    /**
     * Extract File Extension
     *
     * @param fileName Name (or URL) of file from which to extract file extension.
     * @return File extension without the dot, or an empty String if no extension is found.
     */
    public static String extractFileExtension(String fileName) {
        if (fileName.contains("/"))
            fileName = extractFileName(fileName);

        return fileName.contains(".") ? fileName.substring(fileName.lastIndexOf(".") + 1) : "";
    }

    /**
     * Remove Protocol
     *
     * @param url URL from which to strip protocol.
     * @return URL without (http|https|ftp|ftps) protocol.
     */
    public static String removeProtocol(String url) {
        return url.replaceAll("(https?|ftps?)://", "");
    }

    /**
     * Extract Base URL
     *
     * @param url URL from which to extract base URL.
     * @return Base URL (e.g. "https://www.mediasilo.com/" from "https://www.mediasilo.com/images/logo1.png")
     */
    public static String extractBaseUrl(String url) {
        return url.substring(0, indexOfEndOfBaseUrl(url));
    }

    /**
     * Extract Resource Path
     *
     * @param url URL from which to extract resource path.
     * @return Resource Path (e.g. "images/logo1.png" from "https://www.mediasilo.com/images/logo1.png")
     */
    public static String extractResourcePath(String url) {
        return url.substring(indexOfEndOfBaseUrl(url));
    }

    /**
     * Index Of End Of Base URL
     *
     * @param url URL string to examine.
     * @return String position of end of base URL (e.g. 26 for "https://www.mediasilo.com/images/logo1.png")
     */
    public static int indexOfEndOfBaseUrl(String url) {
        return url.indexOf("/", 9) + 1;
    }

    /**
     * Decode
     *
     * @param url URL to decode.
     * @return Decoded URL.
     */
    public static String decode(String url) {
        try {
            return URLDecoder.decode(url, "UTF-8").replaceAll("%2E", ".").replaceAll("%2D", "-");
        }
        catch (UnsupportedEncodingException e) {
            return null; // This will never occur because UTF-8 is a supported character encoding.
        }
    }

    /**
     * Encode
     *
     * @param url URL to encode.
     * @return Encoded URL.
     */
    public static String encode(String url) {
        try {
            return URLEncoder.encode(url, "UTF-8").replaceAll("\\.", "%2E").replaceAll("-", "%2D");
        }
        catch (UnsupportedEncodingException e) {
            return null; // This will never occur because UTF-8 is a supported character encoding.
        }
    }

}
