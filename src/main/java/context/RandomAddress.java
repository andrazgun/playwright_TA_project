package context;

import net.datafaker.Faker;


public record RandomAddress(String street,
                            String city,
                            String state,
                            String zipCode) {

    public static RandomAddress randomAddress() {
        Faker fake = new Faker();
        return new RandomAddress(
                fake.address().streetAddress(),
                fake.address().city(),
                fake.address().state(),
                fake.address().zipCode()
        );
    }
}
