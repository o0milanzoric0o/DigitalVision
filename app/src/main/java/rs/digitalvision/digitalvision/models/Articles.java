
package rs.digitalvision.digitalvision.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Articles implements Serializable{

    @SerializedName("StatusCode")
    @Expose
    private Boolean StatusCode;
    @SerializedName("ErrorMessage")
    @Expose
    private String ErrorMessage;
    @SerializedName("StatusValue")
    @Expose
    private Integer StatusValue;
    @SerializedName("Elements")
    @Expose
    private rs.digitalvision.digitalvision.models.Elements Elements;

    /**
     * 
     * @return
     *     The StatusCode
     */
    public Boolean getStatusCode() {
        return StatusCode;
    }

    /**
     * 
     * @param StatusCode
     *     The StatusCode
     */
    public void setStatusCode(Boolean StatusCode) {
        this.StatusCode = StatusCode;
    }

    /**
     * 
     * @return
     *     The ErrorMessage
     */
    public String getErrorMessage() {
        return ErrorMessage;
    }

    /**
     * 
     * @param ErrorMessage
     *     The ErrorMessage
     */
    public void setErrorMessage(String ErrorMessage) {
        this.ErrorMessage = ErrorMessage;
    }

    /**
     * 
     * @return
     *     The StatusValue
     */
    public Integer getStatusValue() {
        return StatusValue;
    }

    /**
     * 
     * @param StatusValue
     *     The StatusValue
     */
    public void setStatusValue(Integer StatusValue) {
        this.StatusValue = StatusValue;
    }

    /**
     * 
     * @return
     *     The Elements
     */
    public rs.digitalvision.digitalvision.models.Elements getElements() {
        return Elements;
    }

    /**
     * 
     * @param Elements
     *     The Elements
     */
    public void setElements(rs.digitalvision.digitalvision.models.Elements Elements) {
        this.Elements = Elements;
    }

}
