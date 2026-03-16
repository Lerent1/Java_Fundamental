package Session07.Bai03;

interface PaymentMethod {
    void processPayment(double amount);
}

interface CODPayable extends PaymentMethod {
}

interface CardPayable extends PaymentMethod {
}

interface EWalletPayable extends PaymentMethod {
}

class CODPayment implements CODPayable {
    public void processPayment(double amount) {
        System.out.println("Xu ly thanh toan COD: " + (int) amount + " - Thanh cong");
    }
}

class CreditCardPayment implements CardPayable {
    public void processPayment(double amount) {
        System.out.println("Xu ly thanh toan the tin dung: " + (int) amount + " - Thanh cong");
    }
}

class MomoPayment implements EWalletPayable {
    public void processPayment(double amount) {
        System.out.println("Xu ly thanh toan MoMo: " + (int) amount + " - Thanh cong");
    }
}

class PaymentProcessor {
    PaymentMethod paymentMethod;
    public PaymentProcessor(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void process(double amount) {
        paymentMethod.processPayment(amount);
    }
}

public class Gioi01 {
    public static void main(String[] args) {
        System.out.println("Thanh toan COD");
        PaymentProcessor cod = new PaymentProcessor(new CODPayment());
        cod.process(500000);
        System.out.println();

        System.out.println("Thanh toan the tin dung");
        PaymentProcessor card = new PaymentProcessor(new CreditCardPayment());
        card.process(1000000);
        System.out.println();

        System.out.println("Thanh toan vi MoMo");
        PaymentProcessor momo = new PaymentProcessor(new MomoPayment());
        momo.process(750000);
        System.out.println();

        System.out.println("Kiem tra LSP (thay the implementation)");
        PaymentMethod payment = new CreditCardPayment();
        payment.processPayment(1000000);

        payment = new MomoPayment();
        payment.processPayment(1000000);
    }
}
