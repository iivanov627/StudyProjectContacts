package ru.ksergey.StudyProjectWebStart.dao;

import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ru.ksergey.StudyProjectWebStart.model.entity.ContactOwner;
import ru.ksergey.StudyProjectWebStart.model.enums.AppRole;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Primary
@Repository
public class ContactOwnerRepositorySQLiteImpl implements ContactOwnerRepository {

    private final JdbcTemplate jdbcTemplate;

    public ContactOwnerRepositorySQLiteImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    private static class ContactOwnerRowMapper implements RowMapper<ContactOwner> {
        @Override
        public ContactOwner mapRow(ResultSet rs, int rowNum) throws SQLException {
            ContactOwner contactOwner = new ContactOwner();
            contactOwner.setId(UUID.fromString(rs.getString("id")));
            contactOwner.setUsername(rs.getString("username"));
            contactOwner.setDescription(rs.getString("description"));
            contactOwner.setEmail(rs.getString("email"));
            contactOwner.setPassword(rs.getString("password"));
            contactOwner.setRole(AppRole.valueOf(rs.getString("role")));
            return contactOwner;
        }
    }



    @Override
    public List<ContactOwner> findAll() {
//        String sql = "SELECT * FROM contact_owners";
//        return jdbcTemplate.query(sql, new ContactOwnerRowMapper());

        return jdbcTemplate.query(
                "SELECT * FROM contact_owners",
                new BeanPropertyRowMapper<>(ContactOwner.class) // !!!!!!!!!!!!!!
        );

    }

    @Override
    public Optional<ContactOwner> findById(UUID id) {
        String sql = "SELECT * FROM contact_owners WHERE id = ?";
        List<ContactOwner> contactOwners = jdbcTemplate.query(sql, new ContactOwnerRowMapper(), id);

        return contactOwners.isEmpty()
                ? Optional.empty()
                : Optional.of(contactOwners.getFirst());
    }

    @Override
    public Optional<ContactOwner> findByEmail(String email) {
        String sql = "SELECT * FROM contact_owners WHERE email = ?";
        List<ContactOwner> contactOwners = jdbcTemplate.query(sql, new ContactOwnerRowMapper(), email);

        return contactOwners.isEmpty()
                ? Optional.empty()
                : Optional.of(contactOwners.getFirst());
    }

    @Override
    public ContactOwner save(ContactOwner contactOwner) {
        if (contactOwner.getId() == null){
            String sql = """
                    INSERT INTO contact_owners (id, username, description, email, password, role)
                    VALUES
                    (?,?,?,?,?,?)
                    """;
            jdbcTemplate.update(sql,
                    UUID.randomUUID().toString(),
                    contactOwner.getUsername(),
                    contactOwner.getDescription(),
                    contactOwner.getEmail(),
                    contactOwner.getPassword(),
                    contactOwner.getRole().name());
        } else {
            String sql = """
                    UPDATE contact_owners
                    SET username = ?,
                        description = ?,
                        email = ?,
                        password = ?,
                        role = ?
                    WHERE id = ?;
                    """;
            jdbcTemplate.update(sql,
                    contactOwner.getUsername(),
                    contactOwner.getDescription(),
                    contactOwner.getEmail(),
                    contactOwner.getPassword(),
                    contactOwner.getRole(),
                    contactOwner.getId());
        }
        return contactOwner;

    }

    @Override
    public boolean deleteById(UUID id) {
        String sql = "DELETE FROM contact_owners WHERE id = ?";

        return jdbcTemplate.update(sql, id.toString()) > 0;
    }

    @Override
    public List<ContactOwner> findByUsername(String username) {
        String sql = "SELECT * FROM contact_owners WHERE username = ?";

        return jdbcTemplate.query(sql, new ContactOwnerRowMapper(), username);
    }

    @Override
    public List<ContactOwner> searchByKeyword(String keyword) {
        String sql = """
                SELECT *
                FROM contact_owners
                WHERE username like ?
                or description like ?
                or email like ?
                """;

        String pattern = "%" + keyword + "%";
        return jdbcTemplate.query(sql, new ContactOwnerRowMapper(),
                pattern,
                pattern,
                pattern);
    }
}
