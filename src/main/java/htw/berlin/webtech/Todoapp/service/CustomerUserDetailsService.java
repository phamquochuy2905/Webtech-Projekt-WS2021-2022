package htw.berlin.webtech.Todoapp.service;


import htw.berlin.webtech.Todoapp.persistence.CustomUserDetails;
import htw.berlin.webtech.Todoapp.persistence.User;
import htw.berlin.webtech.Todoapp.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomerUserDetailsService implements UserDetailsService {

        @Autowired
        private UserRepository userRepo;

        @Override
        public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                User user = userRepo.findByEmail(username);
                if (user == null) {
                        throw new UsernameNotFoundException("User not found");
                }
                return new CustomUserDetails(user);
        }
}

