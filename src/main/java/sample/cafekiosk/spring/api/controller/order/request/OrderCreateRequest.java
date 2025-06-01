package sample.cafekiosk.spring.api.controller.order.request;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sample.cafekiosk.spring.api.service.order.request.OrderCreateServiceRequest;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Getter
@NoArgsConstructor(force = true)
public class OrderCreateRequest {

    @NotEmpty(message = "상품 번호 리스트는 필수 입니다.")
    private final List<String> productNumbers;

    @Builder
    private OrderCreateRequest(List<String> productNumbers) {
        this.productNumbers = productNumbers;
    }

    public OrderCreateServiceRequest toServiceRequest() {
        return OrderCreateServiceRequest.builder()
                .productNumbers(productNumbers)
                .build();
    }

}
