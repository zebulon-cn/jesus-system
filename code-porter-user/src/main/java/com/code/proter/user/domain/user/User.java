package com.code.proter.user.domain.user;

import com.code.proter.user.domain.role.Role;
import com.code.proter.common.base.core.model.GenerateId;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
public class User extends GenerateId<Long> implements Serializable {

    @Column
    private String name;

    @Column
    private String username;

    @Column
    private String password;

    @Column
    private String mobile;

    @Column
    private String salt;

    @Enumerated(EnumType.STRING)
    @Column
    private State state;

    @Column(name = "role_id")
    private Long roleId;

    @Column
    private String avatar;

    // 关联关系，不产生外键
    @ManyToOne
    @JoinColumn(name = "role_id", insertable = false, updatable = false,
            foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT, name = "none"))
    private Role role;

    /**
     * 状态枚举
     */
    public enum State {
        ENABLED("启用"), DISABLED("禁用"), DELETED("异常");

        public String desc;

        State(String desc) {
            this.desc = desc;
        }
    }

}
