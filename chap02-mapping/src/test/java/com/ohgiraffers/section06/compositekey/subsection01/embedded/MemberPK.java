package com.ohgiraffers.section06.compositekey.subsection01.embedded;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

// 임베드 될 수 있는 복합키 타입을 지정할 때 사용하는 어노테이션
@Embeddable
public class MemberPK implements Serializable {

    @Column(name = "member_no")
    private int memberNo;

    @Column(name = "member_id")
    private String memberId;

    public MemberPK() {
    }

    public MemberPK(int memberNo, String memberId) {
        this.memberNo = memberNo;
        this.memberId = memberId;
    }

    public int getMemberNo() {
        return memberNo;
    }

    public void setMemberNo(int memberNo) {
        this.memberNo = memberNo;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    @Override
    public String toString() {
        return "MemberPK{" +
                "memberNo=" + memberNo +
                ", memberId='" + memberId + '\'' +
                '}';
    }

    /*
    * 일반적인 jpa 경우와 다르게 복합키 사용시 내용물 비교를 위해 오버라이딩 필수
    * */
    @Override
    public int hashCode() {
        return Objects.hash(memberNo, memberId);
    }

    @Override
    public boolean equals(Object obj) {
        // 현재 비교할 객체가 현재 객체와 동일한 경우 true
        if (this == obj) return true;
        // 비교할 객체가 null 이거나, 두 객체의 클래스가 다르면 false
        if (obj == null || obj.getClass() != getClass()) return false;
        MemberPK memberPK = (MemberPK) obj;
        // memberId 가 동일하고, memberNo 가 동일하면 true 반환
        return memberNo == memberPK.memberNo && Objects.equals(memberId, memberPK.memberId);
    }
}