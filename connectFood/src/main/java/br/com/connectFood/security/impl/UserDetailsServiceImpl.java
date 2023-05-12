package br.com.connectFood.security.impl;

import br.com.connectFood.model.UserModel;
import br.com.connectFood.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;

public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<UserModel> user = Optional.ofNullable(userRepository.findByEmail(email));
        user.orElseThrow(() -> new UsernameNotFoundException( email + " not found."));

        return user.map(UserDetailsImpl::new).get();
    }


}
