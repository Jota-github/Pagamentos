package pagamento;

public class PPayAdapter implements PPay {

    private MPay mPay;

    public PPayAdapter(MPay mPay) {
        this.mPay = mPay;
    }

    @Override
    public String getCustCardNo() {
        return mPay.getCreditCardNo();
    }

    @Override
    public String getCardOwnerName() {
        return mPay.getCustomerName();
    }

    @Override
    public String getCardExpMonthDate() {
        // Ajuste da IA: Concatena Mês e Ano para atender ao formato único do PPay
        return mPay.getCardExpMonth() + "/" + mPay.getCardExpYear();
    }

    @Override
    public Integer getCVVNo() {
        // Ajuste da IA: Converte Short (MPay) para Integer (PPay)
        Short cvv = mPay.getCardCVVNo();
        return (cvv != null) ? cvv.intValue() : null;
    }

    @Override
    public Double getTotalAmount() {
        return mPay.getAmount();
    }

    // Setters - Propagam as alterações de volta para o objeto original MPay
    @Override
    public void setCustCardNo(String custCardNo) {
        mPay.setCreditCardNo(custCardNo);
    }

    @Override
    public void setCardOwnerName(String cardOwnerName) {
        mPay.setCustomerName(cardOwnerName);
    }

    @Override
    public void setCardExpMonthDate(String cardExpMonthDate) {
        // Implementação simplificada: assume formato "MM/YYYY" para separar
        // Caso necessário, ajustes podem ser feitos aqui se o formato mudar
        String[] dateParts = cardExpMonthDate.split("/");
        mPay.setCardExpMonth(dateParts[0]);
        mPay.setCardExpYear(dateParts[1]);
    }

    @Override
    public void setCVVNo(Integer cVVNo) {
        mPay.setCardCVVNo(cVVNo.shortValue());
    }

    @Override
    public void setTotalAmount(Double totalAmount) {
        mPay.setAmount(totalAmount);
    }
}