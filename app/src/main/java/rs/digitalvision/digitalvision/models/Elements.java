package rs.digitalvision.digitalvision.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Elements implements Serializable {

    @SerializedName("ArtikalId")
    @Expose
    private Integer ArtikalId;
    @SerializedName("ArtikalSifra")
    @Expose
    private String ArtikalSifra;
    @SerializedName("cenafullStringMP")
    @Expose
    private String cenafullStringMP;
    @SerializedName("cenafullMP")
    @Expose
    private Integer cenafullMP;
    @SerializedName("cenafullStringVP")
    @Expose
    private String cenafullStringVP;
    @SerializedName("cenafullVP")
    @Expose
    private Double cenafullVP;
    @SerializedName("kurs")
    @Expose
    private Double kurs;
    @SerializedName("ArtikalNaziv")
    @Expose
    private String ArtikalNaziv;
    @SerializedName("ArtikalLink")
    @Expose
    private String ArtikalLink;
    @SerializedName("ArtikalOpis")
    @Expose
    private String ArtikalOpis;
    @SerializedName("ArtikalKratakOpis")
    @Expose
    private String ArtikalKratakOpis;
    @SerializedName("ArtikalBrendId")
    @Expose
    private Object ArtikalBrendId;
    @SerializedName("ArtikalProizvodjacId")
    @Expose
    private Integer ArtikalProizvodjacId;
    @SerializedName("BrendIme")
    @Expose
    private Object BrendIme;
    @SerializedName("BrendLink")
    @Expose
    private Object BrendLink;
    @SerializedName("ArtikalVidljivZaMp")
    @Expose
    private Integer ArtikalVidljivZaMp;
    @SerializedName("ArtikalStanje")
    @Expose
    private Integer ArtikalStanje;
    @SerializedName("ArtikalAktivan")
    @Expose
    private Integer ArtikalAktivan;
    @SerializedName("ArtikalPDV")
    @Expose
    private Object ArtikalPDV;
    @SerializedName("Rabat")
    @Expose
    private Object Rabat;
    @SerializedName("DodatniPdvKategorije")
    @Expose
    private Object DodatniPdvKategorije;
    @SerializedName("slika")
    @Expose
    private String slika;
    @SerializedName("ArtikalPozicijaMagacin")
    @Expose
    private String ArtikalPozicijaMagacin;

    /**
     * @return The ArtikalId
     */
    public Integer getArtikalId() {
        return ArtikalId;
    }

    /**
     * @param ArtikalId The ArtikalId
     */
    public void setArtikalId(Integer ArtikalId) {
        this.ArtikalId = ArtikalId;
    }

    /**
     * @return The ArtikalSifra
     */
    public String getArtikalSifra() {
        return ArtikalSifra;
    }

    /**
     * @param ArtikalSifra The ArtikalSifra
     */
    public void setArtikalSifra(String ArtikalSifra) {
        this.ArtikalSifra = ArtikalSifra;
    }

    /**
     * @return The cenafullStringMP
     */
    public String getCenafullStringMP() {
        return cenafullStringMP;
    }

    /**
     * @param cenafullStringMP The cenafullStringMP
     */
    public void setCenafullStringMP(String cenafullStringMP) {
        this.cenafullStringMP = cenafullStringMP;
    }

    /**
     * @return The cenafullMP
     */
    public Integer getCenafullMP() {
        return cenafullMP;
    }

    /**
     * @param cenafullMP The cenafullMP
     */
    public void setCenafullMP(Integer cenafullMP) {
        this.cenafullMP = cenafullMP;
    }

    /**
     * @return The cenafullStringVP
     */
    public String getCenafullStringVP() {
        return cenafullStringVP;
    }

    /**
     * @param cenafullStringVP The cenafullStringVP
     */
    public void setCenafullStringVP(String cenafullStringVP) {
        this.cenafullStringVP = cenafullStringVP;
    }

    /**
     * @return The cenafullVP
     */
    public Double getCenafullVP() {
        return cenafullVP;
    }

    /**
     * @param cenafullVP The cenafullVP
     */
    public void setCenafullVP(Double cenafullVP) {
        this.cenafullVP = cenafullVP;
    }

    /**
     * @return The kurs
     */
    public Double getKurs() {
        return kurs;
    }

    /**
     * @param kurs The kurs
     */
    public void setKurs(Double kurs) {
        this.kurs = kurs;
    }

    /**
     * @return The ArtikalNaziv
     */
    public String getArtikalNaziv() {
        return ArtikalNaziv;
    }

    /**
     * @param ArtikalNaziv The ArtikalNaziv
     */
    public void setArtikalNaziv(String ArtikalNaziv) {
        this.ArtikalNaziv = ArtikalNaziv;
    }

    /**
     * @return The ArtikalLink
     */
    public String getArtikalLink() {
        return ArtikalLink;
    }

    /**
     * @param ArtikalLink The ArtikalLink
     */
    public void setArtikalLink(String ArtikalLink) {
        this.ArtikalLink = ArtikalLink;
    }

    /**
     * @return The ArtikalOpis
     */
    public String getArtikalOpis() {
        return ArtikalOpis;
    }

    /**
     * @param ArtikalOpis The ArtikalOpis
     */
    public void setArtikalOpis(String ArtikalOpis) {
        this.ArtikalOpis = ArtikalOpis;
    }

    /**
     * @return The ArtikalKratakOpis
     */
    public String getArtikalKratakOpis() {
        return ArtikalKratakOpis;
    }

    /**
     * @param ArtikalKratakOpis The ArtikalKratakOpis
     */
    public void setArtikalKratakOpis(String ArtikalKratakOpis) {
        this.ArtikalKratakOpis = ArtikalKratakOpis;
    }

    /**
     * @return The ArtikalBrendId
     */
    public Object getArtikalBrendId() {
        return ArtikalBrendId;
    }

    /**
     * @param ArtikalBrendId The ArtikalBrendId
     */
    public void setArtikalBrendId(Object ArtikalBrendId) {
        this.ArtikalBrendId = ArtikalBrendId;
    }

    public String getArtikalPozicijaMagacin() {
        return ArtikalPozicijaMagacin;
    }

    public void setArtikalPozicijaMagacin(String artikalPozicijaMagacin) {
        ArtikalPozicijaMagacin = artikalPozicijaMagacin;
    }

    /**
     * @return The ArtikalProizvodjacId
     */
    public Integer getArtikalProizvodjacId() {
        return ArtikalProizvodjacId;
    }

    /**
     * @param ArtikalProizvodjacId The ArtikalProizvodjacId
     */
    public void setArtikalProizvodjacId(Integer ArtikalProizvodjacId) {
        this.ArtikalProizvodjacId = ArtikalProizvodjacId;
    }

    /**
     * @return The BrendIme
     */
    public Object getBrendIme() {
        return BrendIme;
    }

    /**
     * @param BrendIme The BrendIme
     */
    public void setBrendIme(Object BrendIme) {
        this.BrendIme = BrendIme;
    }

    /**
     * @return The BrendLink
     */
    public Object getBrendLink() {
        return BrendLink;
    }

    /**
     * @param BrendLink The BrendLink
     */
    public void setBrendLink(Object BrendLink) {
        this.BrendLink = BrendLink;
    }

    /**
     * @return The ArtikalVidljivZaMp
     */
    public Integer getArtikalVidljivZaMp() {
        return ArtikalVidljivZaMp;
    }

    /**
     * @param ArtikalVidljivZaMp The ArtikalVidljivZaMp
     */
    public void setArtikalVidljivZaMp(Integer ArtikalVidljivZaMp) {
        this.ArtikalVidljivZaMp = ArtikalVidljivZaMp;
    }

    /**
     * @return The ArtikalStanje
     */
    public Integer getArtikalStanje() {
        return ArtikalStanje;
    }

    /**
     * @param ArtikalStanje The ArtikalStanje
     */
    public void setArtikalStanje(Integer ArtikalStanje) {
        this.ArtikalStanje = ArtikalStanje;
    }

    /**
     * @return The ArtikalAktivan
     */
    public Integer getArtikalAktivan() {
        return ArtikalAktivan;
    }

    /**
     * @param ArtikalAktivan The ArtikalAktivan
     */
    public void setArtikalAktivan(Integer ArtikalAktivan) {
        this.ArtikalAktivan = ArtikalAktivan;
    }

    /**
     * @return The ArtikalPDV
     */
    public Object getArtikalPDV() {
        return ArtikalPDV;
    }

    /**
     * @param ArtikalPDV The ArtikalPDV
     */
    public void setArtikalPDV(Object ArtikalPDV) {
        this.ArtikalPDV = ArtikalPDV;
    }

    /**
     * @return The Rabat
     */
    public Object getRabat() {
        return Rabat;
    }

    /**
     * @param Rabat The Rabat
     */
    public void setRabat(Object Rabat) {
        this.Rabat = Rabat;
    }

    /**
     * @return The DodatniPdvKategorije
     */
    public Object getDodatniPdvKategorije() {
        return DodatniPdvKategorije;
    }

    /**
     * @param DodatniPdvKategorije The DodatniPdvKategorije
     */
    public void setDodatniPdvKategorije(Object DodatniPdvKategorije) {
        this.DodatniPdvKategorije = DodatniPdvKategorije;
    }

    /**
     * @return The slika
     */
    public String getSlika() {
        return slika;
    }

    /**
     * @param slika The slika
     */
    public void setSlika(String slika) {
        this.slika = slika;
    }

}
