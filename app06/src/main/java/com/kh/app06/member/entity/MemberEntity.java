package com.kh.app06.member.entity;

import com.kh.app06.member.dto.MemberDto;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
//@Setter(AccessLevel.PRIVATE) //프라이빗 레벨로 지정
@Setter
@Table(name = "MEMBER")
@SequenceGenerator(name = "MemSeqGen", sequenceName = "SEQ_MEMBER", allocationSize = 1)
public class MemberEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "MemSeqGen")
    private Long no;

    @Column(nullable = false , unique = true, length = 100)
    private String userId;

    @Column(nullable = false, length = 100)
    private String userPwd;

    @Column(length = 100)
    private String userNick;

    private LocalDateTime createAt;

    @Column(length = 1)
    private String delYn;

    public MemberEntity() {
        createAt = LocalDateTime.now();
        delYn = "N";
    }
    
    //여기서는 세터를 안열어도됨,,,,,
    public static MemberEntity from(MemberDto dto){

        //validate 유효성 검사
        if(dto.getUserId().length() > 100){
            throw new IllegalArgumentException("id error");
        }
        if(dto.getUserPwd().length() > 100){
            throw new IllegalArgumentException("pwd error");
        }
        if(dto.getUserNick().length() > 100){
            throw new IllegalArgumentException("nick error");
        }

        MemberEntity entity = new MemberEntity();
        entity.userId = dto.getUserId();
        entity.userPwd = dto.getUserPwd();
        entity.userNick = dto.getUserNick();
        return entity;
    }
}
