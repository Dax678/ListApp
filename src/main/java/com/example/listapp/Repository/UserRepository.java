package com.example.listapp.Repository;

import com.example.listapp.Database.Entity.User;
import com.example.listapp.Database.View.ShowUserNotesView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query(
            value = "SELECT sunv " +
                    "FROM ShowUserNotesView sunv " +
                    "WHERE sunv.user_id = :#{#user.id}"
    )
    List<ShowUserNotesView> findUserNotes(@Param("user") User user);

    @Query(
            value = "SELECT ro.role_full_name " +
                    "FROM User us " +
                    "JOIN Role ro " +
                    "ON us.role_id=ro.Id " +
                    "WHERE us.username = :#{#user.username}"
    )
    String findUserRole(@Param("user") User user);
}
