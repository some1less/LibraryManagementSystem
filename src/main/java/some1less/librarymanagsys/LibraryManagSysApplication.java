package some1less.librarymanagsys;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import some1less.librarymanagsys.controller.UserController;
import some1less.librarymanagsys.repository.UserRepository;

import javax.naming.ldap.Control;

@SpringBootApplication
public class LibraryManagSysApplication {

    public static void main(String[] args) {
        SpringApplication.run(LibraryManagSysApplication.class, args);
    }

}
