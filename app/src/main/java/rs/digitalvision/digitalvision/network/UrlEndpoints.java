package rs.digitalvision.digitalvision.network;

import rs.digitalvision.digitalvision.common.Config.EndPoints;

public class UrlEndpoints {
    public static String getRequestUrlArticleCode(String code) {
        return String.format(EndPoints.DIGITAL_VISION_URL, code);
    }
}
