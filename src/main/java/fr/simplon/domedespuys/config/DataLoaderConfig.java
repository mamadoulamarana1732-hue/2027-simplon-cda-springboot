package fr.simplon.domedespuys.config;

import java.text.Normalizer;
import com.github.javafaker.Faker;
import fr.simplon.domedespuys.entities.Address;
import fr.simplon.domedespuys.entities.Brand;
import fr.simplon.domedespuys.entities.Product;
import fr.simplon.domedespuys.entities.User;
import fr.simplon.domedespuys.repositories.AddressRepository;
import fr.simplon.domedespuys.repositories.BrandRepository;
import fr.simplon.domedespuys.repositories.ProductRepository;
import fr.simplon.domedespuys.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.jspecify.annotations.NonNull;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Locale;
import java.util.Optional;
import java.util.Random;
import java.util.concurrent.TimeUnit;


@Component
@AllArgsConstructor
public class DataLoaderConfig implements CommandLineRunner {
    private UserRepository userRepository;
    private BrandRepository brandRepository;
    private AddressRepository addressRepository;
    private ProductRepository productRepository;
    private String slugify(String text) {
        return Normalizer.normalize(text, Normalizer.Form.NFD)
                .replaceAll("\\p{M}", "")          // supprime les accents
                .toLowerCase()
                .replaceAll("[^a-z0-9]+", "-")     // remplace tout le reste par un tiret
                .replaceAll("(^-|-$)", "");        // enlève les tirets au début et à la fin
    }


    @Override
    public void run(String @NonNull ... args) {
        createUsers();
        createBrands();
        createAddress();
        createProduct();
    }

    private void createUsers() {
        if (0 == userRepository.count()) {
            Faker faker = new Faker(Locale.of("fr"));

            for (int i = 0; i < 100; i++) {
                User user = new User();
                user.setFirstname(faker.name().firstName());
                user.setLastname(faker.name().lastName());
                String email = faker.internet().emailAddress((user.getFirstname() + "." + user.getLastname()).toLowerCase());
                user.setEmail(email);
                user.setPassword(faker.internet().password(12, 20));
                if (hasProbability(2, 3)) {
                    user.setPhone(faker.phoneNumber().phoneNumber());
                }
                LocalDateTime localDate = new java.sql.Date(faker.date().birthday(0, 5).getTime()).toLocalDate().atTime(0, 0);
                user.setCreatedAt(localDate);
                userRepository.save(user);
            }

            userRepository.flush();
        }
    }

    private void createBrands() {
        if (0 == brandRepository.count()) {
            Faker faker = new Faker(Locale.of("fr"));

            for (int i = 0; i < 50; i++) {
                Brand brand = new Brand();
                brand.setLabel(faker.company().name());
                brand.setLogo(faker.company().logo());
                brand.setSlug(brand.getLabel().toLowerCase().replace(" ", "-"));
                brandRepository.save(brand);
            }

            brandRepository.flush();
        }
    }

    private void createAddress() {
        if (0 == addressRepository.count()) {
            Faker faker = new Faker(Locale.of("fr"));
            Random random = new Random();


            for (int i = 0; i < 100; i++) {
                Address address = new Address();
                address.setCity(faker.country().capital());
                address.setCountry(faker.country().name());
                address.setLine(faker.address().buildingNumber());
                address.setZipCode(faker.file().extension());
                address.setExtraLine(faker.address().buildingNumber() + address.getCity().toLowerCase());



                Long userId = random.nextLong(1, 100);
                Optional<User> optionalUser = userRepository.findById(userId);

                optionalUser.ifPresent(address::setUser);

                if (address.getUser() == null) {
                    continue;
                }

                if (hasProbability(2, 4)) {
                    address.setFirstname(address.getUser().getFirstname());
                    address.setLastname(address.getUser().getLastname());
                    address.setPhone(address.getUser().getPhone());
                } else {
                    address.setFirstname(faker.name().firstName());
                    address.setLastname(faker.name().lastName());
                    address.setPhone(faker.phoneNumber().phoneNumber());
                }

                int year = address.getUser().getCreatedAt().getYear();
                int currentYear = LocalDate.now().getYear();
                address.setCreatedAt(getRandomDate(faker, 0, currentYear - year));

                addressRepository.save(address);
            }

            addressRepository.flush();
        }
    }
    private void createProduct() {
        if (0 == productRepository.count()) {
            Faker faker = new Faker(Locale.of("fr"));
            Random random = new Random();

            for (int i = 0; i < 300; i++) {
                Product product = new Product();
                product.setLabel(faker.book().title()+i);
                product.setCreatedAt(getRandomDate(faker, 0, 10));
                product.setPrice((float) faker.number().numberBetween(100, 300));
                product.setSlug(slugify(product.getLabel()));
                product.setDescription(faker.book().author() + " : " + faker.lorem().characters(100, 1000));

                Long brandId = random.nextLong(59, 107);
                Optional<Brand> optionalBrand = brandRepository.findById(brandId);

                optionalBrand.ifPresent(product::setBrand);

                if (product.getBrand() == null) {
                    continue;
                }
                productRepository.save(product);
            }

            productRepository.flush();
        }
    }

    private LocalDateTime getRandomDate(Faker faker, int min, int max) {
        return new java.sql.Date(faker.date().past(365 * Math.max(max, 1), TimeUnit.DAYS).getTime())
                .toLocalDate()
                .atTime(0, 0);
    }

    private boolean hasProbability(int expected, int max) {
        Random random = new Random();
        // random.nextInt(max) = génère un entier aléatoire entre 0 et MAX
        // expected = la proba attendue
        // Si le random est inférieur à expected, alors on renvoie true
        return random.nextInt(max) < expected;
    }
}