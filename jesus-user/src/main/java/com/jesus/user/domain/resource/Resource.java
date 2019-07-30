package com.jesus.user.domain.resource;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.jesus.common.base.core.model.GenerateId;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
//配置为null的对象不参与序列化
//返回时尽量不要有null，可有为空串“” 或者 0 或者 []， 但尽量不要null。
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class Resource extends GenerateId<Long> implements Serializable {

    @Column(name = "resource_name")
    private String resourceName;

    @Column
    private String url;

    @Column(name = "parent_id")
    private String parentId;

    @Column
    private Type type;

    @Column
    private Status state;

    /**
     * 权限修饰符
     */
    @Column
    private String permission;

    public enum Type {
        Menu(1), Button(0);

        private Integer type;

        Type(Integer type) {
            this.type = type;
        }
    }

    /**
     * 状态枚举
     */
    public enum Status {
        ENABLED("启用"), DISABLED("禁用"), DELETED("异常");

        private String desc;

        Status(String desc) {
            this.desc = desc;
        }
    }
}
