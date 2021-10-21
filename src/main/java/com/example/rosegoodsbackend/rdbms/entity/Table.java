package com.example.rosegoodsbackend.rdbms.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author Jason Qiu
 * @since 2021-09-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Table implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer key;


}
