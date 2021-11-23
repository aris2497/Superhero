package com.example.Superhero.dao;

import com.example.Superhero.dto.Member;
import com.example.Superhero.dto.Organisation;

import java.util.List;

public interface MemberDao {
    List<Member> getAllMembersByOrganisation(Organisation organisation);
}
