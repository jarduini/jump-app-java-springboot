package com.acidonper.myapp.mappers;

import com.acidonper.myapp.dtos.JumpDto;
import com.acidonper.myapp.dtos.UserDto;
import com.acidonper.myapp.entities.Jump;
import com.acidonper.myapp.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface JumpMapper {
    JumpMapper INSTANCE = Mappers.getMapper(JumpMapper.class);

    @Mappings({
            @Mapping(target = "message", source = "entity.message"),
            @Mapping(target = "last_path", source = "entity.last_path"),
            @Mapping(target = "jump_path", source = "entity.jump_path"),
            @Mapping(target = "jumps", source = "entity.jumps")

    })
    JumpDto jumpToJumpDTO(Jump entity);

    @Mappings({
            @Mapping(target = "message", source = "dto.message"),
            @Mapping(target = "last_path", source = "dto.last_path"),
            @Mapping(target = "jump_path", source = "dto.jump_path"),
            @Mapping(target = "jumps", source = "dto.jumps")
    })
    Jump jumpDTOtoJump(JumpDto dto);
}

















