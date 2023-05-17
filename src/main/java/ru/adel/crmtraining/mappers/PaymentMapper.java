package ru.adel.crmtraining.mappers;

import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import ru.adel.crmtraining.dto.PaymentDTO;
import ru.adel.crmtraining.models.Payment;

@Component
@AllArgsConstructor
public class PaymentMapper {
    private final ModelMapper modelMapper;

    public PaymentDTO toDTO(Payment payment) {
        return modelMapper.map(payment, PaymentDTO.class);
    }

    public Payment toEntity(PaymentDTO paymentDTO) {
        return modelMapper.map(paymentDTO, Payment.class);
    }
}
