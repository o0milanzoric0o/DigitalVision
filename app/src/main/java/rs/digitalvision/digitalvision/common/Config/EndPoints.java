package rs.digitalvision.digitalvision.common.Config;

/**
 * Created by 1 on 5/12/2016.
 */
public class EndPoints {
    public static final String DIGITAL_VISION_URL = "http://digitalvision.rs/akcija.php?action=sifraCenaApp&artsifra=%1$s";

    public static final String URL_BY_CODE = "http://digitalvision.rs/parametri.php?action=artikalSifra&br=%1$s";
    public static final String URL_BY_ID = "http://digitalvision.rs/parametri.php?action=artikal&id=%1$s";
    public static final String URL_BY_BARCODE_ID = "http://digitalvision.rs/parametri.php?action=artikalBarkod&br=%1$s&id=%2$s";

    public static final String URL_BY_CATEGORY = "http://digitalvision.rs/parametri.php?action=artikliPoKategoriji&id=%1$s";
}
