
package com.Users;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "organisation",
    "transactionId",
    "basketTotal",
    "cashier",
    "checkoutDate",
    "cardNumber",
    "accountId",
    "country",
    "countryDescription",
    "currency",
    "isTraining",
    "outputProhibited",
    "receiptNumber",
    "storeId",
    "storeName",
    "tillNumber",
    "refundFlag"
})
public class Header {

    @JsonProperty("organisation")
    private String organisation;
    @JsonProperty("transactionId")
    private Integer transactionId;
    @JsonProperty("basketTotal")
    private Double basketTotal;
    @JsonProperty("cashier")
    private String cashier;
    @JsonProperty("checkoutDate")
    private String checkoutDate;
    @JsonProperty("cardNumber")
    private String cardNumber;
    @JsonProperty("accountId")
    private String accountId;
    @JsonProperty("country")
    private String country;
    @JsonProperty("countryDescription")
    private String countryDescription;
    @JsonProperty("currency")
    private String currency;
    @JsonProperty("isTraining")
    private Boolean isTraining;
    @JsonProperty("outputProhibited")
    private Boolean outputProhibited;
    @JsonProperty("receiptNumber")
    private String receiptNumber;
    @JsonProperty("storeId")
    private Integer storeId;
    @JsonProperty("storeName")
    private Object storeName;
    @JsonProperty("tillNumber")
    private Integer tillNumber;
    @JsonProperty("refundFlag")
    private Boolean refundFlag;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("organisation")
    public String getOrganisation() {
        return organisation;
    }

    @JsonProperty("organisation")
    public void setOrganisation(String organisation) {
        this.organisation = organisation;
    }

    @JsonProperty("transactionId")
    public Integer getTransactionId() {
        return transactionId;
    }

    @JsonProperty("transactionId")
    public void setTransactionId(Integer transactionId) {
        this.transactionId = transactionId;
    }

    @JsonProperty("basketTotal")
    public Double getBasketTotal() {
        return basketTotal;
    }

    @JsonProperty("basketTotal")
    public void setBasketTotal(Double basketTotal) {
        this.basketTotal = basketTotal;
    }

    @JsonProperty("cashier")
    public String getCashier() {
        return cashier;
    }

    @JsonProperty("cashier")
    public void setCashier(String cashier) {
        this.cashier = cashier;
    }

    @JsonProperty("checkoutDate")
    public String getCheckoutDate() {
        return checkoutDate;
    }

    @JsonProperty("checkoutDate")
    public void setCheckoutDate(String checkoutDate) {
        this.checkoutDate = checkoutDate;
    }

    @JsonProperty("cardNumber")
    public String getCardNumber() {
        return cardNumber;
    }

    @JsonProperty("cardNumber")
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @JsonProperty("accountId")
    public String getAccountId() {
        return accountId;
    }

    @JsonProperty("accountId")
    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    @JsonProperty("country")
    public String getCountry() {
        return country;
    }

    @JsonProperty("country")
    public void setCountry(String country) {
        this.country = country;
    }

    @JsonProperty("countryDescription")
    public String getCountryDescription() {
        return countryDescription;
    }

    @JsonProperty("countryDescription")
    public void setCountryDescription(String countryDescription) {
        this.countryDescription = countryDescription;
    }

    @JsonProperty("currency")
    public String getCurrency() {
        return currency;
    }

    @JsonProperty("currency")
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @JsonProperty("isTraining")
    public Boolean getIsTraining() {
        return isTraining;
    }

    @JsonProperty("isTraining")
    public void setIsTraining(Boolean isTraining) {
        this.isTraining = isTraining;
    }

    @JsonProperty("outputProhibited")
    public Boolean getOutputProhibited() {
        return outputProhibited;
    }

    @JsonProperty("outputProhibited")
    public void setOutputProhibited(Boolean outputProhibited) {
        this.outputProhibited = outputProhibited;
    }

    @JsonProperty("receiptNumber")
    public String getReceiptNumber() {
        return receiptNumber;
    }

    @JsonProperty("receiptNumber")
    public void setReceiptNumber(String receiptNumber) {
        this.receiptNumber = receiptNumber;
    }

    @JsonProperty("storeId")
    public Integer getStoreId() {
        return storeId;
    }

    @JsonProperty("storeId")
    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    @JsonProperty("storeName")
    public Object getStoreName() {
        return storeName;
    }

    @JsonProperty("storeName")
    public void setStoreName(Object storeName) {
        this.storeName = storeName;
    }

    @JsonProperty("tillNumber")
    public Integer getTillNumber() {
        return tillNumber;
    }

    @JsonProperty("tillNumber")
    public void setTillNumber(Integer tillNumber) {
        this.tillNumber = tillNumber;
    }

    @JsonProperty("refundFlag")
    public Boolean getRefundFlag() {
        return refundFlag;
    }

    @JsonProperty("refundFlag")
    public void setRefundFlag(Boolean refundFlag) {
        this.refundFlag = refundFlag;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
