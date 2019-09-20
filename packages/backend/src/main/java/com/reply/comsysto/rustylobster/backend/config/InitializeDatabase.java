package com.reply.comsysto.rustylobster.backend.config;

import com.github.javafaker.Faker;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.reply.comsysto.rustylobster.backend.daos.BurgerRepository;
import com.reply.comsysto.rustylobster.backend.daos.IngredientRepository;
import com.reply.comsysto.rustylobster.backend.daos.UserAccountRepository;
import com.reply.comsysto.rustylobster.backend.exceptions.IngredientNotFoundException;
import com.reply.comsysto.rustylobster.backend.models.entities.Burger;
import com.reply.comsysto.rustylobster.backend.models.entities.BurgerIngredient;
import com.reply.comsysto.rustylobster.backend.models.entities.Ingredient;
import com.reply.comsysto.rustylobster.backend.models.entities.IngredientCategory;
import com.reply.comsysto.rustylobster.backend.models.entities.IngredientStock;
import com.reply.comsysto.rustylobster.backend.models.entities.UserAccount;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class InitializeDatabase {
  @Bean
  public CommandLineRunner execute(
      final IngredientRepository ingredientRepository,
      final BurgerRepository burgerRepository,
      final UserAccountRepository userAccountRepository) {
    return args -> {
      final Random random = new Random();
      final var initialIngredients =
          ImmutableMap.copyOf(
              Map.of(
                  IngredientCategory.BREAD,
                  ImmutableList.of(
                      "Bread Pitt",
                      "9-Grain Wheat",
                      "Hearty Italian",
                      "9-Grain Honey Oat",
                      "Jalapeno Cheese",
                      "Monterey Cheddar",
                      "Parmesan Oregano",
                      "Roasted Garlic",
                      "Rosemary & Sea Salt",
                      "Rye Bread",
                      "Gluten-Free Bread",
                      "Multi-grain Flatbread",
                      "Italian Herbs & Cheese",
                      "Flatbread"),
                  IngredientCategory.VEGGIE,
                  ImmutableList.of(
                      "Cucumbers",
                      "Green Peppers",
                      "Lettuce",
                      "Red Onions",
                      "Spinach",
                      "Tomatoes",
                      "Banana Peppers",
                      "Jalapenos",
                      "Black Olives",
                      "Pickles",
                      "Avocado",
                      "Carrots",
                      "Green Guacamole",
                      "Sweet Peppers"),
                  IngredientCategory.CHEESE,
                  ImmutableList.of(
                      "American Cheese",
                      "Monterey Cheese",
                      "Feta",
                      "Mozzarella",
                      "Cheddar",
                      "Pepperjack",
                      "Provolone",
                      "Swiss"),
                  IngredientCategory.SAUCE,
                  ImmutableList.of(
                      "Ketchup",
                      "Chipotle Southwest",
                      "Light Mayonnaise",
                      "Regular Mayonnaise",
                      "Ranch",
                      "Oil",
                      "Vinaigrette",
                      "Mustard",
                      "Vinegar",
                      "Sweet Onion",
                      "Barbecue",
                      "Buffalo",
                      "Creamy Italian",
                      "Golden Italian",
                      "Honey Mustard",
                      "Savory Caesar",
                      "Sriracha",
                      "Tzatziki Cucumber"),
                  IngredientCategory.EXTRAS,
                  ImmutableList.of("Pepperoni", "Bacon"),
                  IngredientCategory.PATTY,
                  ImmutableList.of(
                      "Juicy Grilled Beef",
                      "Grilled Chicken Breast",
                      "Vegetarian",
                      "Vegan",
                      "Brisket",
                      "Chuck",
                      "Dry-Aged Beef",
                      "Grass-Fed",
                      "Wagyu",
                      "Shortrib",
                      "Sirloin")));
      initialIngredients.forEach(
          ((category, ingredients) ->
              ingredients.forEach(
                  ingredient -> {
                    final int calories = random.nextInt(190) + 10;
                    final BigDecimal price = BigDecimal.valueOf(random.nextInt(400) / 100.0);
                    final int stockQuantity = random.nextInt(20);
                    ingredientRepository.save(
                        new Ingredient(
                            calories,
                            category,
                            new IngredientStock(stockQuantity),
                            ingredient,
                            price));
                  })));

      var defaultBurgers =
          ImmutableMap.of(
              "Classic",
              ImmutableList.of(
                  "Bread Pitt",
                  "Lettuce",
                  "Cucumbers",
                  "Tomatoes",
                  "Juicy Grilled Beef",
                  "American Cheese",
                  "Regular Mayonnaise",
                  "Bread Pitt"),
              "Light",
              ImmutableList.of(
                  "9-Grain Honey Oat",
                  "Lettuce",
                  "Tomatoes",
                  "Grilled Chicken Breast",
                  "Lettuce",
                  "Mozzarella",
                  "9-Grain Honey Oat"));

      var allIngredients = ingredientRepository.findAll();
      defaultBurgers.forEach(
          (burgerName, ingredientNames) -> {
            final var burgerIngredients =
                ingredientNames.stream()
                    .map(
                        name ->
                            allIngredients.stream()
                                .filter(ingredient -> ingredient.getName().equals(name))
                                .findFirst()
                                .orElseThrow(() -> new IngredientNotFoundException(null)))
                    .map(BurgerIngredient::new)
                    .collect(Collectors.toList());
            burgerRepository.save(new Burger(burgerIngredients, burgerName));
          });

      final Faker faker = new Faker();
      IntStream.range(0, 5)
          .mapToObj(i -> new UserAccount("password", faker.funnyName().name()))
          .forEach(
              userAccount -> {
                log.info(String.format("Created user %s", userAccount.getUsername()));
                userAccountRepository.save(userAccount);
              });
    };
  }
}
