package rs.digitalvision.digitalvision.network;

import rs.digitalvision.digitalvision.common.Config.EndPoints;

public class UrlEndpoints {
    public static String getRequestUrlArticleCode(String code) {
        return String.format(EndPoints.URL_BY_CODE, code);
    }

    public static String getRequestUrlArticleId(String code) {
        return String.format(EndPoints.URL_BY_ID, code);
    }

    public static String getRequestUrlArticleBarcodeId(String barcode, String id) {
        return String.format(EndPoints.URL_BY_BARCODE_ID, barcode, id);
    }

    public static String getRequestUrlCategory(String category) {
        return String.format(EndPoints.URL_BY_CATEGORY, category);
    }
}
