package tech.xiying.h2demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @ClassName TeacherTeamDto
 * @Description
 * @Author shanghao5
 * @Date 2020/12/5 14:14
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TeacherTeamDto {

    private String name;
    private String phone;
    private List<UserDto> userDtoList;
}
