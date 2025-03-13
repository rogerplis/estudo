package com.roger.estudo.config;

import com.roger.estudo.model.Role;
import com.roger.estudo.model.User;
import com.roger.estudo.model.products.Category;
import com.roger.estudo.repositories.UserRepository;
import com.roger.estudo.repositories.products.CategoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {

    private final UserRepository repository;
    private final PasswordEncoder bcryptEncoder;
    private final CategoryRepository categoryRepository;

    public DataLoader(UserRepository repository, PasswordEncoder bcryptEncoder, CategoryRepository categoryRepository) {
        this.repository = repository;
        this.bcryptEncoder = bcryptEncoder;
        this.categoryRepository = categoryRepository;
    }


    @Override
    public void run(String... args) throws Exception {
        String password = bcryptEncoder.encode("123");
        User user1 = new User();
        user1.setFirstName("Rogerio");
        user1.setLastName("Bastos");
        user1.setEmail("rogerplis@hotmail.com");
        user1.setPassword(password);
        user1.setRole(Role.ADMIN);
        user1.setActive(true);
        user1.setLocked(true);



        User user2 = new User();
        user2.setFirstName("Lucas");
        user2.setLastName("Bastos");
        user2.setEmail("lucasplis@hotmail.com");
        user2.setPassword(password);
        user2.setRole(Role.USER);
        user2.setActive(true);
        user2.setLocked(true);


        List<String> categorias = List.of(
                "Eletrônicos",
                "Eletrodomésticos",
                "Móveis",
                "Vestuário",
                "Calçados",
                "Alimentos e Bebidas",
                "Esportes e Lazer",
                "Livros e Papelaria",
                "Brinquedos",
                "Beleza e Cuidados Pessoais",
                "Ferramentas e Construção",
                "Automotivo",
                "Pet Shop",
                "Informática",
                "Saúde e Bem-Estar",
                "Joias e Acessórios",
                "Games",
                "Artigos de Festa",
                "Casa e Decoração",
                "Instrumentos Musicais"
        );




        repository.save(user1);
        repository.save(user2);
        categoryRepository.saveAll(categorias.stream().map(c -> { Category category = new Category(); category.setName(c); return category;}).toList()); //categoryRepository.saveAll(categorias.stream().map(c -> new Category()).toList());

    }

}
