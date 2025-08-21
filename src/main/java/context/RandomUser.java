package context;

import net.datafaker.Faker;

public record RandomUser(
        String firstName,
        String lastName,
        String email,
        String address,
        String city,
        String state,
        String zipCode,
        String phoneNumber,
        String ssn,
        String username,
        String password
) {
    public static RandomUser createRandom() {
        Faker faker = new Faker();

        String username = faker.name().maleFirstName() + faker.number().digits(3);
        String password = faker.internet().password(
                8,
                12,
                true,
                true,
                true);

        return new RandomUser(
                faker.name().firstName(),
                faker.name().lastName(),
                faker.internet().emailAddress(),
                faker.address().streetAddress(),
                faker.address().city(),
                faker.address().stateAbbr(),
                faker.address().zipCode(),
                faker.phoneNumber().cellPhone(),
                faker.number().digits(9), // SSN
                username,
                password
        );
    }
}
