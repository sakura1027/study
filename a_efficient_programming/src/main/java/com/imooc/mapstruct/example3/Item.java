package com.imooc.mapstruct.example3;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * @author zhaobin.11@bytedance.com
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Item {

    private Long id;

    private String title;
}
