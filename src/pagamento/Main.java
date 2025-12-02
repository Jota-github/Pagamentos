package pagamento;

public class Main {

    public static void main(String[] args) {
        System.out.println("=== INICIANDO TESTE DO ADAPTER ===");

        // 1. O Cenário: Temos um objeto antigo (MPay) vindo do sistema legado
        MPay mPay = new MpayImpl();
        mPay.setCreditCardNo("1234.5678.9012.3456");
        mPay.setCustomerName("Maria Oliveira");
        mPay.setCardExpMonth("10");
        mPay.setCardExpYear("2030");
        mPay.setCardCVVNo((short) 999);
        mPay.setAmount(2500.50);

        System.out.println("Objeto MPay original criado com sucesso.");

        // 2. O Adapter: Transformamos o MPay em PPay
        PPay pPayAdapter = new PPayAdapter(mPay);
        System.out.println("Adapter criado. Convertendo chamadas...");

        // 3. O Teste: Chamamos o método que espera um PPay
        testPPay(pPayAdapter);
    }

    // Este é o método exigido no enunciado da atividade
    public static void testPPay(PPay pp){
        System.out.println("\n--- Detalhes do Pagamento (Via PPay Interface) ---");
        System.out.println("Nome do Titular: " + pp.getCardOwnerName());
        System.out.println("Número do Cartão: " + pp.getCustCardNo());
        System.out.println("Data de Validade: " + pp.getCardExpMonthDate()); // Aqui vemos a mágica da concatenação
        System.out.println("CVV (Integer): " + pp.getCVVNo());            // Aqui vemos a conversão de Short para Integer
        System.out.println("Valor Total: " + pp.getTotalAmount());
    }
}