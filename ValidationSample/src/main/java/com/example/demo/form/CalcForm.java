package com.example.demo.form;

import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;

@Data
public class CalcForm {
    @NotNull(message="left: input the number")
    @Range(min=1,max=10,message="left:input the number in range {min}~{max}")
    private Integer leftNum;

    @NotNull(message="right: input the number")
    @Range(min=1,max=10,message="right:input the number in range {min}~{max}")
    private Integer rightNum;
}
