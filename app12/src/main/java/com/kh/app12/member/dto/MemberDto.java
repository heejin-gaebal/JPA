package com.kh.app12.member.dto;

import com.kh.app12.member.entity.MemberEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberDto {
    private String userId;
    private String userNick;

    @Getter
    @Setter
    public static class MemberReqDto extends MemberDto{
        private String userPwd;
    }

    @Getter
    @Setter
    public static class MemberRespDto extends MemberDto{
        private String delYn;

        public static MemberRespDto from(MemberEntity memberEntity) {
            MemberRespDto respDto = new MemberRespDto();
            respDto.setUserId(memberEntity.getUserId());
            respDto.setUserNick(memberEntity.getUserNick());
            respDto.setDelYn(memberEntity.getDelYn().getLabel()); //enum의 이름이 달린 label 가져오기

            return respDto;
        }
    }

}
