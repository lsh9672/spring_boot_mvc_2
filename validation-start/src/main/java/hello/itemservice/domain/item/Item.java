package hello.itemservice.domain.item;

import lombok.Data;
import org.apache.logging.log4j.message.Message;
import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.constraints.ScriptAssert;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
//@ScriptAssert(lang = "javascript", script = "_this.price * _this.quantity >= 10000", message = "총 합이 10000원 넘게 입력해주세요") => 기능이 너무 약해서 권장안함.
public class Item {

//    @NotNull // 수정요구사항
//    @NotNull(groups = UpdateCheck.class)
    private Long id;

//    @NotBlank(message = "공백X")
//    @NotBlank(groups = {SaveCheck.class,UpdateCheck.class})
    private String itemName;

    //표준에는 range가 없어서 하이버네이트 validator를 이용
//    @NotNull(groups = {SaveCheck.class,UpdateCheck.class})
//    @Range(min = 1000, max = 1000000,groups = {SaveCheck.class,UpdateCheck.class})
    private Integer price;

//    @NotNull(groups = {SaveCheck.class,UpdateCheck.class})
//    @Max(value=9999, groups = SaveCheck.class) //수정 요구사항
    private Integer quantity;

    public Item() {
    }

    public Item(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}
