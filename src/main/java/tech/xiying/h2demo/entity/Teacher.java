package tech.xiying.h2demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

/**
 * @ClassName Teacher
 * @Description
 * @Author shanghao5
 * @Date 2020/12/5 10:39
 **/
@Entity
@Table(name="t_teacher")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Teacher extends BaseEntity{

    @Column(name = "t_name" , nullable = false)
    private String name;
    @Column(name = "t_phone" , nullable = false)
    private String phone;
    @OneToMany(cascade= CascadeType.ALL,fetch = FetchType.EAGER,mappedBy = "teacher")
    private List<User> users;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
