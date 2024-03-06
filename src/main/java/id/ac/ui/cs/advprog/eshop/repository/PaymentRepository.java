package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Payment;

import java.util.*;
import java.util.stream.Collectors;

public class PaymentRepository {
    private Map<String, Payment> paymentData = new HashMap<>();

    public Payment save(Payment payment) {
        String id = UUID.randomUUID().toString();
        payment.setId(id);
        paymentData.put(id, payment);
        return payment;
    }
    public Payment findById(String id){
        return paymentData.get(id);
    }
    public List<Payment> findAllByVoucherCode(){
        return paymentData.values().stream()
                .filter(payment -> payment.getMethod().equals("VOUCHER_CODE"))
                .collect(Collectors.toList());
    }
    public List<Payment> findAllByCashOnDelivery(){
        return paymentData.values().stream()
                .filter(payment -> payment.getMethod().equals("CASH_ON_DELIVERY"))
                .collect(Collectors.toList());
    }
    public List<Payment> getAllPayment(){
        return new ArrayList<>(paymentData.values());
    }
}