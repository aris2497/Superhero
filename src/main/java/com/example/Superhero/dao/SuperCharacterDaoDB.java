package com.example.Superhero.dao;

import com.example.Superhero.dto.SuperCharacter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class SuperCharacterDaoDB implements SuperCharacterDao{

    @Autowired
    JdbcTemplate jdbc;

    @Override
    public SuperCharacter getSuperCharacterById(int id) {

            try {
                final String SELECT_SUPERCHAR_BY_ID = "SELECT * FROM superCharacter WHERE id = ?";
                return jdbc.queryForObject(SELECT_SUPERCHAR_BY_ID, new SuperCharacterMapper(), id);
            } catch (DataAccessException ex) {
                return null;
            }
    }


    @Transactional
    @Override
    public SuperCharacter addSuperCharacter(SuperCharacter superChar) {
        final String INSERT_SUPERCHARACTER = "INSERT INTO superCharacter(name, description, superpower) "
                + "VALUES(?,?,?)";
        jdbc.update(INSERT_SUPERCHARACTER,
                superChar.getName(),
                superChar.getDescription(),
                superChar.getSuperpower());

        int newId = jdbc.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        superChar.setId(newId);
        return superChar;
    }

    @Override
    public void updateSuperCharacter(SuperCharacter superChar) {
        final String UPDATE_STUDENT = "UPDATE superCharacter SET name = ?, description = ?, superpower = ? "
                + "WHERE id = ?";
        jdbc.update(UPDATE_STUDENT,
                superChar.getName(),
                superChar.getDescription(),
                superChar.getSuperpower());

    }

    @Transactional
    @Override
    public void deleteSuperCharacterById(int id) {
        final String DELETE_COURSE_STUDENT = "DELETE FROM heroOrganisation WHERE superId = ?";
        jdbc.update(DELETE_COURSE_STUDENT, id);

        final String DELETE_STUDENT = "DELETE FROM superCharacter WHERE id = ?";
        jdbc.update(DELETE_STUDENT, id);

    }

    @Override
    public List<SuperCharacter> getAllSuperCharacters() {
        final String SELECT_ALL_SUPERCHARACTERS = "SELECT * FROM superCharacter";
        return jdbc.query(SELECT_ALL_SUPERCHARACTERS, new SuperCharacterMapper());
    }

    @Override
    public List<SuperCharacter> getAllSuperCharactersByLocation(int id) {
        return null;
    }

    public static final class SuperCharacterMapper implements RowMapper<SuperCharacter> {

        @Override
        public SuperCharacter mapRow(ResultSet rs, int index) throws SQLException {
            SuperCharacter superChar = new SuperCharacter();
            superChar.setId(rs.getInt("superId"));
            superChar.setName(rs.getString("name"));
            superChar.setDescription(rs.getString("description"));
            superChar.setSuperpower(rs.getString("superpower"));

            return superChar;
        }
    }
}
