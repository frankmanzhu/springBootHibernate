package com.frank.execution;

import com.frank.domain.User;
import com.frank.domain.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * Created by frankzhu on 1/11/16.
 */


@Component
public class CLRunner implements CommandLineRunner {
    @Override
    public void run(String... strings) throws Exception {

        //Insert if not exist
        Stream.of("Frank,frankmanzhu@hotmail.com", "John,john@abc.com", "Foo,foo@bar.com").map(x-> x.split(",")).forEach(
                tuple -> {
                    Optional user = userDao.findUserByNameAndEmail(tuple[0], tuple[1]);
                    if (user.isPresent()) {
                        System.out.println(user.get().toString());
                    } else {
                        userDao.save(new User(tuple[0], tuple[1]));
                    }
                });
    }

    @Autowired
    private UserDao userDao;
}
